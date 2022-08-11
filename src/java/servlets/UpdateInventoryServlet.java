
package servlets;

import business.Inventory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 */
public class UpdateInventoryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String sql = "", msg = "", sOnHand = "", bookID = "";
        String URL = "/UpdateInventory.jsp";
        int onhand = 0, storeID = 0;
        Inventory inv = null;
        
        try {
             sOnHand = request.getParameter("onhand");
             if (sOnHand.isEmpty()) {
                 msg = "Inventory On Hand field can not be empty.<br>";
             } else {
                 onhand = Integer.parseInt(sOnHand);
                 if (onhand < 0) {
                    msg += "Inventory OnHand can not be negative.<br>"; 
                 }
             }    
        } catch (Exception e) {
             msg += "Inventory OnHand field error.<br>";
        }
        
        if (msg.isEmpty()) {
            try {
                
                inv = (Inventory) request.getSession().getAttribute("inv");
                
                //db connection data elements
                String dbURL = "jdbc:mysql://localhost:3306/henrybooks_is294";
                String dbUser = "root";
                String dbPwd = "sesame";
            
                Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
                Statement s = conn.createStatement();
            
                sql = "UPDATE bookinv SET onhand = " + onhand + 
                      " WHERE storeID = " + inv.getStoreID() + 
                      " AND bookID = '" + inv.getBookID() +"'";
              
               int rc = s.executeUpdate(sql);
               if (rc == 0) {
                   msg += "Error: no inventory records updated <br>";
               } else if (rc == 1) {
                   msg += "Inventory Updated! <br>";
                   URL = "/StoreSelection.jsp";
               } else {
                   msg += "Warning: " + rc + " records updated.<br>";
               }
            } catch (SQLException e) {
               msg += "SQL Error: " + e.getMessage() + " " + sql + "<br>";
            } catch (Exception e) {
               msg += "General error: " + e.getMessage() + "<br>";   
            }
        }        
       
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
