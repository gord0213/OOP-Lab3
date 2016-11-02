package network;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


@SuppressWarnings({ "unused", "serial" })
public class ShannonsPanel extends JPanel implements Observer{
	private ShannonsController controller;
	private JLabel maxDataRateLBL;
	private String designOption;
	private JTextField stnTextField;
	private JTextField bwTextField;
	private JSlider stnSlider;
	private JSlider bandwidthSlider;
	/**
	 * 
	 * @param ctl
	 * @param option Option for Either Slider or Text
	 */
	public ShannonsPanel(ShannonsController ctl, String option){
		maxDataRateLBL = new JLabel("Bandwidth is: " + "???" + " , Signal to noise is:  " + "???" + ", Maximum data rate is: " + "???");
		designOption = option;
		setController(ctl);
		initGUI();
	}
	/**
	 * 
	 * @return the maxDataRateLBL
	 */
	public JLabel getMaxDataRateLBL(){
		return maxDataRateLBL;
		
	}
	/**
	 * Takes in a Jlabel that is representing the updated MDR Label
	 * 
	 * @param mbrlbl new maximumDataRateLBL
	 */
	public void setMaxDataRateLBL(JLabel mbrlbl){
		maxDataRateLBL = mbrlbl;
	}
	/**
	 * sets the controller variable
	 * @param ctl the controler 
	 */
	public void setController(ShannonsController ctl){
		controller = ctl;
	}
	/**
	 * Initializes the GUI
	 */
	private void initGUI(){
	
		try{
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			JPanel test = new JPanel();
			JLabel label = getMaxDataRateLBL();
			label.setHorizontalAlignment(SwingConstants.LEFT);
			test.add(label);
			test.setLayout(new FlowLayout(FlowLayout.LEFT));
	
			JPanel bwpanel = createBandwidthPanel();
			bwpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			JPanel stnPanel = createSignalToNoisePanel();
			stnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	
			this.add(test);
			this.add(bwpanel);
			this.add(stnPanel);
		}catch(Exception e){
			System.out.println(">>> error: " + e.getMessage());
		}
	}
	/**
	 * Creates a panel that holds the signal to noise option in regards to
	 * the designOption Attribute
	 * 
	 * @return the compiled Signal to noise panel
	 */
	private JPanel createSignalToNoisePanel(){
		JPanel STNpanel = new JPanel();
		STNpanel.setLayout(new BoxLayout(STNpanel,BoxLayout.X_AXIS));
		JLabel label = new JLabel("Signal to noise in (DB)");
		STNpanel.add(label);
		stnTextField = new JTextField(20);
		stnSlider = new JSlider(0, 100);
		if (designOption.equals("Text")){
			stnTextField.setText("0");
			STNpanel.add(stnTextField);
			stnTextField.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try{
						controller.setSignalToNoise(Double.parseDouble(stnTextField.getText()));
//						int num = (int) Double.parseDouble(stnTextField.getText());
//						System.out.println(num);
//						stnSlider.setValue(num);
					}catch(Exception error){
						error.printStackTrace();
					}
				}
			});
		}else if (designOption.equals("Slider")){
			
			stnSlider.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					double value = stnSlider.getValue();
					controller.setSignalToNoise(value);
				}
			});
			STNpanel.add(stnSlider);
		}
		return STNpanel;
	}
	/**
	 * Creates a panel that holds the bandwidth option in regards to
	 * the designOption Attribute
	 *
	 * @return the compiled Bandwidth panel
	 */
	private JPanel createBandwidthPanel(){
		JPanel bwPanel = new JPanel();
		bwPanel.setLayout(new BoxLayout(bwPanel, BoxLayout.X_AXIS));
		JLabel label = new JLabel("Bandwith in (hz)");
		bwPanel.add(label);

		bwTextField = new JTextField(20);
		bandwidthSlider = new JSlider(0, 5000);
		if (designOption.equals("Text")){
			bwTextField.setText("0");
			bwPanel.add(bwTextField);
			bwTextField.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try{
						controller.setBandwidth(Double.parseDouble(bwTextField.getText()));
						int num = (int) Double.parseDouble(bwTextField.getText());
						System.out.println(num);
						bandwidthSlider.setValue(num);
					}catch(Exception error){
						error.printStackTrace();
					}
				}
			});
		}else if (designOption.equals("Slider")){
			bandwidthSlider.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					double value = bandwidthSlider.getValue();
					controller.setBandwidth(value);
				}
			});
			bwPanel.add(bandwidthSlider);
		}
		
		return bwPanel;
	}	
	public void update(Observable o, Object arg){
		maxDataRateLBL.setText(arg.toString());
		String[] temp;
		String[] stnTemp;
		String[] bwTemp;
		String[] mdrTemp;
		temp = arg.toString().split(",");
		
		bwTemp = temp[0].split(":");
		stnTemp= temp[1].split(":");
		mdrTemp = temp[2].split(":");
		int num;
		if (bwTextField != null){
			num = (int) Double.parseDouble(bwTemp[1]);
			//System.out.println(num);
			bwTextField.setText(String.valueOf(num));	
			bandwidthSlider.setValue(num);
		}
		if (stnTextField != null){
			num = (int) Double.parseDouble(stnTemp[1]);
			stnTextField.setText(String.valueOf(num));
			//System.out.println(num);
			stnSlider.setValue(num);
		}	
	}
}
