package com.surya.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String teacherName;
    private String teacherAdress;
    private String qualification;
    private int age;

    @Temporal(TemporalType.DATE)
    private Date dob;
    
    private int experience;
    private String schoolName; 
}
