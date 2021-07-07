package com.epam.rd.izh.controller;

import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.dto.CreatedBookImpl;
import com.epam.rd.izh.mappers.BookMapper;
import com.epam.rd.izh.service.BookService;
import com.epam.rd.izh.service.FieldChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class BookCreateController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private FieldChecker fieldChecker;

    @PostMapping("/createBook/proceed")
    public String processBookCreating(@Valid @ModelAttribute("createBookForm") CreatedBookImpl createdBook,
                                      BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            return "redirect:/";
        }
        if (fieldChecker.isNull(createdBook)) {
            return "redirect:/createBook?error=emptyFields";
        } else if (bookService.findByName(createdBook.getName()) != null) {
            return "redirect:/createBook?error=bookExist";
        }
        BookDTO bookDTO = bookMapper.mapFromCreatedBook(createdBook);
        bookService.addBook(bookDTO);
        return "redirect:/";
    }
}

