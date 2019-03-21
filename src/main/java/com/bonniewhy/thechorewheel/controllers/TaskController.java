package com.bonniewhy.thechorewheel.controllers;

import com.bonniewhy.thechorewheel.models.Room;
import com.bonniewhy.thechorewheel.models.Task;
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
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("task")
public class TaskController {

    @Autowired
    TaskDao taskDao;

    @Autowired
    RoomDao roomDao;

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listTasksOverall(Model model) {

        model.addAttribute("tasks", taskDao.findAll());
        model.addAttribute("title", "All Tasks");

        return "tasks/list";

    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addTasks(Model model) {

        model.addAttribute("title", "Add Tasks");
        model.addAttribute(new Task());

        return "tasks/add";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddTasks(Model model, @ModelAttribute @Valid Task task, Errors errors) {

        if (errors.hasErrors()) {

            model.addAttribute("title", "Add Tasks");

            return "tasks/add";

        }

        taskDao.save(task);
        return "redirect:";

    }

    // [ ] TODO: Figure out how to use the DAO to find all tasks with the right room ID. Dig through cheese to figure out the right syntax.
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listTasksByRoom(Model model, @RequestParam int roomId) {

        Room room = roomDao.findOne(roomId);

        model.addAttribute("title", room.getName());
        model.addAttribute("tasks", taskDao.findAll(roomId));

        return "tasks/list";

    }

}
