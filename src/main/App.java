package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JProgressBar;

public class App {

	private JFrame frame;
	private JTable table;
	private JTextField txtCa;
	private JTextField txtBonusBaseAtaque;
	private JTextField txtdd;
	private JTextField txtRobertLangdon;
	private JTextField txtCaoticoNeutro;
	private JTextField textField_2;
	private JTextField txtd;
	private JTextField txtd_1;
	
	
	private String[][] atributes = {{"Str", "18", "+4"}, {"Dex", "12", "+1"}, {"Con", "15", "+2"}};
	private String[] collums = {"Atributo", "valor", "modificador"};
	private TableModel modelAtributes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		modelAtributes = new DefaultTableModel(atributes, collums);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		table = new JTable(this.modelAtributes);
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(255, 255, 240));
		table.setBounds(26, 113, 193, 200);
		frame.getContentPane().add(table);
		table.setRowSelectionAllowed(false);
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		table.setDefaultEditor(Object.class, null);
		table.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("Atributos");
		lblNewLabel.setBounds(26, 85, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(26, 6, 46, 16);
		frame.getContentPane().add(lblNome);
		
		txtCa = new JTextField();
		txtCa.setText("CA");
		txtCa.setBounds(359, 152, 67, 26);
		frame.getContentPane().add(txtCa);
		txtCa.setColumns(10);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(75);
		progressBar.setBounds(359, 124, 146, 26);
		frame.getContentPane().add(progressBar);
		
		JLabel lblPvpvAtual = new JLabel("PV/PV Atual");
		lblPvpvAtual.setBounds(359, 113, 146, 16);
		frame.getContentPane().add(lblPvpvAtual);
		
		txtBonusBaseAtaque = new JTextField();
		txtBonusBaseAtaque.setText("3");
		txtBonusBaseAtaque.setBounds(155, 329, 67, 26);
		frame.getContentPane().add(txtBonusBaseAtaque);
		txtBonusBaseAtaque.setColumns(10);
		
		txtdd = new JTextField();
		txtdd.setText("2d6 + 1d8");
		txtdd.setBounds(26, 400, 193, 26);
		frame.getContentPane().add(txtdd);
		txtdd.setColumns(10);
		
		JLabel lblAtaques = new JLabel("Ataques");
		lblAtaques.setBounds(26, 382, 61, 16);
		frame.getContentPane().add(lblAtaques);
		
		JButton btnNewButton = new JButton("Magias");
		btnNewButton.setBounds(644, 228, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnTalentos = new JButton("Talentos");
		btnTalentos.setBounds(429, 228, 117, 29);
		frame.getContentPane().add(btnTalentos);
		
		JButton btnPericias = new JButton("Pericias");
		btnPericias.setBounds(537, 228, 117, 29);
		frame.getContentPane().add(btnPericias);
		
		txtRobertLangdon = new JTextField();
		txtRobertLangdon.setText("Robert Langdon");
		txtRobertLangdon.setBounds(68, 1, 233, 26);
		frame.getContentPane().add(txtRobertLangdon);
		txtRobertLangdon.setColumns(10);
		
		JLabel lblTendencia = new JLabel("Tendencia");
		lblTendencia.setBounds(335, 6, 82, 16);
		frame.getContentPane().add(lblTendencia);
		
		txtCaoticoNeutro = new JTextField();
		txtCaoticoNeutro.setText("Caotico Neutro");
		txtCaoticoNeutro.setColumns(10);
		txtCaoticoNeutro.setBounds(404, 1, 130, 26);
		frame.getContentPane().add(txtCaoticoNeutro);
		
		JLabel lblNivel = new JLabel("Nivel");
		lblNivel.setBounds(26, 33, 46, 16);
		frame.getContentPane().add(lblNivel);
		
		textField_2 = new JTextField();
		textField_2.setText("10");
		textField_2.setColumns(10);
		textField_2.setBounds(68, 28, 61, 26);
		frame.getContentPane().add(textField_2);
		
		JLabel lblBonusBaseAtaque = new JLabel("Bonus Base Ataque");
		lblBonusBaseAtaque.setBounds(26, 334, 130, 16);
		frame.getContentPane().add(lblBonusBaseAtaque);
		
		JButton btnEquipamentos = new JButton("Equipamentos");
		btnEquipamentos.setBounds(319, 228, 117, 29);
		frame.getContentPane().add(btnEquipamentos);
		
		txtd = new JTextField();
		txtd.setText("1d6 + 15");
		txtd.setColumns(10);
		txtd.setBounds(26, 426, 193, 26);
		frame.getContentPane().add(txtd);
		
		txtd_1 = new JTextField();
		txtd_1.setText("3d8 + 6");
		txtd_1.setColumns(10);
		txtd_1.setBounds(26, 454, 193, 26);
		frame.getContentPane().add(txtd_1);
	}
	
}
