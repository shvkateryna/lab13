package ua.ucu.edu.task3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder @Setter @AllArgsConstructor
public class CompanyData {
    private String domain;
    private String description;
    private String logo;
    private String name;

}
