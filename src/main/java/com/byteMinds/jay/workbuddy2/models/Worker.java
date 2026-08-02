package com.byteMinds.jay.workbuddy2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;


@Entity
@Getter
@Setter
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Min(value = 0)
    @Max(value = 5)
    private int  stars;
    private int experienceYears;
    private String workCategory;
    private  String description;
    private boolean isAvailaible;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name= "user_id")
    Users user;




}
