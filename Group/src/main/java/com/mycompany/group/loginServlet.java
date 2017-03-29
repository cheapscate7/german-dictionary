package com.mycompany.group;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
Title: Login Servlet
Authors: Miroslaw Pasko eeu258, Chris Owen eeu282, Matthew Badcock eeu247
Version: 1.0
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        /*
        //correct user and password flags
        boolean usernameCorrect = false;
        boolean passwordCorrect = false;
        */
        
        
        //inputted username and password
        String n=request.getParameter("username");  
        String p=request.getParameter("password"); 
        boolean match = false;
        
        
        XMLGetter xget = new XMLGetter();
        ArrayList userInfo = xget.getUser(n);
        
        if(userInfo.get(1).toString().equals(p)){
            match = true;
        }
        
        
        
        String Privilage = userInfo.get(2).toString();
        
        if(!match)
            makeErrorPage("Error", response, request);
        else
        {
            switch (Privilage)
            {
                case "admin":
                    makeAdminWelcomePage(n, response, request);
                case "instructor":
                    makeTeacherWelcomePage(n, response, request);
                case "student":
                    makeStudentWelcomePage(n, response, request);
             }
        }
        session.setAttribute("Uname", n);
    }
    
    /**
     * Outputs printlines for creating Admin welcome page to the browser
     * @param name
     * @param response
     * @param request
     * @throws IOException
     */
    public void makeAdminWelcomePage(String name, HttpServletResponse response, HttpServletRequest request) throws IOException{
         try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>welcome "+name+"</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>welcome "+name+"</h1>");
            out.println("<input type=\"submit\" value=\"Add user\" onclick=\"location.href='/Group/addUser.html'\">");
            out.println("<input type=\"submit\" value=\"Delete user\" onclick=\"location.href='/Group/deleteUser.html'\">");
            out.println("<input type=\"submit\" value=\"Modify user\" onclick=\"location.href='/Group/modifyUser.html'\">");
            out.println("<input type=\"submit\" value=\"View user history\" onclick=\"location.href='/Group/testHistory.html'\">");
            out.println("</body>");
            out.println("</html>");
            
            out.close();
        }
    }
    
    /**
     * Outputs printlines for creating Instructor welcome page to the browser
     * @param name
     * @param response
     * @param request
     * @throws IOException
     */
    public void makeTeacherWelcomePage(String name, HttpServletResponse response, HttpServletRequest request) throws IOException{
         try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>welcome "+name+"</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>welcome "+name+"</h1>");
            out.println("<input type=\"submit\" value=\"Add word\" onclick=\"location.href='/Group/addWord.html'\">");
            out.println("<input type=\"submit\" value=\"Delete word\" onclick=\"location.href='/Group/deleteWord.html'\">");
            out.println("<input type=\"submit\" value=\"Modify word\" onclick=\"location.href='/Group/modifyWord.html'\">");
            out.println("<input type=\"submit\" value=\"View dictionary\" onclick=\"location.href='/Group/dictionary.html'\">");
            out.println("<input type=\"submit\" value=\"View user history\" onclick=\"location.href='/Group/testHistory.html'\">");
            out.println("</body>");
            out.println("</html>");
            
            out.close();
        }
    }
    
    /**
     * Outputs printlines for creating Student welcome page to the browser
     * @param name
     * @param response
     * @param request
     * @throws IOException
     */
    public void makeStudentWelcomePage(String name, HttpServletResponse response, HttpServletRequest request) throws IOException{
         try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>welcome "+name+"</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>welcome "+name+"</h1>");
            out.println("<form action=\"Questions\" method=\"post\">");
            out.println("<input type=\"submit\" value=\"Take test\">");
            out.println("</form>");
            out.println("<form action=\"GetPersonalHistory\" method=\"post\">");
            out.println("<input type=\"submit\" value=\"See scores\">");
            out.println("</form>");
            out.println("<input type=\"submit\" value=\"View dictionary\" onclick=\"location.href='/Group/dictionary.html'\">");
            out.println("</body>");
            out.println("</html>");
            
            out.close();
        }
    }
    
    /**
     * Outputs printlines for creating wrong password page to the browser
     * @param name
     * @param response
     * @param request
     * @throws IOException
     */
    public void makeErrorPage(String name, HttpServletResponse response, HttpServletRequest request) throws IOException{
         try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>welcome "+name+"</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Wrong Username or password</h1>");
            out.println("</body>");
            out.println("</html>");
            
            out.close();
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
