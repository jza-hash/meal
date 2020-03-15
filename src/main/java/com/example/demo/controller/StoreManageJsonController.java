package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.data.redis.connection.ReactiveNumberCommands.DecrByCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.example.demo.entity.Orders;
import com.example.demo.entity.Sale;
import com.example.demo.entity.Store;
import com.example.demo.mapper.OrdersMapper;
import com.example.demo.mapper.StoreMapper;
import com.example.demo.service.CommManageService;
import com.example.demo.service.StoreManageService;

@RestController
public class StoreManageJsonController {

	@Autowired
	private StoreManageService sm;
	
	@Autowired
	private StoreMapper smp;
	
	@RequestMapping("StoreChartJson")
	public List<Sale> memberOrder(int sid) {
		List<Sale> list=sm.getBySid(sid);
		return list;
	}
	
	@RequestMapping("StoreListJson")
	public List<Store> StoreList(String area) {
		System.out.println(area+"==============");
		List<Store> list=smp.getByArea(area);
		return list;
	}
	
	
	
	@RequestMapping("getByAll")        //给所需的字段创建 分词索引
	public List<Store> getByAll() throws IOException {
		//1.从数据库中 查询到所有结果集
		List<Store> list=smp.getByAll();
		//2。创建索引，将结果集 放入到 lucene 的document 对象中去
		List<Document> ld=new ArrayList<Document>();
		Document doc;
		if(null!=list&&list.size()>0) {
			for(Store s:list) {
				doc=new Document();
				//创建 field 对象  域的属性 分词 索引 存储
				//id 不分词 不索引 存储
				Field storeId=new StoredField("id", s.getId());
				Field Name=new StoredField("name", s.getName());
				Field phone=new StoredField("phone", s.getPhone());
				//Field picture=new StoredField("picture", s.getPicture());
				//分词 索引 存储
				Field storeName=new TextField("storename", s.getStorename(),org.apache.lucene.document.Field.Store.YES);
				Field storeCity=new TextField("city", s.getCity(),org.apache.lucene.document.Field.Store.YES);
				Field storeArea=new TextField("area", s.getArea(),org.apache.lucene.document.Field.Store.YES);

				doc.add(storeId);
				doc.add(Name);
				doc.add(phone);
				doc.add(storeArea);
				doc.add(storeCity);
				doc.add(storeName);
				ld.add(doc);
			}
		}
		//将 document 对象 用分词器 进行 分词 得到索引
		Analyzer analyzer=new StandardAnalyzer();  //中文分词器
		//创建索引存储的目录
		Directory directory=FSDirectory.open(FileSystems.getDefault().getPath("G:\\lucene"));
		//创建构造 索引的配置对象
		IndexWriterConfig cfg=new IndexWriterConfig(analyzer);
		//开始构造 索引 写入到 制定的目录
	    IndexWriter wt=new IndexWriter(directory, cfg);
	    for(Document document:ld) {
	    	wt.addDocument(document);
	    }
	    wt.close();
		return list;
	}
	
	

	//得到点击量最高的前五条数据
	@RequestMapping("getHotArea")
	public List<Store> getHotArea(){
		List<Store> list=sm.getByClick();
		return list;
	}

	public boolean delete(String dirpath){	   //删除索引目录及目录中的 所有文件
		File f = new File(dirpath);		
		if(f.isDirectory()){
			File[] fl= f.listFiles();		
			for(File fs: fl){
				delete(fs.toString());
			}
		}
		return f.delete();		
	}
	
	
    //通过模糊匹配 提示搜锁框内容
	@RequestMapping("match")
	public List<Store> match(String name) throws IOException, ParseException {
		List<Store> ls=new ArrayList<Store>();
		if(name!=null) {
		int count=1;
		String[] fields = {"storename","city","area"};
		MultiFieldQueryParser queryParser = new MultiFieldQueryParser(fields,new StandardAnalyzer());
	    Query query1=queryParser.parse(name);
		Directory directory=FSDirectory.open(FileSystems.getDefault().getPath("G:\\lucene"));
		IndexReader reader=DirectoryReader.open(directory);
		IndexSearcher search=new IndexSearcher(reader);
		//执行 搜索
		TopDocs topdoc1=search.search(query1, 10);
		ScoreDoc[] scoredoc1=topdoc1.scoreDocs;
		
		for(ScoreDoc score:scoredoc1) {
			Store store=new Store();
			int docId=score.doc;   //得到文档ID
			Document doc=search.doc(docId);
			if(doc.get("storename").contains(name)) {
				store.setStorename(doc.get("storename"));
			}else if(doc.get("area").contains(name)) {
				store.setArea(doc.get("area"));
			}else if(doc.get("city").contains(name)&&count<=1) {
				store.setCity(doc.get("city"));
			}
			ls.add(store);
			count++;
		}
	}
		return ls;
	}
	

	//通过数据库 精确匹配某个值 避免不可靠数据返回给前端
	@RequestMapping("getArea")
	  public List<Store> getArea(String name){
	    	List<Store> list=smp.getByArea(name);
	    	return list;
	    }
	@RequestMapping("getCity")
    public List<Store> getCity(String name){
    	List<Store> list=smp.getByCity(name);
    	return list;
    }
	@RequestMapping("getStorename")
    public List<Store> getStorename(String name){
    	List<Store> list=smp.getByStorename(name);
    	return list;
    }
	@RequestMapping("getCityAndArea")
    public List<Store> getCityAndArea(String city,String area){
    	List<Store> list=smp.getByCityAndArea(city, area);
    	return list;
    }

	
	//通过查询 索引来 找到目标对象
	@RequestMapping("getByIndex")
	public  List<Store> getByIndex(String name) throws IOException, ParseException{
		//int count=1;
		List<Store> ls=new ArrayList<Store>();
		System.out.println("删掉的索引文档:");
		delete("G:\\lucene");     //为了数据 不重复 先删除原来的索引文件  之后再次创建
		getByAll();
		List<Store> list=smp.getByAll();
		Query query=null;
		int flag=0;     //用来判断是不是 精确字符的标识
		for(Store s:list) {
			if(name.equals(s.getArea())) {
				flag++;
				ls=getArea(name);
			}else if(name.equals(s.getCity())) {
				flag++;
				ls=getCity(name);
			}else if(name.equals(s.getStorename())) {
				flag++;
				ls=getStorename(name);
			}//else if(name.contains("+")){
//				String[] splited = name.split("+");
//				String city=splited[0];
//				String area=splited[1];
//				ls=getCityAndArea(city,area);
			else if(flag==0){
				//创建一个查询对象   万能查找
				String[] fields = {"storename","city","area"};
				MultiFieldQueryParser queryParser = new MultiFieldQueryParser(fields,new StandardAnalyzer());
			   query=queryParser.parse(name);
			    //执行 搜索
				Directory directory=FSDirectory.open(FileSystems.getDefault().getPath("G:\\lucene"));
		        //创建 indexreader 对象
				IndexReader reader=DirectoryReader.open(directory);
				//创建 indexsearch对象进行查询
				IndexSearcher search=new IndexSearcher(reader);
				//执行 搜索
				TopDocs topdoc1=search.search(query, 10);
				//TopDocs topdoc2=search.search(query2, 10);
				//TopDocs topdoc3=search.search(query3, 10);
				//获取搜索到的目标对象
				ScoreDoc[] scoredoc1=topdoc1.scoreDocs;
				System.out.println(scoredoc1.length);
				
				for(ScoreDoc score:scoredoc1) {
					Store store=new Store();
					int docId=score.doc;   //得到文档ID
					Document doc=search.doc(docId);
					System.out.println(doc+"++++++++++++");
					System.out.println("=============");
					System.out.println("餐厅名"+doc.get("storename"));
					System.out.println("店主名"+doc.get("name"));
				    store.setStorename(doc.get("storename"));
				    store.setName(doc.get("name"));
				    store.setId(Integer.parseInt(doc.get("id")));
				    store.setCity(doc.get("city"));
				    store.setArea(doc.get("area"));
				    store.setPhone(Integer.parseInt(doc.get("phone")));
					ls.add(store);
				
					if(store.getName().contains(name)&&flag<=1) {
						System.out.println(store.getName());
					}else if(store.getArea().contains(name)&&flag<=1) {
						System.out.println(store.getArea());
					}else if(store.getCity().contains(name)&&flag<=1) {
						System.out.println(store.getCity());
					}
					flag++;
				}
				
			}
		}
		for(Store li:ls) {
			int click=li.getClick();
			click++;
			int update=sm.updateClickByid(li.getId(), click);
		}
		return ls;
	}
	
}
