package hemeroteca;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
	private int option;

	public Menu() {
		super();
	}

	public int menuPral() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {
			
			System.out.println(" \nMENU PRINCIPAL \n");

			System.out.println("1. Carrega dades. ");
			System.out.println("2. Consulta dades. ");
			
			System.out.println("0. Sortir. ");

			System.out.println("Esculli opci�: ");
			try {
				option = Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {
				System.out.println("valor no v�lid");
				e.printStackTrace();
			}
		} while (option != 1  && option != 0 && option!=2);

		return option;
	}

	
	
	
	

}