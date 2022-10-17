<%-- 
    Document   : index
    Created on : May 3, 2022, 1:36:36 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<div class="container-fluid py-4">

    <div class="row">

        <div class="col-12">
            <div class="card my-4" style="height: 400px;">

                <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                    <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                        <h6 class="text-white  ps-3">Dashboard</h6>
                    </div>
                </div>
                <div class="card-body px-0 pb-2"  style="
                     display: flex;
                     justify-content: center;
                     align-items: center;
                     ">
                    <h1 >Phòng khám đa khoa Hi vọng</h1>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="/WEB-INF/layouts/footer.jsp" />
</div>
