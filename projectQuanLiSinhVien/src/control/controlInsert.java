package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.swing.JOptionPane;

import model.nhanvien;
import model.phongban;
import view.insertNV;

public class controlInsert implements ActionListener{

	private insertNV v;
	public controlInsert(insertNV v) {
		// TODO Auto-generated constructor stub
		this.v = v;
	}
	
	public Boolean checkID(String id)
	{
		
		for(phongban p : v.v.arr)
		{
			for(nhanvien n : p.getDsnv())
			{
				//System.out.println(n.getId());
				if(n.getId().equals(id))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("INSERT"))
		{
			//System.out.println("Hello");
			   phongban p = (phongban)v.comboBox.getSelectedItem();
			   String id = v.ID.getText();
			   String name = v.hoten.getText();
			   String ngaylam = v.ngayvaolam.getText();
			   String ns = v.ngaysinh.getText();
			   
			   if(!checkID(id))
			   { 
				  // JOptionPane.showMessageDialog(insertNV, e, ns, ABORT, null);
		           JOptionPane.showMessageDialog(v.contentPane, "ID bi trung", "Loi", JOptionPane.ERROR_MESSAGE);
		           return;
			   }
			   for(phongban b : v.v.arr)
			   {
				   if(p.maphong.equals(b.maphong))
				   {
					  b.dsnv.add(new nhanvien(id, name, new Date(ngaylam), new Date(ns), b));
				   }
			   }
			   //p.dsnv.add(new nhanvien(id, name, new Date(ngaylam), new Date(ns), p));
			   
			  /* for(nhanvien n : p.getDsnv())
			   {
				   System.out.println(n);
			   }*/
			/*try {
				writeFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
		       JOptionPane.showMessageDialog(v.contentPane, "Dang nhap thanh cong", "Thong bao", JOptionPane.INFORMATION_MESSAGE);
		}	
	}
	public void writeFile() throws IOException
	{
	 FileOutputStream fo = new FileOutputStream("fileluu.txt");
	 ObjectOutputStream objO = new ObjectOutputStream(fo);
	 objO.writeObject(v.arr);
	 
	 for(phongban p : v.arr)
	 {
		for(nhanvien n : p.dsnv)
		{
			System.out.println(n);
		}
	 }
	 
	}

}
