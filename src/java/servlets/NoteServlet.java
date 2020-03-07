/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;
import services.NoteService;

/**
 *
 * @author 799470
 */
public class NoteServlet extends HttpServlet {
        
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
            throws ServletException, IOException {
        NoteService service = new NoteService();
        List<Note> notesList = service.getAll();
        request.setAttribute("notesList", notesList);
        getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response);
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
        request.setAttribute("mode", "view"); 
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
        NoteService service = new NoteService();
        List<Note> notesList = service.getAll();
        request.setAttribute("notesList", notesList);
        request.setAttribute("mode", "edit");
        
        // Edit
        if(request.getParameter("edit") != null) {
            int noteID = Integer.parseInt(request.getParameter("noteID"));
            
            Note note = service.get(noteID);
            request.setAttribute("selectedNoteID", note.getNoteid());
            request.setAttribute("noteTitle", note.getTitle());
            request.setAttribute("noteContents", note.getContents());
        }
        
        // Save (Update)
        if(request.getParameter("save") != null) {
            int noteIDSave =  Integer.parseInt(request.getParameter("selectedNoteID"));
                      
            String newTitle = request.getParameter("noteTitle");
            String newContent = request.getParameter("noteContent");
            service.update(noteIDSave, newTitle, newContent);
            
            // Set to view so that Add Note will be shown in JSP
            request.setAttribute("mode", "view");
        }
        
        // Add
        if(request.getParameter("add") != null) {
            String newTitle = request.getParameter("noteTitle");
            String newContent = request.getParameter("noteContent");
            service.insert(newTitle, newContent);
            
            // Set to view so that Add Note will be shown in JSP
            request.setAttribute("mode", "view");
        }
        
        // Delete
        if(request.getParameter("delete") != null) {
            int noteIDDelete =  Integer.parseInt(request.getParameter("selectedNoteID"));
            service.delete(noteIDDelete);
            
            // Set to view so that Add Note will be shown in JSP
            request.setAttribute("mode", "view");
        }
        
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
