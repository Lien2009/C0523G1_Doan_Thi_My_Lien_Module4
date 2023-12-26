package com.example.cs4;

import com.example.cs4.account.model.Account;
import com.example.cs4.account.service.IAccountService;
import com.example.cs4.account.utils.EncryptedPasswordUtils;
import com.example.cs4.customer.model.Customer;
import com.example.cs4.customer.service.ICustomerService;
import com.example.cs4.role.model.Role;
import com.example.cs4.role.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Controller
public class MainPageController {
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private ICustomerService iCustomerService;
    @RequestMapping("")
    public String showHome (){
        return "/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        System.out.println("Login run");
        return "account/login-page";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUp(Model model) {
        System.out.println("Sign up run");
        model.addAttribute("accountCreate", new Account());
        model.addAttribute("customerCreate", new Customer());
        return "account/sign-up-page";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String save(@ModelAttribute("accountCreate") Account account,
                       @ModelAttribute("customerCreate") Customer customer, Model model) {
        if (iCustomerService.findCustomerByEmail(customer.getEmail()) != null) {
            model.addAttribute("emailError", "Email đã tồn tại!");
            return "account/sign-up-page";
        } else if (iCustomerService.findCustomerByPhoneNumber(customer.getPhoneNumber()) != null) {
            model.addAttribute("phoneNumberError", "Số điện thoại đã tồn tại!");
            return "account/sign-up-page";
        } else if (iAccountService.findAccountByUserName(account.getUserName()) != null) {
            model.addAttribute("userNameError", "Tên tài khoản đã tồn tại!");
            return "account/sign-up-page";
        } else {
            Role defaultRole = iRoleService.findRoleByRoleName("ROLE_USER");
            if (defaultRole == null) {
                defaultRole = new Role("ROLE_USER");
                iRoleService.save(defaultRole);
            }
            Set<Role> roles = new HashSet<>();
            roles.add(defaultRole);
            account.setRoleSet(roles);
            account.setPassword(EncryptedPasswordUtils.encryptedPassword(account.getPassword()));
            iAccountService.save(account);
            customer.setAccount(account);
            iCustomerService.save(customer);
        }
        return "account/login-page";
    }

    @RequestMapping(value = "/accountInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
        System.out.println("userInfo run");

        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();
        System.out.println(userName);
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//        String userInfo = WebUtils.toString(loginedUser);
        Customer customer = iCustomerService.findCustomerByUsername(userName);
        model.addAttribute("username", userName);
        model.addAttribute("customerInfo",customer);

//        System.out.println("User Name: " + userName);
//
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//        String userInfo = WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);

        return "account-information-page";

    }

}
