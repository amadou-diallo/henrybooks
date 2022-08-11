
package servlets;

import business.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 */
public class ViewInventoryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String sql = "", msg = "";
        String URL = "/ViewInventory.jsp";
        int storeid = 0;
        Store st = null;
        Inventory inv = null;
               
        try {
            storeid = Integer.parseInt(request.getParameter("storeid"));

            String dbURL = "jdbc:mysql://localhost:3306/henrybooks_is294";
            String dbUser = "root";
            String dbPwd = "sesame";
            
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
            Statement s = conn.createStatement();
            
            sql = "SELECT * FROM stores WHERE StoreID = " + storeid;
            
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                   st = new Store();
                   st.setStoreID(r.getInt("StoreID"));
                   st.setStoreName(r.getString("StoreName"));
                   st.setStoreAddr(r.getString("StoreAddr"));
                   st.setStoreEmp(r.getInt("StoreEmp"));
            }
            ArrayList<Inventory> inventory = new ArrayList<Inventory>();
                
            sql = "SELECT bookinv.storeID, bookinv.bookID, title, author, price, OnHand " +
                  "FROM bookinv, booklist " +
                  "WHERE bookinv.bookID = booklist.bookID " +
                  "AND bookinv.storeID = " + storeid +
                  " ORDER BY bookinv.bookID";
                
            ResultSet rs = s.executeQuery(sql);
                
            while (rs.next()) {
                  inv = new Inventory();
                  inv.setStoreID(rs.getInt("storeID"));
                  inv.setBookID(rs.getString("bookID"));
                  inv.setTitle(rs.getString("title"));
                  inv.setAuthor(rs.getString("author"));
                  inv.setPrice(rs.getDouble("price"));
                  inv.setOnHand(rs.getInt("OnHand"));
                  inventory.add(inv);
            }
            request.getSession().setAttribute("inventory", inventory);
                            
        } catch (SQLException e) {
            msg = "SQL Error: " + e.getMessage() + "<br>";
        } catch (Exception e) {
            msg = "General Error: " + e.getMessage() + "<br>";
        }
            
        request.getSession().setAttribute("store", st);
        request.setAttribute("msg", msg);
        
        RequestDispatcher disp = getServletContext().getRequestDispatcher(URL);
        disp.forward(request, response);
    }
            
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
