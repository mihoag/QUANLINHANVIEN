package model;

import java.io.Serializable;
import java.util.Vector;

public class phongban implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public String maphong;
  public String tenphong;
  public Vector<nhanvien> dsnv;
  
public phongban(String maphong, String tenphong, Vector<nhanvien> dsnv) {
	super();
	this.maphong = maphong;
	this.tenphong = tenphong;
	this.dsnv = dsnv;
}
public String getMaphong() {
	return maphong;
}
public void setMaphong(String maphong) {
	this.maphong = maphong;
}
public String getTenphong() {
	return tenphong;
}
public void setTenphong(String tenphong) {
	this.tenphong = tenphong;
}
public Vector<nhanvien> getDsnv() {
	return dsnv;
}
public void setDsnv(Vector<nhanvien> dsnv) {
	this.dsnv = dsnv;
}
@Override
public String toString() {
	return this.tenphong;
}
public phongban() {
	dsnv = new Vector<nhanvien>();
}
public void themnhanvien(nhanvien nv)
{
    dsnv.add(nv);
}   
}


