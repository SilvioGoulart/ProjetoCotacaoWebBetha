package org.bairro.apistart.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.bairro.apistart.entidades.Produtos;

@Stateless
public class ProdutosServices {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	public Produtos getById(Integer id) throws Exception {
		Produtos entity = manager.find(Produtos.class, id);
		if (entity == null) {
			throw new Exception("Produto não encontrado!");
		}
		return entity;
	}

	public List<Produtos> getAll() {
		return manager.createQuery("select e from Produtos e", Produtos.class).getResultList();
	}

	public Produtos salvar(Produtos entity) throws Exception {
		validar(entity);
		manager.persist(entity);
		return entity;
	}

	public Produtos atualizar(Produtos entity) throws Exception {
		validar(entity);
		manager.merge(entity);
		return entity;
	}

	public void deletar(Integer id) throws Exception {
		Produtos entity = getById(id);
		manager.remove(entity);
	}

	private void validar(Produtos entity) throws Exception {
		if (entity.getDescricao() == null || entity.getDescricao().isEmpty()) {
			throw new Exception("Descrição deve ser informada!");
		}
		if (entity.getNome() == null || entity.getNome().isEmpty()) {
			throw new Exception("O nome deve ser informado!");
		}

	}

}