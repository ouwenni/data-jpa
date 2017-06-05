package project170604.controller;

import project170604.domain.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lyp on 2017/6/4.
 */

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model){

        Msg msg = new Msg("test title","test content","test etraInfo");
        model.addAttribute("msg",msg);
        return "home";

    }
}
