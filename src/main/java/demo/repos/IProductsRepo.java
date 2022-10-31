package demo.repos;


import org.springframework.data.repository.PagingAndSortingRepository;

import demo.models.Products;

public interface IProductsRepo extends PagingAndSortingRepository<Products, Integer>{

}
