package com.mycompany.group;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
Title: Questions
Authors: Miroslaw Pasko eeu258, Chris Owen eeu282, Matthew Badcock eeu247
Version: 1.0
 */
@WebServlet(name = "Questions", urlPatterns = {"/Questions"})
public class Questions extends HttpServlet {

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
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        try (PrintWriter out = response.getWriter()) 
        {
            HttpSession session = request.getSession();
            XMLGetter getter = new XMLGetter();
            ArrayList<ArrayList<String>> results = getter.getAllWord();
            int list2[] = new int[21];
            
            
            /*
            for(int i = 1; i < 21; i++)
            {
                int randomNum = 0 + (int)(Math.random() * results.size());
                list2[i] = randomNum;
            }
            //*/

            ArrayList<Integer> numbers = new ArrayList<Integer>();
            for(int i = 0; i < results.size(); i++)
            {
                numbers.add(i);
            }
            Collections.shuffle(numbers);
            for(int j =0; j < 21; j++)
            {
                System.out.print(numbers.get(j) + " ");
                list2[j] = numbers.get(j);
            }

     
            session.setAttribute("whoelList", results);
            session.setAttribute("listIndex", list2);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Questions</title>");    
            out.println("</head>");
            out.println("<body>");
            out.println("<form class=\"questions\" action=\"QuestionsServlet\" method=\"post\">");
            for(int i = 1; i < 21; i++)
            {
                out.println("<h4>Question " + i + "</h4>");   
                if(i < 11)
                {
                    out.println("What is the German noun for the English word " + results.get(list2[i]).get(2) + "?"); 
                }
                else 
                {
                    out.println("What is the gender and meaning of the German noun " + results.get(list2[i]).get(0) + "?"); // Questions here...
                }
                out.println("<br>");
                out.println("<input class=\"gender\" type=\"text\" name=\"Q" + i + "a\" placeholder=\"Gender\">");
                out.println("<input type=\"text\" name=\"Q" + i + "b\" placeholder=\"Translation\">");
                out.println("<br>");
            }           
            out.println("<br><br>");
            out.println("<input class=\"submitButton\" type=\"submit\" value=\"SUBMIT ALL ANSWERS\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        } catch (Exception ex) 
        {
            Logger.getLogger(Questions.class.getName()).log(Level.SEVERE, null, ex);
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
