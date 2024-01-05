package com.codechampions.easytravel.model;

import com.codechampions.easytravel.model.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;




@Entity
public class User extends AbstractEntity {


    @NotNull
    private String pwHash;

    public User() {}

    public User(String password) {
            this.pwHash = encoder.encode(password);
    }

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

}
