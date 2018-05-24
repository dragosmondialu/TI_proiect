package servicii.web;

public class Carte {
	private int id;
	private String isbn;
	private String titlu;
	private String autor;
	private String gen;
	private boolean disponibilitate;

	public Carte(int id, String isbn, String titlu, String autor,
			String gen, boolean disponibilitate) {
		this.id = id;
		this.isbn = isbn;
		this.titlu = titlu;
		this.autor = autor;
		this.gen = gen;
		this.disponibilitate = disponibilitate;
	}
	public int getId() {
		return id;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getTitlu() {
		return titlu;
	}
	public String getAutor() {
		return autor;
	}
	public String getGen() {
		return gen;
	}
	public boolean getDisponibilitate() {
		return disponibilitate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Carte [titlu = ").append(titlu)
			.append(", autor = ").append(autor).append(", gen = ")
			.append(gen).append(", disponibilitate = ").append(disponibilitate).append("]");
		return builder.toString();
	}
}
