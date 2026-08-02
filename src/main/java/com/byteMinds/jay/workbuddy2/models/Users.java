package com.byteMinds.jay.workbuddy2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.Checks;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Value;


import java.time.LocalDate;

@Entity
@Data
@Table(name="users",
        uniqueConstraints = {
        @UniqueConstraint(name="unique_email",columnNames = {"email"})
        }
)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private  Role role;
    @Column(nullable = true,columnDefinition = "LONGBLOB")
    @Lob
    byte[] profilePicture;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdAt;
    private double latitude;
    private double longitude;
    @Column(columnDefinition = "POINT SRID 4326",nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Point location;
    @JsonIgnore
    @OneToOne(mappedBy = "user")
    Worker worker;


}
