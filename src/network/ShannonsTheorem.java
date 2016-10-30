package network;



import java.awt.Container;
import java.text.DecimalFormat;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 * @author mike
 *
 */	
@SuppressWarnings("unused")
public class ShannonsTheorem implements ShannonsController{

	/* ATTRIBUTES	-----------------------------------------------------	*/
	private ShannonsModel model = new ShannonsModel();
	
	/* CONSTRUCTORS	--------------------------------------------------	*/
	/**
	 *	Default construtor.
	 */
	public ShannonsTheorem(){ super(); }
	/* ACCESSORS	-----------------------------------------------------	*/
	private ShannonsModel getModel(){
		return null;
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
	private void setModel(ShannonsModel model){
		
	}
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
		
		ShannonsPanel panel1 = new ShannonsPanel(this);
//		ShannonsPanel panel2 = new ShannonsPanel(this);
		appFrame.getContentPane().add(panel1);
//		appFrame.getContentPane().add(panel2);
		appFrame.pack();
		appFrame.setVisible(true);
		
	}
	
	
	@Override
	public void addObserver(Observer o) {
		
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
//		String Str = "";
//		boolean end = false;
//		while(!end){
//			try{
//				DecimalFormat	DF = new DecimalFormat("##.##");
//				shannonsTheorem.setBandwidth(Double.parseDouble(JOptionPane.showInputDialog("What is the bandwidth?")));
//				shannonsTheorem.setSignalToNoise(Double.parseDouble(JOptionPane.showInputDialog("What is the signal to noise?")));
//				JOptionPane.showMessageDialog(null, 
//				"[The bandwidth is: " + Double.parseDouble(DF.format(shannonsTheorem.getBandwidth())) 
//				 + " hz, The Signal to noise is: " + Double.parseDouble(DF.format(shannonsTheorem.getSignalToNoise())) 
//				 + "db, The maximum data rate is: " + Double.parseDouble(DF.format(shannonsTheorem.getMaximumDataRate())) + " bps]");
//				Str = JOptionPane.showInputDialog("Would you like to quit? (Y/N)");
//				if (Str.equalsIgnoreCase("n")){
//					end = false;
//				}else{
//					end = true;
//				}
//				
//			}catch(NumberFormatException e){
//								
//			}catch(NullPointerException e){
//				e.printStackTrace();
//				int dialogButton = JOptionPane.YES_NO_OPTION;
//				int dialogOutput = JOptionPane.showConfirmDialog(null, "Would you like to quit?", "Quit", dialogButton);
//				if (dialogOutput == 0){
//					JOptionPane.showMessageDialog(null, "Good Bye!");
//					end = true;
//				}else if (dialogOutput == 1){
//					end = false;
//				}
//			}
//		}
	}

}
