<%@page import="com.survivalcoding.domain.repository.ProductRepository"%>
<%@page import="com.survivalcoding.domain.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");  	//한글처리

//jsp 코드만 치는 페이지
//addProduct에서 POST로 넘어온 것
// getParameter로 각 input 에 입력된 내용을 가져온다.
String productId = request.getParameter("productId");
String name = request.getParameter("name");
int unitPrice = Integer.valueOf(request.getParameter("unitPrice"));
String description = request.getParameter("description");
String manufacturer = request.getParameter("manufacturer");
String category = request.getParameter("category");
int unitsInStock = Integer.valueOf(request.getParameter("unitsInStock"));
String condition = request.getParameter("condition");

//####싱글턴 패턴#####
//다른 클래스의 메서드 호출 _ 클래스명.메서드명();
ProductRepository repository = ProductRepository.getInstance();

Product product = new Product(productId, name, unitPrice);
product.setDescription(description);
product.setManufacturer(manufacturer);
product.setCategory(category);
product.setUnitsInStock(unitsInStock);
product.setCondition(condition);


repository.addProduct(product);

//응답 객체
response.sendRedirect("products.jsp");
%>