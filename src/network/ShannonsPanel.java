package network;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javafx.scene.input.KeyCode;

@SuppressWarnings({ "unused", "serial" })
public class ShannonsPanel extends JPanel implements Observer{
	private ShannonsController controller;
	private JLabel maxDataRateLBL =  new JLabel("Bandwidth is: " + "???" + " , Signal to noise is:  " + "???" + ", Maximum data rate is: " + "???");
	
	public ShannonsPanel(ShannonsController ctl){
		setController(ctl);
		initGUI();
		
	}
	public JLabel getMaxDataRateLBL(){
		
		System.out.println(maxDataRateLBL.getText());
		return maxDataRateLBL;
		
	}
	public void setMaxDataRateLBL(JLabel mbrlbl){
//		System.out.println(mbrlbl.getText());
//		maxDataRateLBL.setText("Bandwith is'/+ );
		maxDataRateLBL = mbrlbl;
	}
	public void setController(ShannonsController ctl){
		controller = ctl;
	}
	private void initGUI(){
		try{
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel bwpanel = createBandwidthPanel();
		JPanel stnPanel = createSignalToNoisePanel();
		JPanel inputpanel = new JPanel();
		this.add(getMaxDataRateLBL());
		this.add(bwpanel);
		this.add(stnPanel);
		this.add(inputpanel);
		//this.add(getMaxDataRateLBL());

		}catch(Exception e){
			System.out.println(">>> error: " + e.getMessage());
		}
		
	}
	
	private JPanel createSignalToNoisePanel(){
		JPanel STNpanel = new JPanel();
		JLabel label = new JLabel("Signal to noise in (DB)");
		STNpanel.add(label);
		JTextField userInput = new JTextField(20);
		STNpanel.add(userInput);
		userInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.setSignalToNoise(Double.parseDouble(userInput.getText()));
				System.out.println(">> enter pressed and signal to noise changed to " + userInput.getText());
			}
		});
		return STNpanel;
		
	}
	private JPanel createBandwidthPanel(){
		JPanel bwPanel = new JPanel();
		JLabel label = new JLabel("Bandwith in (hz)");
		bwPanel.add(label);
		JTextField userInput = new JTextField(20);
		bwPanel.add(userInput);
		userInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.setBandwidth(Double.parseDouble(userInput.getText()));
				System.out.println(">> enter pressed and Bandwidth changed to " + userInput.getText());
			}
		});
		return bwPanel;
	}
	public void update(Observable o, Object arg){
		if (o.hasChanged()){
			System.out.println(arg);
			maxDataRateLBL.setText(arg.toString());
		}
	}
}
