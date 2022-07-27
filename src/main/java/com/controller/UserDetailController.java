package com.controller;

import com.dao.UserDetailDao;
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
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user/detail")
public class UserDetailController {

    private final UserDetailService userDetailService;

    public UserDetailController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<UserDetail> userDetails = new ArrayList<>();
        userDetails = userDetailService.getAll();
        model.addAttribute("userDetails", userDetails);
        return "user-detail-list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String userDetailCreateForm(Model model) {
        UserDetail userDetail = new UserDetail();
        model.addAttribute("userDetail", userDetail);
        return "create-detail-user-form";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("userDetail") UserDetail userDetail, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create-detail-user-form";
        }
        userDetailService.save(userDetail);
        return "redirect:/user/detail/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String userDetailUpdateForm(@RequestParam("userDetailId") Long id, Model model) {
        UserDetail userDetail = userDetailService.get(id);
        model.addAttribute("userDetail", userDetail);
        return "update-detail-user-form";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("userDetail") UserDetail userDetail) {
        userDetailService.update(userDetail);
        return "redirect:/user/detail/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("userDetailId") Long id) {
        userDetailService.delete(id);
        return "redirect:/user/detail/list";
    }
}
