package br.com.fiap.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Setup;
import br.com.fiap.model.User;
import br.com.fiap.util.EntityManagerFacade;

public class SetupDAO {
	
	private EntityManager manager = new EntityManagerFacade().getEntityManager();

	public void save(Setup setup) {
		manager.getTransaction().begin();
		manager.persist(setup);
		manager.getTransaction().commit();
		manager.clear();
	}
	
	public List<Setup> getAll(){
		String jpql = "SELECT s FROM Setup s";
		TypedQuery<Setup> createQuery = manager.createQuery(jpql, Setup.class);
		return createQuery.getResultList();
	}

	public Setup findById(Long id) {
		return manager.find(Setup.class, id);
		
	}

	public void update(Setup setup) {
		manager.getTransaction().begin();
		manager.merge(setup);
		manager.flush();
		manager.getTransaction().commit();
		
	}

	public void delete(Setup setup) {
		manager.getTransaction().begin();
		manager.remove(setup);
		manager.flush();
		manager.getTransaction().commit();
	}

	public List<Setup> getByUser(User user) {
		System.out.println(user.getId());
		String jpql = "SELECT s FROM Setup s WHERE user_id = :user_id";; 
		TypedQuery<Setup> query = manager.createQuery(jpql, Setup.class).setParameter("user_id", user.getId());
		List<Setup> resultList = query.getResultList();
		if (resultList == null || resultList.isEmpty()) {
			return Collections.emptyList();
		}
		return resultList;
	}
}
