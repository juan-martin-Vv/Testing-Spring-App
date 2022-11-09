package com.jmvv.testing.Models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @NonNull
    private String name;
    @NonNull
    @Min(value = 0)
    private Integer age;
    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genere genere=Genere.NotBinary;
    private LocalDate birth_date;
    @Min(value = 0)
    private Integer numberId;
}
