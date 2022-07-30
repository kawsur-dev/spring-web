package com.controller;

import com.dao.UserContactDao;
import com.model.UserContact;
import com.model.UserDetail;
import com.service.UserContactService;
import com.service.UserDetailService;
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
@RequestMapping("/user/contact")
public class UserContactController {

    private final UserContactService userContactService;

    private final UserDetailService userDetailService;

    public UserContactController(UserContactService userContactService, UserDetailService userDetailService) {
        this.userContactService = userContactService;
        this.userDetailService = userDetailService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
        webDataBinder.registerCustomEditor(UserDetail.class, new UserContactController.UserDetailEditor());
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<UserContact> userContacts = new ArrayList<>();
        userContacts = userContactService.getAll();
        model.addAttribute("userContacts", userContacts);
        return "user-contact-list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String userContactCreateForm(Model model) {
        UserContact userContact = new UserContact();
        List<UserDetail> userDetails = userDetailService.getAll();
        model.addAttribute("userContact", userContact);
        model.addAttribute("userDetails", userDetails);
        return "create-contact-user-form";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("userContact") UserContact userContact, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create-contact-user-form";
        }
        userContactService.save(userContact);
        return "redirect:/user/contact/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String userContactUpdateForm(@RequestParam("userContactId") Long id, Model model) {
        UserContact userContact = userContactService.get(id);
        model.addAttribute("userContact", userContact);
        return "update-contact-user-form";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("userContact") UserContact userContact) {
        userContactService.update(userContact);
        return "redirect:/user/contact/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("userContactId") Long id) {
        userContactService.delete(id);
        return "redirect:/user/contact/list";
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
