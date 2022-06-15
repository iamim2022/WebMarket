package com.survivalcoding.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.survivalcoding.domain.model.Product;

public class ProductRepository_polymorphism {
	public static void main(String[] args) {
		//삽입, 삭제가 빈번할 때 항상 동일 성능, but ArrayList보다 검색 느림
		//메모리 조금 더 많이 사용
		List<Product> products = new LinkedList<>();
		
		//크기가 커질 수록 삽입, 삭제가 느려짐, 내부적으로 배열이라 성능이 빠르다.
		List<Product> products2 = new ArrayList<>();
	
		sort(products);
		sort(products2);
		Stack stack = (Stack) sort(products2);			//List계열 중 하나인 stack으로 받음. 형변환 필요
		
		
		//List말고 배열로 값 받기
		Product[] products3 = new Product[3];
		sort(Arrays.asList(products3));
	}


	// ArrayList <Product> products 라고 해버리면 범주가 좁아져서 ArrayList에서만 동작한다.
	// 다형성을 위해 List <Product> products 로 설정해 LinkedList, ArrayList 등을 전부 사용할 수 있도록 한다.
	public static List <Product> sort(List <Product> products){
		return new LinkedList<>();
	}
}