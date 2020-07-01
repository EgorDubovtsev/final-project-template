package com.epam.rd.izh.dao;

import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BooksDao implements Dao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    BookMapper bookMapper;

    @Override
    public List<BookDTO> getList() {
        String sqlGetAllBooks = "SELECT * FROM books";
        return jdbcTemplate.query(sqlGetAllBooks,bookMapper);//TODO:NULL
    }

    public int addBook(BookDTO bookDTO){
        String sqlAddBook = "INSERT INTO books values('"+bookDTO.getName()+"','"
                +bookDTO.getPublishYear()+"','"
                +bookDTO.getDescription()+"','"
                +bookDTO.getPrice()
                +"','"+bookDTO.getAuthor()+"');";

        String sqlAddBookGenre= "INSERT INTO books_genres VALUES('"
                +bookDTO.getName()+"','"
                +bookDTO.getGenre()+"');";
        System.out.println(sqlAddBook+"  "+ sqlAddBookGenre);
        jdbcTemplate.update(sqlAddBook);
        return jdbcTemplate.update(sqlAddBookGenre);
    }

    public BookDTO getBookByName(String name){
        String sqlGetBookByName = "SELECT * FROM books WHERE book_name='"+name+"'";
        return jdbcTemplate.queryForObject(sqlGetBookByName,bookMapper);
    }


}
