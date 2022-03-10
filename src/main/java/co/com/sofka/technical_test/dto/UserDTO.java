package co.com.sofka.technical_test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String id;
    private String userName;
    private String email;

}
