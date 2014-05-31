package com.hasta.dao.impl;

import java.util.List;

import javax.ejb.Remote;

import com.hastane.entity.Hasta;
@Remote
public interface HastaImpl {
	
	public void add(Hasta hasta);
	public void remove(Hasta hasta);
	public void update(Hasta hasta);
	public List<Hasta> getList();
	
	

}
