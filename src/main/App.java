package main;

import java.awt.EventQueue;

import tables.*;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;

import player.Player;
import labels.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.Point;

public class App {
	
	private Player pl = Player.shared;

	private JFrame frame;
	private TFObserver txtBonusBaseAtaque;
	private TFObserver txtAtaque2;
	private TFObserver txtRobertLangdon;
	private TFObserver txtCaoticoNeutro;
	private TFObserver txtAtaque3;
	private TFObserver txtAtaque4;
	
	
	private JTable table_1; // Equipable table
	private TFObserver txtvalue_for;
	private TFObserver txtvalue_des;
	private TFObserver txtvalue_con;
	private TFObserver txtvalue_int;
	private TFObserver txtvalue_sab;
	private TFObserver txtvalue_car;
	private TFObserver tf_value_fort;
	private TFObserver tf_value_reflex;
	private TFObserver tf_value_vont;
	private TFObserver tfNivelValue;
	private TFObserver txtExp;
	private TFObserver txtAtaque1;
	private TFObserver txCa;
	private TFObserver txPvAtual;
	private TFObserver txPvTotal;
	
	TableModelPericias pericias = new TableModelPericias();
	TableModelListaSimples equips = new TableModelListaSimples("equipamentos");
	TableModelListaSimples talentos = new TableModelListaSimples("talentos");
	TableModelListaSimples magias = new TableModelListaSimples("magias");

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
		listenAtributes();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		
		JLabel lblNewLabel = new JLabel("Atributos");
		lblNewLabel.setBounds(26, 80, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(26, 6, 46, 16);
		frame.getContentPane().add(lblNome);
		
		txtBonusBaseAtaque = new TFObserver();
		txtBonusBaseAtaque.setText("3");
		txtBonusBaseAtaque.setBounds(147, 272, 67, 26);
		frame.getContentPane().add(txtBonusBaseAtaque);
		txtBonusBaseAtaque.setColumns(10);
		
		txtAtaque2 = new TFObserver();
		txtAtaque2.setText("2d6");
		txtAtaque2.setBounds(26, 385, 193, 30);
		frame.getContentPane().add(txtAtaque2);
		txtAtaque2.setColumns(10);
		
		JLabel lblAtaques = new JLabel("Ataques");
		lblAtaques.setBounds(26, 337, 61, 16);
		frame.getContentPane().add(lblAtaques);
		
		
		JButton btnNewButton = new JButton("Magias");
		btnNewButton.setBounds(644, 228, 117, 29);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_1.setModel(magias);
			}
		});
		
		JButton btnTalentos = new JButton("Talentos");
		btnTalentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_1.setModel(talentos);
			}
		});
		btnTalentos.setBounds(429, 228, 117, 29);
		frame.getContentPane().add(btnTalentos);
		
		JButton btnPericias = new JButton("Pericias");
		btnPericias.setBounds(537, 228, 117, 29);
		frame.getContentPane().add(btnPericias);
		btnPericias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_1.setModel(pericias);
			}
		});
		
		txtRobertLangdon = new TFObserver();
		txtRobertLangdon.setText("Robert Langdon");
		txtRobertLangdon.setBounds(68, 1, 233, 26);
		frame.getContentPane().add(txtRobertLangdon);
		txtRobertLangdon.setColumns(10);
		
		JLabel lblTendencia = new JLabel("Tendencia");
		lblTendencia.setBounds(330, 6, 82, 16);
		frame.getContentPane().add(lblTendencia);
		
		txtCaoticoNeutro = new TFObserver();
		txtCaoticoNeutro.setText("Caotico Neutro");
		txtCaoticoNeutro.setColumns(10);
		txtCaoticoNeutro.setBounds(404, 1, 130, 26);
		frame.getContentPane().add(txtCaoticoNeutro);
		
		JLabel lblNivel = new JLabel("Nivel");
		lblNivel.setBounds(26, 33, 46, 16);
		frame.getContentPane().add(lblNivel);
		
		
		JLabel lblBonusBaseAtaque = new JLabel("Bonus Base Ataque");
		lblBonusBaseAtaque.setBounds(18, 277, 130, 16);
		frame.getContentPane().add(lblBonusBaseAtaque);
		
		JButton btnEquipamentos = new JButton("Equipamentos");
		btnEquipamentos.setBounds(319, 228, 117, 29);
		frame.getContentPane().add(btnEquipamentos);
		btnEquipamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_1.setModel(equips);
			}
		});
		
		
		txtAtaque3 = new TFObserver();
		txtAtaque3.setText("1d6 + 15");
		txtAtaque3.setColumns(10);
		txtAtaque3.setBounds(26, 415, 193, 30);
		frame.getContentPane().add(txtAtaque3);
		
		txtAtaque4 = new TFObserver();
		txtAtaque4.setText("3d8 + 6");
		txtAtaque4.setColumns(10);
		txtAtaque4.setBounds(26, 445, 193, 30);
		frame.getContentPane().add(txtAtaque4);
		
		JLabel lblCa = new JLabel("CA");
		lblCa.setBounds(340, 171, 27, 16);
		frame.getContentPane().add(lblCa);
		
		// Table 1 Tabela dos equipamentos e tudo
		table_1 = new JTable(equips);
		table_1.setBounds(329, 272, 432, 267);
		frame.getContentPane().add(table_1);
		JScrollPane js=new JScrollPane(table_1);
		js.setSize(table_1.getSize());
		js.setLocation(new Point(325, 272));
		js.setVisible(true);
		this.frame.getContentPane().add(js);
		
		
		JLabel lblPv = new JLabel("PV");
		lblPv.setBounds(340, 132, 27, 16);
		frame.getContentPane().add(lblPv);
		
		JLabel lblFor = new JLabel("For");
		lblFor.setBounds(26, 113, 37, 16);
		frame.getContentPane().add(lblFor);
		
		JLabel lblDes = new JLabel("Des");
		lblDes.setBounds(26, 132, 37, 16);
		frame.getContentPane().add(lblDes);
		
		JLabel lblInt = new JLabel("Int");
		lblInt.setBounds(26, 173, 37, 16);
		frame.getContentPane().add(lblInt);
		
		JLabel lblCon = new JLabel("Con");
		lblCon.setBounds(26, 152, 37, 16);
		frame.getContentPane().add(lblCon);
		
		JLabel lblCar = new JLabel("Car");
		lblCar.setBounds(26, 212, 37, 16);
		frame.getContentPane().add(lblCar);
		
		JLabel lblSab = new JLabel("Sab");
		lblSab.setBounds(26, 193, 37, 16);
		frame.getContentPane().add(lblSab);
		
		txtvalue_for = new TFObserver();
		txtvalue_for.setText("10");
		txtvalue_for.setBounds(57, 107, 50, 26);
		frame.getContentPane().add(txtvalue_for);
		txtvalue_for.setColumns(10);
		
		txtvalue_des = new TFObserver();
		txtvalue_des.setText("10");
		txtvalue_des.setColumns(10);
		txtvalue_des.setBounds(57, 127, 50, 26);
		frame.getContentPane().add(txtvalue_des);
		
		txtvalue_con = new TFObserver();
		txtvalue_con.setText("10");
		txtvalue_con.setColumns(10);
		txtvalue_con.setBounds(57, 146, 50, 26);
		frame.getContentPane().add(txtvalue_con);
		
		txtvalue_int = new TFObserver();
		txtvalue_int.setText("10");
		txtvalue_int.setColumns(10);
		txtvalue_int.setBounds(57, 165, 50, 26);
		frame.getContentPane().add(txtvalue_int);
		
		txtvalue_sab = new TFObserver();
		txtvalue_sab.setText("10");
		txtvalue_sab.setColumns(10);
		txtvalue_sab.setBounds(57, 185, 50, 26);
		frame.getContentPane().add(txtvalue_sab);
		
		txtvalue_car = new TFObserver();
		txtvalue_car.setText("10");
		txtvalue_car.setColumns(10);
		txtvalue_car.setBounds(57, 205, 50, 26);
		frame.getContentPane().add(txtvalue_car);
		
		
		// Atribute Observer Labels 
		LBObserver lbmod_for = new LBObserver("0");
		lbmod_for.setBounds(119, 113, 37, 16);
		frame.getContentPane().add(lbmod_for);
		lbmod_for.obs_key = "for";
		pl.addObserver(lbmod_for);
		
		LBObserver lbmod_car = new LBObserver("0");
		lbmod_car.setBounds(119, 212, 37, 16);
		frame.getContentPane().add(lbmod_car);
		lbmod_car.obs_key = "car";
		pl.addObserver(lbmod_car);
		
		LBObserver lbmod_sab = new LBObserver("0");
		lbmod_sab.setBounds(119, 193, 37, 16);
		frame.getContentPane().add(lbmod_sab);
		lbmod_sab.obs_key = "sab";
		pl.addObserver(lbmod_sab);
		
		LBObserver lbmod_int = new LBObserver("0");
		lbmod_int.setBounds(119, 173, 37, 16);
		frame.getContentPane().add(lbmod_int);
		lbmod_int.obs_key = "int";
		pl.addObserver(lbmod_int);
		
		LBObserver lbmod_con = new LBObserver("0");
		lbmod_con.setBounds(119, 152, 37, 16);
		frame.getContentPane().add(lbmod_con);
		lbmod_con.obs_key = "con";
		pl.addObserver(lbmod_con);
		
		LBObserver lbmod_des = new LBObserver("0");
		lbmod_des.setBounds(119, 132, 37, 16);
		frame.getContentPane().add(lbmod_des);
		lbmod_des.obs_key = "des";
		pl.addObserver(lbmod_des);
		//End atributes obs
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 240));
		panel.setBounds(18, 98, 138, 152);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(537, 113, 201, 96);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbFortitude = new JLabel("Fortitude");
		lbFortitude.setBounds(6, 6, 61, 16);
		panel_1.add(lbFortitude);
		
		// Obs
		LBObserver lbFortitude_value = new LBObserver("0");
		lbFortitude_value.setBounds(75, 6, 19, 16);
		panel_1.add(lbFortitude_value);
		lbFortitude_value.obs_key = "fortitude";
		pl.addObserver(lbFortitude_value);
		
		tf_value_fort = new TFObserver();
		tf_value_fort.setBounds(99, 1, 42, 26);
		panel_1.add(tf_value_fort);
		tf_value_fort.setColumns(10);
		
		JLabel lblReflexos = new JLabel("Reflexos");
		lblReflexos.setBounds(6, 31, 61, 16);
		panel_1.add(lblReflexos);
		
		
		// Obs
		LBObserver lbReflexos_value = new LBObserver("0");
		lbReflexos_value.setBounds(75, 31, 19, 16);
		panel_1.add(lbReflexos_value);
		lbReflexos_value.obs_key = "reflexos";
		pl.addObserver(lbReflexos_value);
		
		tf_value_reflex = new TFObserver();
		tf_value_reflex.setColumns(10);
		tf_value_reflex.setBounds(99, 26, 42, 26);
		panel_1.add(tf_value_reflex);
		
		JLabel lblVontade = new JLabel("Vontade");
		lblVontade.setBounds(6, 58, 61, 16);
		panel_1.add(lblVontade);
		
		// Obs
		LBObserver lbVontade_value = new LBObserver("0");
		lbVontade_value.setBounds(75, 58, 19, 16);
		panel_1.add(lbVontade_value);
		lbVontade_value.obs_key = "vontade";
		pl.addObserver(lbVontade_value);
		
		tf_value_vont = new TFObserver();
		tf_value_vont.setColumns(10);
		tf_value_vont.setBounds(99, 53, 42, 26);
		panel_1.add(tf_value_vont);
		
		JLabel lblResistencia = new JLabel("Resistencia");
		lblResistencia.setBounds(537, 90, 107, 16);
		frame.getContentPane().add(lblResistencia);
		
		tfNivelValue = new TFObserver();
		tfNivelValue.setText("10");
		tfNivelValue.setBounds(68, 28, 46, 26);
		frame.getContentPane().add(tfNivelValue);
		tfNivelValue.setColumns(10);
		
		
		JLabel lblClasse = new JLabel("Raça");
		lblClasse.setBounds(141, 33, 46, 16);
		frame.getContentPane().add(lblClasse);
		
		JLabel label_6 = new JLabel("Classe");
		label_6.setBounds(330, 33, 46, 16);
		frame.getContentPane().add(label_6);
		
		CBObserver CBClasse = new CBObserver();
		CBClasse.setModel(new DefaultComboBoxModel(new String[] {"Bardo", "Barbaro", "Clérigo", "Druida", "Feiticeiro", "Guerreiro", "Ladino", "Mago", "Monge", "Paladino", "Ranger", "Sem-Classe"}));
		CBClasse.setBounds(380, 29, 146, 27);
		frame.getContentPane().add(CBClasse);
		CBClasse.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				CBObserver cb = (CBObserver) e.getSource();
				pl.updateData("classe", cb.getSelectedIndex());
				//System.out.println("classe: " + pl.getData("classe"));
			}
		});
		CBClasse.setSelectedIndex( (Integer) pl.getData("classe") ); 
		
		CBObserver CBRaca = new CBObserver();
		CBRaca.setModel(new DefaultComboBoxModel(new String[] {"Anão", "Elfo", "Gnomo", "Halfling", "Humano", "Meio-Orc", "Meio-Elfo"}));
		CBRaca.setBounds(187, 29, 114, 27);
		frame.getContentPane().add(CBRaca);
		CBRaca.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				CBObserver cb = (CBObserver) e.getSource();
				pl.updateData("raca", cb.getSelectedIndex());
				//System.out.println("raca: " + pl.getData("raca"));
			}
		});
		CBRaca.setSelectedIndex( (Integer) pl.getData("raca") );
		
		
		JLabel lblExp = new JLabel("EXP");
		lblExp.setBounds(583, 6, 61, 16);
		frame.getContentPane().add(lblExp);
		
		txtExp = new TFObserver();
		txtExp.setBounds(608, 1, 130, 26);
		frame.getContentPane().add(txtExp);
		txtExp.setColumns(10);
		
		txtAtaque1 = new TFObserver();
		txtAtaque1.setText("2d6 + 1d8");
		txtAtaque1.setColumns(10);
		txtAtaque1.setBounds(26, 355, 193, 30);
		frame.getContentPane().add(txtAtaque1);
		
		txCa = new TFObserver();
		txCa.setBounds(360, 166, 46, 26);
		frame.getContentPane().add(txCa);
		txCa.setColumns(10);
		
		txPvAtual = new TFObserver();
		txPvAtual.setColumns(10);
		txPvAtual.setBounds(360, 127, 45, 26);
		frame.getContentPane().add(txPvAtual);
		
		txPvTotal = new TFObserver();
		txPvTotal.setColumns(10);
		txPvTotal.setBounds(405, 127, 45, 26);
		frame.getContentPane().add(txPvTotal);
		
		JLabel lblTotal = new JLabel("total");
		lblTotal.setBounds(410, 113, 37, 16);
		frame.getContentPane().add(lblTotal);
		
		JLabel lblAtual = new JLabel("atual");
		lblAtual.setBounds(365, 113, 40, 16);
		frame.getContentPane().add(lblAtual);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(220, 220, 220));
		panel_2.setBounds(330, 110, 146, 100);
		frame.getContentPane().add(panel_2);
		
		pl.warnObservers();
	}
	
	private void listenAtributes(){
		this.bindTxtField(txtvalue_for, "for", true);
		this.bindTxtField(txtvalue_des, "des", true);
		this.bindTxtField(txtvalue_con, "con", true);
		this.bindTxtField(txtvalue_int, "int", true);
		this.bindTxtField(txtvalue_sab, "sab", true);
		this.bindTxtField(txtvalue_car, "car", true);
		
		this.bindTxtField(tf_value_fort, "fortitude", true);
		this.bindTxtField(tf_value_reflex, "reflexos", true);
		this.bindTxtField(tf_value_vont, "vontade", true);
		
		this.bindTxtField(tfNivelValue, "nivel", true);
		this.bindTxtField(txtRobertLangdon, "nome", false);
		this.bindTxtField(txtCaoticoNeutro, "tendencia", false);
		this.bindTxtField(txtExp, "exp", false);
		
		this.bindTxtField(txtBonusBaseAtaque, "bonus_base_ataque", true);
		this.bindTxtField(txtAtaque1, "ataque1", false);
		this.bindTxtField(txtAtaque2, "ataque2", false);
		this.bindTxtField(txtAtaque3, "ataque3", false);
		this.bindTxtField(txtAtaque4, "ataque4", false);
		
		this.bindTxtField(txPvAtual, "pv_atual", false);
		this.bindTxtField(txPvTotal, "pv_total", false);
		this.bindTxtField(txCa, "ca", true);
		
	}
	
	//Util 
	private void bindTxtField(final TFObserver tf, final String key, final boolean isInt){
		tf.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) { warn(); }
			public void removeUpdate(DocumentEvent e)  { warn(); }
			public void insertUpdate(DocumentEvent e)  { warn(); }

			public void warn() {

				if (tf.getText().isEmpty()) return;
				
				System.out.println(tf.obs_key + " changed: " + tf.getText());
				
				if (isInt){
					int val = Integer.parseInt(tf.getText());

					if ( val >= 0){
						pl.updateData(key, val);
					}
				}else{
					pl.updateData(key, tf.getText());
				}
			}
		});
		
		tf.obs_key = key;
		pl.addObserver(tf, true);
	}

}
