package com.hastane.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.hasta.dao.impl.HastaImpl;
import com.hasta.util.HibernateUtil;
import com.hastane.entity.Hasta;
import com.hastane.entity.Il;
import com.hastane.entity.Ilce;
import com.sun.org.apache.regexp.internal.recompile;

/**
 * Session Bean implementation class HastaBean
 */
@SuppressWarnings("serial")
@ManagedBean(name="hastaBean")
@SessionScoped
public class HastaBean implements Serializable{

    /**
     * Default constructor. 
     */
	@EJB
	HastaImpl hastaImpl;
	Hasta hasta;
	List<Il> iller;
	List<Ilce> ilceler;
	Ilce ilce;
	Il il;
	
	
	public Il getIl() {
		return il;
	}

	public void setIl(Il il) {
		this.il = il;
	}

	public Ilce getIlce() {
		return ilce;
	}

	public void setIlce(Ilce ilce) {
		this.ilce = ilce;
	}

	public List<Ilce> getIlceler() {
		return ilceler;
	}

	public void setIlceler(List<Ilce> ilceler) {
		this.ilceler = ilceler;
	}

	public List<Il> getIller() {
		return iller;
	}

	public void setIller(List<Il> iller) {
		this.iller = iller;
	}

	public synchronized Hasta getHasta() {
		return hasta;
	}

	public synchronized void setHasta(Hasta hasta) {
		this.hasta = hasta;
	}

	public HastaBean() {
        // TODO Auto-generated constructor stub
		hasta=new Hasta();
		iller=new ArrayList<Il>();
		ilceler=new ArrayList<Ilce>();
		ilce=new Ilce();
		il=new Il();
		
    }
	public void add() {
		try {
			hastaImpl.add(hasta);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bilgi:", "kayıt  eklenmiştir."));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hata:", "kayıt gerçekleştirelemedi."));
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void IlListele() {
		
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction =null;
		Criteria criteria=null;
		try {
			transaction =session.beginTransaction();
			criteria =session.createCriteria(Il.class);
			
			transaction.commit();
			iller= (List<Il>)criteria.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			transaction.rollback();
			e.printStackTrace();
			
		}finally{
			session.close();
			
			
		}
		
		
		
	}
	@SuppressWarnings("unchecked")
	public void ilceListele() {
		System.out.println("AJAX ÇALIŞTI");
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction =null;
		Criteria criteria=null;
		try {
			transaction =session.beginTransaction();
			criteria =session.createCriteria(Ilce.class).add(Restrictions.eq("il", hasta.getIl()));
			/*String hql="From ilce AS i WHERE i.sehirId=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, il.getSehirId());*/
			transaction.commit();
			ilceler= (List<Ilce>)criteria.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("hibernate hata : "+e);
			transaction.rollback();
			e.printStackTrace();
			
		}finally{
			session.close();
			
			
		}
		
	}
	
	public void denemeAjax() {
		
		System.out.println("Ajaxxxxxxxxxxxxxxxxxxxxxxxxxxx"+il.getAdi());
	}

}
