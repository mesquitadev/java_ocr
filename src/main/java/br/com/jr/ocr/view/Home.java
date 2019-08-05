package br.com.jr.ocr.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import br.com.jr.ocr.util.Conversor;
import br.com.jr.ocr.util.Upload;

public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		this.build();
		this.drawComponents();
	}
	
	private void build() {
		setTitle("ReadOCR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 436);
		getContentPane().setLayout(null);	
	}
	
	private void drawComponents() {
		//textArea
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 87, 619, 306);
		getContentPane().add(textArea);
		
		//jButton
		JButton btnCarregarImagem = new JButton("Carregar Imagem");
		
		btnCarregarImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				
					Upload up = new Upload();
					up.abrirArquivo();
					String path = up.getPath();
					
					if (path != null) {
						Conversor c = new Conversor(path);
						textArea.setText(c.converte());
					} else {
						JOptionPane.showMessageDialog(null, "Você não selecionou uma imagem."); 
					}
				
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
				}
				
				
			}
		});
		
		btnCarregarImagem.setBounds(211, 29, 213, 23);
		getContentPane().add(btnCarregarImagem);
		
		
		
	}

}
