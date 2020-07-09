package com.epam.rd.izh.controller;

import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookPopupController {
    @Autowired
    private BookService bookService;
    @Autowired
    ObjectMapper mapper;

    @RequestMapping(value = "/api/popup", method = RequestMethod.GET)
    public @ResponseBody
    String getBookInfo(@RequestParam String name) {
        BookDTO bookDTO = bookService.findByName(name);
        System.out.println(bookDTO.getGenre()+"FDF");
        try {
            return mapper.writeValueAsString(bookDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
