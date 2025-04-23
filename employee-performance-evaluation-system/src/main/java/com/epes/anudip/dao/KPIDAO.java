package com.epes.anudip.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.epes.anudip.entity.KPI;
import com.epes.anudip.util.HibernatUtil;

public class KPIDAO {
    //  To add a KPI
	public void saveKPI(KPI kpi) {
		Transaction tobj =null;
		try(Session sobj =HibernatUtil.getSessionFactory().openSession()){
			tobj=sobj.beginTransaction();
			sobj.save(kpi);
			tobj.commit();
		}
		catch(Exception e)
		{
			if(tobj!=null)
				tobj.rollback();
			e.printStackTrace();
		}
	}
	
	// Get KPI by ID
    public KPI getKPIById(Long kpiId) {
        try (Session sobj = HibernatUtil.getSessionFactory().openSession()) {
            return sobj.get(KPI.class, kpiId);
        }
    }

    // Get all KPIs
    public List<KPI> getAllKPIs() {
        try (Session sobj = HibernatUtil.getSessionFactory().openSession()) {
            return sobj.createQuery("FROM KPI", KPI.class).list();
        }
    }
}
