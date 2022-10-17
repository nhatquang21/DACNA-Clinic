<%-- 
    Document   : show_patient_history
    Created on : Jul 19, 2022, 10:01:29 AM
    Author     : huytd
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
                        <h6 class="text-white  ps-3">Lịch sử khám bệnh</h6>
                    </div>
                </div>
                <div class="card-body px-0 pb-2">
                    <div class="table-responsive p-0">
                        <table class="table align-items-center mb-0">
                            <thead>
                                <tr>
                                    <th
                                        class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                        Ngày khám</th>
                                   
                                    <th
                                        class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                        Bác sĩ chẩn đoán</th>
                                    <th
                                        class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                       Chẩn đoán</th>

                                    <th class="text-secondary opacity-7"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="tt" items="${list}">
                                    <tr>
                                        <td class="align-middle ">

                                            <span class="text-secondary fs-6 font-weight-bold" style="padding-left: 13px;">
                                                <fmt:formatDate pattern="dd-MM-yyyy" value="${tt.ngayTao}" />
                                            </span>
                                        </td>
                                     
                                        <td>
                                            <p class="fs-6 font-weight-bold mb-0 text-center" >${tt.idBacSi.ho} ${tt.idBacSi.ten}</p>

                                        </td>
                                        
                                        <td class="align-middle text-center">
                                            <span class="text-secondary fs-6 f">${tt.chanDoan}</span>
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
