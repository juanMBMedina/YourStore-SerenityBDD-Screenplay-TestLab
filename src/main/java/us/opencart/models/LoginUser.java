package us.opencart.models;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginUser {
    private String email;
    private String password;
}
