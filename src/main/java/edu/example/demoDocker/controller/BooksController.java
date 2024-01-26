package edu.example.demoDocker.controller;

import edu.example.demoDocker.repository.TppRefAccountTypeRepository;
import edu.example.demoDocker.service.BookService;
import edu.example.demoDocker.models.response.ResponseBodyForProductRegistry;
import edu.example.demoDocker.service.convertor.TppRefAccountTypeMapper;
import edu.example.demoDocker.service.dto.BookDTO;
import edu.example.demoDocker.service.dto.TppRefAccountTypeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@Validated
public class BooksController {
    private final BookService bookService;
    @RequestMapping(value = "api/v1/books",method = RequestMethod.GET)
    public List<BookDTO> allBooks() {
        return bookService.findAll();
    }
    @RequestMapping(value = "api/v1/book={id}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BookDTO> getBook(@PathVariable ("id") long id) {
//        return ResponseEntity.ok().body(bookService.findById(id));
        return ResponseEntity.ok(bookService.findById(id));
    }
    @RequestMapping(value = "api/v1/book",method = RequestMethod.POST)
    //@PostMapping("/book")
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO book) throws URISyntaxException {
        BookDTO result = bookService.save(book);
        return ResponseEntity.created(new URI("/api/v1/books/" + result.getId()))
                .body(result);
    }
    @RequestMapping(value = "api/v1/book={id}",method = RequestMethod.PUT)
//    @PutMapping("/book={id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id,@RequestBody BookDTO book) {
        return ResponseEntity.ok().body(bookService.save(book));
    }
    @RequestMapping(value = "api/v1/book={id}",method = RequestMethod.DELETE)
//    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }




    @Autowired TppRefAccountTypeRepository tppRefAccountTypeRepository;
    @Autowired private final TppRefAccountTypeMapper tppRefAccountTypeMapper;
    Logger logger=Logger.getLogger(BooksController.class.getName());
    @PostMapping(value = "api/v1/test")
    public ResponseEntity<?> test(@RequestParam int id,@RequestParam(required = false) String name) throws URISyntaxException {
        for(TppRefAccountTypeDTO dto :tppRefAccountTypeMapper.toListDto(tppRefAccountTypeRepository.findAll())) {
            logger.info(dto.getValue());
        }
        logger. info("param (id)="+id);
        logger. info("param (name)="+name);
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "api/v1/body")
    public ResponseEntity<ResponseBodyForProductRegistry> body(@RequestParam String id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseBodyForProductRegistry.Of(id));
    }
}
