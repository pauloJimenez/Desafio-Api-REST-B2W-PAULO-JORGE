package desafioapi.paulo.apiRest.resposta;

import java.util.List;

@SuppressWarnings("hiding")
public class resposta<Object> {

	private Object dados;
	private List<String> erros;
	
	public resposta(Object dados) {
		
		this.setDados(dados);
		
	}
	
	public resposta(List<String> erros) {
		
		this.setErros(erros);
	}

	public Object getDados() {
		return dados;
	}

	public void setDados(Object dados) {
		this.dados = dados;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}
	
}
