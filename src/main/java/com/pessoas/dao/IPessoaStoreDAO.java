package com.pessoas.dao;

import java.util.List;

import com.pessoas.entity.Pessoa;

public interface IPessoaStoreDAO {
	
	List<Pessoa> getPessoas();
	Pessoa getPessoa(int pessoaId);
	Pessoa createPessoa(Pessoa pessoa);
	Pessoa updatePessoa(int pessoaId,Pessoa pessoa);
	boolean deletePessoa(int pessoaId);

}
