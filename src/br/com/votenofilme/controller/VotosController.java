package br.com.votenofilme.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;

@Resource
public class VotosController {

	@Get
	public void index() {
		System.out.println("entoru" );
	}
	
}
