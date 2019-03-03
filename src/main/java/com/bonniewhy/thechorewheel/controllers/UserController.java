package com.bonniewhy.thechorewheel.controllers;

import com.bonniewhy.thechorewheel.models.User;
import com.bonniewhy.thechorewheel.models.data.RoomDao;
import com.bonniewhy.thechorewheel.models.data.TaskDao;
import com.bonniewhy.thechorewheel.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private RoomDao roomDao;

    @RequestMapping(value = "signin", method = RequestMethod.GET)
    public String displaySignIn(Model model) {

        model.addAttribute("title", "Sign In");
        model.addAttribute(new User());

        return "user/signin";

    }

    // @RequestMapping(value = "signin", method = RequestMethod.POST)
    // public String processSignIn(Model model, @ModelAttribute @Valid User user, Errors erros) {

        // [ ] TODO: How do you use Spring to sign someone in?

    // }

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String displaySignUp(Model model) {

        model.addAttribute("title", "Sign Up");
        model.addAttribute(new User());

        return "user/signup";

    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String processSignUp(Model model, @ModelAttribute @Valid User user, Errors errors) {

        if (errors.hasErrors()) {

            model.addAttribute("title", "Sign Up");
            return "user/signup";

        }

        userDao.save(user);
        return "redirect:";

    }

    @RequestMapping(value = "account/{userId}", method = RequestMethod.GET)
    public String viewUserAccount(Model model, @PathVariable int userId) {

        model.addAttribute("title", "Your Account");
        model.addAttribute("user", userDao.findOne(userId));

        return "user/account";

    }

}
