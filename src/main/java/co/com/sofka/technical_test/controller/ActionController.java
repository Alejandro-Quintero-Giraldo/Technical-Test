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

    @GetMapping("/getMessage/{userId}/{userName}/{typeAction}/{languaje}")
    public Mono<String>  getMessage(@PathVariable("userId") String userId,
                                    @PathVariable("userName") String userName,
                                    @PathVariable("typeAction") String typeAction,
                                    @PathVariable("languaje") String languaje){

        return Mono.just(new Action(userId,userName,languaje, typeAction, ""))
                .flatMap(action -> actionService.findUserByUserName(action))
                .map(Action::getMessage);
    }
}
