package br.com.jr.ocr.util;

import javax.swing.JFileChooser;

public class Upload {
	
	private JFileChooser arquivo;
	private String path;
	
	public Upload() {
		this.arquivo = new JFileChooser();
	}
	
	public String getPath() {
		return this.path;
	}
	
	public void abrirArquivo() {
		Integer retorno = arquivo.showOpenDialog(null);
		
		if (retorno == JFileChooser.APPROVE_OPTION) {
			this.path = arquivo.getSelectedFile().toString();
		}
		
	}
	
	
	

}
