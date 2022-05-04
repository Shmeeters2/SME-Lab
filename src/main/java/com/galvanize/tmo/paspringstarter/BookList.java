package com.galvanize.tmo.paspringstarter;

import java.util.List;

public interface BookList {

    Book insertBook(String author, String title, int yearPublished);

    List<Book> getBooks();

    void deleteBookList();
}
