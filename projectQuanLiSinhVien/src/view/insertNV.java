package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.control;
import control.controlInsert;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import model.phongban;
import model.nhanvien;
import control.control;
public class insertNV extends JFrame {

	public JPanel contentPane;
	//JComboBox<> comboBox;
	/**
	 * Launch the application.
	 *
	/**
	 * Create the frame.
	 */
	public JComboBox<phongban> comboBox;
	public JTextArea ID;
    public JTextArea hoten;
	public JTextArea ngayvaolam;
	public ArrayList<phongban> arr;
	public JTextArea ngaysinh;
	public view v;
	public void fakeData() throws IOException, ClassNotFoundException
	{
		for(phongban x : v.arr)
		{
			comboBox.addItem(x);
		}
	}
	
	

	public insertNV(view v) throws ClassNotFoundException, IOException {
		this.v = v;
		//////
		setBackground(new Color(0, 255, 255));
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(600,400);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel phongban = new JLabel("Chọn phòng ban");
		phongban.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		phongban.setBounds(10, 10, 226, 46);
		contentPane.add(phongban);
		
		comboBox = new JComboBox<phongban>();
		comboBox.setBackground(new Color(255, 255, 0));
		comboBox.setBounds(282, 10, 279, 46);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		contentPane.add(comboBox);
		
		JLabel lblNhpM = new JLabel("Nhập mã");
		lblNhpM.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		lblNhpM.setBounds(10, 66, 226, 46);
		contentPane.add(lblNhpM);
		
		JLabel lblNhpHTn = new JLabel("Nhập họ tên");
		lblNhpHTn.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		lblNhpHTn.setBounds(10, 122, 226, 46);
		contentPane.add(lblNhpHTn);
		
		JLabel lblNhpNgyVo = new JLabel("Ngày vào làm");
		lblNhpNgyVo.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		lblNhpNgyVo.setBounds(10, 178, 226, 46);
		contentPane.add(lblNhpNgyVo);
		
		ID = new JTextArea();
		ID.setBounds(282, 66, 279, 46);
		ID.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		contentPane.add(ID);
		
		hoten = new JTextArea();
		hoten.setBounds(282, 122, 279, 46);
		hoten.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		contentPane.add(hoten);
		
		ngayvaolam = new JTextArea();
		ngayvaolam.setBounds(282, 178, 279, 46);
		ngayvaolam.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		contentPane.add(ngayvaolam);
		
		JLabel lblNhpNgyVo_1 = new JLabel("Ngày sinh");
		lblNhpNgyVo_1.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		lblNhpNgyVo_1.setBounds(10, 233, 226, 46);
		contentPane.add(lblNhpNgyVo_1);
		
		ngaysinh = new JTextArea();
		ngaysinh.setBounds(282, 234, 279, 46);
		ngaysinh.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		contentPane.add(ngaysinh);
		
		
		//////////////
		fakeData();
	/*	for(phongban p : arr)
		{
			System.out.println(p);
			for(nhanvien n : p.getDsnv())
			{
				System.out.println(n);
			}
		}*/
		////////////
		controlInsert ac = new controlInsert(this);
		
		JButton insert = new JButton("INSERT");
		insert.setBackground(new Color(0, 255, 255));
		insert.setFont(new Font("Times New Roman", Font.PLAIN, 33));
		insert.addActionListener(ac);
		insert.setBounds(211, 300, 181, 53);
		contentPane.add(insert);
		this.setLocationRelativeTo(null);

	    //////////////////////
		
		
		//////////////
		this.setVisible(true);
	}
	public void insert()
	{
		
	}
}
