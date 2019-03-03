package com.bonniewhy.thechorewheel.controllers;

import com.bonniewhy.thechorewheel.models.Room;
import com.bonniewhy.thechorewheel.models.data.RoomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("room")
public class RoomController {

    @Autowired
    RoomDao roomDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String editRooms(Model model) {

        model.addAttribute(new Room());
        model.addAttribute("rooms", roomDao.findAll());
        model.addAttribute("title", "Edit Rooms");

        return "rooms/index";

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String editRooms(Model model, @ModelAttribute @Valid Room room, Errors errors) {

        if (errors.hasErrors()) {

            model.addAttribute("title", "Edit Rooms");

            return "rooms/index";

        }

        roomDao.save(room);
        return "redirect:";

    }

}
