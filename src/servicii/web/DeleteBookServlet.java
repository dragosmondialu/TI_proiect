package servicii.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public DeleteBookServlet() {
        super();
    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		
		MultivaluedMap<String, String> formParams = new MultivaluedHashMap();
		formParams.putSingle("isbn", request.getParameter("isbn"));

		WebTarget target = client.target(getBaseURI());
		Boolean ok = target.path("rest").path("hello/3").path(request.getParameter("isbn")).request()
				.accept(MediaType.TEXT_PLAIN).get(Boolean.class);

        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        if(ok){  
            /*RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
            rd.forward(request,response);*/
        	response.sendRedirect("index.jsp");
        }  
        else{  
            out.print("<p style=\"color:red\">Eroare la Č�tergerea cÄ�rČ›ii.</p>");  
            RequestDispatcher rd=request.getRequestDispatcher("GetBooks");  
            rd.include(request,response);
        }  

        out.close();  
    }  
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:1234/Proiect").build();
	}
}
