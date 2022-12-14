package com.metra.ezcardbe.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Profile {

    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    private ProfileContainer profile;
    private List<SocialContainer> socials;
    private List<ContactContainer> contacts;
    private List<CompanyContainer> companies;



}
