package controller;


import entity.Country;
import entity.User;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.CountryUtil;

import javax.validation.Valid;

@RequestMapping("/user")
@Controller
public class UserController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    /*@RequestMapping("/registration-form")
    public String showRegistrationForm(@ModelAttribute("user") User user) {
        return "registration";
    }
    */

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        User user = new User();
        /*User user = new User("Mir Md", "Kawsur");*/
        model.addAttribute("user", user);
        model.addAttribute("countries", new CountryUtil().getAll());
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("user") User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
            /*return "redirect:/user/register";*/
        }
        return "confirmation";
    }
}
