package view;


import javax.swing.JFrame;

import model.nhanvien;
import model.phongban;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle.Control;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import control.control;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class view extends JFrame {

   private JTextField ma;
   private JTextField hoten;
   private JTextField ngaylam;
   private JTextField ngaysinh;
   public  JComboBox<phongban> comboBox;
   JButton save;
   JButton delete;
   JButton exit;
   public  JList<nhanvien> lsNV;
   public ArrayList<phongban> arr;
   SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
   private JButton insert;
   
   
	/**
	 * Launch the application.

	/**
	 * Create the frame.
	 */
    public void fakedata()
    {
       arr = new ArrayList<phongban>();
       phongban p1 = new phongban("001","Quản lí nhân sự", new Vector<nhanvien>());
       phongban p2 = new phongban("002","Marketing", new Vector<nhanvien>());
       phongban p3 = new phongban("003","Bán sản phẩm", new Vector<nhanvien>());
       phongban p4 = new phongban("004","Kế toán, kiểm toán", new Vector<nhanvien>());
       
       arr.add(p1);
       arr.add(p2);
       arr.add(p3);
       arr.add(p4);
       
       for(phongban p : arr)
       {
    	   comboBox.addItem(p);
       }
       
       nhanvien n1 = new nhanvien("001","Lê Minh Hoàng", new Date(2020-1900,1,1),new Date(2003-1900,1,29), p4);
       nhanvien n2 = new nhanvien("002","Trương Văn Hoài", new Date(2020-1900,1,1),new Date(2003-1900,1,29), p1);
       nhanvien n3 = new nhanvien("003","Tô Phương Hiếu", new Date(2020-1900,1,1),new Date(2003-1900,1,29), p2);
       nhanvien n4 = new nhanvien("004","Nguyễn Nhật Hào", new Date(2020-1900,1,1),new Date(2003-1900,1,29), p3);
       nhanvien n5 = new nhanvien("005","Bùi Minh Duy", new Date(2020-1900,1,1),new Date(2003-1900,1,29), p4);
       nhanvien n6 = new nhanvien("006","Lê Huỳnh Cường", new Date(2020-1900,1,1),new Date(2003-1900,1,29), p2);
       nhanvien n7 = new nhanvien("007","Nguyễn Phương Đại", new Date(2020-1900,1,1),new Date(2003-1900,1,29), p1);
       
       p1.dsnv.add(n2);
       p1.dsnv.add(n7);
       p2.dsnv.add(n3);
       p2.dsnv.add(n6);
       p3.dsnv.add(n4);
       p4.dsnv.add(n1);
       p4.dsnv.add(n5);
    }
    public void addEvent() {
           	comboBox.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						readFile();
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				    if(comboBox.getSelectedIndex() == -1)
				    {
				    	return;
				    }
				    phongban p = (phongban)comboBox.getSelectedItem();
				    for(phongban b : arr)
				    {
				    	if(b.getMaphong().equals(p.maphong))
				    	{
				    		System.out.println(b == p);
				    	}
				    }
				    for(nhanvien n : p.getDsnv())
					{
						System.out.println(n);
					}
				    lsNV.setListData(p.dsnv);
				     
				}
			});
           	
           lsNV.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				nhanvien n = lsNV.getSelectedValue();
				ma.setText(n.getId());
				hoten.setText(n.getHoten());
				ngaylam.setText(format.format(n.getNgayvaolam()));
				ngaysinh.setText(format.format(n.getNgaysinh()));
				
			}
		  
		});
           
          
    }
    public void readFile() throws IOException, ClassNotFoundException
	{
		FileInputStream fin = new FileInputStream("fileluu.txt");
		ObjectInputStream Objin = new ObjectInputStream(fin);
		//arr =  (ArrayList<phongban>) Objin.readObject();
		/*for(phongban p : arr)
		{
			System.out.println(p);
			for(nhanvien n : p.getDsnv())
			{
				System.out.println(n);
			}
		}*/
	}
    
	public view() {
    	
		getContentPane().setBackground(new Color(255, 255, 128));
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel chonPb = new JLabel("Chọn phòng ban");
		chonPb.setBounds(106, 10, 240, 56);
		chonPb.setBackground(new Color(255, 128, 64));
		chonPb.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		getContentPane().add(chonPb);
		chonPb.setOpaque(true);
		
		comboBox = new JComboBox<phongban>();
		comboBox.setBounds(364, 10, 371, 56);
		comboBox.setBackground(new Color(255, 128, 0));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		getContentPane().add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		panel.setBounds(27, 100, 309, 402);
		getContentPane().add(panel);
		
		lsNV= new JList<nhanvien>();
		lsNV.setBackground(new Color(255, 255, 128));
		lsNV.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(lsNV);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 128));
		panel_1.setBounds(364, 100, 415, 299);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblM = new JLabel("Mã:");
		lblM.setBounds(10, 49, 55, 40);
		lblM.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		lblM.setBackground(new Color(255, 255, 128));
		panel_1.add(lblM);
		lblM.setOpaque(true);
		
		ma = new JTextField();
		ma.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		ma.setBounds(128, 33, 215, 53);
		panel_1.add(ma);
		ma.setColumns(10);
		
		
		JLabel lblHTn = new JLabel("Họ tên:");
		lblHTn.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		lblHTn.setBackground(new Color(255, 255, 128));
		lblHTn.setBounds(10, 110, 101, 40);
		panel_1.add(lblHTn);
		lblHTn.setOpaque(true);
		
		hoten = new JTextField();
		hoten.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		hoten.setColumns(10);
		hoten.setBounds(139, 97, 266, 53);
		panel_1.add(hoten);
		
		
		JLabel lblNgyVoLm = new JLabel("Ngày làm");
		lblNgyVoLm.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		lblNgyVoLm.setBackground(new Color(255, 255, 128));
		lblNgyVoLm.setBounds(10, 168, 137, 48);
		panel_1.add(lblNgyVoLm);
		lblNgyVoLm.setOpaque(true);
		
		JLabel lblNgySinh = new JLabel("Ngày sinh");
		lblNgySinh.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		lblNgySinh.setBackground(new Color(255, 255, 128));
		lblNgySinh.setBounds(10, 226, 148, 40);
		panel_1.add(lblNgySinh);
		lblNgySinh.setOpaque(true);
		
		
		ngaylam = new JTextField();
		ngaylam.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		ngaylam.setColumns(10);
		ngaylam.setBounds(168, 160, 215, 53);
		panel_1.add(ngaylam);
		
		
		ngaysinh = new JTextField();
		ngaysinh.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		ngaysinh.setColumns(10);
		ngaysinh.setBounds(168, 223, 215, 53);
		panel_1.add(ngaysinh);
		
		save = new JButton("Save");
		save.setBackground(new Color(128, 128, 255));
		save.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		save.setBounds(364, 417, 112, 65);
		getContentPane().add(save);
		
		delete = new JButton("Delete");
		delete.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		delete.setBackground(new Color(128, 128, 255));
		delete.setBounds(500, 417, 139, 65);
		getContentPane().add(delete);
		
		exit = new JButton("Exit");
		exit.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		exit.setBackground(new Color(128, 128, 255));
		exit.setBounds(664, 417, 101, 65);
		getContentPane().add(exit);
		
		Font font = new Font("Times New Roman", Font.PLAIN, 30);
		Border thongtin = BorderFactory.createLineBorder(Color.RED);
		TitledBorder tt = new TitledBorder(thongtin, "Thông tin");
		tt.setTitleFont(font);
		tt.setTitleColor(Color.red);
		panel.setBorder(tt);
		
		Border chitiet = BorderFactory.createLineBorder(Color.RED);
		TitledBorder ct = new TitledBorder(chitiet, "Chi tiết");
		ct.setTitleColor(Color.red);
		ct.setTitleFont(font);
		
		panel_1.setBorder(ct);
		
		
		insert = new JButton("Insert");
		insert.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		insert.setBackground(new Color(128, 128, 255));
		insert.setBounds(364, 492, 112, 65);
		getContentPane().add(insert);
		
		control ac = new control(this);
		delete.addActionListener(ac);
		save.addActionListener(ac);
		exit.addActionListener(ac);
	    insert.addActionListener(ac);
		
		//////////////////////// Tạo thông tin giả lập ////////////
		fakedata();
		///////////////////////// Them su kien ////////////////////
		addEvent();
		

		setVisible(true);
		
	}
	public void setText()
	{
		ma.setText("");
		hoten.setText("");
		ngaylam.setText("");
		ngaysinh.setText("");
	}
  
	public static void main(String[] args) {
		new view();
	}
	
}
