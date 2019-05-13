package wyw.service;

import wyw.bean.Book;
import wyw.util.exception.BookException;

import java.util.List;

public interface BookService {
    public List<Book> findAllBooks() throws BookException;
}
