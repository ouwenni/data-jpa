package project170604.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import project170604.dao.UserRepository;
import project170604.domain.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import project170604.domain.SysUser;

/**
 * Created by lyp on 2017/6/4.
 */

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String index(Model model){

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        SysUser user = userRepository.findByUsername(userDetails.getUsername());

        //Msg msg = new Msg(userDetails.getUsername(),"test content");
        Msg msg = new Msg(user.getUsername(),user.getCname(),user.getDept());
        model.addAttribute("msg",msg);
        return "home";

    }
}
