package edu.example.demoDocker.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id @Column(name = "id") @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(name = "title") private String title;
    @Column(name = "author") private String author;
    @Column(name = "year") private int year;
}