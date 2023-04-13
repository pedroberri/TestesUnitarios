import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {

    static Scanner sc = new Scanner(System.in);

    private Biblioteca biblioteca;

    @BeforeEach
    public void setUp() {
        biblioteca = new Biblioteca("Biblioteca-1");
    }

    @Test
    public void testGetAndSetNome() {
        String nome = sc.next();
        biblioteca.setNome(criarBiblioteca(nome).getNome());
        assertEquals(criarBiblioteca(nome).getNome(), biblioteca.getNome());
    }

    @Test
    public void testGetLivros() {
        List<Livro> livros = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            System.out.println(i + ": ");
            Livro livro = criarLivro(sc.next(),sc.next(),sc.next(),sc.nextInt());
            livros.add(livro);
        }
        for (Livro livro : livros) {
            biblioteca.adicionarLivro(livro);
        }
        assertEquals(livros, biblioteca.getLivros());
    }

    @Test
    public void testAdicionarLivro() {
        String titulo = sc.next();
        String autor = sc.next();
        String genero = sc.next();
        int ano = sc.nextInt();
        Livro livroNull = null;
        assertTrue(biblioteca.adicionarLivro(criarLivro(titulo,autor,genero,ano)));
        assertFalse(biblioteca.adicionarLivro(livroNull));
    }

    @Test
    public void testRemoverLivro() {
        String titulo = sc.next();
        String autor = sc.next();
        String genero = sc.next();
        int ano = sc.nextInt();
        assertTrue(biblioteca.removerLivro(criarLivro(titulo,autor,genero,ano)));
    }

    @Test
    public void testBuscarLivroPorTitulo() {
        String titulo = sc.next();
        Livro livro = criarLivro(titulo, sc.next(), sc.next(), sc.nextInt());
        assertEquals(livro, biblioteca.buscarLivroPorTitulo(titulo));
    }

    @Test
    public void testBuscarLivrosPorAutor() {
        String titulo = sc.next();
        String autor = sc.next();
        String genero = sc.next();
        int ano = sc.nextInt();
        List<Livro> livros = biblioteca.buscarLivrosPorAutor(criarLivro(titulo,autor,genero,ano).getAutor());
        assertInstanceOf(List.class, livros);
        assertInstanceOf(Livro.class, livros.get(0));
    }

    @Test
    public void testBuscarLivrosPorGenero() {
        String titulo = sc.next();
        String autor = sc.next();
        String genero = sc.next();
        int ano = sc.nextInt();
        List<Livro> livros = biblioteca.buscarLivrosPorGenero(criarLivro(titulo,autor,genero,ano).getGenero());
        assertInstanceOf(List.class, livros);
        assertInstanceOf(Livro.class, livros.get(0));
    }

    @Test
    public void testGetQuantidadeLivros() {
        List<Livro> livros = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            System.out.println(i + ": ");
            Livro livro = criarLivro(sc.next(),sc.next(),sc.next(),sc.nextInt());
            livros.add(livro);
        }
        for (Livro livro : livros) {
            biblioteca.adicionarLivro(livro);
        }
        assertEquals(livros.size(), biblioteca.getQuantidadeLivros());
    }

    public Biblioteca criarBiblioteca(String nome) {
        Biblioteca biblioteca1;
        biblioteca1 = new Biblioteca(nome);
        return biblioteca1;
    }

    public Livro criarLivro(String titulo, String autor, String genero, int ano) {
        Livro livro;
        livro = new Livro(titulo, autor, genero, ano);
        return livro;
    }
}
