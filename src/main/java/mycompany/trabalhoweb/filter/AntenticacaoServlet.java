
package mycompany.trabalhoweb.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns={"/*"})
public class AntenticacaoServlet implements Filter {

 
    public AntenticacaoServlet() {
    }    
    
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
    
               HttpServletRequest req = (HttpServletRequest) request;
        if (!"/TrabalhoWeb-1.0/faces/login.xhtml".equals(req.getRequestURI()) 
                && req.getSession(true).getAttribute("usuario") == null) {
            request.setAttribute("erro", "Favor realizar login para continuar.");
            RequestDispatcher rd = request.getRequestDispatcher("/TrabalhoWeb-1.0/faces/login.xhtml");
            rd.forward(request,response);
        }
        
        chain.doFilter(request, response);
    }
    

}
  


