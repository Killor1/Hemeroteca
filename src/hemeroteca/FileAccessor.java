package hemeroteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;

@SuppressWarnings("unused")
public class FileAccessor {

	ArrayList<Authors> llistaAutors = new ArrayList<Authors>();
	ArrayList<Magazines> llistaRevistes = new ArrayList<Magazines>();

	public FileAccessor() {
	}
	
	public void readAutorsFile(String filename) throws IOException {
		int id;
		String name, year, country;
		boolean active;

		BufferedReader br = new BufferedReader(new FileReader(filename));
		String linea = "";
		while ((linea = br.readLine()) != null) {
			StringTokenizer str = new StringTokenizer(linea, ",");
			id = Integer.parseInt(str.nextToken());
			name = str.nextToken();
			year = str.nextToken();
			country = str.nextToken();
			active = Boolean.parseBoolean(str.nextToken());
			// System.out.println(id + name + country + year + active);
			llistaAutors.add(new Authors(id, name, country, year, active));

		}
		br.close();
	}

	public void printAutors() {
		for (int i = 0; i < llistaAutors.size(); i++) {
			System.out.println(llistaAutors.get(i).toString());
		}
	}

	public void printRevistes() {
		
		for (int i = 0; i < llistaRevistes.size(); i++) {
			System.out.println(llistaRevistes.get(i).toString());
		}
	}
	public void readMagazinesFile(String filename) throws IOException {
		int id;
		String titol;
		Date date;
		DateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd");

		BufferedReader br = new BufferedReader(new FileReader(filename));
		String linea = "";
		while ((linea = br.readLine()) != null) {
			StringTokenizer str = new StringTokenizer(linea, ",");
			id = Integer.parseInt(str.nextToken());
			titol = str.nextToken();
			try {
				date = dateformat.parse(str.nextToken());
				Magazines mag=new Magazines(id,titol,date);
				llistaRevistes.add(mag);
			} catch (ParseException e) {
				System.err.println(" errada format data al fitxer");
				e.printStackTrace();
			}
		}
		br.close();
	}

	public ArrayList<Magazines> readArticlesFile(String filename) throws IOException {
		int idArticle, idRevista, idAutor;
		String titol;
		Date data_creacio=null;
		boolean publicable;
		DateFormat dateformat = new SimpleDateFormat("YYYY-MM-DD");

		BufferedReader br = new BufferedReader(new FileReader(filename));
		String linea = "";
		while ((linea = br.readLine()) != null) {
			StringTokenizer str = new StringTokenizer(linea, ",");
			idArticle=Integer.parseInt(str.nextToken());
			idRevista=Integer.parseInt(str.nextToken());
			idAutor=Integer.parseInt(str.nextToken());
			titol=str.nextToken();
			try {
				data_creacio = dateformat.parse(str.nextToken());
			}catch (ParseException e) {
			System.err.println(" errada format data al fitxer");
			e.printStackTrace();
			}
			publicable=Boolean.parseBoolean(str.nextToken());
			Authors autor=llistaAutors.get(idAutor-1);
			Articles art=new Articles(idArticle,titol,data_creacio,publicable,autor);
			for (Magazines m:llistaRevistes){
				if(m.getId_revista()==idRevista){
					System.out.println("Articulo añadido");
					m.addArticle(art);
				}
			}
			System.out.println(art.toString()+ art.getAutor().toString());
		}
		return llistaRevistes;		
	}	
}
