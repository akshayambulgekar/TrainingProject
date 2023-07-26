package com.ak.Cars.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Cars {

	@Id
	private int carId;
	private String model;
	private int price;
	private String color;
	
	public Cars() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cars(int carId, String model, int price, String color) {
		super();
		this.carId = carId;
		this.model = model;
		this.price = price;
		this.color = color;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		return Objects.hash(carId, color, model, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cars other = (Cars) obj;
		return carId == other.carId && Objects.equals(color, other.color) && Objects.equals(model, other.model)
				&& price == other.price;
	}

	@Override
	public String toString() {
		return "Cars [carId=" + carId + ", model=" + model + ", price=" + price + ", color=" + color + "]";
	}
	
	
	
	
	
}
