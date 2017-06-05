package project170604.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import project170604.dao.UserRepository;
import project170604.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lyp on 2017/6/3.
 */

@Controller
@RequestMapping("/user")
public class DataController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/save")
    public String save(Model model, @ModelAttribute(value = "user")User user){

        User saveuser = userRepository.save(new User(user.getUsername(),
                user.getCname(),
                user.getPassword(),
                user.getDept()));

        model.addAttribute("msg","success");

        return "user";
    }

    /*

    @RequestMapping("user")
    public User findUser(String username){
        User user = userRepository.findByUsername(username);
        return user;
    }

    @RequestMapping(params = "page")
    public Page<User> page(){
        Page<User> userPage = userRepository.findAll(new PageRequest(1,2));
        return userPage;
    }

    @RequestMapping
    public void nu(){

    }*/



}
