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
		System.out.println(this.bandwidth);
		setChanged();
		notifyObservers(this.bandwidth);
	}

	/**
	 * A setter for the variable signalToNoise
	 * 
	 * @param stn
	 *            is the value to be set to signalToNoise
	 */
	public void setSignalToNoise(double stn) {
		this.signalToNoise = stn;
		System.out.println(this.signalToNoise);
		setChanged();
		notifyObservers(this.signalToNoise);
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
		DF = new DecimalFormat("##.##");
		return "[The bandwidth is: " + Double.parseDouble(DF.format(getBandwidth())) + " hz, The Signal to noise is: "
				+ Double.parseDouble(DF.format(getSignalToNoise())) + "db, The maximum data rate is: "
				+ Double.parseDouble(DF.format(getMaximumDataRate())) + " bps]";

	}

	/**
	 * Takes in two varibles and uses them to calculate the maximum data rate
	 * 
	 * @param hertz
	 * @param signalToNoise
	 * @return The calculated maxamum data rat.
	 */
	private static double maximumDataRate(double hertz, double snr) {
		DF = new DecimalFormat("##.##");
		String test = DF.format(hertz * (Math.log(1 + Math.pow(10, snr / 10)) / Math.log(2)));
		return Double.parseDouble(test);
	}
}
