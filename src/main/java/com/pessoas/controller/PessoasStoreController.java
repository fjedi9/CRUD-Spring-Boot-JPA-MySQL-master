package com.pessoas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pessoas.entity.Pessoa;
import com.pessoas.services.IPessoaStoreService;

import lombok.Data;
@Data
@Controller
@RequestMapping("pessoasservice")
public class PessoasStoreController {
	
	@Autowired
	private IPessoaStoreService service;
	
	@GetMapping("pessoas")
	public ResponseEntity<List<Pessoa>> getPessoas(){
		
		List<Pessoa> pessoas = service.getPessoas();
		return new ResponseEntity<List<Pessoa>>(pessoas, HttpStatus.OK);
		
	}
	
	@GetMapping("pessoas/{id}")
	public ResponseEntity<Pessoa> getPessoa(@PathVariable("id") Integer id){
		Pessoa pessoa = service.getPessoa(id);
		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
	}
	
	@PostMapping("pessoas")
	public ResponseEntity<Pessoas> createPessoa(@RequestBody Pessoas pessoas){
		Pessoa p = service.createBook(pessoas);
		return new ResponseEntity<Pessoa>(p, HttpStatus.OK);
		
	}
	
	@PutMapping("books/{id}")
	public ResponseEntity<Pessoa> updatePessoa(@PathVariable("id") int id, @RequestBody Pessoa pessoa){
		
		Pessoa p = service.updatePessoa(id, pessoa);
		return new ResponseEntity<Pessoa>(p, HttpStatus.OK);
	}
	
	@DeleteMapping("pessoas/{id}")
	public ResponseEntity<String> deletePessoa(@PathVariable("id") int id){
		boolean isDeleted = service.deletePessoa(id);
		if(isDeleted){
			String responseContent = "Pessoa has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting book from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
