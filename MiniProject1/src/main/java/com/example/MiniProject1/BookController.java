package com.example.MiniProject1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.MiniProject1.BookService;
import com.example.MiniProject1.Book;

import java.util.ArrayList;

@RestController
public class BookController {
    BookService bookService= new BookService();
    @GetMapping("/books")
    public ArrayList<Book> getAllBooks(){
        return bookService.getBooks();

    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable("bookId") int bookId){
        return bookService.getBookById(bookId);
    }




}
