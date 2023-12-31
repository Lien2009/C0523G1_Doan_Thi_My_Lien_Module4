package com.example.cs4.yard.controller;

import com.example.cs4.customer.model.Customer;
import com.example.cs4.customer.service.ICustomerService;
import com.example.cs4.yard.dto.YardDto;
import com.example.cs4.yard.model.Yard;
import com.example.cs4.yard.service.IYardService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/yards")
public class YardController {
    @Autowired
    private IYardService yardService;
    @Autowired
    private ICustomerService iCustomerService;
//Liên có code
    @GetMapping("")
    public String showPageYard(@RequestParam(defaultValue = "0", required = false) int page,
                               @RequestParam(defaultValue = "", required = false) String nameSearch,
                               Model model,
                               Principal principal) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Yard> yardPage = yardService.getYardPage(pageable, nameSearch);
        model.addAttribute("nameSearch",nameSearch);
        model.addAttribute("yardPage", yardPage);
        String userName = principal.getName();
        System.out.println(userName);
        Customer customer = iCustomerService.findCustomerByUsername(userName);
        model.addAttribute("username", userName);
        model.addAttribute("customerInfo",customer);
        return "/yard/showList";
    }
//    end

    @GetMapping("/create")
    public String showFormCreateYard(Model model) {
        model.addAttribute("yardDto", new YardDto());
        return "/yard/create";
    }

    @PostMapping("/create")
    public String createYard(@Valid @ModelAttribute YardDto yardDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        new YardDto().validate(yardDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/yard/create";
        }
        Yard yard = new Yard();
        BeanUtils.copyProperties(yardDto, yard);
        yardService.createYard(yard);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/yard";
    }

    @PostMapping("/delete")
    public String deleteYard(@RequestParam int id) {
        yardService.deleteYard(id);
        return "redirect:/yards";
    }

    @PostMapping("/update")
    public String updateYard() {
        return "redirect:/yards";
    }
}
