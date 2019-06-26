package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: hht
 * @Date: 2019/6/25 21:51
 * @Description:
 */
@Controller
public class StudentController {

    @RequestMapping("/student/addStudent")
    public String addStudent(){
        return "/page/addStudent";
    }
    @RequestMapping("/student/updateStudent")
    public String updateStudent(){
        return "/page/updateStudent";
    }
    @RequestMapping("/student/deleteStudent")
    public String deleteStudent(){
        return "/page/deleteStudent";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
