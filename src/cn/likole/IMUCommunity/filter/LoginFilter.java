package cn.likole.IMUCommunity.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by likole on 7/31/17.
 */
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if(req.getRequestURI().endsWith("/admin/login"))
        {
            chain.doFilter(request,response);
            return;
        }

        HttpSession session = req.getSession(true);

        String login = (String) session.getAttribute("login");

        if ("login".equals(login)) {
            chain.doFilter(request,response);
        }
        else {
            res.sendRedirect("http://"+req.getHeader("Host")+"/admin/login");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
