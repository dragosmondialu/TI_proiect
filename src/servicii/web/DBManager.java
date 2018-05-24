package servicii.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
	private static final String URL = "jdbc:mysql://localhost:3306/demo";
	private static final String USERNAME = "student";
	private static final String PASSWORD = "student";
	private static final DBManager instance = new DBManager();
	private Connection conn;
	public static DBManager getInstance() {
		return instance;
	}
	private DBManager() {
		System.out.println("Loading driver...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"Cannot find the driver in the classpath!", e);
		}
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Carte> getBookList() {
		try (Statement st = conn.createStatement()) {
			List<Carte> bookList = new ArrayList<Carte>();
			st.execute("select * from carti");
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				Carte book = new Carte(rs.getInt("id"), rs.getString("isbn"), rs.getString("titlu"),
					rs.getString("autor"), rs.getString("gen"),
					rs.getBoolean("disponibilitate"));
				bookList.add(book);
			}
			// st.close();
			return bookList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean addBook(int id, String isbn, String titlu, String autor, String gen, String disponibilitate){
		boolean status = false;
		String query = "insert into carti"
				+ "(ID, isbn, titlu, autor, gen, disponibilitate) values"
				+ "(?,?,?,?,?,?)";  
        PreparedStatement pst = null;
        try (Statement st = conn.createStatement()) {
        	pst = conn.prepareStatement(query);
        	pst.setInt(1, id);
            pst.setString(2, isbn);
            pst.setString(3, titlu);
            pst.setString(4, autor);
            pst.setString(5, gen);
            if(disponibilitate=="true")
            	pst.setBoolean(6, true);
            else
            	pst.setBoolean(6, false);
            pst.executeUpdate();
            status = true;
        }
        catch (Exception e) {
        	System.out.println(e);
        }/*finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }*/
        return status;
	   }
	
	public boolean validate(String email, String parola) {        
		boolean status = false;
        ResultSet rs = null;
        PreparedStatement pst = null;
        try (Statement st = conn.createStatement()) {
        	pst = conn.prepareStatement("select * from utilizatori where email=? and parola=?");
        	pst.setString(1, email);
            pst.setString(2, parola);
            rs = pst.executeQuery();
            status = rs.next();
        }
        catch (Exception e) {
        	System.out.println(e);
        }/*finally {
            if (conn != null) {
                try {
                    conn.close();
               } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }*/
        return status;
        }
	
	public boolean deleteBook(String isbn){
		boolean status = false;
		String query = "delete from carti where isbn=?";
        PreparedStatement pst = null;
        try (Statement st = conn.createStatement()) {
        	pst = conn.prepareStatement(query);
        	pst.setString(1, isbn);
            pst.executeUpdate();
            status = true;
        }
        catch (Exception e) {
        	System.out.println(e);
        }/*finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }*/
        return status;
	   }
	
	
	
	
	}

