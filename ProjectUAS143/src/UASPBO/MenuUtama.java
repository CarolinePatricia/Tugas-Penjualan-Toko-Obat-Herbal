package UASPBO;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuUtama extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUtama frame = new MenuUtama();
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
	public MenuUtama() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 472);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(233, 150, 122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFormProduct = new JButton("Product");
		btnFormProduct.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnFormProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Product().setVisible(true);
				frame.dispose();
			}
		});
		btnFormProduct.setBounds(41, 66, 258, 52);
		contentPane.add(btnFormProduct);
		
		JButton btnFormSupplier = new JButton("Supplier");
		btnFormSupplier.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnFormSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Supplier().setVisible(true);
				frame.dispose();
			}
		});
		btnFormSupplier.setBounds(41, 125, 258, 48);
		contentPane.add(btnFormSupplier);
		
		JButton btnFormStockBarang = new JButton("Stock Barang");
		btnFormStockBarang.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnFormStockBarang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StockBarang().setVisible(true);
				frame.dispose();
			}
		});
		btnFormStockBarang.setBounds(41, 186, 258, 48);
		contentPane.add(btnFormStockBarang);
		
		JLabel lblMenuUtama = new JLabel("Menu Utama");
		lblMenuUtama.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		lblMenuUtama.setBounds(259, 11, 181, 48);
		contentPane.add(lblMenuUtama);
		
		JButton btnFormMenuUser = new JButton("Menu User");
		btnFormMenuUser.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnFormMenuUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuUser().setVisible(true);
				frame.dispose();
			}
		});
		btnFormMenuUser.setBounds(364, 186, 258, 48);
		contentPane.add(btnFormMenuUser);
		
		JButton btnLaporan = new JButton("Laporan");
		btnLaporan.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnLaporan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Laporan().setVisible(true);
				frame.dispose();
			}
		});
		btnLaporan.setBounds(364, 125, 258, 48);
		contentPane.add(btnLaporan);
		
		JButton btnKeluar = new JButton("Keluar");
		btnKeluar.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnKeluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnKeluar.setBounds(514, 277, 93, 23);
		contentPane.add(btnKeluar);
		
		JButton btnNewButton = new JButton("Penjualan");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Penjualan().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(364, 66, 258, 52);
		contentPane.add(btnNewButton);
	}
}
