<%-- 
    Document   : Final
    Created on : 14.11.2015, 10:14:00
    Author     : hartmann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>  
#nav, nav ul, nav li{    
    float:right; 
    display:inline; 
                
}   
           
#up{
   width:1300px; 
   height:100px;
   
}
#down{
    width:1300px; 
    height:400px; 
    background:red; 
}
#left{
   float:left; 
   width:200px; 
   height:400px; 
  
    
}
#right{
    float:right;
    width:1100px; 
    height:400px; 
    background:blue; 
    
}
    </style>
    </head>
    <body>
        <div id="up">
            <img src="bild.png" width="300px" height="100px">
            <nav>
            
            </nav>
            </div>
        <div id="down">
        <div id="left">
        <table>
            <ul>
                <li>Startseite</li>
                <br>
                <li>Login</li>
                <br>
                <li>Autos anzeigen</li>
            </ul>
        </table>
            </div>
        <div id="right">Rechts</div>
        </div>
    </body>
</html>
