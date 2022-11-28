package com.metra.ezcardbe.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialContainer {
    private String name;
    private String value;
    private String callToAction;
}