package br.com.caelum.livraria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.util.ForwardView;

@ManagedBean
@ViewScoped
public class AutorBean {

	private Autor autor = new Autor();

	public Autor getAutor() {
		return autor;
	}
	
	public List<Autor> getAutores() {
		return new DAO<Autor>(Autor.class).listaTodos();
	}

	public ForwardView gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());
		
		if(this.autor.getId() == null) {			
			new DAO<Autor>(Autor.class).adiciona(this.autor);
		}
		else {
			new DAO<Autor>(Autor.class).atualiza(this.autor);
		}


		this.autor = new Autor();
		
		return new ForwardView("livro");
	}
	
	public void remover(Autor autor) {
		System.out.println("metodo de remover o autor: " + autor);
		new DAO<Autor>(Autor.class).remove(autor);
	}
	
	public void carregar(Autor autor) {
		System.out.println("metodo de carregar o autor: " + autor);
		this.autor = autor;
	}
	
}
