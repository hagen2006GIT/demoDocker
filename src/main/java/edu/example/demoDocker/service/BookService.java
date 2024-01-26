package edu.example.demoDocker.service;

import edu.example.demoDocker.service.dto.BookDTO;
import java.util.List;

public interface BookService {
    List<BookDTO> findAll ();
    BookDTO findById( Long id);
    BookDTO save (BookDTO book);
    void deleteById (Long id);
}
