package wyw.service.impl;

import wyw.bean.Book;
import wyw.dao.BookDao;
import wyw.dao.impl.BookDaoImpl;
import wyw.service.BookService;
import wyw.util.exception.BookException;
import wyw.util.jdbc.JdbcUtil;

import java.util.List;

/**
 * @ClassName BookServiceImpl
 * @Description
 * @Author Wangyw
 */
public class BookServiceImpl implements BookService {

    BookDao bookDao;
    @Override
    public List<Book> findAllBooks() throws BookException {
        bookDao = new BookDaoImpl(JdbcUtil.getInstance());
        List<Book> books = bookDao.selectAllBooks();
        return books;
    }
}
