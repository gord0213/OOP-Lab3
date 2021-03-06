package network;



import java.text.DecimalFormat;
import java.util.Observable;

public class ShannonsModel extends Observable {
	/* ATTRIBUTES ----------------------------------------------------- */
	private double bandwidth;
	private double signalToNoise;
	private static DecimalFormat DF;

	public ShannonsModel() {
	}

	/* ACCESSORS ----------------------------------------------------- */
	/**
	 * 
	 * @return the value of bandwidth
	 */
	public double getBandwidth() {
		return this.bandwidth;
	}

	/**
	 * Getter for the variable signalToNoise
	 * 
	 * @return the variable signal to noise
	 */
	public double getSignalToNoise() {
		return this.signalToNoise;
	}

	/**
	 * A setter for the variable bandwidth
	 * 
	 * @param b
	 *            is the value to be set to bandwidth
	 */
	public void setBandwidth(double b) {
		this.bandwidth = b;
		setChanged();
		notifyObservers(toString());
	}

	/**
	 * A setter for the variable signalToNoise
	 * 
	 * @param stn
	 *            is the value to be set to signalToNoise
	 */
	public void setSignalToNoise(double stn) {
		this.signalToNoise = stn;
		setChanged();
		notifyObservers(toString());
	}



	/**
	 * When this method is called it will call the method with
	 * 
	 * @return MaximumDataRate
	 */
	public double getMaximumDataRate() {
		return maximumDataRate(getBandwidth(), getSignalToNoise());
	}

	/**
	 * Convert this class to a meaningful string.
	 * 
	 * @return This class as a meaningful string.
	 */
	@Override
	public String toString() {
		StringBuilder test = new StringBuilder();
		DF = new DecimalFormat("##.##");
		
		 test.append("Bandwidth is:" + getBandwidth());
		 test.append(" ,Signal to noise is:" + getSignalToNoise());
		 test.append(" ,Maximum data rate is:" + Double.parseDouble(DF.format(getMaximumDataRate())));

		// System.out.println(test);

		return test.toString();
	}

	/**
	 * Takes in two varibles and uses them to calculate the maximum data rate
	 * 
	 * @param hertz
	 * @param signalToNoise
	 * @return The calculated maxamum data rat.
	 */
	private static double maximumDataRate(double hertz, double snr) {

		return (hertz * (Math.log(1 + Math.pow(10, snr / 10)) / Math.log(2)));
	}
}
