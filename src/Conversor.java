import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Conversor extends JFrame {

	private JPanel contentPane;
	private JComboBox opciones;
	private JTextField valor;
	private JButton botonConvertir;
	private JLabel resultado;
	private JLabel lblNewLabel_2;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Conversor() {
		setTitle("Exchange TODAY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conversor Moneda");
		lblNewLabel.setFont(new Font("OCR-A BT", Font.BOLD, 14));
		lblNewLabel.setBounds(42, 27, 174, 29);
		contentPane.add(lblNewLabel);
		
		opciones = new JComboBox();
		opciones.setModel(new DefaultComboBoxModel(new String[] {"Pesos a Dolar", "Dolar a Pesos", "Dolares a Euros", "Euros Libras Esterlinas"}));
		opciones.setBounds(59, 82, 89, 21);
		contentPane.add(opciones);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese un Monton");
		lblNewLabel_1.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(81, 141, 174, 47);
		contentPane.add(lblNewLabel_1);
		
		valor = new JTextField();
		valor.setBounds(267, 150, 135, 32);
		contentPane.add(valor);
		valor.setColumns(10);
		
		botonConvertir = new JButton("Convertir");
		botonConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor2 = valor.getText();
				double valorNum = Double.parseDouble(valor2);
				
				double tipoCambio = 600;
				double resultadoFinal = 0;
				
				DecimalFormat formatear = new DecimalFormat("0.00");
				
				if (opciones.getSelectedIndex()==0) {
					resultadoFinal = (valorNum/tipoCambio);
					resultado.setText("Resultado: " + formatear.format(resultadoFinal));
				}else if(opciones.getSelectedIndex()==1) {
					resultadoFinal = (valorNum*tipoCambio);
					resultado.setText("Resultado: " + formatear.format(resultadoFinal));
					
				}
			}
		});
		botonConvertir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonConvertir.setBounds(260, 223, 152, 53);
		contentPane.add(botonConvertir);
		
		JButton Exit = new JButton("EXIT");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Exit.setBounds(282, 420, 85, 21);
		contentPane.add(Exit);
		
		resultado = new JLabel("0");
		resultado.setFont(new Font("OCR-B 10 BT", Font.BOLD, 17));
		resultado.setBounds(331, 27, 284, 113);
		contentPane.add(resultado);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ASUS\\Pictures\\HD-wallpaper-matrix-ones-title-zeros-movie.jpg"));
		lblNewLabel_2.setBounds(-61, 181, 814, 382);
		contentPane.add(lblNewLabel_2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 101, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("BlackMode");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.BLACK);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
	}
}
