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
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public AddBookServlet() {
        super();
    }
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);

		
		
		MultivaluedMap<String, String> formParams = new MultivaluedHashMap();
		formParams.putSingle("id", request.getParameter("id"));
		formParams.putSingle("isbn", request.getParameter("isbn"));
		formParams.putSingle("titlu", request.getParameter("titlu"));
		formParams.putSingle("autor", request.getParameter("autor"));
		formParams.putSingle("gen", request.getParameter("gen"));
		formParams.putSingle("disponibilitate", request.getParameter("disponibilitate"));
		

		WebTarget target = client.target(getBaseURI());
		Boolean ok = target.path("rest").path("hello/2").request()
				.accept(MediaType.TEXT_PLAIN).post(Entity.form(formParams), Boolean.class);

        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        if(ok){  
            /*RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
            rd.forward(request,response);*/
        	response.sendRedirect("addBook.jsp");
        }  
        else{  
            out.print("<p style=\"color:red\">Eroare la adaugarea cartii.</p>");  
            RequestDispatcher rd=request.getRequestDispatcher("addBook.jsp");  
            rd.include(request,response);
        }  

        out.close();  
    }  
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:1234/Proiect").build();
	}
}
