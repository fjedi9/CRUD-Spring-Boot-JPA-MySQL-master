package com.pessoas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pessoas.entity.Pessoa;

@Transactional
@Repository
public class PessoaStoreDAO implements IPessoaStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> getPessoas() {
		
		String hql = "FROM Pessoa as atcl ORDER BY atcl.id";
		return (List<Pessoa>) entityManager.createQuery(hql).getResultList();
	}

	
	@Override
	public Pessoa getPessoa(int pessoaId) {
		
		return entityManager.find(Pessoa.class, pessoaId);
	}

	@Override
	public Pessoa createPessoa(Pessoa pessoa) {
		entityManager.persist(pessoa);
		Pessoa p = getLastInsertedPessoa();
		return p;
	}

	
	@Override
	public Pessoa updatePessoa(int pessoaId, Pessoa pessoa) {
		
		Pessoa pessoaFromDB = getPessoa(pessoaId);
		pessoaFromDB.setNome(pessoa.getNome());
		pessoaFromDB.setIdade(pessoa.getIdade());
		pessoaFromDB.setSexo(pessoa.getSexo());
		pessoaFromDB.setEndereco(pessoa.getEndereco());
		
		
		entityManager.flush();
		
		//again i am taking updated result of book and returning the book object
		Pessoa updatedPessoa = getPessoa(pessoaId);
		
		return updatedPessoa;
	}

	
	@Override
	public boolean deletePessoa(int pessoaId) {
		Pessoa pessoa = getPessoa(pessoaId);
		entityManager.remove(pessoa);
		
		boolean status = entityManager.contains(pessoa);
		if(status){
			return false;
		}
		return true;
	}
	
	
	private Pessoa getLastInsertedPessoa(){
		String hql = "from Pessoa order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Pessoa pessoa = (Pessoa)query.getSingleResult();
		return pessoa;
	}

}
