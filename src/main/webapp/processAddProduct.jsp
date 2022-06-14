<%@page import="com.survivalcoding.domain.model.Product"%>
<%@page import="com.survivalcoding.data.ProductRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");  	//한글처리

//jsp 코드만 치는 페이지
//POST로 넘어온 것

String productId = request.getParameter("productId");
String name = request.getParameter("name");
int unitPrice = Integer.valueOf(request.getParameter("unitPrice"));
String description = request.getParameter("description");
String manufacturer = request.getParameter("manufacturer");
String category = request.getParameter("category");
int unitsInStock = Integer.valueOf(request.getParameter("unitsInStock"));
String condition = request.getParameter("condition");

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