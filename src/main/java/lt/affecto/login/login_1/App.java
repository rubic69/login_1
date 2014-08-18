package lt.affecto.login.login_1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lt.affecto.login.model.UserHome;

public class App extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("firstname");
		String pass = req.getParameter("password");
		
		UserHome userH = new UserHome();
		
		if (userH.exist(user, pass)) {
			//response(resp, "login ok");
			resp.sendRedirect("result_good.html");
		} else {
			//response(resp, "invalid login");
			resp.sendRedirect("result.html");
		}
	}
	
	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String name = req.getParameter("name");
	        String pass = req.getParameter("pass");
	        UserHome userDao = new UserHome();
	        if (userDao.exist(name, pass)) {
	            resp.sendRedirect("result_good.html");
	        }
	        else {
	            resp.sendRedirect("result.html");
	        }
	    }
	
	/*private void response(HttpServletResponse resp, String msg) throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + msg + "</t1>");
		out.println("</body>");
		out.println("</html>");
	}*/
	
	/*public void init() throws ServletException {
        UserHome userH = new UserHome();
        User user = new User();

        userH.exist("Karolis", "suo1");

    }*/
	
    public static void main( String[] args ) throws Exception 
    {
	//TODO
    	/*Session session = null;
    	Query query = session.createQuery("from Users");
    	
    	
    	
    	
    	
    	
    	String input_name = "Karolis";
    	String input_pass = "suo1";
    	System.out.println("Username: " + input_name + " | Password: " + input_pass +"\n");
    	boolean user_exist = false;
    	
    	String url = "jdbc:sqlite:C:/apache-tomcat-7.0.54/dbs/users.db";
    	try {
    		Class.forName("org.sqlite.JDBC");
    		Connection connect = DriverManager.getConnection(url);
    		if (connect != null) {
    			//System.out.println("Connected to database");
    			Statement statement = connect.createStatement();
    			ResultSet rs = statement.executeQuery("SELECT name, pass FROM user");
    			while(rs.next()) {
    				if (rs.getString("name").equals(input_name)) {
    					user_exist = true;
    					//System.out.println("name = " + rs.getString("name"));
    					System.out.println("User with username '" + input_name + "' exist!");
    					if (rs.getString("pass").equals(input_pass)) {
    						//System.out.println("pass = " + rs.getString("pass"));
    						System.out.println("Your password is correct!");
    					}
    					else {
    						System.out.println("This password is incorrect!");
    					}
    				} 
    			}
    		}
    		if (!user_exist){
    			System.out.println("No username: " + input_name);
    		}
    	} catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    	*/
    }
}
