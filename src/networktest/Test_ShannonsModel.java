package networktest;



import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.text.DecimalFormat;

import network.ShannonsModel;
import junit.framework.*;


/**
 *	JUnit tests for the ShannonsTheorem class from the "network" project.
 * @author Michael Gordanier
 * @version 1.0.0
 */
public class Test_ShannonsModel extends TestCase {


	public Test_ShannonsModel(String name) { super(name);	}

	public static Test suite() { return new TestSuite(Test_ShannonsModel.class);		}

	protected void setUp() throws Exception { System.out.println("Test_ShannonsModel Begin");	}

	protected void tearDown() throws Exception { System.out.println("Test_ShannonsModel End");	}

 	/**
 	 * Test the constructors.
 	 */
	public void testConstructors() {
		System.out.println("\tExecuting Test_ShannonsModel.testConstructors");
		model = new ShannonsModel();
		assertNotNull("\t\tTest_ShannonsModel.testConstructors: model is null", model);
	}
	/**
	 * Test the accessors.
	 */
	public void testAccessors() {
		System.out.println("\tExecuting Test_ShannonsModel.testAccessors");
		model = new ShannonsModel();
		model.setBandwidth(3000);
		model.setSignalToNoise(30);
		
		assertNotNull("\t\tTest_ShannonsModel.testAccessors: ShannonsTheorem is null", model);
		assertTrue("\t\tTest_ShannonsModel.GetSetBandwidth Failed", model.getBandwidth() == 3000 );
		assertTrue("\t\tTest_ShannonsModel.GetSetSignalToNoise Failed", model.getSignalToNoise() == 30 );
		assertTrue("\t\tTest_ShannonsModel.getMaximumDataRate Failed", model.getMaximumDataRate() == 29901.68);
	}


	/**
	 * Test the mutators/modifiers.
	 */
	public void testMutators() {
      System.out.println("\tExecuting Test_ShannonsModel.testMutators");
		model = new ShannonsModel();
		assertNotNull("\t\tTest_ShannonsModel.testMutators: ShannonsTheorem is null", model);
		model.setBandwidth(3000);
		assertTrue("\t\tTest_ShannonsModel.GetSetBandwidth Failed", model.getBandwidth() == 3000 );
		model.setSignalToNoise(30);
		assertTrue("\t\tTest_ShannonsModel.GetSetSignalToNoise Failed", model.getSignalToNoise() == 30 );
	}

	/**
	 * Test behaviors.
	 */
	public void testBehaviors() {
      System.out.println("\tExecuting Test_ShannonsModel.testBehaviors");
		model = new ShannonsModel();
		assertNotNull("\t\tTest_ShannonsModel.testBehaviors: ShannonsTheorem is null", model);
		 DecimalFormat DF = new DecimalFormat("##.##");
		model.setBandwidth(3000);
		model.setSignalToNoise(30);
		testVariable = "[The bandwidth is: " + Double.parseDouble(DF.format(model.getBandwidth())) + " hz, The Signal to noise is: " + Double.parseDouble(DF.format(model.getSignalToNoise())) + "db, The maximum data rate is: " + Double.parseDouble(DF.format(model.getMaximumDataRate())) + " bps]";
		assertEquals(model.toString(), testVariable);		
	}



	/*	STAND-ALONE ENTRY POINT -----------------------------------------	*/
	/**
	 *	Main line for standalone operation.
	 *	@param	args	Standard string command line parameters.
	 */
	public static void main(String[] args) {
      System.out.println("Executing Test_ShannonsModel suite");
      junit.textui.TestRunner.run(suite());
  }



   /* ATTRIBUTES	-----------------------------------------------	*/
   private ShannonsModel model = null;
   private String testVariable = null;

}	/*	End of CLASS:	Test_ShannonsTheorem.java				*/
