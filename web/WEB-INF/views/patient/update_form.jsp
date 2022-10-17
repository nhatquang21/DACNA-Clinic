<%-- 
    Document   : index
    Created on : May 3, 2022, 1:36:36 PM
    Author     : ADMIN
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="container-fluid py-4">

    <div class="row">

        <div class="col-12">
            <div class="card my-4">

                <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                    <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                        <h6 class="text-white  ps-3">Chỉnh sửa hồ sơ bệnh nhân </h6>
                    </div>
                </div>
                <div class="card-body px-0 pb-2">
                    <div class="patient__Content d-flex flex-column justify-content-center align-items-center">

                        <div class="addpatient__Form container">
                            <div class="title">Chỉnh sửa hồ sơ bệnh nhân mới</div>
                            <div class="content">
                                <form method="post" action="<c:url value="/patient/update_patient.do" />"  enctype="multipart/form-data">
                                    <input type="hidden" value="${bn.id}" name="txtId"/>
                                    <input type="hidden" value="${bn.idUser.id}" name="txtIdUser"/>
                                    <div class="user-details">
                                        <div class="input-box">
                                            <span class="details">Họ </span>
                                            <input value="${bn.ho}"  name="txtHo" type="text" placeholder="Nhập họ " required>
                                        </div>
                                        <div class="input-box">
                                            <span class="details">Tên</span>
                                            <input value="${bn.ten}"  name="txtTen"  type="text" placeholder="Nhập tên" required>
                                        </div>
                                        <div class="input-box">
                                            <span class="details">Email</span>
                                            <input  value="${bn.email}"  name="txtEmail" type="text" placeholder="Nhập email" required>
                                        </div>
                                        <div class="input-box">
                                            <span class="details">Số điện thoại</span>
                                            <input  value="${bn.sdt}"  name="txtPhone" type="text" placeholder="Nhập số điện thoại" required>
                                        </div>
                                        <div class="input-box">
                                            <span class="details">Ngày sinh</span>
                                            <input value="<fmt:formatDate pattern="yyyy-MM-dd" value="${bn.ngaySinh}" />" name="txtBirth" type="date" id="birthday" name="birthday" >
                                        </div>
                                        <div class="input-box">
                                            <span class="details">Địa chỉ nhà</span>
                                            <input  value="${bn.diaChi}"  name="txtAddress" type="text" placeholder="Nhập địa chỉ" required>
                                        </div>
                                    </div>
                                    <div class="gender-details">
                                        <input type="radio" name="gender" id="dot-1">
                                        <input type="radio" name="gender" id="dot-2">

                                        <span class="gender-title">Giới tính</span>
                                        <select name="txtGender" id="txtGender">
                                            <c:set var="mystring" value="${bn.gioiTinh}"/>
                                            <c:choose>

                                                <c:when test="${fn:substring(mystring, 0,3) == 'nam'}">
                                                    <option value="nam">Nam </option>
                                                    <option value="nu">Nữ</option>
                                                </c:when>

                                                <c:otherwise    >
                                                    <option value="nu">Nữ</option>
                                                    <option value="nam">Nam </option>

                                                </c:otherwise>

                                            </c:choose>
                                        </select>

                                    </div>
                                    <div class="input-box">
                                        <span class="details">Hình </span>
                                        <input type="file" name="file" size="60" >
                                    </div>
                                    <div class="button">
                                        <input type="submit" value="Update" name="op">
                                    </div>
                                    <div> ${result}</div>
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
