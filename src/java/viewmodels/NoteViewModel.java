/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodels;

import models.Note;

/**
 *
 * @author 799470
 */
public class NoteViewModel {
    
    String title, contents;
    
    public NoteViewModel(Note note) {
        title = note.getTitle();
        contents = note.getContents();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
    
}
