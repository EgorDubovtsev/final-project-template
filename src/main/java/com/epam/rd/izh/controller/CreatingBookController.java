package com.epam.rd.izh.controller;

import com.epam.rd.izh.dao.CartDao;
import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.dto.CreatedBookDTO;
import com.epam.rd.izh.dto.CreatedBookImpl;
import com.epam.rd.izh.dto.RegistredUserDTO;
import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.mappers.AuthorizedUserMapper;
import com.epam.rd.izh.mappers.BookMapper;
import com.epam.rd.izh.repository.BooksRepository;
import com.epam.rd.izh.repository.UserRepository;
import com.epam.rd.izh.service.Converter;
import com.epam.rd.izh.service.UserPriority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
@Controller
public class CreatingBookController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorizedUserMapper authorizedUserMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    BooksRepository booksRepository;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    CartDao cartDao;
    @Autowired
    Converter converter;


    @PostMapping("/createBook/proceed")
    public String processRegistration(@Valid @ModelAttribute("createBookForm") CreatedBookImpl createdBook,
                                      BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            //логика отображения ошибки, не является обязательной
            //...
            //...
            return "redirect:/";
        }
        if (booksRepository.findByName(createdBook.getName()) != null) {
            //TODO:SHOW ERROR MESSAGE
        }
        BookDTO bookDTO = bookMapper.mapFromCreatedBook(createdBook);
        booksRepository.addBook(bookDTO);
//TODO:MESSAGE ABOUT SUCCESS
        return "redirect:/";
    }

}