package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.api.v1.model.CustomerListDTO;
import guru.springfamework.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(description = "This is my Customer Controller")
@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/api/v1/customers";

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation(value = "This will get a list of customers.", notes = "These are some notes about the API.")
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public CustomerListDTO getallCustomers() {

        return new CustomerListDTO(customerService.getAllCustomers());
    }

    @ApiOperation(value = "This will look up a customer by Id.")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomerByName(@PathVariable("id") Long id) {

        return customerService.getCustomerById(Long.valueOf(id));
    }

    @ApiOperation(value = "This will look up a customer by firstname and lastname.")
    @GetMapping("/{firstname}/{lastname}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomerByFirstAndLastName(@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname) {

        return customerService.getCustomerByFirstnameAndLastname(firstname, lastname);

    }

    @ApiOperation(value = "This will create a new customer.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createNewCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.createNewCustomer(customerDTO);
    }

    @ApiOperation(value = "This will update a customer by Id.")
    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
        return customerService.saveCustomerByDTO(id, customerDTO);
    }

    @ApiOperation(value = "This will update a customer property by Id.")
    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO patchCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
        return customerService.patchCustomer(id, customerDTO);
    }

    @ApiOperation(value = "This will delete a customer by Id.")
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomerById(id);
    }
}
