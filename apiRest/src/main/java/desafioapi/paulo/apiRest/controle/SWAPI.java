package desafioapi.paulo.apiRest.controle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SWAPI {

	private static int HTTP_COD_SUCESSO = 200;
	
	public SWAPI() {
		
	}
	
	public Integer retornaQtdFilmes(String planeta) {
			
			String linha = null;      
			
			Integer qtdFilmes=0;
			
			 try {			 		
				 
				 URL url = new URL("https://swapi.dev/api/planets/?search="+planeta);			 	
				 	
				 HttpURLConnection con = (HttpURLConnection) url.openConnection();		 				 		
		 		
				 if (con.getResponseCode() != HTTP_COD_SUCESSO) {
					 throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
				 }
	
	            
				 BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
	           
	         			            	
				 while ((linha = br.readLine()) != null ) {   	              	                
					 if (linha.indexOf("films")!=-1 && !linha.contains("[")){						 						 
						 
						 qtdFilmes+=1;
		        		   
					 }
				 } 
	            			           
				 con.disconnect();			            
			            
		        } 
			 	catch (MalformedURLException e) { e.printStackTrace(); }
			 	catch (IOException e)           { e.printStackTrace(); }		
			
			 return qtdFilmes;
			 
		}
		
}
