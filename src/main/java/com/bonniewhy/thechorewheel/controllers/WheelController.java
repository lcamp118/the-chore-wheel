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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("")
public class WheelController {

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String indexWithoutRooms(Model model) {

        model.addAttribute("rooms", roomDao.findAll());
        model.addAttribute("title", "Spin The Chore Wheel!");
        // model.addAttribute(new User());

        return "index";

    }

    // [ ] TODO: Might need to add a "temporary user" class for people not logged in. Not sure yet.
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String indexWithRooms(Model model, @ModelAttribute @Valid User user, Errors errors) {

        // [ ] TODO: For each room that is selected, add it to the model so it can generate the correct wheel.
        model.addAttribute("rooms", roomDao.findAll());
        model.addAttribute("title", "Spin The Chore Wheel!");

        return "index";

    }

}
