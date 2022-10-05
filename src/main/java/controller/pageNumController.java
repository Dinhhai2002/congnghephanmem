package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;

@WebServlet(urlPatterns = "/page")
public class pageNumController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String pIndex = req.getParameter("index");
		int index = Integer.parseInt(pIndex);

		DAO dao = new DAO();
		int count = dao.getTotalProduct();
		int pageSize = dao.pageSize;
		int endPage = count / pageSize;
		if (count % pageSize > 0) {
			endPage++;
		}
		PrintWriter out = resp.getWriter();
		if (index > 1) {
			out.println("<li class=\"pagination-item\"><a\r\n"
					+ "	href=\"#content\" class=\"pagination-item-link\">\r\n"
					+ "	<i style=\"font-size: 2.5rem;\"\r\n"
					+ "	class='pagination-item-icon bx bx-chevron-left'><p hidden>" + (index - 1) + "</p></i>\r\n"
					+ "	</a></li>");
		}
		if (endPage < 10) {
			for (int i = 1; i <= endPage; i++) {
				out.println((index == i)
						? "<li class=\"pagination-item\"><a href=\"#content\"\r\n"
								+ "	class=\"pagination-item-link bgc-highlight\">" + i + "</a></li>"
						: "<li class=\"pagination-item\"><a href=\"#content\"\r\n"
								+ "	class=\"pagination-item-link\">" + i + "</a></li>");
			}

		} else {
			if (index <= 4) {
				for (int i = 1; i <= 5; i++) {
					out.println((index == i)
							? "<li class=\"pagination-item\"><a href=\"#content\"\r\n"
									+ "	class=\"pagination-item-link bgc-highlight\">" + i + "</a></li>"
							: "<li class=\"pagination-item\"><a href=\"#content\"\r\n"
									+ "	class=\"pagination-item-link\">" + i + "</a></li>");
				}
				out.println(
						"<li class=\"pagination-item\"><span\r\n" + "class=\"pagination-item-link\">...</span></li>");
				out.println((index == endPage)
						? "<li class=\"pagination-item\"><a href=\"#content\"\r\n"
								+ "	class=\"pagination-item-link bgc-highlight\">" + endPage + "</a></li>"
						: "<li class=\"pagination-item\"><a href=\"#content\"\r\n"
								+ "	class=\"pagination-item-link\">" + endPage + "</a></li>");
			}
			if (index > 4 && index < endPage - 4) {
				out.println((index == 1)
						? "<li class=\"pagination-item\"><a href=\"#content\"\r\n"
								+ "	class=\"pagination-item-link bgc-highlight\">1</a></li>"
						: "<li class=\"pagination-item\"><a href=\"#content\"\r\n"
								+ "	class=\"pagination-item-link\">1</a></li>");
				out.println(
						"<li class=\"pagination-item\"><span\r\n" + "class=\"pagination-item-link\">...</span></li>");
				for (int i = index - 1; i <= index + 2; i++) {
					out.println((index == i)
							? "<li class=\"pagination-item\"><a href=\"#content\"\r\n"
									+ "	class=\"pagination-item-link bgc-highlight\">" + i + "</a></li>"
							: "<li class=\"pagination-item\"><a href=\"#content\"\r\n"
									+ "	class=\"pagination-item-link\">" + i + "</a></li>");
				}
				out.println(
						"<li class=\"pagination-item\"><span\r\n" + "class=\"pagination-item-link\">...</span></li>");
				out.println((index == endPage)
						? "<li class=\"pagination-item\"><a href=\"#content\"\r\n"
								+ "	class=\"pagination-item-link bgc-highlight\">" + endPage + "</a></li>"
						: "<li class=\"pagination-item\"><a href=\"#content\"\r\n"
								+ "	class=\"pagination-item-link\">" + endPage + "</a></li>");

			}
			if (index == endPage - 4) {
				out.println((index == 1)
						? "<li class=\"pagination-item\"><a href=\"#content\"\r\n"
								+ "	class=\"pagination-item-link bgc-highlight\">1</a></li>"
						: "<li class=\"pagination-item\"><a href=\"#content\"\r\n"
								+ "	class=\"pagination-item-link\">1</a></li>");
				out.println(
						"<li class=\"pagination-item\"><span\r\n" + "class=\"pagination-item-link\">...</span></li>");
				for (int i = index - 2; i <= endPage; i++) {
					out.println((index == i)
							? "<li class=\"pagination-item\"><a href=\"#content\"\r\n"
									+ "	class=\"pagination-item-link bgc-highlight\">" + i + "</a></li>"
							: "<li class=\"pagination-item\"><a href=\"#content\"\r\n"
									+ "	class=\"pagination-item-link\">" + i + "</a></li>");
				}
			}
			if (index > endPage - 4) {
				out.println((index == 1)
						? "<li class=\"pagination-item\"><a href=\"#content\"\r\n"
								+ "	class=\"pagination-item-link bgc-highlight\">1</a></li>"
						: "<li class=\"pagination-item\"><a href=\"#content\"\r\n"
								+ "	class=\"pagination-item-link\">1</a></li>");
				out.println(
						"<li class=\"pagination-item\"><span\r\n" + "class=\"pagination-item-link\">...</span></li>");
				for (int i = endPage - 5; i <= endPage; i++) {
					out.println((index == i)
							? "<li class=\"pagination-item\"><a href=\"#content\"\r\n"
									+ "	class=\"pagination-item-link bgc-highlight\">" + i + "</a></li>"
							: "<li class=\"pagination-item\"><a href=\"#content\"\r\n"
									+ "	class=\"pagination-item-link\">" + i + "</a></li>");
				}
			}
		}
		if (index < endPage) {
			out.println("<li class=\"pagination-item\"><a\r\n"
					+ "	href=\"#content\" class=\"pagination-item-link\">\r\n"
					+ "	<i style=\"font-size: 2.5rem;\"\r\n"
					+ "	class='pagination-item-icon bx bx-chevron-right'><p hidden>" + (index + 1) + "</p></i>\r\n"
					+ "	</a></li>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
