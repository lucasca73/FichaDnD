package main;

import java.awt.EventQueue;
import tables.TableModelPericias;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;

import player.Pericia;
import player.Player;
import labels.LBObserver;
import labels.TFObserver;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class App {
	
	private Player pl = Player.shared;

	private JFrame frame;
	private TFObserver txtBonusBaseAtaque;
	private TFObserver txtdd;
	private TFObserver txtRobertLangdon;
	private TFObserver txtCaoticoNeutro;
	private TFObserver txtd;
	private TFObserver txtd_1;
	
	
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
	private TFObserver textField_5;
	private TFObserver textField;
	private TFObserver textField_1;
	private TFObserver textField_2;
	private TFObserver textField_3;

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
		
		txtdd = new TFObserver();
		txtdd.setText("2d6");
		txtdd.setBounds(26, 385, 193, 30);
		frame.getContentPane().add(txtdd);
		txtdd.setColumns(10);
		
		JLabel lblAtaques = new JLabel("Ataques");
		lblAtaques.setBounds(26, 337, 61, 16);
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
		
		txtd = new TFObserver();
		txtd.setText("1d6 + 15");
		txtd.setColumns(10);
		txtd.setBounds(26, 415, 193, 30);
		frame.getContentPane().add(txtd);
		
		txtd_1 = new TFObserver();
		txtd_1.setText("3d8 + 6");
		txtd_1.setColumns(10);
		txtd_1.setBounds(26, 445, 193, 30);
		frame.getContentPane().add(txtd_1);
		
		JLabel lblCa = new JLabel("CA");
		lblCa.setBounds(340, 171, 27, 16);
		frame.getContentPane().add(lblCa);
		
		
		ArrayList<Pericia> ps = new ArrayList<Pericia>();
		Pericia p = new Pericia("Cavalgar", "des");
		ps.add(p);
		
		TableModelPericias model = new TableModelPericias(ps);
		pl.addObserver(model);
		
		// Table 1 Tabela dos equipamentos e tudo
		table_1 = new JTable(model);
		table_1.setBounds(329, 272, 432, 267);
		frame.getContentPane().add(table_1);
		
		p.setGraduacao(5);
		
		
		
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
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Bardo", "Barbaro", "Guerreiro", "Ranger", "Paladino", "Feiticeiro", "Mago", "Druida", "Clérigo"}));
		comboBox.setBounds(380, 29, 146, 27);
		frame.getContentPane().add(comboBox);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"Anão", "Humano", "Meio-Orc", "Elfo", "Meio-Elfo", "Halfling"}));
		comboBox_1.setBounds(187, 29, 114, 27);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblExp = new JLabel("EXP");
		lblExp.setBounds(583, 6, 61, 16);
		frame.getContentPane().add(lblExp);
		
		textField_5 = new TFObserver();
		textField_5.setBounds(608, 1, 130, 26);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField = new TFObserver();
		textField.setText("2d6 + 1d8");
		textField.setColumns(10);
		textField.setBounds(26, 355, 193, 30);
		frame.getContentPane().add(textField);
		
		textField_1 = new TFObserver();
		textField_1.setBounds(360, 166, 46, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new TFObserver();
		textField_2.setColumns(10);
		textField_2.setBounds(360, 127, 46, 26);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new TFObserver();
		textField_3.setColumns(10);
		textField_3.setBounds(400, 127, 46, 26);
		frame.getContentPane().add(textField_3);
		
		JLabel lblTotal = new JLabel("total");
		lblTotal.setBounds(405, 113, 37, 16);
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
		this.bindTxtField(txtvalue_for, "for");
		this.bindTxtField(txtvalue_des, "des");
		this.bindTxtField(txtvalue_con, "con");
		this.bindTxtField(txtvalue_int, "int");
		this.bindTxtField(txtvalue_sab, "sab");
		this.bindTxtField(txtvalue_car, "car");
		
		this.bindTxtField(tf_value_fort, "fortitude");
		this.bindTxtField(tf_value_reflex, "reflexos");
		this.bindTxtField(tf_value_vont, "vontade");
	}
	
	//Util 
	private void bindTxtField(final TFObserver tf, final String key){
		tf.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) { warn(); }
			public void removeUpdate(DocumentEvent e)  { warn(); }
			public void insertUpdate(DocumentEvent e)  { warn(); }

			public void warn() {

				if (tf.getText().isEmpty()) return;

				int val = Integer.parseInt(tf.getText());

				if ( val >= 0){
					pl.updateData(key, val);
				}
			}
		});
		
		tf.obs_key = key;
		pl.addObserver(tf, true);
	}

}
