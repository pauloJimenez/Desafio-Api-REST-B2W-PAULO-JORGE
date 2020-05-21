package desafioapi.paulo.apiRest.repositorio;

//import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import desafioapi.paulo.apiRest.controle.SWAPI;
import desafioapi.paulo.apiRest.modelo.planeta;

public interface planetasRepositorio extends MongoRepository<planeta, String>, planetasRepositorioCustom{
		
	planeta findByNome(String nome);
	
	@Override
	default planeta saveCustom(planeta plan) {
		
		Integer qtdFilmes;
		
		//ATUALIZA QUANTIDADE DE APARIÇÕES EM FILMES
		SWAPI swapi = new SWAPI();
		     
		qtdFilmes = swapi.retornaQtdFilmes(plan.getNome());
		
		plan.setQtd_Aparicoes_Filme(qtdFilmes);
		
		return save(plan);
		
	}
	
}
