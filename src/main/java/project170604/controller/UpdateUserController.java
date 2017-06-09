package project170604.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project170604.dao.UserRepository;
import project170604.domain.SysUser;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by lyp on 2017/6/7.
 */

@Controller
@RequestMapping("/updateuser")
public class UpdateUserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String search(Model model, @Valid @ModelAttribute(value = "user")SysUser user){

        SysUser fuser = userRepository.findByUsername(user.getUsername());

        if(fuser != null){
            model.addAttribute("username",fuser.getUsername());
            model.addAttribute("password",fuser.getPassword());
            model.addAttribute("cname",fuser.getCname());
            model.addAttribute("dept",fuser.getDept());
        }else{
            model.addAttribute("alertclass","alert alert-danger");
            model.addAttribute("alerttext","未查找到用户！");
        }
        return "updateuser";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(Model model,@ModelAttribute(value = "user")SysUser user){

        SysUser fuser = userRepository.findByUsername(user.getUsername());
        int id = fuser.getId();

        userRepository.updateById(user.getUsername(),user.getCname(),user.getPassword(),user.getDept(),id);

        model.addAttribute("username",user.getUsername());
        model.addAttribute("password",user.getPassword());
        model.addAttribute("cname",user.getCname());
        model.addAttribute("dept",user.getDept());

        model.addAttribute("alertclass","alert alert-success");
        model.addAttribute("alerttext","变更成功！");

        return "updateuser";
    }

    @RequestMapping(value = "/delete" ,method = RequestMethod.POST)
    public String delete(Model model,@ModelAttribute(value = "user")SysUser user){

        userRepository.deleteSysUserByUsername(user.getUsername());

        model.addAttribute("alertclass","alert alert-success");
        model.addAttribute("alerttext","删除成功！");

        return "updateuser";
    }




    @RequestMapping(method = RequestMethod.GET)
    public String get(Map<String,Object> model){
     //   model.put("fuser",new SysUser());
        return "updateuser";
    }

}
