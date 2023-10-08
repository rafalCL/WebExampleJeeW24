package pl.coderslab.webexamplejeew24.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter("/*")
public class SetReqRespUtf8EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("request incoming. setting request encoding.");
        request.setCharacterEncoding("utf-8");
        chain.doFilter(request, response);
        System.out.println("response outgoing. setting response encoding.");
        response.setContentType("text/html;charset=utf-8");
    }
}
