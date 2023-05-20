package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;

import model.nhanvien;
import model.phongban;
import view.view;
import view.insertNV;

public class control implements ActionListener {

	private view v;
	public control(view v)
	{
		this.v = v;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str  =e.getActionCommand();
		if(str.equals("Save"))
		{
			try {
				Save();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(str.equals("Delete"))
				{
			    nhanvien n = v.lsNV.getSelectedValue();
			    phongban p = (phongban)v.comboBox.getSelectedItem(); 
			    p.dsnv.remove(n);
			    v.lsNV.setListData(p.dsnv);
			    v.setText();
			    try {
					Save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
		else if(str.equals("Insert")){
			try {
				new insertNV(v);
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(str.equals("Exit"))
				{
			System.exit(0);
				}
	}
	public void Save() throws IOException
	{
		FileOutputStream out = new FileOutputStream("fileluu.txt");
		ObjectOutputStream obj0  = new ObjectOutputStream(out);
		obj0.writeObject(v.arr);
	}
	

}
