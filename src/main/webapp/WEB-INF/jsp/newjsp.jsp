<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%-- 
    Document   : newjsp
    Created on : 07.11.2015, 19:06:43
    Author     : THaskioglu
--%>

<html>
    <head>

        <title>Autos hinzufügen</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/midcss.css" rel="stylesheet">
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

                <form:form commandName="baujahr" action="/mavenproject1/writedata.html" method="post">
                    <div class="table-responsive">
                    <table class="table table-borderless">
                          <tr><td><form:select path="datafetchfile">
                          <form:options items="${mapFile}" />
                          </form:select></td></tr>
                        <tr><td>Verkaufspreis: </td><td>Farbe</td></tr>
                         <tr><td ><form:input path="datafetchverkaufspreis" /></td><td> <form:select path="datafetchFarbe">
                                                                             <form:options items="${mapFarbe}" />
                                                                             </form:select> </td></tr>
                          <tr><td>Kilometer: </td><td>Türen</td></tr>
                           <tr><td><form:input path="datafetchkilometeranzahl" /></td><td><form:select path="dataFetchTueren">
                                                                                <form:options items="${mapTueren}" />
                                                                                </form:select> </td></tr>
                            <tr><td>Baujahr: </td><td>Zustände:</td></tr>
                            <tr><td>
                                 <form:select path="datafetchBaujahr">
                                 <form:options items="${mapBaujahr}" />
                                 </form:select> 
                                </td>
                                <td><form:radiobuttons name="radiobuttons" path="dataFetchZustand" items="${mapZustand}"/></td></tr>
                            <tr><td>Hersteller: </td><td>Beschreibung:</td></tr>
                              <tr><td>
                                 <form:select path="datafetchHersteller">
                                 <form:options items="${mapHersteller}" />
                                 </form:select> 
                                </td>
                                <td><form:textarea path="dataFetchBeschreibung" rows="5" cols="30" /></td></tr>
                                <tr><td>Kraftstoff: </td><td></td></tr>
                                 <tr><td>
                                 <form:select path="dataFetchKraftstoff">
                                 <form:options items="${mapKraftstoff}" />
                                 </form:select> 
                                </td>
                                <td></td></tr>
                                 <tr><td>Leistung: </td><td></td></tr>
                              <tr><td>
                                 <form:select path="dataFetchLeistung">
                                 <form:options items="${mapLeistung}" />
                                 </form:select> 
                                </td>
                                <td></td></tr>
                              <tr><td>Modell: </td><td></td></tr>
                               <tr><td>
                                 <form:select path="dataFetchModell">
                                 <form:options items="${mapModell}" />
                                 </form:select> 
                                </td>
                                <td><input class="btn btn-success btn-lg" type="submit" value="Hinzufügen" name="buttonhinz"/></td></tr>


                    </table>
                  <%--
                                <p>
                        Verkaufspreis: <form:input path="datafetchverkaufspreis" />
                    </p>
                    <p>
                        Kilometeranzhal: <form:input path="datafetchkilometeranzahl" />
                    </p>
                    
                    <form:select path="datafetchBaujahr">
                        <form:options items="${mapBaujahr}" />
                    </form:select> 


                    <form:select path="datafetchHersteller">
                        <form:options items="${mapHersteller}" />
                    </form:select>

                    <form:select path="datafetchFarbe">
                        <form:options items="${mapFarbe}" />
                    </form:select>   

                    <form:select path="dataFetchKraftstoff">
                        <form:options items="${mapKraftstoff}" />
                    </form:select>

                    <form:select path="dataFetchLeistung">
                        <form:options items="${mapLeistung}" />
                    </form:select>   

                    <form:select path="dataFetchModell">
                        <form:options items="${mapModell}" />
                    </form:select>

                    <form:select path="dataFetchTueren">
                        <form:options items="${mapTueren}" />
                    </form:select>  

                    <form:textarea path="dataFetchBeschreibung" rows="5" cols="30" />

                    <form:radiobuttons name="radiobuttons" path="dataFetchZustand" items="${mapZustand}"  />
                 
                    
                    <input class="btn btn-success btn-lg" type="submit" value="Hinzufügen"/>  --%>
                  </div>
                </form:form>

            </div>
        </div>

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="js/bootstrap.js"></script>

    </body>
</html>
