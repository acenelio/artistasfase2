package servico;

import java.util.List;

import dao.AlbumDao;
import dao.DaoFactory;
import dao.Transaction;
import dominio.Album;
import dominio.Artista;
import dominio.Musica;

public class AlbumServico {

	private AlbumDao dao;
	
	public AlbumServico() {
		dao = DaoFactory.criarAlbumDao();
	}
	
	public void inserirAtualizar(Album x) {
		try {
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void excluir(Album x) {
		try {
			Transaction.begin();
			dao.excluir(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public Album buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Album> buscarTodos() {
		return dao.buscarTodos();
	}

	public List<Album> buscarPorArtista(Artista art) {
		return dao.buscarPorArtista(art);
	}
		
}
