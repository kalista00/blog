package project.teamtwo.component;

import java.sql.Timestamp;

public class BorderDTO {
	
	private int num;
	private String id;
	private String title;
	private String con;
	private String recon;
	private Timestamp reg;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	public String getRecon() {
		return recon;
	}
	public void setRecon(String recon) {
		this.recon = recon;
	}
	public Timestamp getReg() {
		return reg;
	}
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
}
