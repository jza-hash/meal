<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><!--/*技术支持，小庄602842076     验证：商城技术支持*/
/*技术支持，小庄602842076    验证：商城技术支持*/
/*技术支持，小庄602842076    验证：商城技术支持*/
/*技术支持，小庄602842076    验证：商城技术支持*/
/*技术支持，小庄602842076    验证：商城技术支持*/-->
<html>
<head>
    <meta charset="utf-f8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
    <meta name="keywords" content="" />
    <meta name="description" content="登陆页面" />
    <meta name="viewport" content="user-scalable=no">
    <meta name="google-site-verification" content="BstJA3X9z6f9HcvoN9AZTwaKo_9Abj_j7dVBPfy640s" />
    <meta name="baidu-site-verification" content="IYCrtVH0i1" />
    <meta property="wb:webmaster" content="239d3d1dbdde1b2c" />
    <link rel="stylesheet" type="text/css" href="/static/css/reset.css" />
    <link rel="stylesheet" href="/static/css/common.css"/>
    
    <link rel="stylesheet" href="/static/css/login.css"/>
    
    <script>var feedbackUrl = '/ajax/feedback/';var app = angular.module("app", ["dh.dialog", "dh.form", 'dh.service', 'dh.other']);</script>   
    <script>angular.bootstrap(document, ["app"]);</script>
    <link rel="stylesheet" href="/static/css/common.css?v=2015-5-20"/>
    <link rel="icon" type="/static/image/png" href="/static/images/favicon.ico"/>
    <link rel="stylesheet" href="/static/css/frontPage.css"/>
    

    <script type="text/javascript">
        
        (function(document, screen) {
            if (screen.width < 760) {
                document.location.href="/mobile/";
            }
        }(document, screen));
        function warn()
        {
            setTimeout(function () {
                $(".warn").hide();
            },5000);
        };
    </script>

</head>
<body>
    
    <header id="header" class="">
        <div class="common-width">
            
                <section class="clearfix">
                    <h1 class="logo" title="外卖超人">
                      
                    </h1>

                </section>
                
            
        </div>
    </header>
    
    <section class="main">
        <div class="common-width">
            
    <div class="main-inner">
        
            <div class="log-box" id="loginPageBox">
                <div class="form-group w275">
                    <label for="lPhone">手机号码</label>
                    <div class="member-box fs12" login-box info="loginInfo">
                    <a class="warn" href="javascript:void(0)" ng-click="registerDialogShow()">${flag}</a>
                </div>
                </div>
                    <form action="/login" method="post">
                    <input name="phone" id="lPhone" maxlength="11" autocomplete="off" type="text" class="form-text" placeholder="输入您的手机号码"/>

                <div class="form-error-message"></div>
                <div class="form-group w275">
                    <label  for="lPass" >登录密码</label>
                    <input name="password" id="lPass" maxlength="10" autocomplete="off" type="password" class="form-text" onpaste="return false" placeholder="请输入登录密码"/></label>
                    <input name="fz" type="hidden"/>
                </div>

                <div class="form-error-message"></div>
                
                    <div class="form-group captcha clearfix">
                
                  
                  
                </div>
                <div class="form-error-message"></div>
                <div class="form-group checkbox clearfix">                 
                </div>
                <div>
                    <button onclick="warn()" type="submit" class="form-btn" id="loginPageBtn">登录</button>
                </div>

        </form>
        
    </div>

        </div>
    </section>
    <footer id="footer">
    
        <div class="footer-last">
            <a target="_blank" class="foot-logo-1 base-logo" href="index.html"></a>
            <div class="tc fs14 light-gray mb10">
              ©2014 waimaichaoren.com All Rights Reserved - 沪ICP备11019908号
            </div>
        </div>
    </footer>
    
    
    




</body>
</html>