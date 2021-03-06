package UASPBO;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.Color;


public class Laporan extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Connection konek = null;
	private JButton btnBack;
	private JFrame frame;
	private JLabel lblLaporan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Laporan frame = new Laporan();
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
	public Laporan() {
		setBackground(new Color(233, 150, 122));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 447);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(233, 150, 122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 64, 594, 299);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLaporan = new JButton("Load Laporan");
		btnLaporan.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnLaporan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
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
		});
		btnLaporan.setBounds(383, 374, 148, 23);
		contentPane.add(btnLaporan);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuUtama().setVisible(true);
				frame.dispose();
			}
		});
		btnBack.setBounds(541, 374, 89, 23);
		contentPane.add(btnBack);
		
		lblLaporan = new JLabel("LAPORAN");
		lblLaporan.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		lblLaporan.setBounds(259, 22, 179, 31);
		contentPane.add(lblLaporan);
	}
}
