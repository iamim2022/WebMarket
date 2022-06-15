package com.survivalcoding.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.survivalcoding.domain.model.Product;

//DB연결
public class MySqlProductDaoImpl implements ProductDao {
	//1. 정석 방식 : 상수정의
	private final static String TABLE_NAME = "product";
//	private final static String Column = "p_id";	
	

	// 생성자
	public MySqlProductDaoImpl() {
		// try-catch로 예외처리
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new IllegalStateException("jdbc 드라이버 로드 실패");
		}
	}

	@Override
	public List<Product> getAll() {
		// 여기에 담아서 return
		List<Product> results = new ArrayList<>();

		String sql = "SELECT * FROM product";
		// localhost로 연결
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33061/kopoctc", "root", "kopo38");
				Statement stmt = conn.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					//1. 정석 _ 실제로 서비스 배포할 때는 이렇게 숨김처리
//					String id = rs.getString("COLUMN_ID");
					
					//2. hardcoding ver.
					String id = rs.getString("p_id");
					String name = rs.getString("p_name");
					int unitPrice = rs.getInt("p_unitPrice");
					String description = rs.getString("p_description");
					String category = rs.getString("p_category");
					String manufacturer = rs.getString("p_manufacturer");
					long unitsInStock = rs.getLong("p_unitsInStock");
					String condition = rs.getString("p_condition");

					Product product = new Product(id, name, unitPrice);
					product.setDescription(description);
					product.setCategory(category);
					product.setManufacturer(manufacturer);
					product.setUnitsInStock(unitsInStock);
					product.setCondition(condition);

					results.add(product);
				}
			}
		} catch (SQLException e) {
			//error contents print : e.getLocalizedMessage()  _ 현지언어로 출력 but 영어로 나온다.
			throw new IllegalStateException("db연결 실패" + e.getLocalizedMessage());
		}
		return results;
	}

	@Override
	//hardcoding ver.
	public void insert(Product product) {
		//PreparedStatement : ? 활용한 동적 쿼리 생성 _ Insert, Update, Delete 여러 번 할 때 고속
		String sql = "INSERT INTO product VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33061/kopoctc", "root", "kopo38");
				PreparedStatement stmt = conn.prepareStatement(sql);){
			stmt.setString(1, product.getId());
			stmt.setString(2, product.getName());
			stmt.setInt(3, product.getUnitPrice());
			stmt.setString(4, product.getDescription());
			stmt.setString(5, product.getCategory());
			stmt.setString(6, product.getManufacturer());
			stmt.setLong(7, product.getUnitsInStock());
			stmt.setString(8, product.getCondition());
			stmt.executeUpdate();		//insert실행 _ return 0이면 미반영, 1이면 반영된 것.
			
		} catch (SQLException e) {
			//error contents print : e.getMessage()
			throw new IllegalStateException("insert 실패" + e.getMessage());
		}
	}

	@Override
	public void update(Product product) {
		//PreparedStatement : ? 활용한 동적 쿼리 생성 _ Insert, Update, Delete 여러 번 할 때 고속
		String sql = "UPDATE ? set p_name=?, p_unitPrice=?, p_description=?, p_category=?, p_manufacturer=?, p_unitsInStock=?, p_condition=?";
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33061/kopoctc", "root", "kopo38");
				PreparedStatement stmt = conn.prepareStatement(sql);){
			stmt.setString(1, TABLE_NAME);
			stmt.setString(2, product.getName());
			stmt.setInt(3, product.getUnitPrice());
			stmt.setString(4, product.getDescription());
			stmt.setString(5, product.getCategory());
			stmt.setString(6, product.getManufacturer());
			stmt.setLong(7, product.getUnitsInStock());
			stmt.setString(8, product.getCondition());
			
			stmt.executeUpdate();		//UPDATE실행 _ return 0이면 미반영, 1이면 반영된 것.
			
		} catch (SQLException e) {
			//error contents print : e.getMessage()
			throw new IllegalStateException("UPDATE 실패" + e.getMessage());
		}
	}

	@Override
	//id 제거
	public void delete(Product product) {
		//PreparedStatement : ? 활용한 동적 쿼리 생성 _ Insert, Update, Delete 여러 번 할 때 고속
		String sql = "DELETE FROM ? WHERE p_name=?";
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33061/kopoctc", "root", "kopo38");
				PreparedStatement stmt = conn.prepareStatement(sql);){
			stmt.setString(1, TABLE_NAME);
			stmt.setString(2, product.getId());
			
			stmt.executeUpdate();		//DELETE실행 _ return 0이면 미반영, 1이면 반영된 것.
			
		} catch (SQLException e) {
			//error contents print : e.getMessage()
			throw new IllegalStateException("DELETE 실패" + e.getMessage());
		}
	}
}
