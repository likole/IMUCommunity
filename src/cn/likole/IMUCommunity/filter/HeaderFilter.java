package cn.likole.IMUCommunity.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by likole on 7/27/17.
 */
public class HeaderFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse)resp;

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(request.getServletContext().getRealPath("/WEB-INF/config.properties")), "utf-8");

        Properties properties = new Properties();
        properties.load(inputStreamReader);

        if ("1".equals(properties.getProperty("allow_origin"))) response.setHeader("Access-Control-Allow-Origin", "*");

        if ("0".equals(properties.getProperty("enable_site")) && !(request.getRequestURI().contains("/admin/")||request.getRequestURI().contains("/assets/")))
            request.getRequestDispatcher("/WEB-INF/closed.jsp").forward(request, response);

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
