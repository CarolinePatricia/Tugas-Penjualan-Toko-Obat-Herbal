package UASPBO;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Penjualan extends JFrame {

	protected static final String Hasil_stock = null;
	private Connection konek = null;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtIDPenjualan;
	private JTextField txtNCustomer;
	private JTextField txtIDProduct;
	private JTextField txtNProduct;
	private JTextField txtJumlah;
	private JTextField txtHarga;
	private JTextField txtTgl;
	private JTextField txtTotal;
	private JTextField txtStock;
	private JTextField txtSisaStock;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Penjualan frame = new Penjualan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void refresh()
	{
		try {
			 Class.forName(Koneksi.DATABASE_DRIVER);
			 konek=DriverManager.getConnection(Koneksi.URL, Koneksi.USERNAME, Koneksi.PASSWORD);
			String query="select * from DetilTransaksi";
			PreparedStatement pst=konek.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Penjualan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(233, 150, 122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdTranskasi = new JLabel("ID Penjualan");
		lblIdTranskasi.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblIdTranskasi.setBounds(13, 61, 93, 14);
		contentPane.add(lblIdTranskasi);
		
		JLabel lblTgl = new JLabel("tgl");
		lblTgl.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTgl.setBounds(13, 95, 46, 14);
		contentPane.add(lblTgl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(13, 219, 835, 231);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtIDPenjualan = new JTextField();
		txtIDPenjualan.setBounds(131, 61, 211, 20);
		contentPane.add(txtIDPenjualan);
		txtIDPenjualan.setColumns(10);
		
		JLabel lblNamaSupplier = new JLabel("Nama Customer");
		lblNamaSupplier.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNamaSupplier.setBounds(13, 130, 93, 14);
		contentPane.add(lblNamaSupplier);
		
		txtNCustomer = new JTextField();
		txtNCustomer.setColumns(10);
		txtNCustomer.setBounds(131, 130, 211, 20);
		contentPane.add(txtNCustomer);
		
		JLabel lblIdProduk = new JLabel("ID Produk");
		lblIdProduk.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblIdProduk.setBounds(13, 169, 71, 14);
		contentPane.add(lblIdProduk);
		
		txtIDProduct = new JTextField();
		txtIDProduct.setColumns(10);
		txtIDProduct.setBounds(131, 166, 138, 20);
		contentPane.add(txtIDProduct);
		
		JButton btnCari = new JButton("Cari");
		btnCari.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					Class.forName(Koneksi.DATABASE_DRIVER);
					konek=DriverManager.getConnection(Koneksi.URL, Koneksi.USERNAME, Koneksi.PASSWORD);
					String query="select ID, Nama, Harga, stock from Products where ID=?";
					PreparedStatement pst=konek.prepareStatement(query);
					pst.setString(1, txtIDProduct.getText());
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						txtIDProduct.setText(rs.getString("ID"));
						txtNProduct.setText(rs.getString("Nama"));
						txtHarga.setText(rs.getString("Harga"));
						txtStock.setText(rs.getString("stock"));
					}
					
					pst.close();

				}
				catch (Exception ex)
				{
					ex.printStackTrace();

				}
			}
		});
		btnCari.setBounds(276, 165, 66, 23);
		contentPane.add(btnCari);
		
		JLabel lblNamaProduk = new JLabel("Nama Produk");
		lblNamaProduk.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNamaProduk.setBounds(370, 64, 93, 14);
		contentPane.add(lblNamaProduk);
		
		txtNProduct = new JTextField();
		txtNProduct.setColumns(10);
		txtNProduct.setBounds(465, 61, 211, 20);
		contentPane.add(txtNProduct);
		
		JLabel lblJumlah = new JLabel("Jumlah");
		lblJumlah.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblJumlah.setBounds(370, 95, 71, 14);
		contentPane.add(lblJumlah);
		
		txtJumlah = new JTextField();
		txtJumlah.setColumns(10);
		txtJumlah.setBounds(465, 92, 93, 20);
		contentPane.add(txtJumlah);
		
		JLabel lblTotal = new JLabel("Harga");
		lblTotal.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTotal.setBounds(588, 95, 71, 14);
		contentPane.add(lblTotal);
		
		txtHarga = new JTextField();
		txtHarga.setColumns(10);
		txtHarga.setBounds(630, 92, 119, 20);
		contentPane.add(txtHarga);
		
		JLabel lblTransaksi = new JLabel("PENJUALAN");
		lblTransaksi.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		lblTransaksi.setBounds(405, 10, 357, 39);
		contentPane.add(lblTransaksi);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try 
				{
					Class.forName(Koneksi.DATABASE_DRIVER);
					konek=DriverManager.getConnection(Koneksi.URL, Koneksi.USERNAME, Koneksi.PASSWORD);
				 	String query="insert into DetilTransaksi(ID,ID_Transaksi,Nama,Harga,Jumlah) values (?,?,?,?,?)";			 	
					PreparedStatement pst=konek.prepareStatement(query);
					pst.setString(1,txtIDProduct.getText());
					pst.setString(2,txtIDPenjualan.getText());
					pst.setString(3,txtNProduct.getText());
					pst.setString(4, txtHarga.getText());
					pst.setString(5, txtJumlah.getText());				
					
					pst.execute();


					JOptionPane.showMessageDialog(null, "data saved");
					pst.close();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
	
				refresh();
			}
		});
		btnSave.setBounds(630, 165, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuUtama().setVisible(true);
				frame.dispose();
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnExit.setBounds(759, 165, 89, 23);
		contentPane.add(btnExit);
		
		txtTgl = new JTextField();
		txtTgl.setColumns(10);
		txtTgl.setBounds(131, 92, 211, 20);
		contentPane.add(txtTgl);
		
		JLabel lblTotal_1 = new JLabel("Total");
		lblTotal_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		lblTotal_1.setBounds(588, 130, 71, 14);
		contentPane.add(lblTotal_1);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(630, 127, 211, 20);
		contentPane.add(txtTotal);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Jumlah = txtJumlah.getText();
				String Harga = txtHarga.getText();
				String Stock = txtStock.getText();
				
				 int Jumlah_J = Integer.parseInt(Jumlah);
				 int Harga_H = Integer.parseInt(Harga);
				 int S_Stock = Integer.parseInt(Stock);
				 int Total = Jumlah_J * Harga_H;
				 int sStock = S_Stock - Jumlah_J;
				 
				 String Hasil = String.valueOf(Total);
				 txtTotal.setText(Hasil);
				 String Hasil_Stock = String.valueOf(sStock);
				 txtSisaStock.setText(Hasil_Stock);
				 
				 try 
					{
						Class.forName(Koneksi.DATABASE_DRIVER);
						konek=DriverManager.getConnection(Koneksi.URL, Koneksi.USERNAME, Koneksi.PASSWORD);
					 	String query="insert into Transaksi(ID_Transaksi,Nama,Tanggal_Jual,Harga_Total) values (?,?,?,?)";
					 	String query1="Update Products set stock='"+txtSisaStock.getText()+"' where ID='"+txtIDProduct.getText()+"' ";
						PreparedStatement pst=konek.prepareStatement(query);
						PreparedStatement pst1=konek.prepareStatement(query1);
						pst.setString(1,txtIDPenjualan.getText());
						pst.setString(3,txtNCustomer.getText());
						pst.setString(4,txtTgl.getText());
						pst.setString(5, txtHarga.getText());
						pst.setString(7, txtTotal.getText());
						
						
						pst.execute();
						pst1.execute();


						JOptionPane.showMessageDialog(null, "data saved");
						pst.close();
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
		
					refresh();

			}
		});
		btnTotal.setBounds(759, 91, 89, 23);
		contentPane.add(btnTotal);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(465, 127, 93, 20);
		contentPane.add(txtStock);
		
		txtSisaStock = new JTextField();
		txtSisaStock.setColumns(10);
		txtSisaStock.setBounds(465, 166, 93, 20);
		contentPane.add(txtSisaStock);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblStock.setBounds(370, 130, 71, 14);
		contentPane.add(lblStock);
		
		JLabel lblSisaStock = new JLabel("Sisa Stock");
		lblSisaStock.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSisaStock.setBounds(370, 169, 71, 14);
		contentPane.add(lblSisaStock);
		
		refresh();
	}
}
