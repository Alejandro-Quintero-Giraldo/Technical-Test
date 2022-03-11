package co.com.sofka.technical_test.service;

import co.com.sofka.technical_test.model.Action;
import co.com.sofka.technical_test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ActionService {

    private static final String NOTHING_TO_SEE_HERE = "Nothing to see here";
    private static final String GOODBYE = "Goodbye".toUpperCase();
    private static final String ESPANOL = "Espanol".toUpperCase();
    private static final String  GREET = "Greet".toUpperCase();
    private static final String  NAME =  "Name".toUpperCase();

    @Autowired
    private UserRepository userRepository;

    public Mono<Action> findUserByUserName(Action action){
        return userRepository.findByUserName(action.getUserName()).next()
                .map(user -> {
                    if(action.getTypeAction().equals(GREET)) action.setMessage(greetMessage(action));
                    else if(action.getTypeAction().equals(NAME))  action.setMessage(nameMessage(action));
                    else if(action.getTypeAction().equals(GOODBYE))  action.setMessage(goodbyeMessage(action));
                    else action.setMessage(NOTHING_TO_SEE_HERE);
                    return action;
                });
    }

    public String greetMessage(Action action){
        if(action.getLanguaje().equals(ESPANOL)) return  "Hola "+action.getUserName();
        else return "Hello "+action.getUserName();
    }

    public String nameMessage(Action action){
        if(action.getLanguaje().equals(ESPANOL)) return  "Mi nombre es: "+action.getUserName();
        else return "My name is: "+action.getUserName();
    }

    public String goodbyeMessage(Action action){
        if(action.getLanguaje().equals(ESPANOL)) return  "Hasta luego "+action.getUserName();
        else return "Goodbye "+action.getUserName();
    }
}
