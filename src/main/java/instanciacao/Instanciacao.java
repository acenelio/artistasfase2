package instanciacao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Album;
import dominio.Artista;
import dominio.Musica;
import servico.AlbumServico;
import servico.ArtistaServico;
import servico.MusicaServico;
import servico.ServicoException;

@WebServlet("/Instanciacao")
public class Instanciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			Artista a1 = new Artista(null, "Caetano Veloso", "BR");
			Artista a2 = new Artista(null, "Roberto Carlos", "BR");
			Artista a3 = new Artista(null, "Bon Jovi", "US");
			Artista a4 = new Artista(null, "Michael Jackson", "US");

			Album ab1 = new Album(null, "Contos Diversos", 1982, a1);
			Album ab2 = new Album(null, "Sinais do Tempo", 1971, a1);
			Album ab3 = new Album(null, "Muitas Emoções", 1990, a2);
			Album ab4 = new Album(null, "Histórias do Interior", 1995, a2);
			Album ab5 = new Album(null, "Crush", 2004, a3);
			Album ab6 = new Album(null, "Cross Road", 2010, a3);
			Album ab7 = new Album(null, "Thriller", 1982, a4);
			Album ab8 = new Album(null, "Bad", 1987, a4);
			
			Musica m01 = new Musica(null, "Fala pra mim", 300, ab1);
			Musica m02 = new Musica(null, "Coisas da vida", 280, ab1);
			Musica m03 = new Musica(null, "Preço da verdade", 310, ab1);
			Musica m04 = new Musica(null, "Caminhos da felicidade", 330, ab2);
			Musica m05 = new Musica(null, "Linda mulher", 290, ab2);
			Musica m06 = new Musica(null, "Amigo do peito", 380, ab2);
			Musica m07 = new Musica(null, "Fora tristeza", 280, ab3);
			Musica m08 = new Musica(null, "Você é linda", 310, ab3);
			Musica m09 = new Musica(null, "Te amo demais", 300, ab3);
			Musica m10 = new Musica(null, "Triste realidade", 345, ab4);
			Musica m11 = new Musica(null, "Como é grande meu amor por você", 360, ab4);
			Musica m12 = new Musica(null, "Deixa pra lá", 310, ab4);
			Musica m13 = new Musica(null, "It's My Life", 270, ab5);
			Musica m14 = new Musica(null, "Say It Isn't So", 260, ab5);
			Musica m15 = new Musica(null, "Thank You for Loving Me", 330, ab5);
			Musica m16 = new Musica(null, "Livin' on a Prayer", 340, ab6);
			Musica m17 = new Musica(null, "Keep the Faith", 310, ab6);
			Musica m18 = new Musica(null, "Someday I'll Be Saturday Night", 320, ab6);
			Musica m19 = new Musica(null, "Beat It", 340, ab7);
			Musica m20 = new Musica(null, "Billie Jean", 350, ab7);
			Musica m21 = new Musica(null, "Thriller", 290, ab7);
			Musica m22 = new Musica(null, "Bad", 275, ab8);
			Musica m23 = new Musica(null, "The Way You Make Me Feel", 310, ab8);
			Musica m24 = new Musica(null, "Man in the Mirror", 290, ab8);
			
			ArtistaServico as = new ArtistaServico();
			AlbumServico abs = new AlbumServico();
			MusicaServico ms = new MusicaServico();
			
			as.inserir(a1);
			as.inserir(a2);
			as.inserir(a3);
			as.inserir(a4);
			
			abs.inserirAtualizar(ab1);
			abs.inserirAtualizar(ab2);
			abs.inserirAtualizar(ab3);
			abs.inserirAtualizar(ab4);
			abs.inserirAtualizar(ab5);
			abs.inserirAtualizar(ab6);
			abs.inserirAtualizar(ab7);
			abs.inserirAtualizar(ab8);
			
			ms.inserirAtualizar(m01);
			ms.inserirAtualizar(m02);
			ms.inserirAtualizar(m03);
			ms.inserirAtualizar(m04);
			ms.inserirAtualizar(m05);
			ms.inserirAtualizar(m06);
			ms.inserirAtualizar(m07);
			ms.inserirAtualizar(m08);
			ms.inserirAtualizar(m09);
			ms.inserirAtualizar(m10);
			ms.inserirAtualizar(m11);
			ms.inserirAtualizar(m12);
			ms.inserirAtualizar(m13);
			ms.inserirAtualizar(m14);
			ms.inserirAtualizar(m15);
			ms.inserirAtualizar(m16);
			ms.inserirAtualizar(m17);
			ms.inserirAtualizar(m18);
			ms.inserirAtualizar(m19);
			ms.inserirAtualizar(m20);
			ms.inserirAtualizar(m21);
			ms.inserirAtualizar(m22);
			ms.inserirAtualizar(m23);
			ms.inserirAtualizar(m24);
			
			response.getWriter().append("Pronto!");
		}
		catch (ServicoException e) {
			response.getWriter().append("Erro! " + e.getMessage());
		}
	}

}
