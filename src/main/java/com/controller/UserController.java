package com.controller;

import com.model.User;
import com.model.UserDetail;
import com.service.UserDetailService;
import com.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserDetailService userDetailService;

    public UserController(UserService userService, UserDetailService userDetailService) {
        this.userService = userService;
        this.userDetailService = userDetailService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
        webDataBinder.registerCustomEditor(UserDetail.class, new UserDetailEditor());
    }

    @RequestMapping("/list")
    public String list(Model model, @RequestParam(required = false) String sortKey) {
        List<User> users = new ArrayList<>();
        users = userService.getAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String userCreateForm(Model model) {
        User user = new User();
        List<UserDetail> userDetails = userDetailService.getAll();
        model.addAttribute("user", user);
        model.addAttribute("userDetails", userDetails);
        return "create-user-form";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create-user-form";
        }
        userService.save(user);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String userUpdateForm(@RequestParam("userId") int id, Model model) {
        User user = userService.get(id);
        List<UserDetail> userDetails = userDetailService.getAll();
        model.addAttribute("user", user);
        model.addAttribute("userDetails", userDetails);
        return "update-user-form";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("userId") int id) {
        userService.delete(id);
        return "redirect:/user/list";
    }

    @RequestMapping("/search")
    public String delete(@RequestParam("searchValue") String firstname, Model model) {
        List<User> users = userService.getAll(firstname);
        model.addAttribute("users", users);
        return "user-list";
    }

    class UserDetailEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            UserDetail userDetail = userDetailService.get(Long.parseLong(text));
            if (userDetail != null) {
                this.setValue(userDetail);
                return;
            }
            throw new java.lang.IllegalArgumentException(text);
        }

    }
}
