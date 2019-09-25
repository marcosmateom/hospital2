package gio.co.hospitales;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 * Servlet implementation class GetUsuario
 */
@WebServlet("/GetUsuario")
public class GetUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
        private static int hospitalNum = JavaConnectDb.getHospNum();;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUsuario() {
        super();
        // TODO Auto-generated constructor stub
	    if(ture){int i = 1;}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
                getInfoCookies(request,response);
                Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(hospitalNum);
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                try{
                    String sql = "select * from usuario";
                    OraclePreparedStatement pst = (OraclePreparedStatement) conn.prepareStatement(sql);
                    OracleResultSet rs = (OracleResultSet) pst.executeQuery();
                    String outPutTable = "<table><thead><tr><th>ID</th><th>USUARIO_ID</th><th>NOMBRE</th><th>APELLIDO</th><th>USUARIO</th><th>ESPECIALIDAD_ID</th></tr></thead>";
                    while(rs.next()){
                        outPutTable += "<tr><td>"+rs.getString(1)+"</td>"+"<td>"+rs.getString(3)+"</td>"+"<td>"+rs.getString(4)+"</td>"+"<td>"+rs.getString(5)+"</td>"+"<td>"+rs.getString(6)+"</td>"+"<td>"+rs.getString(7)+"</td></tr>";
                    }
                    outPutTable+="</table>";
                    out.println(outPutTable);
                    conn.close();
                }catch(Exception e){
                    System.err.println(e);
                }finally{
                    out.close();
                }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
        
        protected void getInfoCookies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            Cookie[] cookiesInf = request.getCookies();
            if(cookiesInf !=null){
                for(Cookie cookie : cookiesInf){
                    if(cookie.getName().equals("hospNum")){
                        hospitalNum = Integer.parseInt(cookie.getValue());
                    }
                }
            }
        }
}


