package com.github.ooa.chudq.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

public class TestMap {
	
	@Test
	public void testMap(){
		com.github.ooa.chudq.utils.HashMap mp = new com.github.ooa.chudq.utils.HashMap();
		mp.put("Aa", 666);
		mp.put("BB", 988);
		System.out.println(mp.get("Aa"));
		System.out.println(mp.get("BB"));
		
		HashMap<String,Integer> m = new HashMap<String,Integer>();
		m.put("3C", 111);
		m.put("2b", 222);
		
		Iterator ito = m.keySet().iterator();
		while(ito.hasNext()){
			String key = ito.next().toString(); 
			if(key.equals("3C")){
				ito.remove();
			}
		}
		System.out.println(m.toString());
		
		Iterator<Map.Entry<String, Integer>> it = m.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry<String, Integer> entry = it.next();
			System.out.println(entry.getKey() + "====" + entry.getValue());
			System.out.println(entry.getKey()+" Hash code:"+entry.hashCode());
		}
	}
	
	
}
