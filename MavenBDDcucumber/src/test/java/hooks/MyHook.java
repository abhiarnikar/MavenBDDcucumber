package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import stepDefinations.Base;

public class MyHook extends Base {

	@Before
	public void setUp() {
		
		System.out.println("Launch Application");
	}
	
	@After
	public void tearDown() {
		
		System.out.println("Close the Browser");
	}
	
	@BeforeStep
	public void takescreenshot() {
		
		System.out.println("Take a Screenshot");
	}
	
}
