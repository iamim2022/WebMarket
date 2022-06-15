package com.survivalcoding.data.dao;

import java.util.List;

import com.survivalcoding.domain.model.Product;

// Data Access Object
// DB랑 연결할 놈
public interface ProductDao {

	//interface안에 작성한 멤버 = public final static 이 생략되어있다.
	//1. 정석
//	String TABLE_NAME = "product";
//	String COLUMN_ID = "p_id";

	//interface안에서는 public 생략되어있고 public만 된다.
	//2. hardcoding ver.
	List<Product> getAll();

	void insert(Product product);
	
	void update(Product product);
	
	void delete(Product product);
}
