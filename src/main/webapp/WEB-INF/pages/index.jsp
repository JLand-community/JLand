<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <spring:url value="/resources/assets/css/mainpage.css" var="mainpage"/>
    <spring:url value="/resources/assets/js/app.js" var="app"/>

    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!--font-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Plaster" rel="stylesheet">
    <!--font awesome icons-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">

    <!--my custom styles:-->
    <link rel="stylesheet" href="${mainpage}">

    <title>MainPage</title>
</head>
<body class="main-grid">

<header class="header">
    <input type="checkbox" id="nav-toggle-input" class="nav-toggle__input">
    <nav class="nav-bar">
        <ul class="menu">
            <li class="menu__item"><a href="#" class="menu__link menu__link--active ">Home</a></li>
            <li class="menu__item"><a href="#" class="menu__link">Apply for presentation</a></li>
            <li class="menu__item"><a href="#" class="menu__link">Participants</a></li>
            <li class="menu__item"><a href="#" class="menu__link">All Requests</a></li>
        </ul>
        <form action="#" method="post" class="logout">
            <!--div class="logout__title">Logout</div-->
            <button class="logout__button" title="Logout">
                <i class="fas fa-sign-out-alt logout__icon"></i>
            </button>
        </form>
    </nav>
    <!--img src="img/7.png" alt="The JLand logo" class="logo"-->
    <div class="logo ">
        <p class="logo__letter logo__letter--j logo__letter--plaster">j</p>
        <p class="logo__letter logo__letter--l logo__letter--plaster">l</p>
        <p class="logo__letter logo__letter--amp logo--decoration">&</p>
    </div>

    <label for="nav-toggle-input" class="nav-toggle__label">
        <i class="fas fa-bars nav-toggle-label__icon"></i>
    </label>
</header>

<section class="date-place ">
    <div class="welcome-info welcome-info--decoration">
        <h1>Some welcome information, what Java Community is and for whom...</h1>
    </div>

    <div class="date-place__board">
        <img src="../../../frontend/img/whiteboard2fhd.png" alt="" class="date-place__board--size">
    </div>

    <div class="date-place__item ">
        <div class="date-place__item--grid">
            <div class="date-place__info">Next Java Community is going to be:</div>
            <div class="date-and-place__when">13.10.2018</div>
            <div class="date-and-place__where">Andrey Fabra Str., 2 (International House)
                <a href="#" class="date-and-place__link" title="Map link">
                    <i class="fas fa-map-marker-alt date-and-place__map-icon--size"></i>
                </a>
            </div>
        </div>

    </div>
    <div class="user ">
        <div class="user__grid user--decoration">
            <img src="https://bit.ly/2KRYNb8" alt="User avatar" class="user__avatar user__avatar--resize">
            <div class="user__name">User Name</div>
            <form action="#" method="post" class="register">
                <button class="register__button register__button--not register__button--inactive">

                    <div class="register__icon--not">
                        <i class="fas fa-door-open"></i>
                        <i class="fas fa-walking  register__icon--mirror"></i>
                    </div>
                    <div class="register__button--text">No</div>
                </button>
                <button class="register__button register__button--go register__button--active">
                    <div class="register__button--text">Go</div>
                    <div class="register__icon--go">
                        <i class="fas fa-walking register__icon--active"></i>
                        <i class="fas fa-door-open register__icon--mirror register__icon--active"></i>
                    </div>

                </button>
            </form>
        </div>
    </div>
</section>

<section class="agenda">

    <div class="agenda__header agenda__header--decoration">
        <h1 class="agenda__header--title ">Agenda</h1>
        <div class="agenda__dropdown" id="dropdownForAgenda">
            <i class="fas fa-scroll agenda__icon" title="Agenda details"></i>
        </div>
    </div>

    <ul class="agenda__list" id="agendaList">
        <li class="agenda__item welcome-info--decoration">
            <p class="agenda__item-time" contenteditable="true">11:30 - 12:00</p>

                <img src="../../../frontend/img/coffee.png" class="agenda__item--img-coffee">

            <div class="agenda__item-title ">
                <div class="agenda__item-title--coffe">Welcome Coffee</div>
            </div>
        </li>

        <li class="agenda__item welcome-info--decoration agenda__item--presentation-hover">
            <p class="agenda__item-time" contenteditable="true">12:00 - 13:00</p>

            <div class="agenda__item-title">
                <p class="presentation__name">Presentation name</p>
                <p class="presentation__presenter">@Presenter name</p>
            </div>

            <div class="presentation__dropdown" id="dropdownForPresentationName">
                <i class="fas fa-scroll presentation__icon"></i>
            </div>

            <div class="presentation__plan" id="presentationPlanForPresentationName">
                <ul class="presentation__list">
                    <li class="presentation__item">Motivation Motivation Motivation Motivation Motivation
                        Motivation Motivation Motivation Motivation
                    </li>
                    <li class="presentation__item">Overview</li>
                    <li class="presentation__item">RxJava Instruments</li>
                    <li class="presentation__item">Observable</li>
                    <li class="presentation__item">Operators</li>
                    <li class="presentation__item">Single</li>
                    <li class="presentation__item">Subject</li>
                    <!-- <li class="presentation__item presentation__item&#45;&#45;increment"></li>-->
                </ul>
            </div>

        </li>
    </ul>
</section>

<footer class="footer">
    <p class="footer__item"><i class="far fa-copyright footer__icon"></i>2018 JLand. Copyright notice</p>

</footer>

<button id="goUpButton" title="Back to up" class="button-go-up">
    <i class="fas fa-angle-up button-go-up__icon"></i>
</button>


<!--scripts-->
<script src="${app}"></script>
</body>
</html>
