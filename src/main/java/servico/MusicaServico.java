package servico;

import java.util.List;

import dao.DaoFactory;
import dao.MusicaDao;
import dao.Transaction;
import dominio.Album;
import dominio.Musica;

public class MusicaServico {

	private MusicaDao dao;
	
	public MusicaServico() {
		dao = DaoFactory.criarMusicaDao();
	}
	
	public void inserirAtualizar(Musica x) {
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
	
	public void excluir(Musica x) {
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
	
	public Musica buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Musica> buscarTodos() {
		return dao.buscarTodos();
	}
	
	public List<Musica> buscarPorAlbum(Album alb) {
		return dao.buscarPorAlbum(alb);
	}
	
}
