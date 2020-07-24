package com.pessoas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoas.dao.IPessoaStoreDAO;
import com.pessoas.entity.Pessoa;

@Service
public class PessoaStoreService implements IPessoaStoreService {
	
	@Autowired
	private IPessoaStoreDAO dao;

	@Override
	public List<Pessoa> getPessoas() {
		return dao.getPessoas();
	}

	@Override
	public Pessoa createPessoa(Pessoa pessoa) {
		return dao.createPessoa(pessoa);
	}

	@Override
	public Pessoa updatePessoa(int pessoaId, Pessoa pessoa) {
		return dao.updatePessoa(pessoaId, pessoa);
	}

	@Override
	public Pessoa getPessoa(int pessoaId) {
		return dao.getPessoa(pessoaId);
	}

	@Override
	public boolean deletePessoa(int pessoaId) {
		return dao.deletePessoa(pessoaId);
	}

}
