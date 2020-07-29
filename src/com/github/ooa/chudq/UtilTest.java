package com.github.ooa.chudq;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.github.ooa.chudq.ioc.IcoContainer;
import com.github.ooa.chudq.ioc.test.Benchi;
import com.github.ooa.chudq.ioc.test.HumenWithCar;
import com.github.ooa.chudq.utils.HttpUtils;

public class UtilTest {

	public static void main(String[] args) {
		String interfaceUrl = "http://192.144.143.56:9090/TPEasyRecord/docMain/sendDocMain.html";
		HashMap<String,String> param = new HashMap<String,String>();
		param.put("businum", "005200863757001");
		String resp = HttpUtils.POST_HttpURLConnection( interfaceUrl, param);
		System.out.println(resp);
	}
	
	IcoContainer beans = new IcoContainer();
	
	@Before
	public void setBean(){
		beans.setBean(Benchi.class, "benchi");
		beans.setBean(HumenWithCar.class, "humenWithCar", "benchi");
	}
	
	int inc=0;
	
	public void increase() {
        inc++;
    }
	
	public void testIoC(){
		HumenWithCar humen = (HumenWithCar) beans.getBean("humenWithCar");
		humen.goHome();
	}
	
	@Test
	public void testMap(){
		Map<String,Integer> m = new HashMap<String,Integer>();
		m.put("3C", 111);
		m.put("2b", 222);
		
		Iterator<Map.Entry<String, Integer>> it = m.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry<String, Integer> entry = it.next();
			System.out.println(entry.getKey() + "====" + entry.getValue());
			System.out.println(entry.getKey()+" Hash code:"+entry.hashCode());
		}
	}
	
	
}
