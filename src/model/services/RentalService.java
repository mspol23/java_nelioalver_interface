package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	
	private Double pricePerHour;
	private Double pricePerDay;
	
	private BrazilTaxService taxService;
	
	public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}

	public Double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public Double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public BrazilTaxService getTaxService() {
		return taxService;
	}

	public void setTaxService(BrazilTaxService taxService) {
		this.taxService = taxService;
	}

	public void processInvoice (CarRental carRental) {
		
		double durationInMinutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
		double hours = durationInMinutes / 60;
		double basicPayment;
		
		if (hours > 12) {
			basicPayment = Math.ceil(hours / 24) * this.getPricePerDay();
		} else {
			basicPayment = Math.ceil(hours) * this.getPricePerHour();
		}
		
		double tax = this.taxService.tax(basicPayment);
				
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
}
