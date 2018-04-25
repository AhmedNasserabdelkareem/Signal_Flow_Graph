package Componenets;

public class Branch {
	private int From ;
	private int To;
	private int Gain ;
	public Branch(int from, int to, int gain) {
		super();
		From = from;
		To = to;
		Gain = gain;
	}
	
	public int getFrom() {
		return From;
	}
	public int getTo() {
		return To;
	}

	public int getGain() {
		return Gain;
	}



}
