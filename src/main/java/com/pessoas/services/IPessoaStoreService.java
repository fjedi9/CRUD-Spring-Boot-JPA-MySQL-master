package com.pessoas.services;

import java.util.List;

import com.pessoas.entity.Pessoa;

public interface IPessoaStoreService {
	
	List<Pessoa> getPessoas();
	Pessoa createPessoa(Pessoa pessoa);
	Pessoa updatePessoa(int pessoaId, Pessoa pessoa);
	Pessoa getPessoa(int pessoaId);
	boolean deletePessoa(int pessoaId);

}
