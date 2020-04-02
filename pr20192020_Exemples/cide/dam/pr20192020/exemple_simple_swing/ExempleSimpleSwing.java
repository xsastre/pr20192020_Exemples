package cide.dam.pr20192020.exemple_simple_swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExempleSimpleSwing {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExempleSimpleSwing window = new ExempleSimpleSwing();
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
	public ExempleSimpleSwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEtiqueta = new JLabel("etiqueta");
		lblEtiqueta.setBounds(143, 12, 153, 20);
		frame.getContentPane().add(lblEtiqueta);
		
		JButton btnBoto = new JButton("Confirmar");
		btnBoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblEtiqueta.setText("Hola Mon");
			}
		});
		btnBoto.setBounds(167, 149, 117, 25);
		frame.getContentPane().add(btnBoto);
	}

}
