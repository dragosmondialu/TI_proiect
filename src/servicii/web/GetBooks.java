       package servicii.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.net.URI;
import java.util.List;
import java.lang.reflect.Type;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import com.google.gson.reflect.TypeToken;

import org.glassfish.jersey.client.ClientConfig;

import com.google.gson.Gson;

@WebServlet("/GetBooks")
public class GetBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public GetBooks() {
        super();
    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(response) {
            private final StringWriter sw = new StringWriter();
           
            @Override
            public PrintWriter getWriter() throws IOException {
                return new PrintWriter(sw);
            }

            @Override
            public String toString() {
                return sw.toString();
            }
        };
        request.getRequestDispatcher("menu.jsp").include(request, responseWrapper);
        String content = responseWrapper.toString();
           
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);

		WebTarget target = client.target(getBaseURI());

		Gson gson = new Gson();
		String json = target.path("rest").path("hello/1").request()
			.accept(MediaType.TEXT_PLAIN).get(String.class);
		Type type = new TypeToken<List<Carte>>(){}.getType();
		List<Carte> bookList = gson.fromJson(json, type);
		response.setContentType("text/html");
	    response.setCharacterEncoding("utf-8");
	    PrintWriter pw = response.getWriter();
	    
	    pw.append("<html><head>");
	    pw.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/style.css\">");
	    pw.append("</head>");
	    pw.append("<body style='background-image:url(\"./images/4.png')\">");	    
	    pw.append("<script>");
	    pw.append("function redirect(elem){elem.setAttribute('action','addBook.jsp'); elem.submit();}");
	    pw.append("</script>");
	    pw.append("<header>");
	    pw.append(content);
	    pw.append("<header>");
	    pw.append("<h1>CĂRȚI</h1>");
	    //pw.append("<table align='center'style='color:black;background:#ffdd99;border:1px solid black;'>");
	    pw.append("<table id='tabel'>");
	    pw.append("<form method='get' action='DeleteBookServlet'");
	    pw.append("<tr style='border:1px solid black;'>");
	    pw.append("<th>ID</th>");
	    pw.append("<th>ISBN</th>");
	    pw.append("<th>Titlu</th>");
	    pw.append("<th>Autor</th>");
	    pw.append("<th>Gen</th>");
	    pw.append("<th>Disponibilitate</th></tr>");
	    pw.append("<th></th>");
	    
	    for(Carte carte : bookList)
	    {
	    	pw.append("<tr>");
	    	pw.append("<td>");
	    	pw.append(String.valueOf(carte.getId()));
	    	pw.append("</td>");
	    	pw.append("<td>");
	    	pw.append(String.valueOf(carte.getIsbn()));
	    	pw.append("</td>");
	    	pw.append("<td>");
	    	pw.append(carte.getTitlu());
	    	pw.append("</td>");
	    	pw.append("<td>");
	    	pw.append(carte.getAutor());
	    	pw.append("</td>");
	    	pw.append("<td>");
	    	pw.append(carte.getGen());
	    	pw.append("</td>");
	    	pw.append("<td>");
	    	pw.append(String.valueOf(carte.getDisponibilitate()));
	    	pw.append("</td>");
	    	pw.append("<td >");
	    	pw.append("<input type='submit' value='Șterge carte'>");
	    	pw.append("<input type='hidden' name='isbn' value='"+carte.getIsbn()+"'/>");
	    	//pw.append("<input type='button' name='delete' value='Delete' onclick='deleteRecord("+carte.getIsbn()+")';");
	    	pw.append("</td>");
		    pw.append("</tr>");
	    }
	    pw.append("</form>");
	    pw.append("</table>");
	    pw.append("<form id='add' method='post' action='' onsubmit='redirect(this)'>");
	    pw.append("<input type='submit' name='submit' value='Adaugă carte' id='addButton'>");
	    pw.append("</form>");
	    pw.append("</body>");
	    pw.append("</html>");
	}
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:1234/Proiect").build();
	}
}