package co.com.sofka.technical_test.service;

import co.com.sofka.technical_test.model.Action;
import co.com.sofka.technical_test.model.User;
import co.com.sofka.technical_test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class ActionService {

    public static final String ESPANOL = "Espanol";

    @Autowired
    private UserRepository userRepository;

    public Mono<String> findUserByUserName(Action action){
        return userRepository.findByUserName(action.getUserName()).next()
                .flatMap(buildingMessage(action));
    }

    public Function<User, Mono<String>> buildingMessage(Action action){
        System.out.println("entro al sevice");
        return user -> Mono.just(
                action.getTypeAction().equals("Greet") ? greetMessage(action)
                        : (action.getTypeAction().equals("Name") ? nameMessage(action)
                            : goodbyeMessage(action))
        ); /*{
            if(action.getTypeAction().equals("Greet")) return greetMessage(action);
            else if(action.getTypeAction().equals("Name")) return nameMessage(action);
            else if(action.getTypeAction().equals("Goodbye")) return goodbyeMessage(action);
            return "Nothing to see";
        }*/
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
