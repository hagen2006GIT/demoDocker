package edu.example.demoDocker.repository;

import edu.example.demoDocker.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
