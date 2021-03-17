package com.epam.rd.izh.controller;

import com.epam.rd.izh.entity.Book;
import com.epam.rd.izh.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookPopupController {
    @Autowired
    private BookService bookService;
    @Autowired
    private ObjectMapper mapper;

    @RequestMapping(value = "/api/popup", method = RequestMethod.GET)
    public @ResponseBody
    String getBookInfo(@RequestParam String name) {
        Book book = bookService.findByName(name);
        try {
            return mapper.writeValueAsString(bookService.convertToDto(book));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
