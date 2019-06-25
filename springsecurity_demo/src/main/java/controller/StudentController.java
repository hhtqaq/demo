package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: hht
 * @Date: 2019/6/25 21:51
 * @Description:
 */
@RequestMapping("/student")
@Controller
public class StudentController {

    @RequestMapping("addStudent")
    public String addStudent(){
        return "addStudent";
    }
    @RequestMapping("updateStudent")
    public String updateStudent(){
        return "updateStudent";
    }
    @RequestMapping("deleteStudent")
    public String deleteStudent(){
        return "deleteStudent";
    }
}
