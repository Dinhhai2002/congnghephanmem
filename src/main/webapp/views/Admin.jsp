<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link  rel="stylesheet" href="<c:url value="/css/admin.css"/>" >
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
	<div class="container">
        <div class="navigation">
            <ul>
                <li>
                    <a href="#">
                        <span class="icon">
                            <ion-icon name="logo-apple"></ion-icon>
                        </span>
                        <span class="title">Admin</span>
                    </a>
                </li>

                <li>
                    <a href="/Shopee/admin">
                        <span class="icon">
                            <ion-icon name="home-outline"></ion-icon>
                        </span>
                        <span class="title">Trang chủ</span>
                    </a>
                </li>

                <li>
                    <a href="/Shopee/customer">
                        <span class="icon">
                            <ion-icon name="people-outline"></ion-icon>
                        </span>
                        <span class="title">Quản lí người dùng</span>
                    </a>
                </li>

                <li>
                    <a href="/Shopee/category">
                        <span class="icon">
                            <ion-icon name="chatbubble-outline"></ion-icon>
                        </span>
                        <span class="title">Quản lí danh mục</span>
                    </a>
                </li>

               

                <li>
                    <a href="/Shopee/login">
                        <span class="icon">
                            <ion-icon name="log-out-outline"></ion-icon>
                        </span>
                        <span class="title">Đăng xuất</span>
                    </a>
                </li>
            </ul>
        </div>

        <!-- ========================= Main ==================== -->
        <div class="main">
            <div class="topbar">
                <div class="toggle">
                    <ion-icon name="menu-outline"></ion-icon>
                </div>

                <div class="search">
                    <label>
                        <input type="text" placeholder="Search here">
                        <ion-icon name="search-outline"></ion-icon>
                    </label>
                </div>

                <div class="user">
                    <img src="assets/imgs/customer01.jpg" alt="">
                </div>
            </div>

            <!-- ======================= Cards ================== -->
            <div class="cardBox">
                <div class="card">
                    <div>
                        <div class="numbers">${totalShop}</div>
                        <div class="cardName">Shops</div>
                    </div>

                    <div class="iconBx">
                        <ion-icon name="eye-outline"></ion-icon>
                    </div>
                </div>

                <div class="card">
                    <div>
                        <div class="numbers">${totalUser}</div>
                        <div class="cardName">Users</div>
                    </div>

                    <div class="iconBx">
                        <ion-icon name="cart-outline"></ion-icon>
                    </div>
                </div>

                <div class="card">
                    <div>
                        <div class="numbers">${totalProduct}</div>
                        <div class="cardName">Products</div>
                    </div>

                    <div class="iconBx">
                        <ion-icon name="chatbubbles-outline"></ion-icon>
                    </div>
                </div>

                <div class="card">
                    <div>
                        <div class="numbers">$7,842</div>
                        <div class="cardName">Earning</div>
                    </div>

                    <div class="iconBx">
                        <ion-icon name="cash-outline"></ion-icon>
                    </div>
                </div>
            </div>

           <!-- ================ Order Details List ================= -->
           <div class="details">
                <div class="recentOrders">
                    <div class="cardHeader">
                        <h2>Recent Orders</h2>
                        <a href="#" class="btn">View All</a>
                    </div>
                    <div class="flexWrapper">
                    	<canvas id="chartElement" width="200" height="50"></canvas>
                    </div>
					
                    <table>
                        <thead>
                            <tr>
                                <td>ORDER ID</td>
                                <td>PRICE</td>
                                <td>Payment</td>
                                <td>Status</td>
                            </tr>
                        </thead>

                        <tbody>
                        <c:forEach items="${listOrder}" var="o">
                       		<tr>
                                <td>${o.id}</td>
                                <td>${o.count}</td>
                                <td>${o.totalPrice}</td>     
                                <td>
                                <c:if test="${o.status == 'OrderStatus [idStatus=1, nameStatus=Chờ xác nhận]'}">
                                	<span class="status pending">Chờ xác nhận</span>
                                </c:if> 
                                <c:if test="${o.status == 'OrderStatus [idStatus=2, nameStatus=Chờ lấy hàng]'}">
                                	<span class="status waiting">Chờ lấy hàng</span>
                                </c:if> 
                                <c:if test="${o.status == 'OrderStatus [idStatus=3, nameStatus=Đang giao]'}">
                                	<span class="status inProgress">Đang giao</span>
                                </c:if> 
                                <c:if test="${o.status == 'OrderStatus [idStatus=4, nameStatus=Đã giao]'}">
                                	<span class="status delivered">Đã giao</span>
                                </c:if>
                                <c:if test="${o.status == 'OrderStatus [idStatus=5, nameStatus=Đã hủy]'}">
                                	<span class="status return">Đã hủy</span>
                                </c:if> 
                                <c:if test="${o.status == 'OrderStatus [idStatus=6, nameStatus=Trả hàng]'}">
                                	<span class="status cancel">Trả hàng</span>
                                </c:if>                           
                                </td>
                               
                                
                            </tr>
                         </c:forEach>
                          

                        </tbody>
                    </table>
                </div>
                <!-- ================= New Customers ================ -->
                <div class="recentCustomers">
                    <div class="cardHeader">
                        <h2>Recent Customers</h2>
                    </div>
			            <table>
			                    <c:forEach items="${listUser}" var="o">
			                        <tr>
			                            <td width="60px">
			                                <div class="imgBx"><img src="${o.uImage}" alt="${o.uImage}"></div>
			                            </td>
			                            <td>
			                                <h4>${o.uFullName} <br> <span>${o.uAddress}</span></h4>
			                            </td>
			                        </tr>
								</c:forEach> 
								
			             </table>
                   	
                </div>
            </div>
        </div>
    </div>

    <!-- =========== Scripts =========  -->
    <script src="<c:url value="/js/admin.js"/>"></script>
    <script src="<c:url value ="/js/stats.js" />"><</script>
	<script> 
	let statusLabel=["Chờ xác nhận","Chờ lấy hàng","Đang giao","Đã giao","Đã hủy","Trả hàng"],statusInfo=[]
	
		statusInfo.push(${orderdetail.countStatusByIdStatus(1)});
		statusInfo.push(${orderdetail.countStatusByIdStatus(2)});
		statusInfo.push(${orderdetail.countStatusByIdStatus(3)});
		statusInfo.push(${orderdetail.countStatusByIdStatus(4)});
		statusInfo.push(${orderdetail.countStatusByIdStatus(5)});
		statusInfo.push(${orderdetail.countStatusByIdStatus(6)});
		window.onload = function(){
			cateChart("chartElement",statusLabel,statusInfo)
		}
	</script>
    <!-- ====== ionicons ======= -->
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    
</body>
</html>
</body>
</html>