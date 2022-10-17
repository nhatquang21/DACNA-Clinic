<%-- 
    Document   : index
    Created on : May 26, 2022, 12:07:27 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/assets/img/apple-icon.png">
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/assets/img/favicon.png">
        <title>
            Quản lý phòng khám đa khoa
        </title>
        <!--     Fonts and icons     -->
        <link rel="stylesheet" type="text/css"
              href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900|Roboto+Slab:400,700" />


        <!-- Font Awesome Icons -->
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
        <!-- Material Icons -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">
        <script src="/clinic/js/jquery.min.js" type="text/javascript"></script>
        <!-- CSS Files -->
        <link href="<c:url value="/assets/css/style.css"/>" rel="stylesheet" type="text/css"/>
    </head>

    <body class="g-sidenav-show  bg-gray-200">
        <aside
            class="sidenav navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-3   bg-gradient-dark"
            id="sidenav-main">
            <div class="sidenav-header">
                <i class="fas fa-times p-3 cursor-pointer text-white opacity-5 position-absolute end-0 top-0 d-none d-xl-none"
                   aria-hidden="true" id="iconSidenav"></i>
                <a class="navbar-brand m-0" href="${pageContext.request.contextPath}/home/dashboard.do"
                   target="_blank">
                    <img src="<c:url value="/assets/img/logo-ct.png"/>" class="navbar-brand-img h-100" alt="main_logo" />
                    <span class="ms-1 font-weight-bold text-white">Quản lý phòng khám</span>
                </a>
            </div>
            <hr class="horizontal light mt-0 mb-2">
            <div class="collapse navbar-collapse  w-auto " id="sidenav-collapse-main" style="overflow: initial !important;">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link text-white bg-gradient-primary  active " href="${pageContext.request.contextPath}/home/dashboard.do">
                            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="material-icons opacity-10">dashboard</i>
                            </div>
                            <span class="nav-link-text ms-1">Dashboard</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white  " href="${pageContext.request.contextPath}/home/index.do">
                            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="material-icons opacity-10">table_view</i>
                            </div>
                            <span class="nav-link-text ms-1">Tiếp nhận bệnh nhân</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white " href="${pageContext.request.contextPath}/home/doctor.do">
                            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="material-icons opacity-10">assignment</i>
                            </div>
                            <span class="nav-link-text ms-1">Khám bệnh</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white " href="${pageContext.request.contextPath}/home/medicine.do">
                            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                                <span class="material-icons">medication</span>
                            </div>
                            <span class="nav-link-text ms-1">Phát thuốc</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white " href="<c:url value="/account/show_patient_history.do"/>" >
                            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="material-icons opacity-10">person</i>
                            </div>
                            <span class="nav-link-text ms-1">Xem lịch sử khám bệnh</span>
                        </a>
                    </li>
                    <li class="nav-item mt-3">
                        <h6 class="ps-4 ms-2 text-uppercase text-xs text-white font-weight-bolder opacity-8">Account pages
                        </h6>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white " href="<c:url value="/account/profile.do"/>" >
                            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="material-icons opacity-10">account_box</i>
                            </div>
                            <span class="nav-link-text ms-1">Profile</span>
                        </a>
                    </li>

                    <li class="nav-item ">
                        <a class="nav-link  text-white " href="${pageContext.request.contextPath}/account/sign_up_form.do">
                            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="material-icons opacity-10">assignment</i>
                            </div>
                            <span class="nav-link-text ms-1">Sign Up</span>
                        </a>
                    </li>
                </ul>
            </div>

        </aside>
        <main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
            <!-- Navbar -->
            <nav class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl" id="navbarBlur"
                 navbar-scroll="true">
                <div class="container-fluid py-1 px-3">

                    <div class="collapse navbar-collapse mt-sm-0 mt-2 me-md-0 me-sm-4" id="navbar" style="
                         display: flex;
                         justify-content: end;">

                        <ul class="navbar-nav  justify-content-end">
                            <li class="nav-item d-flex align-items-center">
                                <c:choose>
                                    <c:when test="${account==null}">
                                        <a href="<c:url value="/account/login.do"/>" class="nav-link text-body font-weight-bold px-0">
                                            <i class="fa fa-user me-sm-1"></i>
                                            <span class="d-sm-inline d-none">Sign In</span>
                                        </a>
                                    </c:when>

                                    <c:otherwise    >

                                        <c:set var="ten" value="${account.benhNhanList[0].ten}"/>
                                        <c:set var="ho" value="${account.benhNhanList[0].ho}"/>
                                        <b style="margin-right: 12px;">Welcome ${account.role == "BacSi" ? "Bác sĩ" : account.role == "TiepTan" ? "Tiếp tân" :  account.role == "PhatThuoc" ? "Nhân viên phát thuốc" : account.role == "BenhNhan" ?  "Bệnh nhân " += ho += " " += ten : "" } ${account.nhanVienList[0].ten} </b> || 
                                        <a  style="margin-left: 12px;" href="<c:url value="/account/logout.do"/>">Logout</a>
                                    </c:otherwise>

                                </c:choose>

                            </li>
                            <li class="nav-item d-xl-none ps-3 d-flex align-items-center">
                                <a href="javascript:;" class="nav-link text-body p-0" id="iconNavbarSidenav">
                                    <div class="sidenav-toggler-inner">
                                        <i class="sidenav-toggler-line"></i>
                                        <i class="sidenav-toggler-line"></i>
                                        <i class="sidenav-toggler-line"></i>
                                    </div>
                                </a>
                            </li>


                        </ul>
                    </div>
                </div>
            </nav>
            <!-- End Navbar -->
            <!-- Content -->

            <jsp:include page="/WEB-INF/views/${controller}/${action}.jsp" />
        </main>
        <div class="fixed-plugin">
            <a class="fixed-plugin-button text-dark position-fixed px-3 py-2">
                <i class="material-icons py-2">settings</i>
            </a>
            <div class="card shadow-lg">
                <div class="card-header pb-0 pt-3">
                    <div class="float-start">
                        <h5 class="mt-3 mb-0">Material UI Configurator</h5>
                        <p>See our dashboard options.</p>
                    </div>
                    <div class="float-end mt-4">
                        <button class="btn btn-link text-dark p-0 fixed-plugin-close-button">
                            <i class="material-icons">clear</i>
                        </button>
                    </div>
                    <!-- End Toggle Button -->
                </div>
                <hr class="horizontal dark my-1">
                <div class="card-body pt-sm-3 pt-0">
                    <!-- Sidebar Backgrounds -->
                    <div>
                        <h6 class="mb-0">Sidebar Colors</h6>
                    </div>
                    <a href="javascript:void(0)" class="switch-trigger background-color">
                        <div class="badge-colors my-2 text-start">
                            <span class="badge filter bg-gradient-primary active" data-color="primary"
                                  onclick="sidebarColor(this)"></span>
                            <span class="badge filter bg-gradient-dark" data-color="dark"
                                  onclick="sidebarColor(this)"></span>
                            <span class="badge filter bg-gradient-info" data-color="info"
                                  onclick="sidebarColor(this)"></span>
                            <span class="badge filter bg-gradient-success" data-color="success"
                                  onclick="sidebarColor(this)"></span>
                            <span class="badge filter bg-gradient-warning" data-color="warning"
                                  onclick="sidebarColor(this)"></span>
                            <span class="badge filter bg-gradient-danger" data-color="danger"
                                  onclick="sidebarColor(this)"></span>
                        </div>
                    </a>
                    <!-- Sidenav Type -->
                    <div class="mt-3">
                        <h6 class="mb-0">Sidenav Type</h6>
                        <p class="text-sm">Choose between 2 different sidenav types.</p>
                    </div>
                    <div class="d-flex">
                        <button class="btn bg-gradient-dark px-3 mb-2 active" data-class="bg-gradient-dark"
                                onclick="sidebarType(this)">Dark</button>
                        <button class="btn bg-gradient-dark px-3 mb-2 ms-2" data-class="bg-transparent"
                                onclick="sidebarType(this)">Transparent</button>
                        <button class="btn bg-gradient-dark px-3 mb-2 ms-2" data-class="bg-white"
                                onclick="sidebarType(this)">White</button>
                    </div>
                    <p class="text-sm d-xl-none d-block mt-2">You can change the sidenav type just on desktop view.</p>
                    <!-- Navbar Fixed -->
                    <div class="mt-3 d-flex">
                        <h6 class="mb-0">Navbar Fixed</h6>
                        <div class="form-check form-switch ps-0 ms-auto my-auto">
                            <input class="form-check-input mt-1 ms-auto" type="checkbox" id="navbarFixed"
                                   onclick="navbarFixed(this)">
                        </div>
                    </div>
                    <hr class="horizontal dark my-3">
                    <div class="mt-2 d-flex">
                        <h6 class="mb-0">Light / Dark</h6>
                        <div class="form-check form-switch ps-0 ms-auto my-auto">
                            <input class="form-check-input mt-1 ms-auto" type="checkbox" id="dark-version"
                                   onclick="darkMode(this)">
                        </div>
                    </div>
                    <hr class="horizontal dark my-sm-4">
                    <a class="btn bg-gradient-info w-100"
                       href="https://www.creative-tim.com/product/material-dashboard">Free Download</a>
                    <a class="btn btn-outline-dark w-100"
                       href="https://www.creative-tim.com/learning-lab/bootstrap/overview/material-dashboard">View
                        documentation</a>
                    <div class="w-100 text-center">
                        <a class="github-button" href="https://github.com/creativetimofficial/material-dashboard"
                           data-icon="octicon-star" data-size="large" data-show-count="true"
                           aria-label="Star creativetimofficial/material-dashboard on GitHub">Star</a>
                        <h6 class="mt-3">Thank you for sharing!</h6>
                        <a href="https://twitter.com/intent/tweet?text=Check%20Material%20UI%20Dashboard%20made%20by%20%40CreativeTim%20%23webdesign%20%23dashboard%20%23bootstrap5&amp;url=https%3A%2F%2Fwww.creative-tim.com%2Fproduct%2Fsoft-ui-dashboard"
                           class="btn btn-dark mb-0 me-2" target="_blank">
                            <i class="fab fa-twitter me-1" aria-hidden="true"></i> Tweet
                        </a>
                        <a href="https://www.facebook.com/sharer/sharer.php?u=https://www.creative-tim.com/product/material-dashboard"
                           class="btn btn-dark mb-0 me-2" target="_blank">
                            <i class="fab fa-facebook-square me-1" aria-hidden="true"></i> Share
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <script>
            $(document).ready(function () {
                $('.collapse li a').click(function (e) {
                    console.log('a');
                    $('.collapse li a ').removeClass(' bg-gradient-primary');
                  
                    var $parent = $(this).parent();
                    $parent.addClass(' bg-gradient-primary ');
                 S
                
                });
            });
        </script>
    </body>

</html>