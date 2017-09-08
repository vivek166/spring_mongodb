package com.synerzip.springwithmongo.model;

public class Results {

	private String id;
	private String maxPrice;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}
	@Override
	public String toString() {
		return "Results [id=" + id + ", maxPrice=" + maxPrice + "]";
	}
	
}