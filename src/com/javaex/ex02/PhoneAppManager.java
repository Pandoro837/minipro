package com.javaex.ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.javaex.ex01.Person;

public class PhoneAppManager {
	
	Scanner sc = new Scanner(System.in);
	
	public ArrayList<Person> boots() throws IOException {
		ArrayList<Person> pList = new ArrayList<Person>();	//Person 관리용 리스트
		
		Reader fr = new FileReader("C:\\JavaStudy\\file\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		while(true) {	//읽어온 DB를 리스트에 입력
			String info = br.readLine();
			if(info != null) {
				pList.add(new Person(info));
			} else {
				break;
			}
		}
		
		br.close();
		
		return pList;
	}
	
	public void start() {	//시작문구
		
		System.out.println("****************************************");
		System.out.println("*        전화번호 관리 프로그램        *");
		System.out.println("****************************************");
	}
	
	public String menu() {	//메뉴
		System.out.println("\n" + "1.리스트  2.등록  3.삭제  4.검색  5.종료");
		System.out.println("----------------------------------------");
		System.out.print(">메뉴번호: ");
		
		String sMenu = sc.nextLine();
		return sMenu;
	}
	
	public void showList(List<Person> pList) {	//리스트 출력
		for(int i = 0; i < pList.size(); i++) {
			System.out.println((i + 1) + pList.get(i).toString());
		}
	}
	
	public void saveData(List<Person> pList) throws IOException {	//add, remove 메소드 사용 시 데이터 저장을 위한 메소드
		Writer saveData = new FileWriter("C:\\JavaStudy\\file\\PhoneDB.txt");
		BufferedWriter bSaveData = new BufferedWriter(saveData);
		
		for(Person info : pList) {
			bSaveData.write(info.reWrite());
			bSaveData.newLine();
		}
		
		bSaveData.flush();
		bSaveData.close();	
		
	}
	
	public void add(List<Person> pList) throws IOException {	//리스트에 해당 객체 추가
		System.out.println("<2.등록>");
		System.out.print(">이름: ");
		String sName = sc.nextLine();
		System.out.print(">휴대전화: ");
		String sHp = sc.nextLine();
		System.out.print(">회사전화: ");
		String sCp = sc.nextLine();
		System.out.println("[등록 되었습니다.]");
		
		pList.add(new Person(sName, sHp, sCp));
		this.saveData(pList);
	}
	
	public void remove(List<Person> pList) throws IOException {	//리스트에서 해당 인덱스 삭제
		System.out.println("<3.삭제>");
		System.out.print(">번호: ");
		int iNum = sc.nextInt();
		
		System.out.println("[삭제 되었습니다.]");
		
		pList.remove(iNum - 1);
		this.saveData(pList);
	}
	
	public void search(List<Person> pList) {	//리스트에 해당 문자열이 포함된 객체를 출력
		System.out.println("<4.검색>");
		System.out.print(">이름: ");	//리스트 내부에 해당 문자열이 포함된 Person 객체를 출력
		String name = sc.nextLine();
		
		for(int i = 0; i < pList.size(); i++) {
			if(pList.get(i).search(name)) {		//.search(name)으로 해당 객체의 이름에 name 문자열이 포함되는지를 불린으로 리턴
				System.out.println((i + 1) + pList.get(i).toString());
			}
		}
	}
	
	public void quit() {	//종료문구
		System.out.println("****************************************");
		System.out.println("*              감사합니다              *");
		System.out.println("****************************************");
		sc.close();
	}
	
}
