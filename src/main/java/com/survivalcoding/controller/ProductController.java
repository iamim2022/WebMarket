package com.survivalcoding.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.survivalcoding.domain.model.Product;
import com.survivalcoding.domain.repository.ProductRepository;

//products.do 또는 processAddProduct.do 주소를 치면 class ProductController extends HttpServlet로 통과한다.
//req는 request객체

@WebServlet(name = "ProductController", urlPatterns = {"/products.do", "/processAddProduct.do"})

//서블릿을 통과하는 것
public class ProductController extends HttpServlet{
	private static final long serialVersionUID = -8981601493800853908L;
	
	
	//doGet 입력 후 ctrl + Space + Enter
	//get방식 코드가 실행되고 나간다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String command = req.getRequestURI().substring(req.getContextPath().length());
		
		//######싱글턴 패턴#######
		//다른 클래스의 메서드 호출 _ 클래스명.메서드명();
		ProductRepository repository = ProductRepository.getInstance();		//자바빈즈 대신 사용
		
		if (command.equals("/products.do")) {	
			// 아래 페이지 출력요청오면 products 꺼내서 출력
			List<Product> products = repository.getAllProducts();	//data가져오기
			req.getSession().setAttribute("products", products);
			
		} else if (command.equals("/processAddProduct.do")) {
            // 한글 처리
            req.setCharacterEncoding("UTF-8");
            // POST로 넘어온 것
            String productId = req.getParameter("productId");
            String name = req.getParameter("name");
            int unitPrice = Integer.valueOf(req.getParameter("unitPrice"));
            String description = req.getParameter("description");
            String manufacturer = req.getParameter("manufacturer");
            String category = req.getParameter("category");
            int unitsInStock = Integer.valueOf(req.getParameter("unitsInStock"));
            String condition = req.getParameter("condition");

            Product product = new Product(productId, name, unitPrice);
            product.setDescription(description);
            product.setManufacturer(manufacturer);
            product.setCategory(category);
            product.setUnitsInStock(unitsInStock);
            product.setCondition(condition);

            repository.addProduct(product);
		}
		
		System.out.println("pass!!!!!!!!!!!!!!");
//		super.doGet(req, resp);
		
		// products.jsp 로 이동
		req.getRequestDispatcher("products.jsp").forward(req, resp);
	}

	//doPost 입력 후 ctrl + Space + Enter
	//post방식 코드가 실행되고 나간다.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
