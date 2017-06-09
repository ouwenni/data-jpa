package project170604.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project170604.dao.NsrRepository;
import project170604.dao.UserRepository;
import project170604.domain.Nsrxx;
import project170604.domain.SysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by lyp on 2017/6/6.
 */

@Controller
@RequestMapping("/nsrxx")
public class NsrController {

    @Autowired
    NsrRepository nsrRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String findbydept(Map<String,Object> model){

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        SysUser user = userRepository.findByUsername(userDetails.getUsername());
        String dept = user.getDept();
        List<Nsrxx> nsrxxes = nsrRepository.findByDept(dept);

        model.put("nsrxxes",nsrxxes);

        return "nsrxx";

    }


}
