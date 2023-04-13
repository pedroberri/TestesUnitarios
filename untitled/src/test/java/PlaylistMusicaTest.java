import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistMusicaTest {

    static Scanner sc = new Scanner(System.in);

    private PlaylistMusica playlistMusica;

    @BeforeEach
    public void setUp() {
        playlistMusica = new PlaylistMusica("Playlist-1");
    }

    @Test
    public void testGetAndSetNome() {
        String nome = sc.next();
        playlistMusica.setNome(criarPlaylist(nome).getNome());
        assertEquals(criarPlaylist(nome).getNome(), playlistMusica.getNome());
    }

    @Test
    public void testGetMusicas() {
        List<Musica> musicas = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            System.out.println(i + ": ");
            Musica musica = criarMusica(sc.next(),sc.next(),sc.nextInt());
            musicas.add(musica);
        }
        for (Musica musica : musicas) {
            playlistMusica.adicionarMusica(musica);
        }
        assertEquals(musicas, playlistMusica.getMusicas());
    }

    @Test
    public void testAdicionarMusicas() {
        assertTrue(playlistMusica.adicionarMusica(criarMusica(sc.next(), sc.next(), sc.nextInt())));
        assertFalse(playlistMusica.adicionarMusica(null));
    }

    @Test
    public void testRemoverMusica() {
        Musica musica = criarMusica(sc.next(), sc.next(), sc.nextInt());
        assertFalse(playlistMusica.removerMusica(musica));
        playlistMusica.adicionarMusica(musica);
        assertTrue(playlistMusica.removerMusica(musica));
    }

    @Test
    public void testBuscarMusicasPorTitulo() {
        String titulo = sc.next();
        Musica musica = criarMusica(titulo, sc.next(), sc.nextInt());
        assertEquals(musica, playlistMusica.buscarMusicaPorTitulo(titulo));
    }

    @Test
    public void testBuscarMusicasPorArtista() {
        String titulo = sc.next();
        String artista = sc.next();
        int duracao = sc.nextInt();
        List<Musica> musicas = playlistMusica.buscarMusicasPorArtista(criarMusica(titulo,artista,duracao).getArtista());
        assertInstanceOf(List.class, musicas);
        assertInstanceOf(Livro.class, musicas.get(0));
    }

    @Test
    public void ordenaListaPorTitulo(){
        Musica musica1 = new Musica("Moon","Kanye West",200);
        Musica musica2 = new Musica("Wet Dreamz","J. Cole",200);
        Musica musica3 = new Musica("Lucid Dreams","Juice WRLD",200);

        assertTrue(playlistMusica.adicionarMusica(musica1));
        assertTrue(playlistMusica.adicionarMusica(musica2));
        assertTrue(playlistMusica.adicionarMusica(musica3));

        playlistMusica.ordenarPorTitulo();
        assertEquals(musica1, playlistMusica.getMusicas().get(0));
        assertEquals(musica2, playlistMusica.getMusicas().get(1));
        assertEquals(musica3, playlistMusica.getMusicas().get(2));
    }

    @Test
    public void ordenaListaPorArtista(){
        Musica musica1 = new Musica("Moon","Kanye West",200);
        Musica musica2 = new Musica("Wet Dreamz","J. Cole",200);
        Musica musica3 = new Musica("Lucid Dreams","Juice WRLD",200);

        assertTrue(playlistMusica.adicionarMusica(musica1));
        assertTrue(playlistMusica.adicionarMusica(musica2));
        assertTrue(playlistMusica.adicionarMusica(musica3));

        playlistMusica.ordenarPorArtista();
        assertEquals(musica1, playlistMusica.getMusicas().get(0));
        assertEquals(musica3, playlistMusica.getMusicas().get(1));
        assertEquals(musica2, playlistMusica.getMusicas().get(2));
    }

    @Test
    public void testGetQuantidadeMusicas() {
        List<Musica> musicas = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            System.out.println(i + ": ");
            Musica musica = criarMusica(sc.next(),sc.next(),sc.nextInt());
            musicas.add(musica);
        }
        for (Musica musica : musicas) {
            playlistMusica.adicionarMusica(musica);
        }
        assertEquals(musicas.size(), playlistMusica.getQuantidadeMusicas());
    }

    public PlaylistMusica criarPlaylist(String nome) {
        PlaylistMusica playlistMusica1;
        playlistMusica1 = new PlaylistMusica(nome);
        return playlistMusica1;
    }

    public Musica criarMusica(String titulo, String artista, int duracao) {
        Musica musica;
        musica = new Musica(titulo, artista, duracao);
        return musica;
    }
}
