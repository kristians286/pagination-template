package demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import demo.models.Products;
import demo.repos.IProductsRepo;


@SpringBootApplication
public class PaginationApp {

	public static void main(String[] args) {
		SpringApplication.run(PaginationApp.class, args);
	}
	
	@Bean
	public CommandLineRunner runner(final IProductsRepo productsRepo)
	{
		return new CommandLineRunner() {
				
			public void run(String... args) throws Exception {
				
				for (int i = 0; i < 101; i++) {
					Products product = new Products("Cool product","Awesome description",(float) 10.00);
					productsRepo.save(product);
				}
				
			}
		};
	}
	
}
