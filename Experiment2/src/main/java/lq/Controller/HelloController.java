package lq.Controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lq.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;


@Controller
public class HelloController {
    @RequestMapping("/hello")
    public void hello(){
        System.out.println("此方法跳转到templates/hello.html页面");
    }

    @RequestMapping("/aaa")
    public String testAAA(){
        return "aaa";
    }
    @RequestMapping("/bbb")
    public String testBBB(){
    //将请求重定向到/hello，重定向是将当前请求重定向的url告诉客户端，客户端重新向重定向的地址发送请求，相当于发生了两次请求
        return "redirect:/hello";
    }
    @RequestMapping("/ccc")
    public String testccc(){//将请求转发到/aaa，转发是将当前请求转发到一个新的url，对客户端来说相当于一次请求，而且转发时request对象不变，其中携带的参数也可以传递给新的请求，转发一般只在同一个应用之间，重定向可以转发到其他应用站点
        return "forward:/aaa";
    }

    @RequestMapping("/ddd")
    public String testDDD(HttpServletRequest request, HttpSession session, Model model){
        ServletContext context = session.getServletContext();
        //测试携带参数优先级
//        request.setAttribute("username","request设置的username");
//        model.addAttribute("username","model设置的username");
//        session.setAttribute("username","session设置的username");
//        context.setAttribute("username","context设置的username");
        User user = new User();
        user.setUsername("zhagnsan");
        user.setPassword("12345");
        user.setAge(19);
        model.addAttribute("user",user);
        return "ddd";
    }

    @RequestMapping("/eee")
    public String testEEE(){
        return "eee";
    }

    @RequestMapping("/fff")
    public ModelAndView testFFF(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("username","zhangsan");
        mv.setViewName("fff");
        return mv;
    }

    @RequestMapping("/ggg")
    public void testGGG(HttpServletResponse response){
        try {
            response.getWriter().println("response");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/userInfo")
    @ResponseBody
    public User userInfo(){
        User user = new User();
        user.setId(1l);
        user.setUsername("zhangsan");
        user.setPassword("123");
        user.setEmail("zhangsan@xcu.edu.cn");
        user.setAge(19);
        return user;
    }
}
