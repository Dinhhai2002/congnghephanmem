<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link  rel="stylesheet" href="<c:url value="/css/admin.css"/>" >
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
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
                    <a href="/Shopee/admin/customer">
                        <span class="icon">
                            <ion-icon name="people-outline"></ion-icon>
                        </span>
                        <span class="title">Quản lí người dùng</span>
                    </a>
                </li>

                <li>
                    <a href="/Shopee/admin/category">
                        <span class="icon">
                            <ion-icon name="chatbubble-outline"></ion-icon>
                        </span>
                        <span class="title">Quản lí danh mục</span>
                    </a>
                </li>
                
                <li>
                    <a href="/Shopee/admin/product">
                        <span class="icon">
                            <ion-icon name="chatbubble-outline"></ion-icon>
                        </span>
                        <span class="title">Quản lí sản phẩm</span>
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

                <!-- <div class="search">
                    <label>
                        <input type="text" placeholder="Search here">
                        <ion-icon name="search-outline"></ion-icon>
                    </label>
                </div>

                <div class="user">
                    <img src="assets/imgs/customer01.jpg" alt="">
                </div> -->
            </div>

            <!-- ======================= Cards ================== -->
            <div class="cardBox">
                <div class="card">
                    <div>
                        <div class="numbers">${totalShop}</div>
                        <div class="cardName">Cửa hàng</div>
                    </div>

                    <div class="iconBx">
                        <ion-icon name="eye-outline"></ion-icon>
                    </div>
                </div>

                <div class="card">
                    <div>
                        <div class="numbers">${totalUser}</div>
                        <div class="cardName">Người dùng</div>
                    </div>

                    <div class="iconBx">
                        <ion-icon name="cart-outline"></ion-icon>
                    </div>
                </div>

                <div class="card">
                    <div>
                        <div class="numbers">${totalProduct}</div>
                        <div class="cardName">Sản phẩm</div>
                    </div>

                    <div class="iconBx">
                        <ion-icon name="chatbubbles-outline"></ion-icon>
                    </div>
                </div>
                <div class="card">
                    <div>
                        <div class="numbers"><fmt:formatNumber
														type="number" pattern="#,###"
														value="${doanhthu}"></fmt:formatNumber>₫</div>
                        <div class="cardName">Tổng doanh thu</div>
                    </div>

                    <div class="iconBx">
                        <ion-icon name="chatbubbles-outline"></ion-icon>
                    </div>
                </div>
                

               
            </div>

           <!-- ================ Order Details List ================= -->
           <div class="details">
                <div class="recentOrders">
                    <div class="cardHeader">
                        <h2>Tổng doanh thu</h2>
                    </div>
                    
                    <!--<div>
                    	<td> 
                    	<tr>Theo ngày</tr>
                    	<tr>
	                    	<input type="text" id="datetime" placeholder="Select time"/>
	                    </tr>
                    	</td>
                	
                    </div>  --> 
                     
                   <!-- 
                   <form>
                    	<span>
                    		<label for ="day">Ngày:</label>
                    		<select name = "day" id="day"></select>
                    	</span>
                    	<span>
                    		<label for ="month">Tháng:</label>
                    		<select name = "month" id="month"></select>
                    	</span>
                    	<span>
                    		<label for ="year">Năm:</label>
                    		<select name = "year" id="year"></select>
                    	</span>                 
                    	<button type="submit">Theo ngày</button>
                    	<button type="submit">Theo tháng</button>
                    	<button type="submit">Theo năm</button>
                    </form>
                     --> 
                     
                    <form action="" method="get">
						  <label for="from">Từ ngày:</label>
						  <input type="date" id="fromday" name="fromday">
						  <label for="to">Đến ngày:</label>
						  <input type="date" id="today" name="today">
						  <input type="submit" value="Thống kê" />
						  
					</form>
                   
                    <div class="flexWrapper">
                    	<canvas id="chartElement" width="200" height="50"></canvas>
                    </div>
					
                    <table>
                        <thead>
                            <tr>
                                <td>Mã đơn hàng</td>
                                <td>Giá tiền</td>
                                <td>Ngày tạo</td>
                                <td>Trạng thái</td>
                                
                                
                            </tr>
                        </thead>

                        <tbody>
                        <c:forEach items="${listSelectOrderDetail}" var="o">
                       		<tr>
                                <td>${o.id}</td>                             
                                <td><fmt:formatNumber
														type="number" pattern="#,###"
														value="${o.totalPrice}"></fmt:formatNumber>₫</td>     
                                <td>${o.createAt}
                                <td>
                                   <c:if test="${o.status == 'OrderStatus [idStatus=1, nameStatus=Chờ shop xác nhận]'}">
                                	<span class="status pending">Chờ xác nhận</span>
	                                </c:if> 
	                                <c:if test="${o.status == 'OrderStatus [idStatus=2, nameStatus=Chờ lấy hàng]'}">
	                                	<span class="status waiting">Chờ lấy hàng</span>
	                                </c:if> 
	                                <c:if test="${o.status == 'OrderStatus [idStatus=3, nameStatus=Đang giao]'}">
	                                	<span class="status inProgress">Đang giao</span>
	                                </c:if> 
	                                <c:if test="${o.status == 'OrderStatus [idStatus=4, nameStatus=Đã giao hàng]'}">
	                                	<span class="status delivered">Đã giao</span>
	                                </c:if>
	                                <c:if test="${o.status == 'OrderStatus [idStatus=5, nameStatus=Khách đã hủy]'}">
	                                	<span class="status return">Đã hủy</span>
	                                </c:if> 
	                                <c:if test="${o.status == 'OrderStatus [idStatus=6, nameStatus=Trả hàng]'}">
	                                	<span class="status cancel">Trả hàng</span>
	                                </c:if> 
	                                <c:if test="${o.status == 'OrderStatus [idStatus=7, nameStatus=Chờ shipper nhận đơn]'}">
	                                	<span class="status cancel">Chờ nhận đơn</span>
	                                </c:if> 
	                                <c:if test="${o.status == 'OrderStatus [idStatus=8, nameStatus=Shipper nhận hàng]'}">
	                                	<span class="status cancel">Đã nhận hàng</span>
	                                </c:if> 
	                                <c:if test="${o.status == 'OrderStatus [idStatus=9, nameStatus=Đơn hàng đã giao dịch thành công]'}">
	                                	<span class="status cancel">Giao hàng thành công</span>
	                                </c:if> 
	                                <c:if test="${o.status == 'OrderStatus [idStatus=10, nameStatus=Shop đã hủy]'}">
	                                	<span class="status cancel">Shop đã hủy</span>
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
                        <h2>Người dùng</h2>
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
    <script src="<c:url value ="/js/stats.js" />"></script>
    <script src="<c:url value ="/js/managerProduct.js" />"></script>

	<script> 
	//var xValues = [50,60,70,80,90,100,110,120,130,140,150];
	//var yValues = ['7','8','8','9','9','9','10','11','14','14','15'];
	
	
	
	
	let xValues=[], yValues=[]; 
			<c:forEach items="${listThongKe2}" var ="o">	
			yValues.push('${o.createAt}');
			xValues.push('${o.total}');
		</c:forEach>
		window.onload = function(){
			cateChart("chartElement",xValues,yValues)
		}
	
		</script>
	 
	    <!-- ====== ionicons ======= -->
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    
    
</body>
</html>
