package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_artistas")
public class Artista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codArtista;
	private String nome;
	private String nacionalidade;
	
	@OneToMany(mappedBy="artista")
	private List<Album> albuns;

	public Artista() {
		albuns = new ArrayList<>();
	}

	public Artista(Integer codArtista, String nome, String nacionalidade) {
		this.codArtista = codArtista;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		albuns = new ArrayList<>();
	}

	public Integer getCodArtista() {
		return codArtista;
	}

	public void setCodArtista(Integer codArtista) {
		this.codArtista = codArtista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public List<Album> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(List<Album> albuns) {
		this.albuns = albuns;
	}

	public void addAlbum(Album x) {
		this.albuns.add(x);
	}
	
	public void removeAlbum(Album x) {
		this.albuns.remove(x);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codArtista == null) ? 0 : codArtista.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artista other = (Artista) obj;
		if (codArtista == null) {
			if (other.codArtista != null)
				return false;
		} else if (!codArtista.equals(other.codArtista))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Artista [codArtista=" + codArtista + ", nome=" + nome + ", nacionalidade=" + nacionalidade + "]";
	}

}
