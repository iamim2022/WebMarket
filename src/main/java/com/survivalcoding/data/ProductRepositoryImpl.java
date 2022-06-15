package com.survivalcoding.data;
//products에서 ProductRepository.java 사용
import java.util.ArrayList;
import java.util.List;
import com.survivalcoding.domain.model.Product;
import com.survivalcoding.domain.repository.ProductRepository;

// 다형성
//220615_ override
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> products = new ArrayList<>();

    //싱글턴 패턴
    /*
     1. static 인스턴스 준비
     2. static 메서드로 인스턴스 리턴 (getInstance() 이름을 주로 사용)
     3. 생성자 막기_private
     */

    //static 메서드
    //new ProductRepository()가 인스턴스 생성하는 것 _ 이 인스턴스 명칭이 instance
    //tomcat9이 서버 재시작하자마자 static으로 들고있는다.
    private static ProductRepositoryImpl instance = new ProductRepositoryImpl();

    //ProductRepository라는 객체를 매번 new로 생성하지 말고 인스턴스 반환
    //static 메서드 명칭 getInstance()
    public static ProductRepositoryImpl getInstance(){
        return instance;
    }

    //생성자
    //DB미연결로 직접 data입력 _ 생성자를  private으로 변경해 해당 클래스에서만 접근 _ 자바빈즈미사용한다는 의미
    private ProductRepositoryImpl() {
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

    @Override
    public List<Product> getAllProducts() {
        return products;
    }
    
    @Override   
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

    @Override
    //상품추가 메소드
    public void addProduct(Product product) {
        products.add(product);
    }
}