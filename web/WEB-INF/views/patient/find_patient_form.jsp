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
            <div class="card my-4">

                <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                    <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                        <h6 class="text-white  ps-3">Tìm kiếm hồ sơ bệnh nhân</h6>
                    </div>
                </div>
                <div class="card-body px-0 pb-2">
                    <div class="patient__Content d-flex flex-column justify-content-center align-items-center">

                        <div class="addpatient__Form container">
                            <div class="title">Tìm kiếm hồ sơ </div>
                            <div class="content">
                                <form action="${pageContext.request.contextPath}/patient/find_patient.do" >
                                    <div class="user-details">
                                        <div class="input-box">
                                            <span class="details"> </span>
                                            <input value="${info}"  name="txtInfo" type="text" placeholder="Mời bạn nhập thông tin " required>
                                        </div>

                                    </div>
                                    <div class="gender-details">
                                        <input type="radio" name="gender" id="dot-1">
                                        <input type="radio" name="gender" id="dot-2">

                                        <span class="gender-title">Tìm theo</span>
                                        <select name="txtChoice" id="txtGender">
                                            <option value="sdt">số điện thoại </option>
                                            <option value="email">email</option>
                                        </select>

                                    </div>

                                    <div class="button">
                                        <input type="submit" value="Tìm" name="op">
                                    </div>
                                    <div  style="
                                          font-style: italic;
                                          color: red;
                                          font-weight: 600;
                                          "> ${result}</div>
                                </form>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>

    </div>

    <jsp:include page="/WEB-INF/layouts/footer.jsp" />
</div>
