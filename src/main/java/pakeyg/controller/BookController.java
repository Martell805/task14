package pakeyg.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import pakeyg.entity.Book;
import pakeyg.service.BookService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("book")
public class BookController {
    private final BookService bookService;

    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id) throws ChangeSetPersister.NotFoundException {
        return bookService.getById(id);
    }

    @GetMapping("/all")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/all/author/{authorId}")
    public List<Book> getAllByAuthor(@PathVariable Integer authorId) {
        return bookService.getAllByAuthorId(authorId);
    }

    @GetMapping("/all/name/{name}")
    public List<Book> getAllByName(@PathVariable String name) {
        return bookService.getAllByName(name);
    }

    @PostMapping()
    public Book add(@RequestBody Book book) {
        return bookService.add(book);
    }

    @PatchMapping
    public Book edit(@RequestBody Book book) {
        return bookService.edit(book);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
        bookService.deleteById(id);
    }
}
