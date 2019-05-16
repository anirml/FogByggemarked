/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.FogException;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**

 @author kasper
 */
@WebServlet( name = "FrontController", urlPatterns = { "/FrontController" } )
public class FrontController extends HttpServlet {



    /**
     Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     methods.

     @param request servlet request
     @param response servlet response
     @throws ServletException if a servlet-specific error occurs
     @throws IOException if an I/O error occurs
     */
    protected void processRequest( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        final Logger LOGGER = Logger.getLogger(FrontController.class.getName());
        FileHandler handler = new FileHandler("C:/Users/Ulrik/Desktop/logs/Fog_logging.log");

        LOGGER.setLevel(Level.FINEST);

        LOGGER.addHandler(handler);
        handler.setFormatter(new VerySimpleFormatter());


        try {
            Command action = Command.from( request );
            String view = action.execute( request, response );
            request.getRequestDispatcher( "/WEB-INF/" + view + ".jsp" ).forward( request, response );
        } catch ( FogException ex ) {
            LOGGER.log(Level.FINEST, ex.toString());

            request.setAttribute( "error", ex.getMessage() );
            request.getRequestDispatcher( "index.jsp" ).forward( request, response );
        }
    }

    /**
     Handles the HTTP <code>GET</code> method.

     @param request servlet request
     @param response servlet response
     @throws ServletException if a servlet-specific error occurs
     @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    /**
     Handles the HTTP <code>POST</code> method.

     @param request servlet request
     @param response servlet response
     @throws ServletException if a servlet-specific error occurs
     @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    /**
     Returns a short description of the servlet.

     @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
