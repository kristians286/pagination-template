package demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.models.Products;
import demo.repos.IProductsRepo;
import demo.services.IProductsService;

@Service
public class ProductsServiceImpl implements IProductsService {
	
	@Autowired
	private IProductsRepo productsRepo;
	
	
	public Page<Products> listAll(int pageNr) {
		Pageable pageable = PageRequest.of(pageNr-1, 10);
		return productsRepo.findAll(pageable);
	}
	
	public List<Products> listAll() {

		return (List<Products>) productsRepo.findAll();
	}
}
