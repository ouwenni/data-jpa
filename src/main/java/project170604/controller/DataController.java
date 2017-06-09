package project170604.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import project170604.dao.NsrRepository;
import project170604.dao.NsrxxQueryService;
import project170604.domain.Nsrxx;

import java.util.List;

/**
 * Created by lyp on 2017/6/8.
 */

@Controller
@RequestMapping("/data")
public class DataController {
    @Autowired
    NsrRepository nsrRepository;

    @Autowired
    NsrxxQueryService nsrxxQueryService;

    @RequestMapping(method = RequestMethod.GET)
    public String data(Model model, @RequestParam(value = "page",defaultValue = "0")int page,
                       @RequestParam(value = "size",defaultValue = "10")int size){

        Page<Nsrxx> nsrxxes = nsrxxQueryService.findNsrxxNoCriteria(page,size);

        model.addAttribute("datas",nsrxxes);

        return "datapage";
    }

    /*

    @RequestMapping(method = RequestMethod.GET)
    public String data(Model model){

        List<Nsrxx> nsrxxes = nsrRepository.findAll();

        model.addAttribute("nsrxxes",nsrxxes);

        return "data";
    }

    */
}
