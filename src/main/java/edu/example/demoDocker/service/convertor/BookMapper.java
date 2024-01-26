package edu.example.demoDocker.service.convertor;

import edu.example.demoDocker.models.Book;
import edu.example.demoDocker.service.dto.BookDTO;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book dtoToModel(BookDTO bookDto);
    BookDTO modelToDto(Book book);
    List<BookDTO> toListDto(List<Book> books);
}