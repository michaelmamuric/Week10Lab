/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
    
    public Note get(int noteid) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Note note = em.find(Note.class, noteid);
            return note;
        } finally {
            em.close();
        }
    }
    
    public int update(Note note) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        try {
            et.begin();
            em.merge(note);
            et.commit();
            return 1;
        } catch(Exception e) {
            et.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    
    public int insert(Note note) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        try {
            et.begin();
            em.persist(note);
            et.commit();
            return 1;
        } catch(Exception e) {
            et.rollback();
            throw e;
        } finally {
            em.close();
        } 
    }
    
    public int delete(Note note) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        try {
            et.begin();
            em.remove(em.merge(note));
            et.commit();
            return 1;
        } catch(Exception e) {
            et.rollback();
            throw e;
        } finally {
            em.close();
        } 
    }
    
}
