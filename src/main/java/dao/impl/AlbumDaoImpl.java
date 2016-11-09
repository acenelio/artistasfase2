package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.AlbumDao;
import dominio.Album;
import dominio.Artista;

public class AlbumDaoImpl implements AlbumDao {

	private EntityManager em;

	public AlbumDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Album x) {
		if (x.getCodAlbum() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Album x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Album buscar(int cod) {
		return em.find(Album.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Album> buscarTodos() {
		String jpql = "SELECT x FROM Album x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Album> buscarPorArtista(Artista art) {
		String jpql = "SELECT x FROM Album x WHERE x.artista = :p1";
		Query query = em.createNamedQuery(jpql);
		query.setParameter("p1", art);
		return query.getResultList();
	}

}

