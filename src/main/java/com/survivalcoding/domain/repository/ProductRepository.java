package com.survivalcoding.domain.repository;

import java.util.List;
import com.survivalcoding.data.ProductRepositoryDbImpl;
import com.survivalcoding.data.dao.MySqlProductDaoImpl;
import com.survivalcoding.domain.model.Product;

//interface
public interface ProductRepository {
	
	//mysql객체를 반환
    public static ProductRepository getInstance() {
//      return ProductRepositoryImpl.getInstance();
       return new ProductRepositoryDbImpl(new MySqlProductDaoImpl());
  }
	
	//ProductsRepositroy.java 의 메서드 가져오기
	//
    public List<Product> getAllProducts();
    
    public Product getProductById(String id);
    
    public void addProduct(Product product);
    
}
