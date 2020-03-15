<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
    <meta name="description" content="" />
    <meta name="viewport" content="user-scalable=no">
    
    <meta name="google-site-verification" content="BstJA3X9z6f9HcvoN9AZTwaKo_9Abj_j7dVBPfy640s" />
    <meta name="baidu-site-verification" content="IYCrtVH0i1" />
    <meta property="wb:webmaster" content="239d3d1dbdde1b2c" />
    <link rel="icon" type="image/png" href="/static/images/favicon.ico"/>
    <script type="text/javascript" src="/static/js/jquery-1.7.2.js"></script>
    <script src="/static/js/echarts.js" ></script>
    
    <script type="text/javascript">
     
       
    </script>
    
    <link rel="stylesheet" href="/static/css/common.css?v=2015-5-20"/>
    
    <link rel="stylesheet" href="/static/css/user_center.css"/>

    <!--[if lte IE 7]><script>window.onload=function(){location.href="/ie6warning/"}</script><![endif]-->
    <!--[if lt IE 9]>
    <script src="js/respond.js"></script>
    <script>
        var e = "abbr, article, aside, audio, canvas, datalist, details, dialog, eventsource, figure, footer, header, hgroup, mark, menu, meter, nav, output, progress, section, time, video, dh-dialog, dh-checkbox".split(', ');
         var i= e.length;while (i--){document.createElement(e[i])}
    </script>
    <![endif]-->
    <title>个人中心 - 账号管理</title>
</head>
<body class="day " ng-controller="bodyCtrl"  day-or-night>
    <section class="common-back" id="wrapBackground">
        
            <header id="header">
                <div class="common-width clearfix">
                    <h1 class="fl">
                        <a class="logo base-logo" href="/getIndex?logintoken=${logintoken}">外卖超人</a>
                    </h1>
                    
                        <ul class="member logging" ng-init="loginInfo=true">
                            <li><a href="/getIndex?logintoken=${logintoken}" class="index">首页</a></li>
                            <li class="userName">
                                <a href="/memberIndex?logintoken=${logintoken}" rel="nofollow" draw-user>${logintoken}<em></em></a>
                            </li>
                            <li class=""><a href="/memberOrder?logintoken=${logintoken}" class="order-center"  rel="nofollow">我的订单</a></li>
                            <li class=""><a href="/memberCollect?logintoken=${logintoken}"  rel="nofollow">我的收藏</a></li>
   
                        </ul>
                    
                </div>
            </header>
        
        <div id="main-box">

        
            <div ng-controller="colorAction">
                <div class="dayColor_two"></div>
                <div class="dayColor_one"></div>
                <div class="dayColor_three" ng-class="{dayColor_threeActive:threeActive}"></div>
            </div>
        
            
    <section>
        <div class="user-center-main-box common-width clearfix">
            <aside class="fl">
                <ul>
                    <li class="active">
                        <a href="/memberIndex?logintoken=${logintoken}" rel="nofollow">账号管理</a>
                    </li>
                    <li >
                        <a href="/memberOrder?logintoken=${logintoken}" rel="nofollow">我的订单</a>
                    </li>
                    <li >
                        <a href="/memberCollect?logintoken=${logintoken}" rel="nofollow">我的收藏</a>
                    </li>
                    <li >
                        <a href="/memberAddr?logintoken=${logintoken}"  rel="nofollow">地址管理</a>
                    </li>
                    <li >
                        <a href="/StoreChart?logintoken=${logintoken}" rel="nofollow">我的销量</a>
                    </li>
                </ul>
            </aside>
            <article class="fl user-center-main">
                <header>我的销量</header>
                
     <section id="part" class="user-account-body">
        
        
        	<table>
            <tr>
                <td>
                    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
                    <div id="main" style="width: 600px;height:400px;"></div>
                    <script type="text/javascript">
                        // 基于准备好的dom，初始化echarts实例
                        var myChart = echarts.init(document.getElementById('main'));
                        var data1 = [];
                        var data2 = [];
                        // 指定图表的配置项和数据
                        option = {
                    title : {
                        text: '交易次数',
                    },
                    tooltip : {
                        trigger: 'axis'
                    },
                    
                    toolbox: {
                        show : true,
                        feature : {
                            dataView : {show: true, readOnly: false},
                            magicType : {show: true, type: ['line', 'bar']},
                            restore : {show: true},
                            saveAsImage : {show: true}
                        }
                    },
                    calculable : true,
                    xAxis : [
                        {
                            type : 'category',
                            data :data1
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            name:'销售量',
                            type:'bar',
                            data:data2,
                            markPoint : {
                                data : [
                                    {type : 'max', name: '最大值'},
                                    {type : 'min', name: '最小值'}
                                ]
                            },
                            markLine : {
                                data : [
                                    {type : 'average', name: '平均值'}
                                ]
                            }
                        },
                       
                    ]
                };

                        // 使用刚指定的配置项和数据显示图表。
                        //myChart.setOption(option);
                        
                        $.ajax({
                            url: "/StoreChartJson?sid=1",
                        	dataType:"Json",
                            type: 'get',
                            success: function (res) {
                            	var json= JSON.stringify(res);
                                //alert(res);
                               // alert(json);
                                for (var i=0;i<res.length;i++){
                                //data1数据为横轴数据
                                    data1.push(res[i].month+"月")
                               //data1数据为纵轴数据
                                    data2.push(res[i].count)
                                }
                          // 使用刚指定的配置项和数据显示图表。
                                myChart.setOption(option);
                            }

                        });
                       

             
                    </script>
                </td>
            </tr>
        </table>


     </section>
     
            </article>
        </div>
    </section>

        </div>
    </section>
    
        <footer id="footer">
        <div class="footer-first gray">
            <div class="company-info clearfix fs14 gray">
                <a href="about.html" target="_blank"  rel="nofollow">关于我们</a>
                <a href="help.html" target="_blank"  rel="nofollow">帮助中心</a>
                <a href="javascript:;" target="_blank"  rel="nofollow">法律声明</a>
                <a href="jobs.html" target="_blank"  rel="nofollow">人才招聘</a>
                <a href="contact.html" target="_blank"  rel="nofollow">联系我们</a>
                <a href="javascript:;" user-feedback ng-click="userFeedback=true" class="last" rel="nofollow">意见反馈</a>
                <a href="javascript:;" class="last" target="_blank" style="display:none">上海餐厅导航</a>
            </div>
        </div>
        <div class="footer-last">
            <a target="_blank" class="foot-logo-1 base-logo" href="index.html"></a>
            <div class="tc fs14 light-gray mb10">
              ©2014 waimaichaoren.com All Rights Reserved - 沪ICP备11019908号
            </div>
        </div>
    </footer>
    
    
    <dh-dialog class="disnone" height="500" feeedbackclass="userFeedback" type="user-feedback" header="意见反馈" show="userFeedback">
        <div ng-controller="feedbackCtrl">
            <form novalidate="true" name="feedbackForm" class="inline">
                <div class="form-group row mb10">
                    <label class="col-3">联系方式：</label>
                    <div class="col-8">
                        <input type="text" maxlength="20" name="userContact" required ng-focus="userContactFocus()" ng-class="{error:feedback.phoneMessage}" placeholder="请输入您的手机号码" ng-model="feedback.userContact"/>
                    </div>
                </div>
                <div class="row mb10">
                    <div class="clo-8 col-offset-3" ng-if="feedback.phoneMessage">
                        <span class="vaildate-error">联系方式不能为空</span>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-3 vt">反馈信息：</label>
                    <div class="col-8">
                        <textarea name="feedbackMessage"  placeholder="可以说说您对外卖超人的意见" ng-focus="feedbacFocus()" required ng-class="{error:feedback.feedbackMessageTip}" ng-model="feedback.feedbackMessage" maxlength="300" cols="25" rows="7"></textarea>
                    </div>
                </div>
                <div class="row mb10">
                    <div class="clo-8 col-offset-3" ng-if="feedback.feedbackMessageTip">
                        <span class="vaildate-error">反馈信息不能为空</span>
                    </div>
                </div>
                <div class="tc">
                    <button class="btn normal-btn btn-success" ng-click="feedbackSubmit()">确认</button>
                    <button class="btn normal-btn btn-cancel" ng-click="feedbackCancel()">取消</button>
                </div>
            </form>
        </div>
        <div class="common-dialog-footer">
            咨询加QQ群：337212031
        </div>
    </dh-dialog>
    
    <dh-dialog class="disnone" header="修改登录密码" height="500" show="showChangePass">
        <div ng-controller="changePasswordCtrl" class="change-password-box">
            <div class="form-group">
                <label>当前密码</label>
                <div>
                    <input type="password" ng-class="{error:user.passwordMessage}" onpaste="return false" maxlength="10" placeholder="请输入当前使用的登录密码" ng-model="user.password" />
                    <span class="vaildate-error" ng-if="user.passwordMessage">
                        <span ng-bind="user.passwordMessage"></span>
                    </span>
                </div>
            </div>
            <div class="form-group mb10">
                <label>新的密码</label>
                <div>
                    <input type="password" ng-class="{error:user.newPasswordMessage}" onpaste="return false" maxlength="10"  placeholder="请输入 6-10个字符" ng-model="user.newPassword" />
                    <span class="vaildate-error" ng-if="user.newPasswordMessage">
                        <span ng-bind="user.newPasswordMessage"></span>
                    </span>
                </div>
            </div>
            <div class="form-group mb20">
                <div>
                    <input type="password" ng-class="{error:user.newPassword2Message}" onpaste="return false" maxlength="10"  placeholder="请再次输入新的密码" ng-model="user.newPassword2"/>
                    <span class="vaildate-error" ng-if="user.newPassword2Message">
                        <span ng-bind="user.newPassword2Message"></span>
                    </span>
                </div>
            </div>
            <div class="tr">
                <button class="btn small-btn btn-success" ng-click="changePassSubmit()" ng-disabled="isSubmit" ng-bind="submitText"></button>
                <button class="btn small-btn btn-cancel" ng-click="changePassCancel()">取消</button>
            </div>
        </div>
    </dh-dialog>
    <dh-dialog class="disnone" type="alert" height="500" index="1001" header="" show="requestSuccess">
        <div class="alert-box">
            <p>修改密码成功</p>
            <p class="fs12">3秒后自动关闭</p>
        </div>
    </dh-dialog>
    <dh-dialog class="disnone" type="alert" height="500" index="1001" header="" show="requestError">
        <div class="alert-box error">
            <p>修改密码失败</p>
        </div>
    </dh-dialog>

     <ul class="site-fixed">
        <li class="scroll-top"><img src="/static/images/scroll_top1.png" alt=""/> </li>
        <li class="scorll-feekback" ng-click="userFeedback=true">
            <img src="/static/images/scorll_feekback.png" alt=""/>
            <div>意见反馈</div>
        </li>
        <li class="scroll-wx">
            <img src="/static/images/scroll_wx.png" alt=""/>
             <div><img src="/static/images/wx.png" alt=""/></div>
        </li>
    </ul>
    
    <script type="text/javascript" src="/static/js/angular.min.js"></script>
    <script src="/static/js/common.js"></script>
    
     
    <script src="/static/js/service.js"></script>
    
    <script>var feedbackUrl = '/ajax/feedback/';var app = angular.module("app", ["dh.dialog", "dh.form", 'dh.service', 'dh.other']);</script>
    <!--[if lt IE 9]><script src="js/fix.js"></script><![endif]-->
    
    
    <script>
        var reviewUrl = "/mobile/ajax/order_review/",favoriteUrl = "/ajax/restaurant/0/favorite/";
    </script>
    <script src="/static/js/user_center.js"></script>

    
    <script>angular.bootstrap(document, ["app"]);</script>

    <!-- Baidu Analytics -->


</body>
</html>
