package co.com.sofka.technical_test.repository;

import co.com.sofka.technical_test.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User,String> {

    Flux<User> findByUserName(String userName);
}