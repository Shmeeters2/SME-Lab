package com.galvanize.tmo.paspringstarter;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class BookListServiceImpl implements BookList {

    private static List<Book> DB = new ArrayList<>();
    private int idCount = 0;

    @Override
    public Book insertBook(String author, String title, int yearPublished) {
        idCount++;
        Book newBook = new Book(idCount, author, title, yearPublished);
        DB.add(newBook);
        return newBook;
    }

    @Override
    public List<Book> getBooks(){
        List<Book> books = DB;
        //Old Way
        //books.sort((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
        books.sort(Comparator.comparing(Book::getTitle));
        return books;
    }

    @Override
    public void deleteBookList() {
        DB.clear();
        idCount = 0;
    }
}
