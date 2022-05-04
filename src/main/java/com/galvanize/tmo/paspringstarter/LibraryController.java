package com.galvanize.tmo.paspringstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class LibraryController {

    @Autowired
    private BookList bookList;

    @GetMapping("/health")
    public void health() {

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book add(String author, String title, int yearPublished){
        return bookList.insertBook(author, title, yearPublished);
    }

    @GetMapping
    public List<Book> getList(){
        return bookList.getBooks();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(){
        bookList.deleteBookList();
    }


}
