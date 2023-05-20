package model;

import java.io.Serializable;
import java.util.Date;

public class nhanvien implements Serializable{
private String id;
private String hoten;
private Date ngayvaolam;
private Date ngaysinh;
private phongban phong;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getHoten() {
	return hoten;
}
public void setHoten(String hoten) {
	this.hoten = hoten;
}
public Date getNgayvaolam() {
	return ngayvaolam;
}
public void setNgayvaolam(Date ngayvaolam) {
	this.ngayvaolam = ngayvaolam;
}
public Date getNgaysinh() {
	return ngaysinh;
}
public void setNgaysinh(Date ngaysinh) {
	this.ngaysinh = ngaysinh;
}
public phongban getPhong() {
	return phong;
}
public void setPhong(phongban phong) {
	this.phong = phong;
}

public nhanvien() {
	super();
	// TODO Auto-generated constructor stub
}
public nhanvien(String id, String hoten, Date ngayvaolam, Date ngaysinh, phongban phong) {
	super();
	this.id = id;
	this.hoten = hoten;
	this.ngayvaolam = ngayvaolam;
	this.ngaysinh = ngaysinh;
	this.phong = phong;
}
@Override
public String toString() {
	return this.hoten;
}
}

