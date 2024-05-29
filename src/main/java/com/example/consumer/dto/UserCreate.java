package com.example.consumer.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreate {
    private String userName;
    private String userEmail;
}
