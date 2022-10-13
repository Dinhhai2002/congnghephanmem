package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.connect;
import entity.Category;
import entity.Product;
import entity.Shop;
import utils.Constant;


public class ProductDao {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM dbo.product";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryDao categoryDao = new CategoryDao();
				ShopDao shopDao = new ShopDao();
				Category category = categoryDao.findOne(rs.getInt("cateId"));
				Shop shop = shopDao.findOne(rs.getInt("shopId"));

				Product product = new Product();
				product.setpId(rs.getInt("pId"));
				product.setpName(rs.getString("pName"));
				product.setpPrice(rs.getInt("pPrice"));
				product.setpImage(rs.getString("pImage"));
				product.setpDescription(rs.getString("pDescription"));
				product.setpQuantity(rs.getInt("pQuantity"));
				product.setCategory(category);
				product.setShop(shop);
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public List<Product> getProductbyCateId(String cateId) {
		List<Product> products = new ArrayList<>();
		String query = "select * from product where cateId=?";
		try {
			conn = new connect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, cateId);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryDao categoryDao = new CategoryDao();
				ShopDao shopDao = new ShopDao();
				Category category = categoryDao.findOne(rs.getInt("cateId"));
				Shop shop = shopDao.findOne(rs.getInt("shopId"));

				Product product = new Product();
				product.setpId(rs.getInt("pId"));
				product.setpName(rs.getString("pName"));
				product.setpPrice(rs.getInt("pPrice"));
				product.setpImage(rs.getString("pImage"));
				product.setpDescription(rs.getString("pDescription"));
				product.setpQuantity(rs.getInt("pQuantity"));
				product.setCategory(category);
				product.setShop(shop);
				products.add(product);
			}
		} catch (Exception e) {
		}
		return products;
	}

	public List<Product> SearchProduct(String txtS) {
		List<Product> products = new ArrayList<>();
		String query = "select * from product where pName like ?";
		try {
			conn = new connect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + txtS + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryDao categoryDao = new CategoryDao();
				ShopDao shopDao = new ShopDao();
				Category category = categoryDao.findOne(rs.getInt("cateId"));
				Shop shop = shopDao.findOne(rs.getInt("shopId"));

				Product product = new Product();
				product.setpId(rs.getInt("pId"));
				product.setpName(rs.getString("pName"));
				product.setpPrice(rs.getInt("pPrice"));
				product.setpImage(rs.getString("pImage"));
				product.setpDescription(rs.getString("pDescription"));
				product.setpQuantity(rs.getInt("pQuantity"));
				product.setCategory(category);
				product.setShop(shop);
				// product.setCreateAt(rs.getDate("createAt"));
				products.add(product);
			}
		} catch (Exception e) {
		}
		return products;
	}

	public Product findOne(int id) {
		String sql = "SELECT * FROM product WHERE pId = ? ";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryDao categoryDao = new CategoryDao();
				ShopDao shopDao = new ShopDao();
				Category category = categoryDao.findOne(rs.getInt("cateId"));
				Shop shop = shopDao.findOne(rs.getInt("shopId"));

				Product product = new Product();
				product.setpId(rs.getInt("pId"));
				product.setpName(rs.getString("pName"));
				product.setpPrice(rs.getInt("pPrice"));
				product.setpImage(rs.getString("pImage"));
				product.setpDescription(rs.getString("pDescription"));
				product.setpQuantity(rs.getInt("pQuantity"));
				product.setCategory(category);
				product.setShop(shop);
				// product.setCreateAt(rs.getDate("createAt"));
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getTotalProduct() {
		String query = "select count(*) from product";
		try {
			conn = new connect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public int pageSize = 10;

	public List<Product> pagingProduct(int index) {
		List<Product> products = new ArrayList<>();
		String query = "select * from product\r\n" + "order by pId\r\n" + "offset ? rows fetch next ? rows only;";

		try {
			conn = new connect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index - 1) * pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryDao categoryDao = new CategoryDao();
				ShopDao shopDao = new ShopDao();
				Category category = categoryDao.findOne(rs.getInt("cateId"));
				Shop shop = shopDao.findOne(rs.getInt("shopId"));

				Product product = new Product();
				product.setpId(rs.getInt("pId"));
				product.setpName(rs.getString("pName"));
				product.setpPrice(rs.getInt("pPrice"));
				product.setpImage(rs.getString("pImage"));
				product.setpDescription(rs.getString("pDescription"));
				product.setpQuantity(rs.getInt("pQuantity"));
				product.setCategory(category);
				product.setShop(shop);
				// product.setCreateAt(rs.getDate("createAt"));
				products.add(product);
			}
		} catch (Exception e) {
		}
		return products;
	}

	public void insertProduct(Product product) {
		String query = "insert into product values(?,?,?,?,?,?,?,default,null)";
		try {
			conn = new connect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, product.getpName());
			ps.setFloat(2, product.getpPrice());
			ps.setString(3, product.getpImage());
			ps.setString(4, product.getpDescription());
			ps.setInt(5, product.getpQuantity());
			ps.setInt(6, product.getCategory().getcId());
			ps.setInt(7, product.getShop().getShopId());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteProduct(int id) {
		String query = "delete from product where pId=?";
		try {
			conn = new connect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateProduct(Product product) {
		String query = "update product set pName=?, pPrice=?, pImage=?, pDescription=?, pQuantity=?, cateId=?, updateAt=GETDATE() \r\n"
				+ "where pId = ? ";
		try {
			conn = new connect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, product.getpName());
			ps.setFloat(2, product.getpPrice());
			ps.setString(3, product.getpImage());
			ps.setString(4, product.getpDescription());
			ps.setInt(5, product.getpQuantity());
			ps.setInt(6, product.getCategory().getcId());
			ps.setInt(7, product.getpId());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void editUpdateProduct(Product newProduct) {
		Product oldProduct = findOne(newProduct.getpId());
		oldProduct.setpName(newProduct.getpName());
		oldProduct.setpPrice(newProduct.getpPrice());
		oldProduct.setpDescription(newProduct.getpDescription());
		oldProduct.setpQuantity(newProduct.getpQuantity());
		oldProduct.setCategory(newProduct.getCategory());
		if (newProduct.getpImage() != null) {
			String fileName = oldProduct.getpImage();
			File file = new File(Constant.dir + "/product/" + fileName);
			if (file.exists()) {
				file.delete();
			}
			oldProduct.setpImage(newProduct.getpImage());
		}
		updateProduct(oldProduct);
	}

	public List<Product> getTop20Product() {
		List<Product> products = new ArrayList<>();
		String query = "select top 20 * from product";

		try {
			conn = new connect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryDao categoryDao = new CategoryDao();
				ShopDao shopDao = new ShopDao();
				Category category = categoryDao.findOne(rs.getInt("cateId"));
				Shop shop = shopDao.findOne(rs.getInt("shopId"));

				Product product = new Product();
				product.setpId(rs.getInt("pId"));
				product.setpName(rs.getString("pName"));
				product.setpPrice(rs.getInt("pPrice"));
				product.setpImage(rs.getString("pImage"));
				product.setpDescription(rs.getString("pDescription"));
				product.setpQuantity(rs.getInt("pQuantity"));
				product.setCategory(category);
				product.setShop(shop);
				// product.setCreateAt(rs.getDate("createAt"));
				products.add(product);
			}
		} catch (Exception e) {
		}
		return products;
	}
	public List<Product> getTop5Product(String cateId) {
		List<Product> products = new ArrayList<>();
		String query = "select top 5 * from product where cateId=?";

		try {
			conn = new connect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, cateId);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryDao categoryDao = new CategoryDao();
				ShopDao shopDao = new ShopDao();
				Category category = categoryDao.findOne(rs.getInt("cateId"));
				Shop shop = shopDao.findOne(rs.getInt("shopId"));

				Product product = new Product();
				product.setpId(rs.getInt("pId"));
				product.setpName(rs.getString("pName"));
				product.setpPrice(rs.getInt("pPrice"));
				product.setpImage(rs.getString("pImage"));
				product.setpDescription(rs.getString("pDescription"));
				product.setpQuantity(rs.getInt("pQuantity"));
				product.setCategory(category);
				product.setShop(shop);
				// product.setCreateAt(rs.getDate("createAt"));
				products.add(product);
			}
		} catch (Exception e) {
		}
		return products;
	}

	public List<Product> getNext10Product(int amount) {
		List<Product> products = new ArrayList<>();
		String query = "select * from product\r\n" + "order by pId\r\n" + "offset ? rows fetch next 10 rows only;";

		try {
			conn = new connect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, amount);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryDao categoryDao = new CategoryDao();
				ShopDao shopDao = new ShopDao();
				Category category = categoryDao.findOne(rs.getInt("cateId"));
				Shop shop = shopDao.findOne(rs.getInt("shopId"));

				Product product = new Product();
				product.setpId(rs.getInt("pId"));
				product.setpName(rs.getString("pName"));
				product.setpPrice(rs.getInt("pPrice"));
				product.setpImage(rs.getString("pImage"));
				product.setpDescription(rs.getString("pDescription"));
				product.setpQuantity(rs.getInt("pQuantity"));
				product.setCategory(category);
				product.setShop(shop);
				// product.setCreateAt(rs.getDate("createAt"));
				products.add(product);
			}
		} catch (Exception e) {
		}
		return products;
	}

	public List<Product> getProductByShopId(int id) {
		List<Product> products = new ArrayList<>();
		String query = "select * from product where shopId=?";
		try {
			conn = new connect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryDao categoryDao = new CategoryDao();
				ShopDao shopDao = new ShopDao();
				Category category = categoryDao.findOne(rs.getInt("cateId"));
				Shop shop = shopDao.findOne(rs.getInt("shopId"));

				Product product = new Product();
				product.setpId(rs.getInt("pId"));
				product.setpName(rs.getString("pName"));
				product.setpPrice(rs.getInt("pPrice"));
				product.setpImage(rs.getString("pImage"));
				product.setpDescription(rs.getString("pDescription"));
				product.setpQuantity(rs.getInt("pQuantity"));
				product.setCategory(category);
				product.setShop(shop);
				// product.setCreateAt(rs.getDate("createAt"));
				products.add(product);
			}
		} catch (Exception e) {
		}
		return products;
	}


        }
