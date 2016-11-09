package dao;

import dao.impl.AlbumDaoImpl;
import dao.impl.ArtistaDaoImpl;
import dao.impl.MusicaDaoImpl;

public class DaoFactory {

	public static ArtistaDao criarArtistaDao() {
		return new ArtistaDaoImpl();
	}

	public static AlbumDao criarAlbumDao() {
		return new AlbumDaoImpl();
	}

	public static MusicaDao criarMusicaDao() {
		return new MusicaDaoImpl();
	}
}
