package demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName:Controller
 * Package:demo
 * Description:
 *
 * @date:2019-11-30 15:04
 * @author:892698613@qq.com
 */

@Controller
@RequestMapping("/test")
public class MyController {


    @RequestMapping(value = "/hello",method={RequestMethod.GET,RequestMethod.POST},params = {"name","age"})
    public ModelAndView test(@RequestParam("name")String nameStr){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("msg","hello annotation");

        modelAndView.setViewName("show");

        return modelAndView;
    }

}
