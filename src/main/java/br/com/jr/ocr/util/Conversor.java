package br.com.jr.ocr.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Conversor é reponsável  por receber uma rota de uma imagem e converte-la 
 * para texto editável
 * <p>
 * Por exemplo, se eu passar um caminho de uma imagem  para o construtor de
 * Conversor ele me entregará uma String contendo todo o conteúdo da imagem
 *
 *
 * @author  Jock Rodrigues
 * @since   1.0
 */
public class Conversor {
	
	private String diretorioImagem;
	
	public Conversor(String diretorioImagem) {
		this.diretorioImagem = diretorioImagem;
	}
	
	public void setdiretorioImagem(String diretorioImagem) {
		this.diretorioImagem = diretorioImagem;
	}
	
	public String getdiretorioImagem() {
		return this.diretorioImagem;
	}
	
	public String converte() {
		String command = "tesseract " + diretorioImagem + " stdout";
		return executeCommand(command);
	}
	
	/**
	 * 
	 * Este metodo chamará a biblioteca tesseract passando todos os
	 * paramentros necessários para sua execução.
	 * <p>
	 * Ao final de sua execução ele entregará o resultado da biblioteca
	 * para uma String
	 * 
	 * @param command 		Comando a ser executado no Bash	
	 * @return output		Resultado do comando executado
	 * 
	 */
	
	private String executeCommand(String command) {
		    StringBuffer output = new StringBuffer();
		    Process p;
		    try {
		        p = Runtime.getRuntime().exec(command);
		        p.waitFor();
		        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		 
		        String line = "";
		        while ((line = reader.readLine()) != null) {
		           output.append(line + "\n");
		        }
		 
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return output.toString();
	}
	
}
