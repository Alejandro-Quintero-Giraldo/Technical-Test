package co.com.sofka.technical_test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Document(value = "user")
public class User {

    @Id
    private String id;

    private String userName;
    private String email;

}
