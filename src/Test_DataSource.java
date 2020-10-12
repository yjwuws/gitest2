import java.io.*;
import java.sql.*;

import javax.naming.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;

@WebServlet("/Test_DataSource")
public class Test_DataSource extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = res.getWriter();

		try {
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/G2DB");
			if (ds != null) {
				Connection con = ds.getConnection();

				if (con != null) {
					out.println("Got Connection: " + con.toString());
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from TENANT");
					while (rs.next()) {
						out.println("tnt_no = " + rs.getString(1));
					}
					con.close();
				}
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
