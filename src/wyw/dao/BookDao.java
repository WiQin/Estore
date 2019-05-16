package wyw.dao;

import wyw.bean.Book;

import java.util.List;

public interface BookDao {
    public List<Book> selectAllBooks();
    public Book selectBookById(long id);

}
