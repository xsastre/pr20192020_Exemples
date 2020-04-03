package cide.dam.pr20192020.exemple_bd_swing;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Exemple_bd_swing {

	private JFrame frame;
	private JTextField desc;
	private JTextField di;
	private JTextField df;
	private JTextField np;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exemple_bd_swing window = new Exemple_bd_swing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public int CercarAliasalaLlista (List<Enquesta> lllistaenquestes, String cercat) {
		int comptador=0;
		for(Enquesta enquesta : lllistaenquestes) {
			if (enquesta.alias.equals(cercat)) {
				return comptador;
			}
			comptador++;
		}
		return -1;
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public Exemple_bd_swing() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		GestorBD basededades=new GestorBD();
		List<Enquesta> llistaEnquestes=basededades.obtenirEnquestes();
		frame = new JFrame();
		frame.setBounds(100, 100, 637, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNomDescriptiu = new JLabel("Nom descriptiu");
		lblNomDescriptiu.setBounds(12, 153, 127, 15);
		frame.getContentPane().add(lblNomDescriptiu);
		
		desc = new JTextField();
		desc.setBounds(175, 151, 202, 19);
		frame.getContentPane().add(desc);
		desc.setColumns(10);
		
		di = new JTextField();
		di.setColumns(10);
		di.setBounds(175, 173, 202, 19);
		frame.getContentPane().add(di);
		
		JLabel lblDataInici = new JLabel("Data inici");
		lblDataInici.setBounds(12, 175, 127, 15);
		frame.getContentPane().add(lblDataInici);
		
		JLabel lblDataFi = new JLabel("Data fi");
		lblDataFi.setBounds(12, 198, 127, 15);
		frame.getContentPane().add(lblDataFi);
		
		JLabel lblNomDescriptiu_1_1 = new JLabel("Número preguntes");
		lblNomDescriptiu_1_1.setBounds(12, 220, 145, 15);
		frame.getContentPane().add(lblNomDescriptiu_1_1);
		
		df = new JTextField();
		df.setColumns(10);
		df.setBounds(175, 196, 202, 19);
		frame.getContentPane().add(df);
		
		np = new JTextField();
		np.setColumns(10);
		np.setBounds(175, 218, 202, 19);
		frame.getContentPane().add(np);
		
		JList list = new JList(basededades.ObtenirAliesEnquestes(llistaEnquestes));
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Enquesta enq_temp=llistaEnquestes.get(CercarAliasalaLlista(llistaEnquestes,list.getSelectedValue().toString()));
				desc.setText(enq_temp.nom_descriptiu);
				di.setText(enq_temp.data_inici.toLocalDate().toString());
				df.setText(enq_temp.data_fi.toLocalDate().toString());
				np.setText(String.valueOf(enq_temp.numero_preguntes));
			}
		});
		list.setBounds(39, 26, 127, 88);
		frame.getContentPane().add(list);
		
		JLabel lblSeleccionaEnquesta = new JLabel("Selecciona enquesta");
		lblSeleccionaEnquesta.setBounds(192, 62, 185, 15);
		frame.getContentPane().add(lblSeleccionaEnquesta);
	}
}
