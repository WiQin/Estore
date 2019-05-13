package wyw.dao.impl;

import wyw.bean.Book;
import wyw.dao.BookDao;
import wyw.util.jdbc.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BookDaoImpl
 * @Description
 * @Author Wangyw
 */
public class BookDaoImpl implements BookDao {

    private JdbcUtil util;

    public BookDaoImpl(JdbcUtil util) {
        this.util = util;
    }

    public Book resultBook(ResultSet rs) throws SQLException {
        Book book;
        int id = rs.getInt("id");
        String name = rs.getString("name");
        float price = rs.getFloat("price");
        String type = rs.getString("type");
        book = new Book(id,name,price,type);
        return book;
    }

    @Override
    public List<Book> selectAllBooks() {
        String sql = "select * from book";
        ResultSet rs = util.executeSelect(sql, null);
        List<Book> list = new ArrayList<Book>();

        try {
            while(rs.next()){
                Book book = this.resultBook(rs);
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
