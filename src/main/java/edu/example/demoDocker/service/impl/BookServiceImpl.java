package edu.example.demoDocker.service.impl;

import edu.example.demoDocker.models.Book;
import edu.example.demoDocker.service.dto.BookDTO;
import edu.example.demoDocker.service.convertor.BookMapper;
import edu.example.demoDocker.repository.BookRepository;
import edu.example.demoDocker.service.BookService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override public List<BookDTO> findAll() {
        return bookMapper.toListDto(bookRepository.findAll());
    }
    @Override public BookDTO findById(@NonNull Long id) {
        Logger logger=Logger.getLogger(BookServiceImpl.class.getName());
        logger.info("Mapper In");
        return Optional.ofNullable(getById(id)).map(bookMapper::modelToDto).get();
    }
    @Override @Transactional public BookDTO save(BookDTO book) {
        return bookMapper.modelToDto(bookRepository.save(
                bookMapper.dtoToModel(book)));
    }
    @Override @Transactional public void deleteById(Long id) {
        var book = getById(id);
        bookRepository.delete(book);
    }
    private Book getById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Book with id: " + id + " not found"));
    }
}
