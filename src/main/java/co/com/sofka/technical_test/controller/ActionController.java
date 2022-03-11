package co.com.sofka.technical_test.controller;

import co.com.sofka.technical_test.model.Action;
import co.com.sofka.technical_test.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
@RequestMapping("/action")
public class ActionController {

    @Autowired
    private ActionService actionService;

    @GetMapping("/getMessage")
    public Mono<String>  getMessage(@RequestBody Action action){
        return actionService.findUserByUserName(action)
                .map(Action::getMessage);
    }
}
