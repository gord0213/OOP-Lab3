package networktest;



import junit.framework.*;

/**
 * JUnit test class to execute all JUNIT tests for the "Shannons Theorem"
 * project.
 *
 */
public class AllTests extends TestCase {

	public AllTests(String name) {
		super(name);
	}

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(Test_ShannonsTheorem.suite());
		suite.addTest(Test_ShannonsModel.suite());
		return suite;
	}

	/* STAND-ALONE ENTRY POINT ----------------------------------------- */
	/**
	 * Main line for standalone operation.
	 * 
	 * @param args
	 *            Standard string command line parameters.
	 */
	public static void main(String[] args) {
		System.out.println("Executing AllTests ...");
		junit.textui.TestRunner.run(suite());
	}

} /* End of CLASS: AllTests.java */
