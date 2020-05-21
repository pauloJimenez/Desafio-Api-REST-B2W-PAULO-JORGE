package desafioapi.paulo.apiRest.modelo;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "planetas")
public class planeta {

	private String  id;	
	
	@NotEmpty(message = "O Nome não pode ser vazio")
	private String  nome;	
	
	@NotEmpty(message = "O Clima não pode ser vazio")
	private String  clima;	
	
	@NotEmpty(message = "O Terreno não pode ser vazio")
	private String  terreno;
	
	private Integer qtd_Aparicoes_Filme;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	public String getTerreno() {
		return terreno;
	}
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	public Integer getQtd_Aparicoes_Filme() {
		return qtd_Aparicoes_Filme;
	}
	public void setQtd_Aparicoes_Filme(Integer qtd_Aparicoes_Filme) {
		this.qtd_Aparicoes_Filme = qtd_Aparicoes_Filme;
	}
	
}
