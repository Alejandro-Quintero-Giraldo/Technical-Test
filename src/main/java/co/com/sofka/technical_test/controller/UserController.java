package co.com.sofka.technical_test.controller;

import co.com.sofka.technical_test.dto.UserDTO;
import co.com.sofka.technical_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public Mono<UserDTO> save(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }

    @GetMapping("/findById/{id}")
    public  Mono<UserDTO> findById(@PathVariable("id") String id){
        return userService.findById(id);
    }

    @GetMapping("/findAll")
    public Flux<UserDTO> findAll(){
        return userService.findAll();
    }

    @PutMapping("/update")
    public Mono<UserDTO> update(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<String> delete(@PathVariable("id") String id){
        return  userService.delete(id);
    }
}
