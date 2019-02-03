package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Bootstrap  implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadFruits();
        loadCustomers();
    }

    private void loadFruits() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        log.info("Category data loaded " + categoryRepository.count());
    }

    private void loadCustomers() {
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFirstname("Bob");
        customer1.setLastname("Jones");
        customer1.setCustomerUrl("/shop/customers/1");

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setFirstname("Steve");
        customer2.setLastname("Shapiro");
        customer2.setCustomerUrl("/shop/customers/2");


        Customer customer3 = new Customer();
        customer3.setId(3L);
        customer3.setFirstname("Ed");
        customer3.setLastname("Pollack");
        customer3.setCustomerUrl("/shop/customers/3");


        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        log.info("Customer data loaded: " + customerRepository.count());

    }

}
