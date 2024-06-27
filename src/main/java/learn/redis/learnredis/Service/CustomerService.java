package learn.redis.learnredis.Service;


import learn.redis.learnredis.Entity.Customer;
import learn.redis.learnredis.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public Customer addCustomer(Customer customer){
       return customerRepo.save(customer);
    }
    public List<Customer> getAllCustomers(){

        List<Customer> allCustomer = new ArrayList<>();
        customerRepo.findAll().forEach(allCustomer::add);
        return allCustomer;
    }

    public Customer getCustomerById(int id){

        Optional<Customer> optionalCustomer
                = customerRepo.findById(String.valueOf(id));
        return optionalCustomer.orElse(null);
    }

    public Customer updateCustomerById(int id,
                                       Customer newCustomer){

        Optional<Customer> existingCustomer
                = customerRepo.findById(String.valueOf(id));

        if (existingCustomer.isPresent()) {
            Customer updatedCustomer
                    = existingCustomer.get();

            updatedCustomer.setName(newCustomer.getName());
            updatedCustomer.setPhone(newCustomer.getPhone());
            updatedCustomer.setEmail(newCustomer.getEmail());

            customerRepo.deleteById(String.valueOf(id));
            return customerRepo.save(updatedCustomer);
        }

        return null;
    }

    // delete the existing customer
    public void deleteCustomerById(int id){
        customerRepo.deleteById(String.valueOf(id));
    }
}
