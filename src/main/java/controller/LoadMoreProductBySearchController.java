package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import entity.Product;

@WebServlet(urlPatterns = {"/loadPS"})
public class LoadMoreProductBySearchController extends HttpServlet {
	ProductDao productDao = new ProductDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String txtS = req.getParameter("txtS");
		String index = req.getParameter("amount");
		int amount = Integer.parseInt(index);
		String imgUrl = "";
		List<Product> listP = productDao.getLoadNextSearchProduct(txtS, amount);
		PrintWriter out = resp.getWriter();
		for(Product o: listP) {
			if(o.getpImage().contains("https")) {
				imgUrl = o.getpImage();
			}else {
				imgUrl = "http://localhost:8080/Shopee/image?fname="+o.getpImage();
			}
			out.println("<div class=\"col l-2-4 lo-3 m-4 c-6 search-item-result__item\">\r\n"
					+ "									<a href=\"/Shopee/detail?pId="+o.getpId()+"&quantity=1&action=\"\r\n"
					+ "										class=\"search-item-result__item-link\">\r\n"
					+ "										<div class=\"search-item-result__item-bgc\">\r\n"
					+ "\r\n"
					+ "											<div class=\"search-item-result__item-tag-left\">\r\n"
					+ "												<div class=\"mall-tag hide-tag\">\r\n"
					+ "													<span>Mall</span>\r\n"
					+ "												</div>\r\n"
					+ "												<div class=\"order-processing-tag-wrap hide-tag\">\r\n"
					+ "													<div class=\"order-processing-tag\"></div>\r\n"
					+ "												</div>\r\n"
					+ "												<div class=\"favourite-tag\">\r\n"
					+ "													<span>Yêu Thích</span>\r\n"
					+ "												</div>\r\n"
					+ "											</div>\r\n"
					+ "											<div class=\"search-item-result__item-discount\">\r\n"
					+ "												<div class=\"search-item-result__item-discount-text\">\r\n"
					+ "													<span>12%</span> GIẢM\r\n"
					+ "												</div>\r\n"
					+ "											</div>\r\n"										
					+ "											<div class=\"search-item-result__item-overlay\">\r\n"
					+ "												<img src=\""+imgUrl+"\" alt=\" "+o.getpName()+"\">\r\n"
					+ "											</div>\r\n"
					+ "										</div>\r\n"
					+ "										<div class=\"search-item-result__item-body\">\r\n"
					+ "											<div class=\"search-item-result__item-group\">\r\n"
					+ "												<h3 class=\"search-item-result__item-title\">"+o.getpName()+"</h3>\r\n"
					+ "												<div class=\"search-item-result__item-sale-off\">\r\n"
					+ "													<div class=\"search-item-result__item-sale-off-ticket\">\r\n"
					+ "														<svg class=\"search-item-result__item-sale-off-ticket-icon\"\r\n"
					+ "															viewBox=\"-0.5 -0.5 4 16\">\r\n"
					+ "                                                        <path\r\n"
					+ "																d=\"M4 0h-3q-1 0 -1 1a1.2 1.5 0 0 1 0 3v0.333a1.2 1.5 0 0 1 0 3v0.333a1.2 1.5 0 0 1 0 3v0.333a1.2 1.5 0 0 1 0 3q0 1 1 1h3\"\r\n"
					+ "																stroke-width=\"1\" transform=\"\" stroke=\"currentColor\"\r\n"
					+ "																fill=\"#f69113\" color=\"#f69113\"></path>\r\n"
					+ "                                                    </svg>\r\n"
					+ "														<span class=\"sale-off-tag\">Giảm ₫80k</span>\r\n"
					+ "														<svg class=\"search-item-result__item-sale-off-ticket-icon\"\r\n"
					+ "															viewBox=\"-0.5 -0.5 4 16\">\r\n"
					+ "                                                        <path\r\n"
					+ "																d=\"M4 0h-3q-1 0 -1 1a1.2 1.5 0 0 1 0 3v0.333a1.2 1.5 0 0 1 0 3v0.333a1.2 1.5 0 0 1 0 3v0.333a1.2 1.5 0 0 1 0 3q0 1 1 1h3\"\r\n"
					+ "																stroke-width=\"1\"\r\n"
					+ "																transform=\"rotate(180) translate(-3 -15)\"\r\n"
					+ "																stroke=\"currentColor\" fill=\"#f69113\" color=\"#f69113\"></path>\r\n"
					+ "                                                    </svg>\r\n"
					+ "													</div>\r\n"
					+ "													<span class=\"buy–with-original\">Mua kèm deal sốc</span> <span\r\n"
					+ "														class=\"installment-tag hide-tag\"> 0% TRẢ GÓP </span>\r\n"
					+ "												</div>\r\n"
					+ "\r\n"
					+ "											</div>\r\n"
					+ "											<div class=\"search-item-result__item-price-wrap\">\r\n"
					+ "												<span class=\"search-item-result__item-price\">\r\n"
					+ "													₫"+o.getpPrice()+5000+" </span>\r\n"
					+ "												<div class=\"search-item-result__item-price-saleoff\">\r\n"
					+ "													<span> ₫"+o.getpPrice()+" </span>\r\n"
					+ "													<svg height=\"12\" viewBox=\"0 0 20 12\" width=\"20\"\r\n"
					+ "														class=\"search-item-result__item-price-saleoff-icon\">\r\n"
					+ "                                                    <g fill=\"none\"\r\n"
					+ "															fill-rule=\"evenodd\" transform=\"\">\r\n"
					+ "                                                        <rect\r\n"
					+ "															fill=\"#00bfa5\" fill-rule=\"evenodd\" height=\"9\" rx=\"1\"\r\n"
					+ "															width=\"12\" x=\"4\"></rect>\r\n"
					+ "                                                        <rect height=\"8\"\r\n"
					+ "															rx=\"1\" stroke=\"#00bfa5\" width=\"11\" x=\"4.5\" y=\".5\">\r\n"
					+ "                                                        </rect>\r\n"
					+ "                                                        <rect\r\n"
					+ "															fill=\"#00bfa5\" fill-rule=\"evenodd\" height=\"7\" rx=\"1\"\r\n"
					+ "															width=\"7\" x=\"13\" y=\"2\"></rect>\r\n"
					+ "                                                        <rect height=\"6\"\r\n"
					+ "															rx=\"1\" stroke=\"#00bfa5\" width=\"6\" x=\"13.5\" y=\"2.5\">\r\n"
					+ "                                                        </rect>\r\n"
					+ "                                                        <circle cx=\"8\"\r\n"
					+ "															cy=\"10\" fill=\"#00bfa5\" r=\"2\"></circle>\r\n"
					+ "                                                        <circle cx=\"15\"\r\n"
					+ "															cy=\"10\" fill=\"#00bfa5\" r=\"2\"></circle>\r\n"
					+ "                                                        <path\r\n"
					+ "															d=\"m6.7082481 6.7999878h-.7082481v-4.2275391h2.8488017v.5976563h-2.1405536v1.2978515h1.9603297v.5800782h-1.9603297zm2.6762505 0v-3.1904297h.6544972v.4892578h.0505892c.0980164-.3134765.4774351-.5419922.9264138-.5419922.0980165 0 .2276512.0087891.3003731.0263672v.6210938c-.053751-.0175782-.2624312-.038086-.3762568-.038086-.5122152 0-.8758247.3017578-.8758247.75v1.8837891zm3.608988-2.7158203c-.5027297 0-.8536919.328125-.8916338.8261719h1.7390022c-.0158092-.5009766-.3446386-.8261719-.8473684-.8261719zm.8442065 1.8544922h.6544972c-.1549293.571289-.7050863.9228515-1.49238.9228515-.9864885 0-1.5903965-.6269531-1.5903965-1.6464843 0-1.0195313.6165553-1.6669922 1.5872347-1.6669922.9580321 0 1.5366455.6064453 1.5366455 1.6083984v.2197266h-2.4314412v.0351562c.0221328.5595703.373095.9140625.9169284.9140625.4110369 0 .6924391-.1376953.8189119-.3867187zm2.6224996-1.8544922c-.5027297 0-.853692.328125-.8916339.8261719h1.7390022c-.0158091-.5009766-.3446386-.8261719-.8473683-.8261719zm.8442064 1.8544922h.6544972c-.1549293.571289-.7050863.9228515-1.49238.9228515-.9864885 0-1.5903965-.6269531-1.5903965-1.6464843 0-1.0195313.6165553-1.6669922 1.5872347-1.6669922.9580321 0 1.5366455.6064453 1.5366455 1.6083984v.2197266h-2.4314412v.0351562c.0221328.5595703.373095.9140625.9169284.9140625.4110369 0 .6924391-.1376953.8189119-.3867187z\"\r\n"
					+ "															fill=\"#fff\"></path>\r\n"
					+ "                                                        <path\r\n"
					+ "															d=\"m .5 8.5h3.5v1h-3.5z\" fill=\"#00bfa5\"></path>\r\n"
					+ "                                                        <path\r\n"
					+ "															d=\"m0 10.15674h3.5v1h-3.5z\" fill=\"#00bfa5\"></path>\r\n"
					+ "                                                        <circle cx=\"8\"\r\n"
					+ "															cy=\"10\" fill=\"#047565\" r=\"1\"></circle>\r\n"
					+ "                                                        <circle cx=\"15\"\r\n"
					+ "															cy=\"10\" fill=\"#047565\" r=\"1\"></circle>\r\n"
					+ "                                                    </g>\r\n"
					+ "                                                </svg>\r\n"
					+ "												</div>\r\n"
					+ "											</div>\r\n"
					+ "											<div class=\"search-item-result__item-react\">\r\n"
					+ "												<div class=\"search-item-result__item-like\">\r\n"
					+ "													<i class=\"search-item-result__item-like-icon far fa-heart\"></i>\r\n"
					+ "													<!-- <i class=\"search-item-result__item-like-icon fas fa-heart\"></i> -->\r\n"
					+ "												</div>\r\n"
					+ "												<div class=\"search-item-result__item-rated\">\r\n"
					+ "													<div class=\"search-item-result__item-icon\">\r\n"
					+ "														<i class=\"fas fa-star\"></i> <i class=\"fas fa-star\"></i> <i\r\n"
					+ "															class=\"fas fa-star\"></i> <i class=\"fas fa-star\"></i> <i\r\n"
					+ "															class=\"fas fa-star\"></i>\r\n"
					+ "													</div>\r\n"
					+ "													<span>Đã bán 5</span>\r\n"
					+ "												</div>\r\n"
					+ "											</div>\r\n"
					+ "											<p class=\"search-item-result__item-location\">TP. Hồ Chí\r\n"
					+ "												Minh</p>\r\n"
					+ "										</div>\r\n"
					+ "									</a>\r\n"
					+ "								</div>");
			
		}
	}
}
