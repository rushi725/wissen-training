package com;

import java.util.List;

import com.app.model.Product;
import com.app.model.ProductType;
import com.app.repository.JdbcProductRepository;
import com.app.repository.ProductRepository;

public class App {

	
	public static void main(String[] args) {
		
		ProductRepository productRepository = new JdbcProductRepository();

		//Product product1 = new Product("Mobile", 22000.00, ProductType.ELEC);
	///	Product product2 = new Product("Printer", 219300.00, ProductType.ELEC);

		//productRepository.save(product1);
		//productRepository.save(product2);
		//productRepository.update(2, 192000.00);
		Product product = productRepository.findById(1);
		System.out.println(product);
		List<Product> list = productRepository.findAll();
		System.out.println(list);
		//productRepository.delete(0);
		
		
	}
}
