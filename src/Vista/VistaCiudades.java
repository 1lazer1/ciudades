package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorCiudades;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaCiudades extends JFrame {

	private JPanel contentPane;
	private JTextField Ciudad;
	private JTextField CodigoPostal;
	private ControladorCiudades controlador = new ControladorCiudades();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCiudades frame = new VistaCiudades();
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
	public VistaCiudades() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Ciudad = new JTextField();
		Ciudad.setBounds(10, 44, 86, 20);
		contentPane.add(Ciudad);
		Ciudad.setColumns(10);
		
		CodigoPostal = new JTextField();
		CodigoPostal.setBounds(126, 44, 71, 20);
		contentPane.add(CodigoPostal);
		CodigoPostal.setColumns(10);
		
		JButton Aceptar = new JButton("ok");
		Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			if(!controlador.exiteenbasdedatos(Ciudad.getText())) {
				
				controlador.guardarenbasesededatos(Ciudad.getText(), Integer.parseInt(CodigoPostal.getText()));
				
			}else {
				
				
				controlador.modificarenbasadedatos(Ciudad.getText(),Integer.parseInt(CodigoPostal.getText()));
				
			}
				
		
				
			}
		});
		Aceptar.setBounds(227, 43, 53, 23);
		contentPane.add(Aceptar);
		
		JLabel lblNewLabel = new JLabel("Ciudad");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(26, 28, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo postal");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(126, 28, 71, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton lista = new JButton("lista");
		lista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, controlador.listarbasededatos());
				
				
			}
		});
		lista.setBounds(290, 43, 89, 23);
		contentPane.add(lista);
		
		JButton btnEliminar = new JButton("eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(controlador.exiteenbasdedatos(Ciudad.getText())) {
					
					controlador.eliminardelabasededatos(Ciudad.getText());
					
				}else {
					
					
					JOptionPane.showInternalMessageDialog(null, "No existe");
					
				}
			}
		});
		btnEliminar.setBounds(227, 77, 89, 23);
		contentPane.add(btnEliminar);
	}
}
