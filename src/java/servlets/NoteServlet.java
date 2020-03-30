/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;
import services.NoteService;
import viewmodels.NoteViewModel;

/**
 *
 * @author 799470
 */
public class NoteServlet extends HttpServlet {

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
        NoteService service = new NoteService();
        List<Note> notesList = service.getAll();
        request.setAttribute("notesList", notesList);
        request.setAttribute("mode", "view");
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response);
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
        String action = request.getParameter("action");
        
        // Edit
        if(action.equals("Edit")) {            
            request.setAttribute("mode", "edit");
            int noteID = Integer.parseInt(request.getParameter("noteID"));
            Note note = service.get(noteID);
            request.setAttribute("note", note);
        }
        
        // Add
        if(action.equals("Add")) {
            request.setAttribute("mode", "view");
            String newTitle = request.getParameter("noteTitle");
            String newContent = request.getParameter("noteContent");
            service.insert(newTitle, newContent);
        }
        
        // Delete
        if(action.equals("Delete")) {
            int deleteNoteId = Integer.parseInt(request.getParameter("deleteNoteId"));
            service.delete(deleteNoteId);
            request.setAttribute("mode", "view");
        }
        
        List<Note> notesList = service.getAll();
        request.setAttribute("notesList", notesList);
        getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response);
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
