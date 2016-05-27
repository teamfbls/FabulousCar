<%-- 
    Document   : showcars
    Created on : 02.12.2015, 20:39:17
    Author     : THaskioglu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Liste mit Autos</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/midcss.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src = "js/bootstrap.js" ></script>
    </head>
    <body>
        <div style="background-color: #222;">
            <div class="c-wrapper">
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">

                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                    </ol>
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="pic/R8_1600x640.jpg" alt="" class="img-responsive"/>
                            <div class="carousel-caption">
                                <h1>Effizienz</h1> 
                            </div>        

                        </div>

                        <div class="item ">
                            <img src="pic/V10_1600x640.jpg" alt="" class="img-responsive"/>
                            <div class="carousel-caption">
                                <h1>Power</h1>
                            </div> 
                        </div>
                        <div class="item ">
                            <img src="pic/M3_1600x400.jpg" alt="" class="img-responsive"/>
                            <div class="carousel-caption">
                                <h1>Stil</h1>
                            </div> 
                        </div>
                        <div class="item ">
                            <img src="pic/BMW_1600x640.jpg" alt="" class="img-responsive"/>
                            <div class="carousel-caption">
                                <h1>FabulousCar</h1>
                            </div> 
                        </div>
                    </div>
                    <a class="carousel-control left" href="#carousel-example-generic" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span> 
                    </a>

                    <a class="carousel-control right" href="#carousel-example-generic" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>  
                    </a>
                </div>
            </div>
        </div>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button class="navbar-toggle collapsed" aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse" type="button">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">FabulousCar</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#">Dashboard</a>
                        </li>
                        <li>
                            <a href="#">Settings</a>
                        </li>
                        <li>
                            <a href="#">Profile</a>
                        </li>
                        <li>
                            <a href="#">Help</a>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">
                    <ul class="nav nav-sidebar">
                        <li class="active">
                            <a href="index.html">
                                Startseite
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>

                        <li>
                            <a href="showcars.html">Autosanzeigen</a>
                        </li>
                        <li>
                            <a href="newjsp.html">Autoshinzufügen</a>
                        </li>
                    </ul>
                    <ul class="nav nav-sidebar">
                        <li>
                            <a href="">Autos bearbeiten</a>
                        </li>
                        <li>
                            <a href="listall.html">Autos löschen</a>
                        </li>
                        <li>
                            <a href="latestentry.html">Zuletzt angelegt</a>
                        </li>
                        <li>
                            <a href="search.html">Search</a>
                        </li>
                        <li>
                            <a href="">Impressum</a>
                        </li>
                    </ul>
                </div>
                <br>
                <br>
                <br>
                <br>

                <div class="container-fluid">



                    <c:forEach var="rows" items="${listrow[0]}" varStatus="status">

                        <div class="row">
                            <div class="table-responsive">
                                <div class="col-xs-4 col-md-6">
                                    <table  class="table table-bordered">


                                        <tr></tr>
                                        <form:form action="/mavenproject1/pdfsuc.html" method="Post">

                                            <tr><input type="image"  width="35" height="35" name="submit" src="pic/pdfbutton.png" border="0" alt="Submit" /></tr>
                                        </form:form>
                                        <c:forEach var="column" items="${listhead}" varStatus="statusHead">
                                            <tr><td>   ${column}</td>
                                                <c:forEach var="row"  items="${listrow[statusHead.index][status.index]}" varStatus="status2" >    
                                                    <c:set var="ind" value="${statusHead.index}"/>
                                                    <td>
                                                        ${row}
                                                    </td> 
                                                    <c:if test="${ind ==13}">
                                                        <td>
                                                            <c:set var="g" value="webapp\\"></c:set>
                                                            <c:set var="path" value="${fn:substringAfter(row,g)}"></c:set>

                                                                <img width="200" height="140" alt="" src="${fn:replace(path,"\\","//")}" class="img-rounded" >




                                                        </td>
                                                    </c:if>
                                                    <c:if test="${ind==14}">
                                                        <c:choose>
                                                            <c:when test="${row==1}">
                                                                <td>  <img src="pic/sign_available_red.png" alt=""/></td>
                                                            </c:when>
                                                                <c:otherwise>
                                                                <td>
                                                                <img src="pic/sign_available.png" alt=""/></td>
                                                                </c:otherwise>
                                                         </c:choose>
                                                        </c:if>

                                                </tr>
                                            </c:forEach>

                                        </c:forEach>

                                    </table>
                                </div>
                            </div>
                        </div>
                    </c:forEach>


                </div>


                </body>
                </html>
