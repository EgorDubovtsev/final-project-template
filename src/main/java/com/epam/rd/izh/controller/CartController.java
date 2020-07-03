package com.epam.rd.izh.controller;

import com.epam.rd.izh.dao.CartDao;
import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.dto.UserPersonalData;
import com.epam.rd.izh.dto.UserPersonalDataImpl;
import com.epam.rd.izh.service.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
@Controller
public class CartController {
    @Autowired
    CartDao cartDao;
    @Autowired
    Converter converter;
    @PostMapping("/cart/proceed")
    public String processWorkInCart(@Valid @ModelAttribute("userPersonalData") UserPersonalDataImpl userPersonalData,
                                    Model model,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //логика отображения ошибки, не является обязательной
            //...
            //...
            return "redirect:/";
        }

        System.out.println(userPersonalData.getName()+"BEFORE");
        List<BookDTO> booksInTheCart =  cartDao.getCartByLogin(userPersonalData.getName()).stream().map(bookInCart ->converter.convertToBookDto(bookInCart)).collect(Collectors.toList());
        model.addAttribute("booksInTheCart",booksInTheCart);
        System.out.println(booksInTheCart);
        return "cart";

    }
}
