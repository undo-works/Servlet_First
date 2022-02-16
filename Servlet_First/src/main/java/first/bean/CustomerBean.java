package first.bean;

import java.io.Serializable;

public class CustomerBean implements Serializable {
	private int id = 0;
	private String name;
	private double height = 0;
	private int flag = 0;
	
	public void checkValues() {
		//三つの要素がすべてある場合、フラグを１にする。
		if(id != 0 && name != null && height != 0) {
			flag = 1;
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
}
