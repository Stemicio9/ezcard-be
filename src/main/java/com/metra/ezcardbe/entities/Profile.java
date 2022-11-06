package com.metra.ezcardbe.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Profile {

    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String city;
    private String country;


}
