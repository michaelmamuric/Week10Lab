/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.NoteDB;
import java.util.Date;
import java.util.List;
import models.Note;
import models.User;

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
    
    public int update(int noteid, String title, String contents) {
        Note note = get(noteid);
        note.setDatecreated(new Date());
        note.setTitle(title);
        note.setContents(contents);
        return noteDB.update(note);
    }
    
    public int insert(String title, String contents) {
        Note newNote = new Note();
        newNote.setDatecreated(new Date());
        newNote.setTitle(title);
        newNote.setContents(contents);
        // This is a hack just to make Lab 10 work
        // Note table structure has changed and needs to have an owner!
        newNote.setOwner(new User("anne"));
        return noteDB.insert(newNote);
    }
    
    public int delete(int noteid) {
        Note note = noteDB.get(noteid);
        return noteDB.delete(note);
    }
    
}
