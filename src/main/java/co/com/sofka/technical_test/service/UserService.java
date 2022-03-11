package co.com.sofka.technical_test.service;

import co.com.sofka.technical_test.dto.UserDTO;
import co.com.sofka.technical_test.mapper.UserMapper;
import co.com.sofka.technical_test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Mono<UserDTO> save(UserDTO userDTO){
        return userRepository.save(
                    userMapper.toModel().apply(userDTO))
                .flatMap(userMapper::toDTO);
    }

    public Mono<UserDTO> findById(String id){
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("El usuario no existe")))
                .flatMap(userMapper::toDTO);
    }

    public Flux<UserDTO> findAll(){
        return userRepository.findAll()
                .flatMap(userMapper::toDTO);
    }

    public Mono<String> delete(String id) {
        return userRepository.findById(id)
                .flatMap(user ->  user.getId().isEmpty()|| user.getId() == null
                        ? Mono.just("El usuario no existe")
                        : userRepository.deleteById(id)
                            .thenReturn("El usuario ha sido borrado exitosamente"));
    }

}
