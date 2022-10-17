<%-- 
    Document   : doctor
    Created on : May 3, 2022, 1:36:57 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="/clinic/js/jquery.min.js" type="text/javascript"></script>
        <%--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>--%>
    </head>
    <body onload="showDoctor()">
        <div class="container-fluid py-4">
            <div class="row">
                <div class="col-12">
                    <div class="card my-4">
                        <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                            <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                                <h6 class="text-white  ps-3" style="
                                    font-size: 1.5rem;
                                    line-height: 1.625;
                                    font-weight: 600;
                                    ">Khám bệnh</h6>
                            </div>
                        </div>

                        <div class="card-body px-0 pb-2">

                            <div class="container mt-5">
                                <div class="row">
                                    <div class="col-sm-3" >       
                                        <h3>Bệnh nhân chờ khám </h3>                                                       
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
                                            <p>Bác sĩ kê toa:                                           
                                                <select id="listbs" >                                                    
                                                </select>                                                                                           
                                            </p>        	                                           
                                            <div class="mb-3 mt-3">
                                                <label for="chandoan" class="form-label">Chẩn đoán:</label>
                                                <input type="text" class="form-control" id="chandoan" placeholder="" name="chandoan">
                                            </div>                                                                                                	
                                        </div>
                                        <input type="submit" onclick="setToaInfo(), setToaCT()" class="btn btn-success" value="Submit">
                                        <div id="result"></div>
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
                                                        <th>Tên thuốc</th>
                                                        <th>Số lượng </th>                    
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
                                                <tbody>                                                                                                                                                         
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
                                    $("#result").empty();
                                });
                                function setToaCT() {
                                    var idtoalist = [];
                                    var tenthuoclist = [];
                                    var sang = [];
                                    var chieu = [];
                                    var toi = [];
                                    var cachdung = [];
                                    $("#tableT").find('tbody tr').each(function () {
                                        var row = $(this);
                                        idtoalist.push(row.children('td').eq(0).text());
                                        tenthuoclist.push(row.children('td').eq(1).text());
                                    });
                                    $('input[name^=sang]').each(function () {
                                        sang.push($(this).val());
                                    });
                                    $('input[name^=chieu]').each(function () {
                                        chieu.push($(this).val());
                                    });
                                    $('input[name^=toi]').each(function () {
                                        toi.push($(this).val());
                                    });
                                    $('input[name^=cachdung]').each(function () {
                                        cachdung.push($(this).val());
                                    });
                                    console.log(idtoalist);
                                     console.log(JSON.stringify(idtoalist));
                                    console.log(tenthuoclist);
                                    console.log(JSON.stringify(tenthuoclist));
                                    console.log(sang);
                                    console.log(JSON.stringify(sang));
                                    console.log(chieu);
                                    console.log(JSON.stringify(chieu));
                                    console.log(toi);
                                    console.log(JSON.stringify(toi));
                                    console.log(cachdung);
                                    console.log(JSON.stringify(cachdung));                                   
                                    $.ajax({
                                        url: "/clinic/dprocess", //Ten controller xu ly yeu cau
                                        method: "GET",
                                        async: true, //Xu ly yeu cau bat dong bo
                                        cache: false, //Khong cache du lieu
                                        //dataType: "json", //Kieu du lieu server gui ve                                       
                                        data: {//Du lieu gui len server      
                                            action: "setToaCT",
                                            idtoa: JSON.stringify(idtoalist),
                                            tenthuoc: JSON.stringify(tenthuoclist),
                                            sang: JSON.stringify(sang),
                                            chieu: JSON.stringify(chieu),
                                            toi: JSON.stringify(toi),
                                            cachdung: JSON.stringify(cachdung)
                                        },
                                        beforeSend: function () {//Chay truoc khi gui yeu cau len server
                                            //console.log(idbs);
                                        }
                                    }).done(function (result) {//Lay ket qua server gui ve
                                        console.log(result);
                                        newResult = result;
                                        $("#result").html(newResult);
                                        $("#list").find('option:selected').remove();
                                        $("#hoten").empty();
                                        $("#namsinh").empty();
                                        $("#chandoan").empty();
                                        $("#tableT").find('tr').remove();
                                    }).fail(function (xhr, status) {//Xu ly loi
                                        $("#divResult").html("HTTP error: " + status + ": " + xhr.statusText);
                                    }).always(function () {//Luon duoc thuc hien sau khi xu ly xong yeu cau
                                    });
                                }
                                function setToaInfo() {
                                    var bsselected = $("#listbs").find('option:selected');
                                    var idbs = bsselected.val();
                                    var chandoan = $("#chandoan").val();
                                    var idtoa = $("#toact").find("td:eq(0)").text();
                                    console.log(idtoa);
                                    $("#divValue").html(idtoa);
                                    $.ajax({
                                        url: "/clinic/dprocess", //Ten controller xu ly yeu cau
                                        method: "GET",
                                        async: true, //Xu ly yeu cau bat dong bo
                                        cache: false, //Khong cache du lieu
                                        //dataType: "json", //Kieu du lieu server gui ve                                       
                                        data: {//Du lieu gui len server      
                                            action: "setToaInfo",
                                            id: idbs,
                                            chandoan: chandoan,
                                            idtoa: idtoa
                                        },
                                        beforeSend: function () {//Chay truoc khi gui yeu cau len server
                                            //console.log(idbs);
                                        }
                                    }).done(function () {//Lay ket qua server gui ve  

                                    }).fail(function (xhr, status) {//Xu ly loi
                                        $("#divResult").html("HTTP error: " + status + ": " + xhr.statusText);
                                    }).always(function () {//Luon duoc thuc hien sau khi xu ly xong yeu cau
                                    });
                                }
                                function showDoctor() {
                                    $.ajax({
                                        url: "/clinic/dprocess", //Ten controller xu ly yeu cau
                                        method: "GET",
                                        async: true, //Xu ly yeu cau bat dong bo
                                        cache: false, //Khong cache du lieu
                                        dataType: "json", //Kieu du lieu server gui ve                                       
                                        data: {//Du lieu gui len server      
                                            action: "showDoctor"
                                        },
                                        beforeSend: function () {//Chay truoc khi gui yeu cau len server
                                            //console.log("asd");
                                        }
                                    }).done(function (listNV) {//Lay ket qua server gui ve
                                        console.log(listNV);
                                        listNV.forEach(function (nv) {
                                            newResult = nv.ho + " " + nv.ten;
                                            var option = $("<option>");//Tạo phần tử option mới
                                            option.text(newResult);//Gán giá trị cho thuộc tính text của option
                                            option.val(nv.id);//Gán giá trị cho thuộc tính value của option
                                            //console.log(option.val());
                                            option.data("nv", nv);//Lưu info vào phần tử option
                                            //console.log(option.data());
                                            $("#listbs").append(option);
                                        });
                                    }).fail(function (xhr, status) {//Xu ly loi
                                        $("#divResult").html("HTTP error: " + status + ": " + xhr.statusText);
                                    }).always(function () {//Luon duoc thuc hien sau khi xu ly xong yeu cau
                                    });
                                }
                                function searchThuoc(param) {
                                    var searchTxt = param.value;
                                    $.ajax({
                                        url: "/clinic/dprocess", //Ten controller xu ly yeu cau
                                        method: "GET",
                                        async: true, //Xu ly yeu cau bat dong bo
                                        cache: false, //Khong cache du lieu
                                        //dataType: "json", //Kieu du lieu server gui ve                                       
                                        data: {//Du lieu gui len server      
                                            action: "getMed",
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
                                function addThuoc(param) {
                                    var col2 = $(param).find("td:eq(1)").text(); // get current row 2nd TD
                                    var bnselected = $("#list").find('option:selected');
                                    var idbnselected = bnselected.val();
                                    //console.log(idbnselected);
                                    $.ajax({
                                        url: "/clinic/dprocess", //Ten controller xu ly yeu cau
                                        method: "GET",
                                        async: true, //Xu ly yeu cau bat dong bo
                                        cache: false, //Khong cache du lieu
                                        //dataType: "json", //Kieu du lieu server gui ve                                       
                                        data: {//Du lieu gui len server      
                                            action: "getToaAsBN",
                                            id: idbnselected
                                        },
                                        beforeSend: function () {//Chay truoc khi gui yeu cau len server                                            
                                        }
                                    }).done(function (idtoaselected) {//Lay ket qua server gui ve                                        
                                        var col1 = idtoaselected;
                                        var tr = "<tr id=\"toact\">\n"
                                                + "        	<td>" + col1 + "</td>\n"
                                                + "        	<td name=\"tenthuoc\" class=\"tenthuoc\">" + col2 + "</td>\n"
                                                + "         <td><input type=\"sang\" class=\"form-control\" id=\"sang\" placeholder=\"\" name=\"sang\"></td>\n"
                                                + "         <td><input type=\"chieu\" class=\"form-control\" id=\"chieu\" placeholder=\"\" name=\"chieu\"></td>\n"
                                                + "         <td><input type=\"toi\" class=\"form-control\" id=\"toi\" placeholder=\"\" name=\"toi\"></td>\n"
                                                + "         <td><input type=\"canhdung\" class=\"form-control\" id=\"cachdung\" placeholder=\"\" name=\"cachdung\"></td>"
                                                + "               </tr>";
                                        $("#tableT").append(tr);
                                    }).fail(function (xhr, status) {//Xu ly loi
                                        $("#divResult").html("HTTP error: " + status + ": " + xhr.statusText);
                                    }).always(function () {//Luon duoc thuc hien sau khi xu ly xong yeu cau
                                    });
                                }

                                //Cứ 1 giây gửi yêu cầu lên server 1 lần
                                setInterval(function () {
                                    $.ajax({
                                        url: "/clinic/dprocess", //Ten controller xu ly yeu cau
                                        method: "GET",
                                        async: true, //Xu ly yeu cau bat dong bo
                                        cache: false, //Khong cache du lieu
                                        dataType: "json", //Kieu du lieu server gui ve                                       
                                        data: {//Du lieu gui len server      
                                            action: "getToa"
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