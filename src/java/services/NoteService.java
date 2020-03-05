/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.NoteDB;
import java.util.List;
import models.Note;

/**
 *
 * @author 799470
 */
public class NoteService {
    NoteDB noteDB;
    
    public NoteService() {
        noteDB = new NoteDB();
    }
    
    public List<Note> getAll() {
        List<Note> notesList = noteDB.getAll();
        return notesList;
    }
    
    public Note get(int noteid) {
        Note note = noteDB.get(noteid);
        return note;
    }
}
