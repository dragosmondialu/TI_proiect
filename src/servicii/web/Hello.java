package servicii.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

// adnotarea Path specifica calea relativa spre un anumit serviciu web
// e.g., @ApplicationPath("rest") + @Path("/hello") => http://localhost:8080/ProiectServiciiWeb/rest/hello
// in aceasta situatie se va apela una din metodele clasei Hello, in functie de tipul media (text/plain, text/xml sau text/html)
@Path("/hello")
public class Hello {

	
	
	
	// Metoda apelata daca tipul media cerut este TEXT_PLAIN
	@GET
	@Path("/1")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		Gson gson = new Gson();
		List<Carte> obj = DBManager.getInstance().getBookList();
		String json = gson.toJson(obj);
		return json;
	}

	@POST
	@Path("/2")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean addBook(@FormParam("id") int id, @FormParam("isbn") String isbn, @FormParam("titlu") String titlu, @FormParam("autor") String autor, @FormParam("gen") String gen, @FormParam("disponibilitate") String disponibilitate, @Context HttpServletResponse servletResponse)
			throws IOException {
	  boolean result = DBManager.getInstance().addBook(id, isbn, titlu, autor, gen, disponibilitate);
	  if(result){
	     return result;
	  }
	  return result;
	}
	
	@GET    
	@Path("/3/{isbn}")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean deleteBook(@PathParam("isbn") String isbn)
			throws IOException {
	  boolean result = DBManager.getInstance().deleteBook(isbn);
	  if(result){
	     return result;
	  }
	  return result;
	}
	
	/*
	// Metoda apelata daca tipul media cerut este XML
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	}

	// Metoda apelata daca tipul media cerut este HTML
	 
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>" + "<body><h1>" + "Hello Jersey" + "</h1>" + DBManager.getInstance().getBookList().toString() + "</body>" + "</html> ";
	}
	*/
}