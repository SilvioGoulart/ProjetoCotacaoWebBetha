package org.bairro.apistart.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.bairro.apistart.entidades.Cotacoes;

@Stateless
public class CotacoesServices {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	public Cotacoes getById(Integer id) throws Exception {
		Cotacoes entity = manager.find(Cotacoes.class, id);
		if (entity == null) {
			throw new Exception("Cotação não encontrada!");
		}
		return entity;
	}

	public List<Cotacoes> getAll() {
		return manager.createQuery("select e from Cotacoes e", Cotacoes.class).getResultList();
	}

	public Cotacoes salvar(Cotacoes entity) throws Exception {
		validar(entity);
		manager.persist(entity);
		return entity;
	}

	public Cotacoes atualizar(Cotacoes entity) throws Exception {
		validar(entity);
		manager.merge(entity);
		return entity;
	}

	public void deletar(Integer id) throws Exception {

		Cotacoes entity = getById(id);
		manager.remove(entity);
	}

	public List<Cotacoes> getByIdProduto(Integer idProduto) {
		TypedQuery<Cotacoes> query = manager.createQuery("select e from Cotacoes e where e.produto.idProduto = :id",
				Cotacoes.class);
		query.setParameter("id", idProduto);
		return query.getResultList();
	}

	private void validar(Cotacoes entity) throws Exception {

		if (entity.getProduto() == null || entity.getProduto().getIdProduto() == null) {
			throw new Exception("O produto deve ser informado!");
		}

	}

}
