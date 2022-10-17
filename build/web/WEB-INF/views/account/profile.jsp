<%-- 
    Document   : index
    Created on : May 3, 2022, 1:36:36 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<div class="container-fluid py-4">

    <div class="row">

        <div class="col-12">
            <div class="card my-4">

                <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                    <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                        <h6 class="text-white  ps-3">Thông tin tài khoản</h6>
                    </div>
                </div>
                <div class="card-body px-0 pb-2">
                    <div class="patient__Content d-flex flex-column justify-content-center align-items-center">

                        <div class="addpatient__Form container">
                            <div class="title">Đổi mật khẩu</div>
                            <div class="content">
                                <form action="${pageContext.request.contextPath}/account/profile_handler.do" >
                                    <div class="user-details"  style="
                                         flex-direction: column;
                                         ">
                                        <div class="input-box">

                                            <input  name="txtPwd" type="password" placeholder="Nhập mật khẩu hiện tại " required>
                                        </div>
                                        <div style="display: block;" class="input-box">

                                            <input  name="txtNewPwd"  type="password" placeholder="Nhập mật khẩu mới" >
                                        </div>
                                        <div style="display: block;" class="input-box">

                                            <input  name="txtConfPwd"  type="password" placeholder="Nhập lại mật khẩu mới" >
                                        </div>
                                    </div>

                                    <div class="button">
                                        <input type="submit" value="Đổi mật khẩu" style="
                                               background: linear-gradient(195deg, #EC407A 0%, #D81B60 100%);
                                               " name="op">
                                    </div>
                                    <div style="
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
