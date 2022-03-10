package co.com.sofka.technical_test.controller;

import co.com.sofka.technical_test.model.Action;
import co.com.sofka.technical_test.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/action")
public class ActionController {

    @Autowired
    private ActionService actionService;

    @GetMapping("/getMessage")
    public Mono<String>  getMessage(@RequestBody Action action){
        System.out.println("entra al controller");
        return actionService.findUserByUserName(action);
    }
}
