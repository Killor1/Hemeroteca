package hemeroteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class HemerotecaMain {
	public static ArrayList<Magazines> revistes = new ArrayList<Magazines>();
	public static void main(String[] args) throws NumberFormatException, IOException  {
		
		FileAccessor fa=new FileAccessor();
		
		Menu menu = new Menu();
		int opcio = 3;
		while (opcio!=0){
			opcio = menu.menuPral();

			switch (opcio) {

			case 1:				
				System.out.println("1!!");				
				try {				
					fa.readAutorsFile("sources/autors.txt");
					fa.printAutors();
					fa.readMagazinesFile("sources/revistes.txt");
					fa.printRevistes();
					revistes=fa.readArticlesFile("sources/articles.txt");
					mostraRevistes(revistes);
				} catch (NumberFormatException | IOException e) {				
					e.printStackTrace();
				} 
				break;
			case 2:	
				seleccionaRevista(revistes);
				break;
			default:
				System.out.println("Adeu!!");
				System.exit(1);
				break;

			}

		}
		
	}
	public static void mostraRevistes(ArrayList<Magazines> revistes){
		for (Magazines m:revistes){
			System.out.println(m.toString());
		}
	}
	
	public static Magazines seleccionaRevista(ArrayList<Magazines> revistes) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mostraRevistes(revistes);
		System.out.println("Tria una revista (id): ");
		int op=Integer.parseInt(br.readLine());
		Magazines mag=revistes.get(op-1);
		System.out.println(mag.toString());
		List<Articles> art=mag.getArticles();
		for(Articles a:art){
			System.out.println(a.toString());
		}
				
		return mag;		
	}
	public static Magazines seleccionaArticle(Magazines revista){
		//TODO
		
		return null;
		
	}
	
	
	
}
