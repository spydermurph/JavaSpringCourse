package is.webworks.SpringBootWeb1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @ModelAttribute("course")
    public String courseName(){
        return "Java";
    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("addAlien")
    public String addAlien(@ModelAttribute("alien") Alien alien) {

        return "result";
    }

    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("num1") int number, @RequestParam int num2, ModelAndView mv) {
        int result = number + num2;

        mv.addObject("result", result);
        mv.setViewName("result");

        return mv;
    }

//    @RequestMapping("/add")
//    public String add(HttpServletRequest request, HttpSession session) {
//        int num1 = Integer.parseInt(request.getParameter("num1"));
//        int num2 = Integer.parseInt(request.getParameter("num2"));
//        int result = num1 + num2;
//
//        session.setAttribute("result", result);
//
//        return "result.jsp";
//    }

//    @RequestMapping("/add")
//    public String add(@RequestParam("num1") int number, @RequestParam int num2, Model model) {
//        int result = number + num2;
//
//        model.addAttribute("result", result);
//
//        /* til að stilla af hvar skráin er og af hvaða tegund er hægt að finna upplýsingar á
//            Common Application Properties https://docs.spring.io/spring-boot/docs/2.7.0/reference/html/application-properties.html
//         */
//        return "result";
//    }
}
