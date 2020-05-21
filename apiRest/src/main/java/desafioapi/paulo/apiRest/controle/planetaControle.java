package desafioapi.paulo.apiRest.controle;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import desafioapi.paulo.apiRest.modelo.planeta;
import desafioapi.paulo.apiRest.resposta.resposta;
import desafioapi.paulo.apiRest.servico.servicoPlaneta;

@RestController
public class planetaControle {

	
	@Autowired
	private servicoPlaneta servico;
	
	
	//ADICIONAR PLANETAS
	@PostMapping(path = "/planetas")
	@ResponseBody	
	public ResponseEntity<resposta<planeta>> adicionarPlaneta(@Valid @RequestBody planeta planeta,BindingResult resultado ) {		
		
		  if(resultado.hasErrors()) { List<String> erros = new ArrayList<String>();
		  resultado.getAllErrors().forEach(erro ->
		  erros.add(erro.getDefaultMessage()));
		  
		  return ResponseEntity.badRequest().body(new resposta<planeta>(erros)); }
		 										
		return ResponseEntity.ok(new resposta<planeta>(this.servico.adicionar(planeta)));		

	}
	
	//LISTAR PLANETAS
	@GetMapping(path = "/planetas")
	public ResponseEntity<List<planeta>> listarPlanetas() {
		if(servico.ListarPlanetas().isEmpty()) {
			return ResponseEntity.notFound().build(); 
		}
		
		return ResponseEntity.ok(this.servico.ListarPlanetas());
	}
	
	//BUSCAR PLANETA POR NOME
	@GetMapping(path = "/planetas/nome/{nome}")	
	public ResponseEntity<planeta> buscarPlanetaPorNome(@PathVariable("nome") String nome) {								
		
		return ResponseEntity.ok(servico.buscaPorNome(nome));
	}
	
	//BUSCAR PLANETA POR ID
	@GetMapping(path = "/planetas/{id}")
	public ResponseEntity<Optional<planeta>> buscarPlanetaPorID(@PathVariable("id") String id) {				
		
		return ResponseEntity.ok(servico.buscaPorID(id));
	}
	
	//REMOVER PLANETAS
	@DeleteMapping(path = "/planetas/{id}")
	public ResponseEntity<Boolean> removerPlaneta(@PathVariable("id") String id) {			
		
		servico.removerPlaneta(id);			
			
		return ResponseEntity.ok(true);
	}
}
