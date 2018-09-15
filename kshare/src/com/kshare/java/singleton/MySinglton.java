package com.kshare.java.singleton;

public class MySinglton {

	private static MySinglton instance;
	private Integer state = 0;
	static{
		System.out.println("com.kshare.java.singleton.MySinglton class is getting loaded..");
	}

	public static void main(String[] args) {
		System.out.println("Singlton class");
		MySinglton instance = MySinglton.getInstance();
		System.out.println("hashCode : " + instance.hashCode());
	}

	private MySinglton() {
		super();
	}

	public static MySinglton getInstance() {
		if (instance == null) {
			instance = new MySinglton();
		}
		return instance;
	}
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	public void showClassLoader(){
		System.out.println("Class Loader Name : "+MySinglton.class.getClassLoader());
	}
}
