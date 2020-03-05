/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import models.Note;

/**
 *
 * @author 799470
 */
public class NoteDB {
    
    public List<Note> getAll() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Note> notes = em.createNamedQuery("Note.findAll", Note.class).getResultList();
            return notes;
        } finally {
            em.close();
        }
    }
    
}
