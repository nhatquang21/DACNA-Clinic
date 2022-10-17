
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<body >

    <main class="main-content  mt-0">
        <section>
            <div class="page-header min-vh-100">
                <div class="container">
                    <div class="row">
                        <div class="col-6 d-lg-flex d-none h-100 my-auto pe-0 position-absolute top-0 start-0 text-center justify-content-center flex-column">
                            <div class="position-relative bg-gradient-primary h-100 m-3 px-7 border-radius-lg d-flex flex-column justify-content-center" style="background-image: url('../assets/img/illustrations/illustration-signup.jpg'); background-size: cover;">
                            </div>
                        </div>
                        <div   class="col-xl-4 col-lg-5 col-md-7 d-flex flex-column ms-auto me-auto ms-lg-auto me-lg-5">
                            <div  style="margin-left: -2rem !important;width:500px" class="patient__Content d-flex flex-column justify-content-center align-items-center">

                                <div class="addpatient__Form container">
                                    <div class="title">Đăng ký người dùng</div>
                                    <div class="content">
                                        <form action="${pageContext.request.contextPath}/account/sign_up.do" >
                                            <div class="user-details">
                                                <div class="input-box">
                                                    <span class="details">Họ </span>
                                                    <input  name="txtHo" type="text" placeholder="Nhập họ " required>
                                                </div>
                                                <div class="input-box">
                                                    <span class="details">Tên</span>
                                                    <input  name="txtTen"  type="text" placeholder="Nhập tên" required>
                                                </div>
                                                <div class="input-box">
                                                    <span class="details">Email</span>
                                                    <input   name="txtEmail" type="text" placeholder="Nhập email" required>
                                                </div>
                                                <div class="input-box">
                                                    <span class="details">Số điện thoại</span>
                                                    <input  name="txtPhone" type="text" placeholder="Nhập số điện thoại" required>
                                                </div>
                                                <div class="input-box">
                                                    <span class="details">Ngày sinh</span>
                                                    <input name="txtBirth" type="date" id="birthday" name="birthday" >
                                                </div>
                                                <div class="input-box">
                                                    <span class="details">Địa chỉ nhà</span>
                                                    <input  name="txtAddress" type="text" placeholder="Nhập địa chỉ" required>
                                                </div>
                                            </div>
                                            <div class="role-details">
                                                <input type="radio" name="gender" id="dot-1">
                                                <input type="radio" name="gender" id="dot-2">

                                                <span class="gender-title">Vai trò</span>
                                                <select name="txtRole" id="txtGender">
                                                    <option value="TiepTan">Tiếp tân </option>
                                                    <option value="BacSi">Bác sĩ</option>
                                                    <option value="PhatThuoc">Phát thuốc</option>
                                                </select>

                                            </div>
                                          
                                            <div class="text-center">
                                                <button type="submit" class="btn btn-lg bg-gradient-primary btn-lg w-100 mt-4 mb-0">Sign Up</button>
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
        </section>
    </main>

</body>

