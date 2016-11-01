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
	
	public ShannonsPanel(ShannonsController ctl){
		maxDataRateLBL = new JLabel("Bandwidth is: " + "???" + " , Signal to noise is:  " + "???" + ", Maximum data rate is: " + "???");
		setController(ctl);
		initGUI();
	}
	public ShannonsPanel(ShannonsController ctl, String option){
		maxDataRateLBL = new JLabel("Bandwidth is: " + "???" + " , Signal to noise is:  " + "???" + ", Maximum data rate is: " + "???");
		designOption = option;
		setController(ctl);
		initGUI();
	}
	public JLabel getMaxDataRateLBL(){
		return maxDataRateLBL;
		
	}
	public void setMaxDataRateLBL(JLabel mbrlbl){
		maxDataRateLBL = mbrlbl;
	}
	public void setController(ShannonsController ctl){
		controller = ctl;
	}
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
	
	
	
	private JPanel createSignalToNoisePanel(){
		JPanel STNpanel = new JPanel();
		STNpanel.setLayout(new BoxLayout(STNpanel,BoxLayout.X_AXIS));
		JLabel label = new JLabel("Signal to noise in (DB)");
		STNpanel.add(label);
		if (designOption.equals("Text")){
			JTextField userInput = new JTextField(20);
			STNpanel.add(userInput);
			userInput.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.setSignalToNoise(Double.parseDouble(userInput.getText()));
					//System.out.println(">> enter pressed and signal to noise changed to " + userInput.getText());
				}
			});
		}else if (designOption.equals("Slider")){
			JSlider stnSlider = new JSlider(0, 100);
			stnSlider.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					double value = stnSlider.getValue();
					System.out.println(">>> Value of signal to noise slider is : " + value);
					controller.setSignalToNoise(value);
				}
			});
			STNpanel.add(stnSlider);
		}
		return STNpanel;
	}
	private JPanel createBandwidthPanel(){
		JPanel bwPanel = new JPanel();
		bwPanel.setLayout(new BoxLayout(bwPanel, BoxLayout.X_AXIS));
		JLabel label = new JLabel("Bandwith in (hz)");
		bwPanel.add(label);
		if (designOption.equals("Text")){
			JTextField userInput = new JTextField(20);
			bwPanel.add(userInput);
			userInput.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.setBandwidth(Double.parseDouble(userInput.getText()));
					System.out.println(">> enter pressed and Bandwidth changed to " + userInput.getText());
				}
			});
		}else if (designOption.equals("Slider")){
			JSlider bandwidthSlider = new JSlider(0, 5000);
			bandwidthSlider.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					double value = bandwidthSlider.getValue();
					System.out.println(">>> Value of bandwidth slider is : " + value);
					controller.setBandwidth(value);
				}
			});
			bwPanel.add(bandwidthSlider);
		}
		
		return bwPanel;
	}
	public void update(Observable o, Object arg){
		maxDataRateLBL.setText(arg.toString());
	}
}
