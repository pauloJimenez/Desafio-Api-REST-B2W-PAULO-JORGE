package desafioapi.paulo.apiRest.servico.impl;

import java.util.List;
import java.util.Optional;
import desafioapi.paulo.apiRest.modelo.planeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import desafioapi.paulo.apiRest.repositorio.planetasRepositorio;
import desafioapi.paulo.apiRest.servico.servicoPlaneta;

@Service
public class servicoPlanetaImpl implements servicoPlaneta {

	@Autowired
    private planetasRepositorio repositorio;
	
	@Override
	public planeta adicionar(planeta plan) {				
				    				      
		return repositorio.saveCustom(plan);
	}

	@Override
	public List<planeta> ListarPlanetas() {
		
		return this.repositorio.findAll();
	}

	@Override
	public planeta buscaPorNome(String nome) {
		
		return this.repositorio.findByNome(nome);
	}

	@Override
	public Optional<planeta> buscaPorID(String id) {
		
		return  this.repositorio.findById(id);
	}

	@Override
	public void removerPlaneta(String id) {
		
		repositorio.deleteById(id);

	}

}
