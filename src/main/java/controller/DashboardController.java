package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DashboardController {

    @RequestMapping("/dashboard")
    public String show() {
        return "dashboard";
    }

    @RequestMapping("/process/v1")
    public String processOne() {
        return "confirmation";
    }

    @RequestMapping("/process/v2")
    public String processTwo(HttpServletRequest request, Model model) {
       String fullname = request.getParameter("fullname");
       if (! fullname.isEmpty()) {
           fullname = fullname.toUpperCase();
       }
       model.addAttribute("username", fullname);
       return "confirmation";
    }

    @RequestMapping("/process/v3")
    public String processThree(@RequestParam("fullname") String fullname, Model model) {
        if (! fullname.isEmpty()) {
            fullname = fullname.toUpperCase();
        }
        model.addAttribute("username", fullname);
        return "confirmation";
    }
}
