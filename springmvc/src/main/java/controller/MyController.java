package controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * ClassName:MyController
 * Package:controller
 * Description:
 *
 * @date:2019-11-30 13:27
 * @author:892698613@qq.com
 */
public class MyController implements Controller {

    /**
     * @return  modelAndView:model包含数据,map结构;View负责显示数据,mvc中的view
     */
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv=new ModelAndView();

        //把数据放到request作用域,等同于request.setAttribute
        mv.addObject("msg","helloSpringmvc");


        //指定视图
        //等同于request.getRequestDispatcher("/show.jsp").forward(req,resp)
        mv.setViewName("show");

        return mv;
    }
}
