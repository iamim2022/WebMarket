package com.survivalcoding.data;

import java.util.ArrayList;
import java.util.List;
import com.survivalcoding.domain.model.Product;

// 다형성
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    //DB미연결로 직접 data입력
    public ProductRepository() {
        Product phone = new Product("P1234", "iPhone 6s", 800000);
        phone.setDescription("4.7-inch, 1334x750 Retina HD display");
        phone.setCategory("Smart Phone");
        phone.setManufacturer("Apple");
        phone.setUnitsInStock(1000);
        phone.setCondition("New");

        Product notebook = new Product("P1235", "LG PC 그램", 1500000);
        notebook.setDescription("!4.7-inch, 1334x750 Retina HD display");
        notebook.setCategory("!Smart Phone");
        notebook.setManufacturer("!Apple");
        notebook.setUnitsInStock(1000);
        notebook.setCondition("Refubished");

        Product tablet = new Product("P1236", "Galaxy Tab S", 900000);
        tablet.setDescription("?4.7-inch, 1334x750 Retina HD display");
        tablet.setCategory("?Smart Phone");
        tablet.setManufacturer("?Apple");
        tablet.setUnitsInStock(1000);
        tablet.setCondition("Old");

        products.add(phone);
        products.add(notebook);
        products.add(tablet);
    }

    public List<Product> getAllProducts() {
        return products;
    }
    
    public Product getProductById(String id) {
    	// List는 데이터가 고정되어있는 것
    	// Stream은 데이터가 흘러 내려온다
    	// List -> Stream
    	// phone의 id 확인 - 아니면 안거름 - 맞으면 출력 - notebook , tablet..
    	// java8에서 가장 진보된 데이터 찾기 방법
    	return products.stream()
    			.filter((product) -> product.getId().equals(id))		//조건
    			.findFirst()		//조건에 맞는 첫번째 값
    			.get();			//그 값을 가져오기
    }
}