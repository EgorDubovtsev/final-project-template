package com.epam.rd.izh.dao;

import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.dto.SearchParametersDTO;
import com.epam.rd.izh.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SimpleBooksDao implements BooksDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookDTO> getList() {
        String sqlGetAllBooks = "SELECT * FROM books";
        return jdbcTemplate.query(sqlGetAllBooks, bookMapper);//TODO:NULL
    }

    @Override
    public int addBook(BookDTO bookDTO) {
        String sqlAddBook = "INSERT INTO books values('" + bookDTO.getName() + "','"
                + bookDTO.getPublishYear() + "','"
                + bookDTO.getDescription() + "','"
                + bookDTO.getPrice()
                + "','" + bookDTO.getAuthor() + "');";

        String sqlAddBookGenre = "INSERT INTO books_genres VALUES('"
                + bookDTO.getName() + "','"
                + bookDTO.getGenre() + "');";
        jdbcTemplate.update(sqlAddBook);
        return jdbcTemplate.update(sqlAddBookGenre);
    }

    @Override
    public BookDTO getBookByName(String name) {
        String sqlGetBookByName = "SELECT * FROM books WHERE book_name like '" + name + "'";
        return jdbcTemplate.queryForObject(sqlGetBookByName, bookMapper);
    }

    @Override
    public List<BookDTO> getBooksByParameters(SearchParametersDTO searchParameters) {
        System.out.println("books dao");
        String bookName = searchParameters.getName().equals("") ? "%" : searchParameters.getName();
        String bookAuthor = searchParameters.getAuthor().equals("") ? "%" : searchParameters.getAuthor();
        String bookGenre = searchParameters.getGenre().equals("") ? "%" : searchParameters.getGenre();
        String bookMaxPrice = searchParameters.getMaxPrice();
        String sqlGetBooksByParameters = "SELECT * FROM (" +
                "SELECT * FROM (" +
                "SELECT * FROM books WHERE book_name LIKE '" + bookName + "'" +
                ") AS books" +
                " JOIN books_genres ON books.book_name = books_genres.book_name " +
                "WHERE books_genres.genre LIKE '" + bookGenre + "'" +
                ") AS result_table" +
                " WHERE result_table.author LIKE '" + bookAuthor + "'";
        System.out.println("sql");
        if (!bookMaxPrice.equals("")) {
            System.out.println("not null");
            return jdbcTemplate.query(sqlGetBooksByParameters, bookMapper).stream()
                    .filter(bookDTO -> bookDTO.getPrice() < Integer.parseInt(bookMaxPrice))
                    .collect(Collectors.toList());
        }
        System.out.println(sqlGetBooksByParameters);
        System.out.println(jdbcTemplate.query(sqlGetBooksByParameters, bookMapper));
        return jdbcTemplate.query(sqlGetBooksByParameters, bookMapper);
    }
}
