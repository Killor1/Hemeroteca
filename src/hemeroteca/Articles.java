package hemeroteca;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Articles implements Serializable {
	int id_article;
	String titol;
	Date data_creacio;
	boolean publicable;
	public Authors autor;
	  
	public Articles(int id_article, String titol, Date data_creacio,
			boolean publicable, Authors autor) {
		super();
		this.id_article = id_article;
		this.titol = titol;
		this.data_creacio = data_creacio;
		this.publicable = publicable;
		this.autor=autor;
	}
	public Articles() {
		super();
		
	}
	
	public int getId_article() {
		return id_article;
	}
	public void setId_article(int id_article) {
		this.id_article = id_article;
	}
	public String getTitol() {
		return titol;
	}
	public void setTitol(String titol) {
		this.titol = titol;
	}
	public Date getData_creacio() {
		return data_creacio;
	}
	public void setData_creacio(Date data_creacio) {
		this.data_creacio = data_creacio;
	}
	
	public boolean isPublicable() {
		return publicable;
	}
	public void setPublicable(boolean publicable) {
		this.publicable = publicable;
	}
	public Authors getAutor() {
		return autor;
	}
	public void setAutor(Authors autor) {
		this.autor = autor;
	}
	@Override
	public String toString() {
		return "Article [id_article=" + id_article + ", titol=" + titol
				+ ", data_creacio=" + data_creacio + ", publicable="
				+ publicable + "]";
	}
	

}