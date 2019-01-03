package com.exact.service.campana.utils;

import java.util.Comparator;
import java.util.Map;

import com.exact.service.campana.entity.ItemCampana;

public class OrdenarItemCampanaImpresion implements Comparator<ItemCampana> {

	@SuppressWarnings("unchecked")
    @Override
    public int compare(ItemCampana ic1, ItemCampana ic2) {
		int c;
		
    	String clasifica1 = ic1.getClasificacion();
    	String clasifica2 = ic2.getClasificacion();
		
		Map<String, Object> MapDistrito1 =  ic1.getDistrito();
		Map<String, Object> MapProvincia1 = (Map<String, Object>) ic1.getDistrito().get("provincia");			
		Map<String, Object> MapDepartamento1 = (Map<String, Object>) MapProvincia1.get("departamento");	
		
		String nombre_distrito1 = MapDistrito1.get("nombre").toString().trim();
		String nombre_provincia1 = MapProvincia1.get("nombre").toString().trim();
		String nombre_departamento1 = MapDepartamento1.get("nombre").toString().trim();
		
		Map<String, Object> MapDistrito2 =  ic2.getDistrito();
		
		Map<String, Object> MapProvincia2 = (Map<String, Object>) ic2.getDistrito().get("provincia");			
		Map<String, Object> MapDepartamento2 = (Map<String, Object>) MapProvincia2.get("departamento");	
		
		String nombre_distrito2 = MapDistrito2.get("nombre").toString().trim();
		String nombre_provincia2 = MapProvincia2.get("nombre").toString().trim();
		String nombre_departamento2 = MapDepartamento2.get("nombre").toString().trim();
    		
    	c = clasifica1.compareTo(clasifica2);
    	
    	if ( c == 0 ) {
    		c = nombre_departamento1.compareTo(nombre_departamento2);
            
            if (c == 0) {
            	c = nombre_provincia1.compareTo(nombre_provincia2);
            	if( c== 0 ) {
            		return nombre_distrito1.compareTo(nombre_distrito2);        		
            	}else {
            		return c;
            	}
            	
            }else {
            	return c;
            }
    	}
    	else {
    		return c;
    	}
    	 	
    }
}

