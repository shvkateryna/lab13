package ua.ucu.edu.task1;

import java.time.LocalDate;

public interface User {
    public String getEmail();
    public String getCountry();
    public LocalDate getLastActiveDate();
}
