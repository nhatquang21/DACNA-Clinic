<%-- 
    Document   : index
    Created on : May 3, 2022, 1:36:36 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<div class="container-fluid py-4">
    <a  href="${pageContext.request.contextPath}/patient/register_form.do"  type="submit" class="mb-2 add__Patient btn btn-success" style="margin: 16px 0 16px 16px" >
        Tạo hồ sơ bệnh nhân mới
    </a>
    <a  href="${pageContext.request.contextPath}/patient/find_patient_form.do"  type="submit" class="mb-2 add__Patient btn btn-danger" style="margin: 16px 0 16px" >
        Tìm hồ sơ bệnh nhân
    </a>
    <div class="row">

        <div class="col-12">
            <div class="card my-4">

                <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                    <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                        <h6 class="text-white  ps-3">Danh sách bệnh nhân hôm nay</h6>
                    </div>
                </div>
                <div class="card-body px-0 pb-2">
                    <div class="table-responsive p-0">
                        <table class="table align-items-center mb-0">
                            <thead>
                                <tr>
                                    <th
                                        class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                        Họ tên</th>
                                    <th
                                        class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                                        Số điện thoại</th>
                                    <th
                                        class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                        Ngày sinh</th>
                                    <th
                                        class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                        Địa chỉ</th>

                                    <th class="text-secondary opacity-7"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="tt" items="${list}">


                                    <tr>
                                        <td>
                                            <div class="d-flex px-2 py-1">
                                                <div style="
                                                     display: flex;
                                                     align-items: center;
                                                     ">
                                                    <img src="${pageContext.request.contextPath}/images/${tt.idBenhNhan.id}.jpg"
                                                         class="avatar avatar-sm me-3 border-radius-lg" alt="user1">
                                                </div>
                                                <div class="d-flex flex-column justify-content-center">
                                                    <h6 class="mb-0 fs-5">${tt.idBenhNhan.ho} ${tt.idBenhNhan.ten}</h6>
                                                    <p class="fs-6 text-secondary mb-0">${tt.idBenhNhan.email}</p>
                                                </div>
                                            </div>
                                        </td>

                                        <td>
                                            <p class="fs-6 font-weight-bold mb-0">${tt.idBenhNhan.sdt}</p>

                                        </td>
                                        <td class="align-middle text-center">

                                            <span class="text-secondary fs-6 ">
                                                <fmt:formatDate pattern="yyyy-MM-dd" value="${tt.idBenhNhan.ngaySinh}" />
                                            </span>
                                        </td>
                                        <td class="align-middle text-center">
                                            <span class="text-secondary fs-6 f">${tt.idBenhNhan.diaChi}</span>
                                        </td>
                                        <td class="table__Action align-middle text-center text-sm">
                                            <a href="${pageContext.request.contextPath}/patient/update_form.do?id=${tt.idBenhNhan.id}" class="badge badge-sm bg-gradient-warning" style="padding: 12px 10px; cursor: pointer;">Edit</a>
                                         
                                        </td>


                                    </tr>   
                                </c:forEach>      


                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="/WEB-INF/layouts/footer.jsp" />
</div>
