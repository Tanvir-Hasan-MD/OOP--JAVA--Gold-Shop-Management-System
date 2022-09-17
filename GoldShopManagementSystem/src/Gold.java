
public class Gold extends Item{
	private int goldID;
	private String type;
	private double karat;
	
	public Gold(double weight, double price, int unit, int goldID, String type, double karat) {
		super(weight, price, unit);
		this.setGoldID(goldID);
		this.setType(type);
		this.setKarat(karat);
	}

	public int getGoldID() {
		return goldID;
	}

	public void setGoldID(int goldID) {
		this.goldID = goldID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getKarat() {
		return karat;
	}

	public void setKarat(double karat) {
		this.karat = karat;
	}
}
