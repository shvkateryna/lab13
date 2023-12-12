package ua.ucu.edu.task1;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FacebookUser {
    private String email;
    private String userCountry;
    private LocalDateTime userActiveTime;
}
