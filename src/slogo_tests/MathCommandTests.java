package slogo_tests;
import java.util.ArrayList;

import commands.mathCommands.*;
import static org.junit.Assert.*;

public class MathCommandTests {
	

	@org.junit.Test
	public void testthatArcTanReturnsCorrectly() {
		ArcTanMathCommand arctan = new ArcTanMathCommand();
		ArrayList<Double> testparam = new ArrayList<Double>();
		testparam.add(90.0);
		arctan.parameters = testparam;
		assertEquals("Arctan returns correct double, in degrees", arctan.execute(null), 57.518, 0.01);
		
	}
	
	@org.junit.Test
	public void testthatA

}
