package com.github.ooa.chudq.ioc;


import org.junit.Before;
import org.junit.Test;
import com.github.ooa.chudq.ioc.test.Benchi;
import com.github.ooa.chudq.ioc.test.HumenWithCar;

public class TestIoc {
	
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
	}
	
}
