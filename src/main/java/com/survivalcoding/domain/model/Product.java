package com.survivalcoding.domain.model;

import java.util.Objects;

/*
 java class와 객체
 
 1. 무지성 private 멤버 변수
 2. 필요하면 생성자 추가
 3. 무지성 getter / setter _ 읽기전용, 쓰기 전용 설정
 4. 무지성 toString()
 5. 필요하면 equals / hashCode 재정의 (오버라이드)
 */


public class Product extends Object {	
	public static void main(String[] args) {
		Product product = new Product("33","33", 11);
		//Product product2 = new Product();
		//product.setId("111");
		
		//기본 생성자 재정의
		//오버로드 : 같은 이름의 생성자, 메서드를 여러개 작성
		//public Product() { }
		
		System.out.println(product.hashCode()); 	//1023487453
		//출력결과 com.survivalcoding.domain.model.Product@3d012ddd
		//hashCode 출력된다.
		
		Product product2 = new Product("33","33", 11);
		System.out.println(product2.hashCode());	//1651191114
		
		//Quiz? : false
		//product와 product2는 hashCode가 다르다. new로 새 객체 생성했기 때문
		// ==는 reference 비교 _ 주소값이 같은지를 비교하기 때문에 false다.
		System.out.println(product == product2);
		
		
		//equals 사용하는 이유?
		//name이 객체라서 == 일때는 값이 다르게 나올 수도 있기 때문에 정확한 비교 위해 equals 사용
		System.out.println("name".equals("name"));
		System.out.println(new String("name") == new String("name"));
		
		
		//Object는 모든 타입을 다 받겠다는 의미
		Object object = new Product("33","33", 11);
		
		//reference로 주소 hascode 비교하기 때문에 false
		System.out.println(product == product2);
		
		
		//#############equals와 haschCode 짝꿍####################
		//내용물 비교_ 객체비교!는 무조건 equals
		//Object의 equals를 호출하면 reference로 비교해버린다.
		System.out.println(product.equals(product2));   //false -> equals 재정의 후 true로 변화
		
		
		//hashCode가 얼결에 재정의 됐다. _ equals를 재정의하면서 hashCode도 함께 동일하게 변화됐다.
		System.out.println(product.hashCode() == product2.hashCode());   	//true
		
		
		//memory주소는 우리가 볼 수 없다. 다만, new로 각각 생성했기 때문에 reference비교해도 false
		System.out.println(product == product2);   //false
		
		
	}

	//private 변수 선언
	private String id;
	private String name;
	private int unitPrice;
	private String description;
	private String manufacturer;
	private String category;
	private long unitsInStock;
	private String condition;

	//parameter 받는 생성자 정의
	public Product(String id, String name, int unitPrice) {
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
	}

	//getter, setter 정의 _ 캡슐화
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	
	//무지성 toString
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", unitPrice=" + unitPrice + ", description=" + description
				+ ", manufacturer=" + manufacturer + ", category=" + category + ", unitsInStock=" + unitsInStock
				+ ", condition=" + condition + "]";
	}

	
	//Source - Generate hashCode and equals
	//equals를 재정의 _ id가 같으면 true로 설정했다.
	//hashCdoe도 id기반으로 id가 같으면 동일하게 재정의
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
}
