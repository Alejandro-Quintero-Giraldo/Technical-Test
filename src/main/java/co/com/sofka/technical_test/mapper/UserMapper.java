package co.com.sofka.technical_test.mapper;


import co.com.sofka.technical_test.dto.UserDTO;
import co.com.sofka.technical_test.model.User;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
public class UserMapper {

    public Function<UserDTO, User> toModel(){
        return userDTO -> new User(userDTO.getId(), userDTO.getUserName(), userDTO.getEmail());
    }

    public Mono<UserDTO> toDTO(User user){
        return Mono.just(new UserDTO(user.getId(), user.getUserName(), user.getEmail()));
    }
}
