package project170604.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project170604.dao.NsrRepository;
import project170604.dao.UserRepository;
import project170604.domain.Nsrxx;
import project170604.domain.SysUser;

import java.util.Date;

/**
 * Created by lyp on 2017/6/7.
 */

@Controller
@RequestMapping("/updatensrxx")
public class UpdateNsrxxController {
    @Autowired
    private NsrRepository nsrRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String search(Model model, @ModelAttribute("nsrxx")Nsrxx nsrxx, BindingResult bindingResult){

        Nsrxx fnsrxx = nsrRepository.findByNsrsbh(nsrxx.getNsrsbh());

        if(fnsrxx != null){
            model.addAttribute("nsrsbh",fnsrxx.getNsrsbh());
            model.addAttribute("nsrmc",fnsrxx.getNsrmc());
            model.addAttribute("dept",fnsrxx.getDept());
            model.addAttribute("sfwj",fnsrxx.getSfwj());
        }else{
            model.addAttribute("alertclass","alert alert-danger");
            model.addAttribute("alerttext","未查找到该纳税人信息");
        }

        return "updatensrxx";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("nsrxx")Nsrxx nsrxx){

        Date date = new Date();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SysUser user = userRepository.findByUsername(userDetails.getUsername());
        String lrr = user.getCname();

        nsrxx.setLrrq(date);
        nsrxx.setLrr(lrr);

        nsrRepository.deleteByNsrsbh(nsrxx.getNsrsbh());

        nsrRepository.save(nsrxx);


        model.addAttribute("alertclass","alert alert-success");
        model.addAttribute("alerttext","变更成功！");

        return "updatensrxx";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String updatensrxx(){
        return "updatensrxx";
    }
}
