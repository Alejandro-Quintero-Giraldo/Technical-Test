package co.com.sofka.technical_test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Action {

    private String userId;
    private String userName;
    private String languaje;
    private String typeAction;
    private String message;

}
