<%@page import="com.survivalcoding.domain.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--  자바빈즈 _해당 클래스의 기본 생성자 호출  -->
<jsp:useBean id="repository"
	class="com.survivalcoding.data.ProductRepository" scope="session"></jsp:useBean>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap cdn import -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>상품목록</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	
	<!-- jumbotron -->
    <div class="mt-4 p-5 bg-primary text-white rounded">
      <!-- .container>h1.display-3 -->
      <div class="container">
        <h1 class="display-3" align="center">
          상품목록
        </h1>
      </div>
    </div>
		<div class="container">
			<div class="row" align="center">
			<%
			List<Product> products = repository.getAllProducts();	//data가져오기
			for (int i = 0; i < products.size(); i++){
				Product product = products.get(i);
			%>
			
				<!-- 코드빠르게치기 꿀팁_12칸나눴을때 4칸 차지하겠다 .col-md-4 -->
				<div class="col-md-4">
					<h3><%= product.getName() %></h3>
					<p><%= product.getDescription() %></p>
					<p><%= product.getUnitPrice() %>원</p>
					<p><a href="product.jsp?id=<%= product.getId() %>" class="btn btn-secondary">상세 정보 &raquo;</a></p>
					<!--  raquo는 특수문자 >> 의미 -->
				</div>
			<%
			}		//for문을 여기서 닫는다.
			%>
			</div>
		</div>
    
	<!-- import위해 ctrl + space -->
	<%
	//List<Product> products = repository.getAllProducts();			//data가져오기
	//out.print(products);
	%>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>