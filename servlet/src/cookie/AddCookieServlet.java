package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addCookie")
public class AddCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie=new Cookie("name","liuhongchen");
        //设置过期时间为60s
        cookie.setMaxAge(60);
        //设置跨域共享，例如本网站为a.liuhongchen.com,做了如下设置后，b.liuhongchen.com也能读取到该cookie
        cookie.setDomain("b.liuhongchen.com");
        //安全性设置，设置为true的时候，js脚本将无法读取到Cookie信息，能有效防止XSS攻击
        cookie.setHttpOnly(true);
        //只有访问这个uri时才会带cookie到请求头
        cookie.setPath("/getCookie");

        resp.addCookie(cookie);
        resp.getWriter().write("add cookie servlet");
    }
}
