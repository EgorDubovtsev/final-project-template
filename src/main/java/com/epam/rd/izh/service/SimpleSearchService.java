package com.epam.rd.izh.service;

import com.epam.rd.izh.dto.BookDto;
import com.epam.rd.izh.dto.SearchParametersDTO;
import com.epam.rd.izh.repository.BookDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SimpleSearchService implements SearchService {

    @Autowired
    private BookDtoRepository bookDtoRepository;

    @Override
    public List<BookDto> findBookBySearchParameters(SearchParametersDTO searchParameters) {
        String bookName = searchParameters.getName().equals("") ? "%" : searchParameters.getName();
        String bookAuthor = searchParameters.getAuthor().equals("") ? "%" : searchParameters.getAuthor();
        String bookGenre = searchParameters.getGenre().equals("") ? "%" : searchParameters.getGenre();
        String bookPriceString = searchParameters.getMaxPrice();
        int bookMaxPrice = bookPriceString.equals("") ? Integer.MAX_VALUE : Integer.parseInt(bookPriceString);

        return bookDtoRepository.findByNameLikeAndAuthorLikeAndGenreLikeAndPriceLessThanEqual(bookName, bookAuthor, bookGenre, bookMaxPrice);
    }
}
