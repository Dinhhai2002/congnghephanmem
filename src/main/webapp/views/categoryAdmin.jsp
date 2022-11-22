<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý danh mục</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap&subset=vietnamese" rel="stylesheet">
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
    <!-- ======= Styles ====== -->
    <link rel="stylesheet" href="<c:url value="/css/categoryAdmin.css"/>">
</head>
<body>
	 <!-- =============== Navigation ================ -->
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
                    <form role="form" action="addCategoryAdmin" method="post"
                         enctype="multipart/form-data">
                <div class="form-group">
                <label>Tên danh mục:</label> <input class="form-control"
                placeholder="Tên danh mục muốn thêm mới" name="name" />
                </div>
                <div class="form-group">
                <label>Ảnh đại diện</label> <input type="file" name="image" />
                </div>
                <button type="submit" class="btn btn-default">Thêm</button>
                <button type="reset" class="btn btn-primary">Hủy</button>
                </form>
            </div>

            <!-- ================ Order Details List ================= -->
            <div class="details">
                <div class="recentOrders">
                    <div class="cardHeader">
                        <h2>Danh mục</h2>
                        <!-- <a href="#" class="btn">Xem tất cả</a> -->
                    </div>

                    <table>
                        <thead>
                            <tr>
                                <td >Tên danh mục</td>
                                <td >Hình ảnh</td>
                                <td >Hành động</td>
                            </tr>
                        </thead>

                        <tbody>
                        	
                        <c:forEach items="${listCategory}" var="o">
                            <tr>
                                <td>${o.cName }</td>
                                <c:url value="/image?fname=${o.cImage}" var="imgUrl"></c:url>
                                <td>
                                <c:if test="${fn:contains(o.cImage, 'https')}">
										<img style="width: 150px; height: 150px; object-fit: contain;" src="${o.cImage}" alt=" ${o.cName}">
									</c:if>
									<c:if test="${fn:contains(o.cImage, 'category')}">
										<img style="width: 150px; height: 150px; object-fit: contain;" src="${imgUrl}" alt=" ${o.cName}">
									</c:if>
								</td>
                                <td class="customerEdit">
                                    <a href="" onclick="editCategoryModal(${o.cId})" class="edit btn-link" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                    <a href="" onclick="deleteCategoryModal(${o.cId})" class="delete btn-link" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                            </tr>
                          </c:forEach>
                                                                                                                            
                        </tbody>
                    </table>
                </div>

                <!-- ================= New Customers ================ -->
                
            </div>
        </div>
    </div>
    <div id="addEmployeeModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="add" method="post">
                    <div class="modal-header">						
                        <h4 class="modal-title">Add Product</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">					
                        <div class="form-group">
                            <label>Name</label>
                            <input name="name" type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Image</label>
                            <input name="image" type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Price</label>
                            <input name="price" type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Title</label>
                            <textarea name="title" class="form-control" required></textarea>
                        </div>
                        <div class="form-group">
                            <label>Description</label>
                            <textarea name="description" class="form-control" required></textarea>
                        </div>
                        <div class="form-group">
                            <label>Category</label>
                            <select name="category" class="form-select" aria-label="Default select example">
                                <c:forEach items="${listC}" var="o">
                                    <option value="${o.id}">${o.name}</option>
                                </c:forEach>
                            </select>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                        <input type="submit" class="btn btn-success" value="Add">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Edit Modal HTML -->
    <div id="editCategoryModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="editcategory" method="post" enctype="multipart/form-data">
                    <div class="modal-header">						
                        <h4 class="modal-title">Chỉnh sửa danh mục</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">					
                        	<input id="editId" name="id" value="0" hidden="">
                            <div class="form-group">
                            <label>Tên danh mục:</label> <input id="editName" type="text" class="form-control"
                            value="category" name="name" />
                            </div>
                            <div class="form-group">
                            
                            <c:url value="/image?fname=image" var="imgUrl"></c:url>
                            <img id="editImage" class="img-responsive" width="100px" src="/image?fname=image"
                            alt="">
                            <label>Ảnh đại diện</label> <input type="file" name="image"/>
                            </div>
                            
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-default">Edit</button>
                            <button type="reset" class="btn btn-primary">Reset</button>	
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Delete Modal HTML -->
    <div id="deleteCategoryModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="deletecategory" method="post">

                    <div class="modal-header">						
                        <h4 class="modal-title">Xóa danh mục</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <input id="deleteId" name="id" value="0" hidden="">
                    <div class="modal-body">					
                        <p>Bạn có chắc muốn xóa?</p>
                        <p class="text-warning"><small>Hành động này không thể hoàn tác</small></p>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                        <input type="submit" class="btn btn-danger" value="Delete">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- =========== Scripts =========  -->
    <script src="<c:url value="/js/admin.js"/>"></script>

    <!-- ====== ionicons ======= -->
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>