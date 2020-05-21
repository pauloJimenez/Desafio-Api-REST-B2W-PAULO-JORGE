package desafioapi.paulo.apiRest.servico;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import desafioapi.paulo.apiRest.modelo.planeta;

public interface servicoPlaneta {	
	
	
	//adicionar planeta
	planeta adicionar(planeta planeta);			
	
	//listar planetas
	List<planeta> ListarPlanetas();
	
	//buscar por nome do planeta
	planeta buscaPorNome(String nome);
	
	//buscar por ID do planeta
	Optional<planeta> buscaPorID(String id);
	
	//remover planeta
	void removerPlaneta(String id); 
	
}
