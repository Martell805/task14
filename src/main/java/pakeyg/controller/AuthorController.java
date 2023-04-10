package pakeyg.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import pakeyg.entity.Author;
import pakeyg.service.AuthorService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("author")
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("{id}")
    public Author getById(@PathVariable Integer id) throws ChangeSetPersister.NotFoundException {
        return authorService.getById(id);
    }

    @GetMapping("/all")
    public List<Author> getAll() {
        return authorService.getAll();
    }

    @GetMapping("/all/firstName/{name}")
    public List<Author> getAllByFirstName(@PathVariable String name) {
        return authorService.getAllByFirstName(name);
    }

    @GetMapping("/all/middleName/{name}")
    public List<Author> getAllByMiddleName(@PathVariable String name) {
        return authorService.getAllByMiddleName(name);
    }

    @GetMapping("/all/lastName/{name}")
    public List<Author> getAllByLastName(@PathVariable String name) {
        return authorService.getAllByLastName(name);
    }

    @PostMapping()
    public Author add(@RequestBody Author author) {
        return authorService.add(author);
    }

    @PatchMapping
    public Author edit(@RequestBody Author author) {
        return authorService.edit(author);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
        authorService.deleteById(id);
    }
}
