package main;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.RentalService;
import model.services.USTaxService;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com os dados do aluguel:");
		System.out.print("Modelo do carro: ");
		String carModel = sc.nextLine();
		System.out.print("Reserva (DD/MM/YYYY HH:MM): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), CarRental.ldtf);
		System.out.print("Devolução (DD/MM/YYYY HH:MM): ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), CarRental.ldtf);
		
		CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));
		
		System.out.print("Entre o preço por hora: ");
		double pricePerHour = sc.nextDouble();
		sc.nextLine();
		System.out.print("Entre o preço por dia: ");
		double pricePerDay = sc.nextDouble();
		sc.nextLine();
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new USTaxService());
		rentalService.processInvoice(carRental);
		
		System.out.println("FATURA:");
		System.out.printf("Pagamento básico: %.2f\n",carRental.getInvoice().getBasicPayment());
		System.out.printf("Imposto: %.2f\n", carRental.getInvoice().getTax());
		System.out.printf("Pagamento total: %.2f", carRental.getInvoice().getTotalPayment());
		
		sc.close();
	}

}
