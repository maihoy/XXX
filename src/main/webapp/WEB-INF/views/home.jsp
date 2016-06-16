<%@ page language="java" contentType="text/html; charset=Windows-1251"
         pageEncoding="Windows-1251"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Windows-1251">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Главная</title>
        <link href="<c:url value='/static/css/reset.css' />" rel="stylesheet">
        <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet">


    </head>
    <body>


            <nav class="navbar navbar-inverse navbar-fixed-top">

                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="<c:url value='/' />">VSA</a>
                    </div>
                    <div id="navbar" class="collapse navbar-collapse">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="<c:url value='/' />">Главная<span class="sr-only">(current)</span></a></li>
                                <li><a href="<c:url value='/team/list' />">Команды</a></li>
                                <li><a href="<c:url value='/player/list' />">Игроки</a></li>
                                <li><a href="<c:url value='/comment/list' />">Комментарии</a></li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Матчи... <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="<c:url value='/match/new' />">Создать</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="#">Список матчей</a></li>

                                    </ul>
                                </li>
                                <sec:authorize access="hasRole('ADMIN')">
                                     <li><a href="<c:url value='/user/list' />">Список пользователей</a></li>
                                </sec:authorize>
                            </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
                                <li><p class="navbar-text"> ${user}</p></li>
                            </sec:authorize>
                            <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
                                <li><a href="<c:url value='/logout' />">Выход</a></li>
                            </sec:authorize>
                            <sec:authorize access="isAnonymous()">
                                <li><a href="<c:url value='/login'/>">Вход </a> </li>
                            </sec:authorize>
                        </ul>
                    </div>
                </div>
            </nav>


            <div class="container">




                <!-- Marketing messaging and featurettes
                ================================================== -->
                <!-- Wrap the rest of the page in another container to center all the content. -->

                <div class="container marketing">

                    <!-- Three columns of text below the carousel -->
                    <div class="row">
                        <div class="col-lg-4">
                            <img class="img-responsive" src="http://www.360conditioning.com/images/thumbnails/thumbnail_140__PVB88S.jpg" alt="Generic placeholder image" height="140" width="140">
                            <h2>Nullam id dolor</h2>
                            <p>Donec sed odio dui. Etiam porta sem malesuada magna mollis
                                euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi
                                leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo
                                cursus magna.</p>

                        </div><!-- /.col-lg-4 -->
                        <div class="col-lg-4">
                            <img class="img-responsive" src="http://cdn9.staztic.com/app/a/3318/3318172/tampa-united-volleyball-1-l-140x140.png" alt="Generic placeholder image" height="140" width="140">
                            <h2>Cras mattis</h2>
                            <p>Duis mollis, est non commodo luctus, nisi erat porttitor
                                ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus
                                sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor
                                mauris condimentum nibh.</p>

                        </div><!-- /.col-lg-4 -->
                        <div class="col-lg-4">
                            <img class="img-responsive" src="http://images.maxpreps.com.edgesuite.net/TeamPhoto/mmFzbidHCE2MZGUWxOpemw/yT0eCj5bR06JWe55POgb8A/3,140/1415191089_cobras_contreras_girls_varsity_volleyball_fall_14-15.jpg" alt="Generic placeholder image" height="140" width="140">
                            <h2> Vestibulum id ligula</h2>
                            <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis
                                in, egestas eget quam. Vestibulum id ligula porta felis euismod semper.
                                Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
                                ut fermentum massa justo sit amet risus.</p>

                        </div><!-- /.col-lg-4 -->
                    </div><!-- /.row -->


                    <!-- START THE FEATURETTES -->

                    <hr class="featurette-divider">

                    <div class="row featurette">
                        <div class="col-md-7">
                            <h2 class="featurette-heading">First featurette heading. <span class="text-muted">It'll blow your mind.</span></h2>
                            <p class="lead">Donec ullamcorper nulla non metus auctor
                                fringilla. Vestibulum id ligula porta felis euismod semper. Praesent
                                commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus,
                                tellus ac cursus commodo.</p>
                        </div>
                        <div class="col-md-5">
                            <img data-holder-rendered="true" src="https://s-media-cache-ak0.pinimg.com/736x/33/f6/a7/33f6a713de20f9bcf75c197cedffc635.jpg" class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="500x500">
                        </div>
                    </div>

                    <hr class="featurette-divider">

                    <div class="row featurette">
                        <div class="col-md-7 col-md-push-5">
                            <h2 class="featurette-heading">Oh yeah, it's that good. <span class="text-muted">See for yourself.</span></h2>
                            <p class="lead">Donec ullamcorper nulla non metus auctor
                                fringilla. Vestibulum id ligula porta felis euismod semper. Praesent
                                commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus,
                                tellus ac cursus commodo.</p>
                        </div>
                        <div class="col-md-5 col-md-pull-7">
                            <img data-holder-rendered="true" src="http://www.improveyourvolley.com/images/volleyballgirlpassingtheballtothesetterphotobychar1iej1.jpg" class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="500x500">
                        </div>
                    </div>

                    <hr class="featurette-divider">

                    <div class="row featurette">
                        <div class="col-md-7">
                            <h2 class="featurette-heading">And lastly, this one. <span class="text-muted">Checkmate.</span></h2>
                            <p class="lead">Donec ullamcorper nulla non metus auctor
                                fringilla. Vestibulum id ligula porta felis euismod semper. Praesent
                                commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus,
                                tellus ac cursus commodo.</p>
                        </div>
                        <div class="col-md-5">
                            <img data-holder-rendered="true" src="http://www.evovball.com/wp-content/uploads/2015/10/10384914_1564651700480761_3930099888588517135_n2-500x500.jpg" class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="500x500">
                        </div>
                    </div>

                    <hr class="featurette-divider">

                    <!-- /END THE FEATURETTES -->

            </div>
        </div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="/static/js/jquery.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="/static/js/bootstrap.js"></script>





            <svg style="display: none; visibility: hidden; position: absolute; top: -100%; left: -100%;" preserveAspectRatio="none" viewBox="0 0 500 500" height="500" width="500" xmlns="http://www.w3.org/2000/svg"><defs><style type="text/css"></style></defs><text style="font-weight:bold;font-size:25pt;font-family:Arial, Helvetica, Open Sans, sans-serif" y="25" x="0">500x500</text></svg>
    </body>
</html>
