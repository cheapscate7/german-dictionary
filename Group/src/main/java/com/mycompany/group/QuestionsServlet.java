package com.mycompany.group;

import java.io.File;
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
 *
 * @author eeu282
 */
@WebServlet(name = "QuestionsServlet", urlPatterns = {"/QuestionsServlet"})
public class QuestionsServlet extends HttpServlet 
{

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
            XMLWriter writer = new XMLWriter();
            String resultsa[] = new String[21];
            String resultsb[] = new String[21];
            String name = (String) session.getAttribute("Uname");
            int listIndex[] = new int[21];
            int score = 0;

            for(int i = 1; i < 21; i++)
            {
                resultsa[i] = request.getParameter("Q" + i + "a");
                resultsb[i] = request.getParameter("Q" + i + "b");
            }
        
            listIndex =  (int[]) session.getAttribute("listIndex");
            ArrayList<ArrayList<String>> results = (ArrayList<ArrayList<String>>) session.getAttribute("whoelList");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Results</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Results</h1>");
            for(int i = 1; i < 21; i++)
            {
                out.println("<H4>Question " + i + "</H4><br>Your answers:");
                out.println(" Gender: " + resultsa[i]);
                out.println(" Translation: " + resultsb[i]);
                
                if (i < 11)
                {
                    out.println("<br>Correct answers:");
                    out.println(" Gender: " + results.get(listIndex[i]).get(1));
                    out.println(" Translation: " + results.get(listIndex[i]).get(0));
                    if(resultsa[i].equals(results.get(listIndex[i]).get(1)) && resultsb[i].matches(".*\\b"+results.get(listIndex[i]).get(0)+"\\b.*"))
                    {
                        score++;
                    }
                }
                else
                {
                    out.println("<br>Correct answers:");
                    out.println(" Gender: " + results.get(listIndex[i]).get(1));
                    out.println(" Translation: " + results.get(listIndex[i]).get(2));
                    if(resultsa[i].equals(results.get(listIndex[i]).get(1)) && resultsb[i].matches(".*\\b"+results.get(listIndex[i]).get(2)+"\\b.*"))
                    {
                        score++;
                    }
                }
            }
            out.println("<br><br>Score: " + score);
            out.println("</body>");
            out.println("</html>");
            out.close();
           
            if(!name.isEmpty())
            {
                File f = new File("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\test.xml");
                if(f.exists())
                    writer.appendHistoryXML(name, score);
                else
                    writer.beginHistoryXML(name, score);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(QuestionsServlet.class.getName()).log(Level.SEVERE, null, ex);
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
