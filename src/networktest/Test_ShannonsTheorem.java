package networktest;



import network.ShannonsTheorem;
import junit.framework.*;

/**
 *	JUnit tests for the ShannonsTheorem class from the "network" project.
 * @author Michael Gordanier
 * @version 1.0.0
 */
public class Test_ShannonsTheorem extends TestCase {


	public Test_ShannonsTheorem(String name) { super(name);	}

	public static Test suite() { return new TestSuite(Test_ShannonsTheorem.class);		}

	protected void setUp() throws Exception { System.out.println("Test_ShannonsTheorem Begin");	}

	protected void tearDown() throws Exception { System.out.println("Test_ShannonsTheorem End");	}

 	/**
 	 * Test the constructors.
 	 */
	public void testConstructors() {
		System.out.println("\tExecuting Test_ShannonsTheorem.testConstructors");
		shannonsTheorem = new ShannonsTheorem();
		assertNotNull("\t\tTest_ShannonsTheorem.testConstructors: ShannonsTheorem is null", shannonsTheorem);
		
		
	}


	/**
	 * Test the accessors.
	 */
	public void testAccessors() {
		System.out.println("\tExecuting Test_ShannonsTheorem.testAccessors");
		shannonsTheorem = new ShannonsTheorem();
		
		assertNotNull("\t\tTest_ShannonsTheorem.testAccessors: ShannonsTheorem is null", shannonsTheorem);
		shannonsTheorem.setBandwidth(3000);
		assertTrue("\t\tTesting_ShannonsTheorem.GetSetBandwidth Failed", shannonsTheorem.getBandwidth() == 3000 );
		shannonsTheorem.setSignalToNoise(30);
		assertTrue("\t\tTesting_ShannonsTheorem.GetSetSignalToNoise Failed", shannonsTheorem.getSignalToNoise() == 30.0 );
		assertTrue("\t\tTesting_ShannonsTheorem.getMaximumDataRate Failed", shannonsTheorem.getMaximumDataRate() == 29901.68);
	}


	/**
	 * Test the mutators/modifiers.
	 */
	public void testMutators() {
      System.out.println("\tExecuting Test_ShannonsTheorem.testMutators");
		shannonsTheorem = new ShannonsTheorem();
		assertNotNull("\t\tTest_ShannonsTheorem.testMutators: ShannonsTheorem is null", shannonsTheorem);		
		
		shannonsTheorem.setBandwidth(3000);
		assertTrue("\t\tTesting_ShannonsTheorem.GetSetBandwidth Failed", shannonsTheorem.getBandwidth() == 3000 );
		
	
		shannonsTheorem.setSignalToNoise(30);
		assertTrue("\t\tTesting_ShannonsTheorem.GetSetSignalToNoise Failed", shannonsTheorem.getSignalToNoise() == 30 );
		
	}


	/*	STAND-ALONE ENTRY POINT -----------------------------------------	*/
	/**
	 *	Main line for standalone operation.
	 *	@param	args	Standard string command line parameters.
	 */
	public static void main(String[] args) {
      System.out.println("Executing Test_ShannonsTheorem suite");
      junit.textui.TestRunner.run(suite());
  }



   /* ATTRIBUTES	-----------------------------------------------	*/
   private ShannonsTheorem shannonsTheorem = null;
}	/*	End of CLASS:	Test_ShannonsTheorem.java				*/
