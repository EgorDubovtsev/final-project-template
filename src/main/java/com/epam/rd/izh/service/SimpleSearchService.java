package com.epam.rd.izh.service;

import com.epam.rd.izh.entity.Book;
import com.epam.rd.izh.dto.SearchParametersDTO;
import com.epam.rd.izh.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SimpleSearchService implements SearchService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findBookBySearchParameters(SearchParametersDTO searchParameters) {
        String bookName = searchParameters.getName().equals("") ? "%" : searchParameters.getName();
        String bookAuthor = searchParameters.getAuthor().equals("") ? "%" : searchParameters.getAuthor();
        String bookGenre = searchParameters.getGenre().equals("") ? "%" : searchParameters.getGenre();
        String bookPriceString = searchParameters.getMaxPrice();
        int bookMaxPrice = bookPriceString.equals("") ? Integer.MAX_VALUE : Integer.parseInt(bookPriceString);

        return bookRepository.findByNameLikeAndAuthorNameLikeAndGenreLikeAndPriceLessThanEqual(bookName, bookAuthor, bookGenre, bookMaxPrice);
    }
}
