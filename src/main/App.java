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
	private JTextField txtBonusBaseAtaque;
	private JTextField txtdd;
	private JTextField txtRobertLangdon;
	private JTextField txtCaoticoNeutro;
	private JTextField txtd;
	private JTextField txtd_1;
	
	private String[][] atributes = {{"Str", "18", "+4"}, {"Dex", "12", "+1"}, {"Con", "15", "+2"}};
	private String[] collums_1 = {"Atributo", "valor", "modificador"};
	private TableModel modelAtributes;
	
	private String[][] resistences = {{"Fortitude", "18"}, {"Reflexos", "12"}, {"Vontade", "15"}};
	private String[] collums_2 = {"Resistencia", "valor"};
	private TableModel modelResistences;
	
	
	private JTable table_1; // Generic Equipable table
	private JTable table_Resistence;

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
		
		modelAtributes = new DefaultTableModel(atributes, collums_1);
		modelResistences = new DefaultTableModel(resistences, collums_2);
		
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
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(75);
		progressBar.setBounds(359, 124, 146, 26);
		frame.getContentPane().add(progressBar);
		
		JLabel lblPvpvAtual = new JLabel("14/20");
		lblPvpvAtual.setBounds(383, 112, 107, 16);
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
		btnTalentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
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
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setValue(75);
		progressBar_1.setBounds(26, 47, 146, 26);
		frame.getContentPane().add(progressBar_1);
		
		JLabel labelNivelDescription = new JLabel("10");
		labelNivelDescription.setBounds(78, 33, 46, 16);
		frame.getContentPane().add(labelNivelDescription);
		
		JLabel lblCa = new JLabel("CA");
		lblCa.setBounds(359, 157, 27, 16);
		frame.getContentPane().add(lblCa);
		
		table_1 = new JTable();
		table_1.setBounds(329, 272, 432, 206);
		frame.getContentPane().add(table_1);
		
		table_Resistence = new JTable(modelResistences);
		table_Resistence.setBounds(641, 113, 120, 60);
		frame.getContentPane().add(table_Resistence);
		table_Resistence.setEnabled(false);
		
		JLabel lblPv = new JLabel("PV");
		lblPv.setBounds(359, 112, 27, 16);
		frame.getContentPane().add(lblPv);
		
		JLabel labelCA_number = new JLabel("17");
		labelCA_number.setBounds(383, 157, 27, 16);
		frame.getContentPane().add(labelCA_number);
		
	}
	
}
