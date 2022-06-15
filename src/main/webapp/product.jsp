
<%@page import="com.survivalcoding.domain.repository.ProductRepository"%>
<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@page import="com.survivalcoding.domain.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--  자바빈즈 제거완료 -->
<%
// ProductRepository repository = new ProductRepository();		//자바빈즈 안쓸 경우 대체사용_singleton pattern으로 미사용!
%>	
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap cdn import -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>상품정보</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>	
	<!-- jumbotron -->
    <div class="mt-4 p-5 bg-primary text-white rounded">
      <!-- .container>h1.display-3 -->
      <div class="container">
        <h1 class="display-3" align="center">
          상품정보
        </h1>
      </div>
    </div>
    <%
    //######싱글턴 패턴#######
        //다른 클래스의 메서드 호출 _ 클래스명.메서드명();
        ProductRepository repository = ProductRepository.getInstance();

        String id = request.getParameter("id");       //내장객체 request사용해 id 넘겨받기
        Product product = repository.getProductById(id);
        //out.print(product);
    %>
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h3><%=product.getName()%></h3>
          <p><%=product.getDescription()%></p>
          <p><b>상품코드 : </b><span class="badge bg-danger"><%= product.getId() %></span></p>
          <p><b>제조사 : </b><%= product.getManufacturer() %></p>
          <p><b>분류 : </b><%= product.getCategory() %></p>
          <p><b>재고 수 : </b><%= product.getUnitsInStock() %></p>
          <p><%= product.getUnitPrice() %>원</p>
          <p><a href="#" class="btn btn-info">상품 주문 &raquo;</a></p>
          <a href="products.jsp" class="btn btn-secondary">상품 목록 &raquo;</a>
        </div>
      </div>
    </div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>