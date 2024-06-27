package learn.redis.learnredis.Entity;


import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "Customer")
public class Customer {
    @Id
    @Indexed
    private int id;
    private String name;
    private long phone;
    private String email;

}
