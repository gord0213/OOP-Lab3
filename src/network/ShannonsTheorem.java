package network;



import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.Observer;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;


/**
 * 
 * @author mike
 *
 */	
@SuppressWarnings("unused")
public class ShannonsTheorem implements ShannonsController{

	/* ATTRIBUTES	-----------------------------------------------------	*/
	private ShannonsModel model = new ShannonsModel();
	private static ShannonsController controller;
	
	/* CONSTRUCTORS	--------------------------------------------------	*/
	/**
	 *	Default construtor.
	 */
	public ShannonsTheorem(){
		model = new ShannonsModel();
		
	}
	/* ACCESSORS	-----------------------------------------------------	*/
	private ShannonsModel getModel(){
		return model;
	}
	
	
	/**Calls the getBandwidth form ShannonsModel
	 * 
	 *	@return the value of bandwidth
	 */
	public double getBandwidth() { return model.getBandwidth();	}

	/**
	 * calls the getMaximumDataRate from Shannons Model
	 * @return the calculated MaximumDataRate
	 */
	public double getMaximumDataRate(){	return model.getMaximumDataRate(); }
	
	/**
	 * calls the getSignalToNoise from Shannons Model
	 * @return signalToSound
	 */
	public double getSignalToNoise(){ return model.getSignalToNoise(); }
		/**
	 * Takes the inputed atribute and makes the calls setSignalToNoise with snr
	 * @param stn Signal To Noise
	 */
	public void setSignalToNoise(double stn){ model.setSignalToNoise(stn); }
	/**
	 * 
	 * @param model
	 */
	private void setModel(ShannonsModel model){	this.model = model; }
	/**
	 * Takes in a double and sets the attribute bandwith in shannons model to the double variable
	 * @param h bandwidth value
	 */
	public void setBandwidth(double h){	model.setBandwidth(h);	}
	/**
	 * 
	 */
	private void initGUI(){
		JFrame appFrame = new JFrame("Shannons Theorem");
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ShannonsPanel panel1 = new ShannonsPanel(this, "Text");
		ShannonsPanel panel2 = new ShannonsPanel(this, "Slider");
		ShannonsPanel panel3 = new ShannonsPanel(this, "Text");
		//panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(panel1);
		container.add(panel2);
		container.add(panel3);
		
		addObserver(panel1);
		addObserver(panel2);
		addObserver(panel3);
		
		appFrame.getContentPane().add(container).setPreferredSize(new Dimension(500, 400));
		appFrame.pack();
		appFrame.setVisible(true);
		
	}
	
	
	@Override
	public void addObserver(Observer o) {
		model.addObserver(o);
	}
	
	
	/*	ENTRY POINT for STAND-ALONE OPERATION ---------------------------	*/
	/**
	 * Entry point "main()" as required by the JVM.
	 * @param  args   Standard command line parameters (arguments) as a
	 *	string array.
	 */
	public static void main(String args[]){
		ShannonsTheorem shannonsTheorem = new ShannonsTheorem();
		shannonsTheorem.initGUI();

	}

}
