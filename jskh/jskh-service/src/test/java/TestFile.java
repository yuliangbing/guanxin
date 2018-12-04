import java.math.BigDecimal;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;


public class TestFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Binding binding = new Binding();
		
		for (int i = 1; i<20; i++) {
			BigDecimal a = new BigDecimal(i).divide(new BigDecimal(100));
			BigDecimal b = new BigDecimal(i).multiply(new BigDecimal(5)).divide(new BigDecimal(100));
			BigDecimal c = new BigDecimal(i).multiply(new BigDecimal(6)).divide(new BigDecimal(100));
			BigDecimal d = new BigDecimal(i).multiply(new BigDecimal(8)).divide(new BigDecimal(100));
			
			binding.setVariable("A",a);
	        binding.setVariable("B",b);
	        binding.setVariable("C",c);
	        binding.setVariable("D",d);

	        binding.setVariable("language", "Groovy");

	        GroovyShell shell = new GroovyShell(binding);
	        
	        
	        String p1 = "P1=(A+(B * C / D))*A; return P1";

	        Object F1 =shell.evaluate(p1);

	        //System.out.println("J"+i+"="+F1);
	        
	        float i1 = i;
	        float a1 = i1/100;
	        float b1 = i1*5/100;
	        float c1 = i1*6/100;
	        float d1 = i1*8/100;
			
			binding.setVariable("A",a1);
	        binding.setVariable("B",b1);
	        binding.setVariable("C",c1);
	        binding.setVariable("D",d1);

	        binding.setVariable("language", "Groovy");

	        GroovyShell shell1 = new GroovyShell(binding);
	        
	        String p2 = "P1=(A+(B * C / D))*A; return P1";

	        Object F2 =shell1.evaluate(p2);

	        //System.out.println("K"+i+"="+F2);
	        System.out.println("A1:"+a+";B1:"+b+";C1:"+c+";D1:"+d);
	        System.out.println("A2:"+a1+";B2:"+b1+";C2:"+c1+";D2:"+d1);
		}
	}

}
