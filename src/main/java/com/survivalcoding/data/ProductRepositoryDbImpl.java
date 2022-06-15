package com.survivalcoding.data;

import java.util.List;

import com.survivalcoding.data.dao.ProductDao;
import com.survivalcoding.domain.model.Product;
import com.survivalcoding.domain.repository.ProductRepository;

public class ProductRepositoryDbImpl implements ProductRepository{
	
	private ProductDao dao;
	
	//생성자 _ ProductDao.java를 여기서 받는다. 
	public ProductRepositoryDbImpl(ProductDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		// 상품목록에 빈리스트 반환
		//return Collections.emptyList();
		
		//dao에서 getALL()메서드 반환
		return dao.getAll();
	}

	@Override
	//상품 목록을 넘겨준다.
	public Product getProductById(String id) {
    	// List는 데이터가 고정되어있는 것
    	// Stream은 데이터가 흘러 내려온다
    	// List -> Stream
    	// phone의 id 확인 - 아니면 안거름 - 맞으면 출력 - notebook , tablet..
    	// java8에서 가장 진보된 데이터 찾기 방법
    	return getAllProducts().stream()
    			.filter((product) -> product.getId().equals(id))		//조건
    			.findFirst()		//조건에 맞는 첫번째 값
    			.get();			//그 값을 가져오기
	}

	@Override
	//add는 DAO(MySqlProductDaoImpl)가 한다.
	public void addProduct(Product product) {
		dao.insert(product);
		
	}


}
