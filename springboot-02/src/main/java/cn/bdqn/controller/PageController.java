package cn.bdqn.controller;

import cn.bdqn.entity.Good;
import cn.bdqn.service.GoodService;
import cn.bdqn.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    GoodService goodService;

    @Autowired
    PageService pageService;

    @GetMapping("/page/{name}")
    public String getPage(@PathVariable String name){
        return name;
    }

    @GetMapping("/")
    public String getPage(Model model){

        List<Good> goods = goodService.selectAll();
        model.addAttribute("goods",goods);
        return "index";
    }

    @GetMapping("/good/delete/{gid}")
    public String delete(Model model,@PathVariable Integer gid){
        int num =  goodService.delete(gid);
        List<Good> goods = goodService.selectAll();
        model.addAttribute("goods",goods);
        return "index";
    }


    @GetMapping("/good/{gid}")
    public String toItem(@PathVariable Integer gid,Model model) throws FileNotFoundException, UnsupportedEncodingException {

        if (pageService.isExists(gid)){
            return  gid+".html";
        }else{
            Good good = goodService.selectByGid(gid);
            pageService.createHtml(gid,good);
            model.addAttribute("good",good);
            return "item";
        }
    }
}
