<%-- 
    Document   : medicine
    Created on : May 3, 2022, 1:37:03 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="/clinic/js/jquery.min.js" type="text/javascript"></script>
        <%--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>--%>
    </head>
    <body onload="showPT()">
        <div class="container-fluid py-4">
            <div class="row">
                <div class="col-12">
                    <div class="card my-4">
                        <div class="card-body px-0 pb-2">
                            <h1>Phát Thuốc</h1>                                                                                                  
                            <div class="container mt-5">
                                <div class="row">
                                    <div class="col-sm-3" >       
                                        <h3>Bệnh nhân chờ phát thuốc</h3>                                                       
                                        <select id="list" name="list" style="width:100%;" size="10">            
                                        </select>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="description">
                                            <h3>Thông tin bệnh nhân </h3>
                                            <p>Họ tên bệnh nhân:
                                                <span class="color-red" id="hoten">  </span>
                                            </p>
                                            <p>Năm sinh:
                                                <span class="color-red" id="namsinh">  </span>
                                            </p>
                                            <p>Phát thuốc:                                           
                                                <select id="listpt"  >                                                    
                                                </select>                                                                                           
                                            </p>        	                                           
                                             <p>Chẩn đoán:
                                                <span class="color-red" id="chandoan">  </span>
                                            </p>                                                                                               	
                                        </div>
                                        <input type="submit"  onclick="deleteTT()" class="btn btn-success" value="Phat Thuoc">
                                    </div>

                                    <div class="col-sm-3">                                        
                                        <h3>Tra cứu thuốc</h3>     
                                        <div class="input-group mb-3">               
                                            <input oninput="searchThuoc(this)" type="text" class="form-control" name="search" placeholder="Search">                                                                   
                                        </div>      
                                        <div class="table-responsive">
                                            <table class="w3-table w3-border w3-hoverable">
                                                <thead>
                                                    <tr>                    
                                                        <th>ID</th>
                                                        <th>Ten thuoc</th>
                                                        <th>So luong </th>                    
                                                    </tr>
                                                </thead>
                                                <tbody  id="listT">                                                                                                                                                                                         	
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>                                    
                                </div>
                            </div>

                            <div class="container mt-1">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <h3>Toa thuốc chi tiết </h3>
                                        <div class="table-responsive">
                                            <table class="table table-bordered" id="tableT">
                                                <thead>
                                                    <tr>
                                                        <th>ID toa </th>
                                                        <th>Tên thuốc</th>       	
                                                        <th>Sáng </th>                                                       
                                                        <th>Chiều </th>
                                                        <th>Tối </th>
                                                        <th>Cách dùng </th>
                                                    </tr>
                                                </thead>
                                                <tbody id="body">                                                                                                                                                         
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>                           
                            <script>
                                $("#list").change(function () {
                                    var selectedOption = $(this).find('option:selected');
                                    var bn = selectedOption.data("bn");//Lấy info từ thuộc tính data của option
                                    $("#hoten").html(bn.ho + " " + bn.ten);
                                    $("#namsinh").html(bn.ngaysinh);
                                    var idbnselected = selectedOption.val();
                                    //console.log(idbnselected);
                                    $.ajax({
                                        url: "/clinic/mprocess", //Ten controller xu ly yeu cau
                                        method: "GET",
                                        async: true, //Xu ly yeu cau bat dong bo
                                        cache: false, //Khong cache du lieu
                                        dataType: "json", //Kieu du lieu server gui ve                                       
                                        data: {//Du lieu gui len server      
                                            action: "getToaAsBNPT",
                                            id: idbnselected
                                        },
                                        beforeSend: function () {//Chay truoc khi gui yeu cau len server                                            
                                        }
                                    }).done(function (idtoaselected) {//Lay ket qua server gui ve
                                       //console.log(idtoaselected);
                                       newResult=idtoaselected.chandoan;
                                       $("#chandoan").html(newResult);
                                    }).fail(function (xhr, status) {//Xu ly loi
                                        $("#divResult").html("HTTP error: " + status + ": " + xhr.statusText);
                                    }).always(function () {//Luon duoc thuc hien sau khi xu ly xong yeu cau
                                    });
                                    $.ajax({
                                        url: "/clinic/mprocess", //Ten controller xu ly yeu cau
                                        method: "GET",
                                        async: true, //Xu ly yeu cau bat dong bo
                                        cache: false, //Khong cache du lieu
                                        //dataType: "json", //Kieu du lieu server gui ve                                       
                                        data: {//Du lieu gui len server      
                                            action: "getToaCTAsBNPT",
                                            id: idbnselected
                                        },
                                        beforeSend: function () {//Chay truoc khi gui yeu cau len server                                            
                                        }
                                    }).done(function (data) {//Lay ket qua server gui ve
                                       //console.log(idtoaselected);
                                       newResult= data;
                                       $("#body").html(newResult);
                                    }).fail(function (xhr, status) {//Xu ly loi
                                        $("#divResult").html("HTTP error: " + status + ": " + xhr.statusText);
                                    }).always(function () {//Luon duoc thuc hien sau khi xu ly xong yeu cau
                                    });
                                });
                                function deleteTT(){
                                    $("#list").find('option:selected').remove();
                                    $("#hoten").empty();
                                    $("#namsinh").empty();
                                    $("#chandoan").empty();
                                    $("#body").find('tr').remove();  
                                }
                                function showPT(){
                                   $.ajax({
                                        url: "/clinic/mprocess", //Ten controller xu ly yeu cau
                                        method: "GET",
                                        async: true, //Xu ly yeu cau bat dong bo
                                        cache: false, //Khong cache du lieu
                                        dataType: "json", //Kieu du lieu server gui ve                                       
                                        data: {//Du lieu gui len server      
                                            action: "showPT"
                                        },
                                        beforeSend: function () {//Chay truoc khi gui yeu cau len server
                                            console.log("asd");
                                        }
                                    }).done(function (listNV) {//Lay ket qua server gui ve  
                                        //console.log(data);
                                        listNV.forEach(function (nv) {
                                            newResult = nv.ho + " " + nv.ten;
                                            var option = $("<option>");//Tạo phần tử option mới
                                            option.text(newResult);//Gán giá trị cho thuộc tính text của option
                                            option.val(nv.id);//Gán giá trị cho thuộc tính value của option
                                            option.data("nv", nv);//Lưu info vào phần tử option
                                            $("#listpt").append(option);
                                        });
                                    }).fail(function (xhr, status) {//Xu ly loi
                                        $("#divResult").html("HTTP error: " + status + ": " + xhr.statusText);
                                    }).always(function () {//Luon duoc thuc hien sau khi xu ly xong yeu cau
                                    });

                                }
                                function searchThuoc(param) {
                                    var searchTxt = param.value;
                                    $.ajax({
                                        url: "/clinic/mprocess", //Ten controller xu ly yeu cau
                                        method: "GET",
                                        async: true, //Xu ly yeu cau bat dong bo
                                        cache: false, //Khong cache du lieu
                                        //dataType: "json", //Kieu du lieu server gui ve                                       
                                        data: {//Du lieu gui len server      
                                            action: "getMedPT",
                                            txt: searchTxt
                                        },
                                        beforeSend: function () {//Chay truoc khi gui yeu cau len server                                            
                                        }
                                    }).done(function (data) {//Lay ket qua server gui ve  
                                        console.log(data);
                                        newResult = data;
                                        //var option = $("<option>");//Tạo phần tử option mới
                                        //option.text(newResult);//Gán giá trị cho thuộc tính text của option
                                        //option.val(patient.id);//Gán giá trị cho thuộc tính value của option
                                        //option.data("patient", patient);//Lưu info vào phần tử option
                                        $("#listT").html(newResult);
                                    }).fail(function (xhr, status) {//Xu ly loi
                                        $("#divResult").html("HTTP error: " + status + ": " + xhr.statusText);
                                    }).always(function () {//Luon duoc thuc hien sau khi xu ly xong yeu cau
                                    });
                                }                               
                                //Cứ 1 giây gửi yêu cầu lên server 1 lần
                                setInterval(function () {
                                    $.ajax({
                                        url: "/clinic/mprocess", //Ten controller xu ly yeu cau
                                        method: "GET",
                                        async: true, //Xu ly yeu cau bat dong bo
                                        cache: false, //Khong cache du lieu
                                        dataType: "json", //Kieu du lieu server gui ve                                       
                                        data: {//Du lieu gui len server      
                                            action: "getToaPT"
                                        },
                                        beforeSend: function () {//Chay truoc khi gui yeu cau len server                                            
                                        }
                                    }).done(function (listTT) {//Lay ket qua server gui ve  
                                        console.log(listTT);
                                        listTT.forEach(function (tt) {
                                            //getBN
                                            var idbn = tt.idbenhnhan;
                                            $.ajax({
                                                url: "/clinic/dprocess", //Ten controller xu ly yeu cau
                                                method: "GET",
                                                async: true, //Xu ly yeu cau bat dong bo
                                                cache: false, //Khong cache du lieu
                                                dataType: "json", //Kieu du lieu server gui ve                                       
                                                data: {//Du lieu gui len server      
                                                    action: "getPatient",
                                                    id: idbn
                                                },
                                                beforeSend: function () {//Chay truoc khi gui yeu cau len server                                            
                                                }
                                            }).done(function (bn) {//Lay ket qua server gui ve  
                                                console.log(bn);
                                                newResult = bn.ho + " " + bn.ten;
                                                var option = $("<option>");//Tạo phần tử option mới
                                                option.text(newResult);//Gán giá trị cho thuộc tính text của option
                                                option.val(bn.id);//Gán giá trị cho thuộc tính value của option
                                                option.data("bn", bn);//Lưu info vào phần tử option
                                                $("#list").append(option);
                                            }).fail(function (xhr, status) {//Xu ly loi
                                                $("#divResult").html("HTTP error: " + status + ": " + xhr.statusText);
                                            }).always(function () {//Luon duoc thuc hien sau khi xu ly xong yeu cau
                                            }); //getBN                                           
                                        });
                                    }).fail(function (xhr, status) {//Xu ly loi
                                        $("#divResult").html("HTTP error: " + status + ": " + xhr.statusText);
                                    }).always(function () {//Luon duoc thuc hien sau khi xu ly xong yeu cau
                                    });
                                }, 5000);
                            </script>                                         
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="/WEB-INF/layouts/footer.jsp" />
        </div>
    </body>
</html>
