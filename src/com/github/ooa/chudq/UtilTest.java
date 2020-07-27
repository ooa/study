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

	public static String OutputExpress(int[] coefficientArry,int[]  exponenArry){
		if(exponenArry.length>coefficientArry.length) return "error: 指数个数不能大于系数";//这里也可以采用0*N
		StringBuffer str = new StringBuffer();
		for(int i=0;i<exponenArry.length;i++){
			if(i!=0) str.append(" + ");
			if(i<exponenArry.length){
				str.append(coefficientArry[i] + "x" + exponenArry[i]);
			}else{
				str.append(coefficientArry[i] + "x" + "0");
			}
		}
		return str.toString();
	}
	public static void main(String[] args) {
		String interfaceUrl = "http://192.144.143.56:9090/TPEasyRecord/docMain/sendDocMain.html";
		HashMap<String,String> param = new HashMap<String,String>();
		param.put("businum", "005200863757001");
		String resp = HttpUtils.POST_HttpClient( interfaceUrl, param);
		System.out.println(resp);
				
		/*ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		BeanInitDemo1 bid = (BeanInitDemo1) context.getBean("init-one");
		System.out.println(bid.getMessage());
		
		DealDataService server = (DealDataService) context.getBean("dealDataService");
		server.test();*/
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
	
	@Test
	public void testIoC(){
		HumenWithCar humen = (HumenWithCar) beans.getBean("humenWithCar");
		humen.goHome();
		
		Map<String,Integer> m = new HashMap<String,Integer>();
		m.put("3C", 111);
		m.put("2b", 222);
		m.put("3A", 111);
		m.put("4A", 222);
		m.put("5A", 111);
		m.put("6A", 222);
		m.put("7A", 111);
		m.put("8A", 222);
		m.put("9A", 111);
		m.put("10A", 222);
		m.put("11A", 111);
		m.put("12A", 222);
		m.put("13A", 111);
		m.put("14A", 222);
		m.put("15A", 111);
		m.put("16A", 222);
		m.put("17A", 111);
		m.put("18A", 222);
		
		Iterator<Map.Entry<String, Integer>> it = m.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry<String, Integer> entry = it.next();
			System.out.println(entry.getKey() + "====" + entry.getValue());
		}
		
		System.out.println(m.get("2b"));
		
		UtilTest test = new UtilTest();
		for(int i=0;i<10;i++){
			new Thread(){
				public void run() {
                    test.increase();
                };
			}.start();
		}
		System.out.println(test.inc);
	}
	
}
