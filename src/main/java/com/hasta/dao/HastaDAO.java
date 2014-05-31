package com.hasta.dao;

import java.util.List;
import java.util.ArrayList;

import com.hasta.dao.impl.HastaImpl;
import com.hasta.util.HibernateUtil;
import com.hastane.entity.Hasta;
import com.hastane.entity.Il;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Session Bean implementation class HastaDAO
 */
@Stateless
@Remote(HastaImpl.class)
@LocalBean
public class HastaDAO implements HastaImpl {

    /**
     * Default constructor. 
     */
	
	 
	List<Hasta> hastaList;
	
    public HastaDAO() {
        // TODO Auto-generated constructor stub
    	
    	hastaList=new ArrayList<Hasta>(); 
    }

	/**
     * @see HastaImpl#add(Hasta)
     */
    public void add(Hasta hasta) {
        // TODO Auto-generated method stub
    	Session session = HibernateUtil.getSessionfactory().openSession();
    	
    	Transaction transaction =null;
    	try {
    		System.out.println("metoda girdi");
			transaction=session.beginTransaction();
			session.save(hasta);
			transaction.commit();
			hastaList.add(hasta);
			System.out.println("kayıt gerçekleşmiştir");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}finally{
			session.close();
		}
    }

	/**
     * @see HastaImpl#remove(Hasta)
     */
    public void remove(Hasta hasta) {
        // TODO Auto-generated method stub
    }

	/**
     * @see HastaImpl#getList()
     */
    public List<Hasta> getList() {
        // TODO Auto-generated method stub
			return hastaList;
    }

	/**
     * @see HastaImpl#update(Hasta)
     */
    public void update(Hasta hasta) {
        // TODO Auto-generated method stub
    }

}
