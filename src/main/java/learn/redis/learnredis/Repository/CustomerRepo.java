package learn.redis.learnredis.Repository;

import learn.redis.learnredis.Entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer,String> {
}
