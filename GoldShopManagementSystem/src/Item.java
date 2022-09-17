
public class Item {
	private double weight;
	private double price;
	private int unit;
	
	public Item(double weight,double price, int unit)
	{
		this.setWeight(weight);
		this.setPrice(price);
		this.setUnit(unit);
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}
}
