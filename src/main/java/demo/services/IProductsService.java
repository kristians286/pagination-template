package demo.services;

import java.util.List;

import org.springframework.data.domain.Page;

import demo.models.Products;

public interface IProductsService {
	
	public Page<Products> listAll(int pageNr);
	public List<Products> listAll();
}
