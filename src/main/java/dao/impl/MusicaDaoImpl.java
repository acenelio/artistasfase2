package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.MusicaDao;
import dominio.Album;
import dominio.Musica;

public class MusicaDaoImpl implements MusicaDao {

	private EntityManager em;

	public MusicaDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Musica x) {
		if (x.getCodMusica() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Musica x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Musica buscar(int cod) {
		return em.find(Musica.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Musica> buscarTodos() {
		String jpql = "SELECT x FROM Musica x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Musica> buscarPorAlbum(Album alb) {
		String jpql = "SELECT x FROM Musica x WHERE x.album = :p1";
		Query query = em.createNamedQuery(jpql);
		query.setParameter("p1", alb);
		return query.getResultList();
	}
}
