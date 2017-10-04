package com.salesmans.expances;

public class TableDTO {
	private String name;
	private double foodEx;
	private double travelEx;
	private double taxiEx;
	private double miscEx;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFoodEx() {
		return foodEx;
	}

	public void setFoodEx(double foodEx) {
		this.foodEx = foodEx;
	}

	public double getTravelEx() {
		return travelEx;
	}

	public void setTravelEx(double travelEx) {
		this.travelEx = travelEx;
	}

	public double getTaxiEx() {
		return taxiEx;
	}

	public void setTaxiEx(double taxiEx) {
		this.taxiEx = taxiEx;
	}

	public double getMiscEx() {
		return miscEx;
	}

	public void setMiscEx(double miscEx) {
		this.miscEx = miscEx;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", foodEx=" + foodEx + ", travelEx=" + travelEx + ", taxiEx=" + taxiEx + ", miscEx="
				+ miscEx + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TableDTO other = (TableDTO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
