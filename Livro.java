public class Livro {
    private Autor autor;
    private String titulo;
    private String ISBN;
    private String gênero;
    private String categoria;

    public Livro (String ISBN, String titulo, Autor autor, String categoria, String gênero){
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.gênero = gênero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getGênero() {
        return gênero;
    }

    //===
}