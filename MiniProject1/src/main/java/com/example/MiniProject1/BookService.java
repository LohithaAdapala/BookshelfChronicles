package com.example.MiniProject1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import com.example.MiniProject1.BookRepository;
import com.example.MiniProject1.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BookService implements BookRepository{
    private HashMap<Integer, Book> hmap = new HashMap<Integer,Book>();
    int uniqueBookId=3;
    BookService(){
        Book b1= new Book(1,"It ends with us","itEndsWithUs.jpg");
        Book b2= new Book(2,"Verity","verity.jpg");
        hmap.put(b1.getBookId(),b1);
        hmap.put(b2.getBookId(),b2);

    }

    @Override
    public ArrayList<Book> getBooks(){
        Collection<Book> bookCollection=hmap.values();
        ArrayList<Book> books=new ArrayList<>(bookCollection);
        return books;
    }
    @Override
    public Book getBookById(int bookId){
        Book book =hmap.get(bookId);
        if(book==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return book;
    }

    @Override
    public Book addBook(Book book){
        book.setBookId(uniqueBookId);
        hmap.put(uniqueBookId,book);
        uniqueBookId+=1;
        return book;

    }

    @Override
    public Book updateBook(int bookId, Book book){
        Book existingBook = hmap.get(bookId);
        if(existingBook==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(book.getBookName()!=null){
            existingBook.setBookName(book.getBookName());
        }
        if(book.getImageUrl()!=null){
            existingBook.setImageUrl(book.getImageUrl());
        }
        return existingBook;

    }

    @Override
    public void deleteBook(int bookId){
        Book book=hmap.get(bookId);
        if(book==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            hmap.remove(bookId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }


}
