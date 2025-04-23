package com.epes.anudip.service;

import java.util.List;

import com.epes.anudip.dao.KPIDAO;
import com.epes.anudip.entity.KPI;

public class KPIService {
	
	KPIDAO  kpidao = new KPIDAO();
	
	// add a KPI
	public void addKPI(KPI kpi)
	{
		kpidao.saveKPI(kpi);
		System.out.println("KPI added:"+kpi.getName());
	}
		
    // Get All KPIs
	public List<KPI> getAllKPIs()
	{
		return kpidao.getAllKPIs();
	}
}
