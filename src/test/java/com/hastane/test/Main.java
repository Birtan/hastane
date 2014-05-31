package com.hastane.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hasta.util.HibernateUtil;
import com.hastane.entity.Hasta;
import com.hastane.entity.Il;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session s=HibernateUtil.getSessionfactory().openSession();
		Transaction t=null;
		try {
			t=s.beginTransaction();
			Il il = (Il) s.get(Il.class, 34);
			Hasta hasta =new Hasta(il, "deneme", "hasta", "67341256422", 2324567);
			s.save(hasta);
			t.commit();
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("hibernate hata: "+e);
			t.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}

	}

}
