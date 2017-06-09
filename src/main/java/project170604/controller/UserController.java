package project170604.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project170604.dao.UserRepository;
import project170604.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by lyp on 2017/6/3.
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;


    @RequestMapping(method = RequestMethod.POST)
    public String save(Model model,@Valid @ModelAttribute(value = "user")SysUser user){

        SysUser saveuser = userRepository.save(new SysUser(user.getUsername(),
                user.getCname(),
                user.getPassword(),
                user.getDept(),
                user.getRole()));

        model.addAttribute("msg","success");

        return "redirect:/user";
    }



    @RequestMapping(method = RequestMethod.GET)
    public String findUsers(Map<String,Object> model){
//        List<SysUser> users = userRepository.findAll();

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        SysUser user = userRepository.findByUsername(userDetails.getUsername());
        String dept = user.getDept();
        List<SysUser> users = userRepository.findAllByDeptLike(dept);
        model.put("users",users);
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
