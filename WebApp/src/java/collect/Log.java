/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collect;

import ent.Regdata;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import session.RegdataFacade;

/**
 *
 * @author Teo
 */
@Named
@RequestScoped
public class Log extends HttpServlet{
    @EJB 
    private RegdataFacade uf;
    int  check;
    protected void doPost(HttpServletRequest req,HttpServletResponse res ) throws IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        res.setContentType("index.html");
        
        try{
        check = uf.Validate(email, pass);
        
        if(check == 1){
             res.sendRedirect("welcome.html");
        }
         if(check == 0){
              res.getWriter().println("Invalid email");
        }
         
         if(check == 2){
              res.getWriter().println("Invalid password");
        }
        else {
              res.getWriter().println("Login Error.Please try again");
        }
            
        }
        catch(Exception e){
           
       }
           
           
    }
}
