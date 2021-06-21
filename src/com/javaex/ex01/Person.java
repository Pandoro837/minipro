package com.javaex.ex01;

public class Person {
	
	// 필드
	private String name;
	private String hp;
	private String cp;
	
	//생성자
	public Person() {
		
	}
	
	public Person(String _info) {
		String[] sInfo = _info.split(",");
		this.name = sInfo[0];
		this.hp = sInfo[1];
		this.cp = sInfo[2];
	}
	
	public Person(String name, String hp, String cp) {
		this.name = name;
		this.hp = hp;
		this.cp = cp;
	}
	
	//메소드 일반
	public boolean search(String _name) {
		if(this.name.contains(_name)) {
			return true;
		} else {
			return false;
		}
	}

	public String reWrite() {
		return this.name + "," + this.hp + "," + this.cp;
	}
	
	@Override
	public String toString() {
		return".\t" + name + "\t" + hp + "\t" + cp;
	}
	
	
	
}
