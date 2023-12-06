package com.example.MiniProject1;

import java.util.ArrayList;
import com.example.MiniProject1.Book;

public interface BookRepository {
    ArrayList<Book> getBooks();
    Book getBookById(int bookId);
}
