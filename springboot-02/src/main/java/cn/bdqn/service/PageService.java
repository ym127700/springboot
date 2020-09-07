package cn.bdqn.service;

import cn.bdqn.entity.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@Service
public class PageService {

    @Value("${html.path}")
    String htmlpath;

    @Autowired
    TemplateEngine templateEngine;

    public boolean isExists(Integer gid){
        File file = new File(htmlpath+gid+".html");
        return file.exists();
    }

    public void createHtml(Integer gid, Good good) throws FileNotFoundException, UnsupportedEncodingException {
        File path = new File(htmlpath);
        if (!path.exists()){
            path.mkdirs();
        }

        //准备数据  放到上下文
        Context context = new Context();
        context.setVariable("good",good);

        //准备创建的文件
        File html = new File(htmlpath+gid+".html");
        PrintWriter writer = new PrintWriter(html,"utf-8");

        //生成静态的html页面
        templateEngine.process("item",context,writer);

    }
}
