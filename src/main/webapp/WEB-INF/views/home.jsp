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
                                        <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
                                            <li><a href="<c:url value='/match/new' />">Создать</a></li>
                                            <li role="separator" class="divider"></li>
                                        </sec:authorize>

                                        <li><a href="<c:url value='/match/list' />">Список матчей</a></li>

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
                            <h2>Женская сборная. Гран-при. 2-й игровой уикенд. Группа «F1». 1-й тур. Россия – Голландия – 3:0</h2>
                            <p>Россиянки (главный тренер – Юрий Маричев) одержали четвертую подряд победу со старта Гран-при.
                                В Бари (Италия) 17 июня обыграна команда Голландии – 3:0. Мини-турнир группы «F1» проходит в Бари
                                (Италия). С Голландией (наш соперник по победному финалу Евро-2015)
                                уже встречались в первом игровом уикенде в Калининграде, тогда взяли верх в четырех сетах. </p>

                        </div><!-- /.col-lg-4 -->
                        <div class="col-lg-4">
                            <img class="img-responsive" src="http://cdn9.staztic.com/app/a/3318/3318172/tampa-united-volleyball-1-l-140x140.png" alt="Generic placeholder image" height="140" width="140">
                            <h2>Мужская сборная. Мировая лига. 1-й игровой уикенд. Группа «С1» в Калининграде. Россия – Сербия – 0:3</h2>
                            <p>Мужская сборная России (главный тренер – Владимир Алекно) начала свое участие в Мировой лиге 2016
                                с поражения от Сербии – 0:3. Мини-турнир группы «С1» проходит в Калининграде.
                            </p>

                        </div><!-- /.col-lg-4 -->
                        <div class="col-lg-4">
                            <img class="img-responsive" src="http://images.maxpreps.com.edgesuite.net/TeamPhoto/mmFzbidHCE2MZGUWxOpemw/yT0eCj5bR06JWe55POgb8A/3,140/1415191089_cobras_contreras_girls_varsity_volleyball_fall_14-15.jpg" alt="Generic placeholder image" height="140" width="140">
                            <h2>Лига чемпионов. Казанский «Зенит» - четырехкратный обладатель трофея!
                            </h2>
                            <p>
                                Казанский «Зенит» в финале мужской Лиги чемпионов на «Таурон Арене» в Кракове (Польша)
                                одержал волевую победу над итальянским клубом «Тренто», отбившись со счета 0:2 – итоговый результат
                                3:2. «Зенит» отстоял звание лучшей команды Лиги чемпионов и получил его в четвертый раз (рекорд
                                турнира). Представители России уже пять лет бессменно владеют главным континентальным трофеем!</p>

                        </div><!-- /.col-lg-4 -->
                    </div><!-- /.row -->


                    <!-- START THE FEATURETTES -->

                    <hr class="featurette-divider">

                    <div class="row featurette">
                        <div class="col-md-7">
                            <h2 class="featurette-heading">В финальном матче Кубка России – 2014 среди мужских команд памяти Константина Ревы казанский «Зенит» переиграл новосибирский «Локомотив» со счетом <span class="text-muted">3:0 (25:20, 25:19, 25:22).</span></h2>
                            <p class="lead">Владимир Алекно, главный тренер «Зенита»:<br>
                                Этот титул, этот турнир «Зенит» не выигрывал давно. Особенно приятна эта победа в канун Нового Года. Рад, что команда
                                выдержала. Рад за связующего Игоря Кобзаря, что он доказал свой уровень, свой профессионализм. Хорошо поработали здесь.
                                Полетела подача. А как вы знаете, подача это результат душевного состояния. Когда внутри спокойно, и я попытался создать
                                такие условия команде. Больше я работал над собой, что бы не срываться, не кричать. Когда спокоен тренер – спокойна команда.
.</p>
                        </div>
                        <div class="col-md-5">
                            <img data-holder-rendered="true" src="https://s-media-cache-ak0.pinimg.com/736x/33/f6/a7/33f6a713de20f9bcf75c197cedffc635.jpg" class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="500x500">
                        </div>
                    </div>

                    <hr class="featurette-divider">

                    <div class="row featurette">
                        <div class="col-md-7 col-md-push-5">
                            <h2 class="featurette-heading">"Омичка" (Омская область) - "Ярославна-ТМЗ" -  <span class="text-muted">3:0 (25:22,25:23,25:16)</span></h2>
                            <p class="lead">

                                Между командами из Омской и Ярославской областей пропасть в две лиги.
                                Ничего сверхестественного от подопечных Владимира Пилипенко ждать не приходилось после того,
                                как команда отказалась от перехода в Высшую лигу "А". Тем не менее в двух первых партиях тутаевские
                                девушки не давали расслабиться более именитым соперницам. Однако запас в мастерстве у омичек таков,
                                что выигрывать они обязаны, что сделали. В третьем сете уже борьба была формальной - 25:16 и,
                                соответственно, 3:0 - победа "Омички". </p>
                        </div>
                        <div class="col-md-5 col-md-pull-7">
                            <img data-holder-rendered="true" src="http://www.improveyourvolley.com/images/volleyballgirlpassingtheballtothesetterphotobychar1iej1.jpg" class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="500x500">
                        </div>
                    </div>

                    <hr class="featurette-divider">

                    <div class="row featurette">
                        <div class="col-md-7">
                            <h2 class="featurette-heading">Кубок молодежной лиги у <span class="text-muted">«Уралочки-НТМК»</span></h2>
                            <p class="lead">Новый и первый трофей в женской молодежной лиги у «Уралочки-НТМК»!
                                В финальном матче «уралочки» вырвали победу у «Динамо-Академия-УОР» из Казани со счетом 3:2 (14:25; 23:25; 25:23; 25:13; 15:6) Первые два сеты «динамовки» уверенно шли впереди и выигрывали концовки партий, но в переломном третьем сете «уралочки» проявили характер, и выиграли финальный интересный матч турнира!

                                Третье место у саратовского «Протона», который обыграл команду
                                «Подмосковье»  со счетом 3:1 (24:14; 20:25; 25:10; 25:14)</p>
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
