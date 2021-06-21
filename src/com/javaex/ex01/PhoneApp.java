package com.javaex.ex01;

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

public class PhoneApp {

	public static void main(String[] args) throws IOException {
		
		List<Person> pList = new ArrayList<Person> ();	//DB를 읽어 사용할 리스트 작성
		
		Reader fr = new FileReader("C:\\JavaStudy\\file\\PhoneDB.txt");	//Reader로 DB를 읽음
		BufferedReader br = new BufferedReader(fr);
		
		boolean flag = true;
		
		while(true) {	//읽어온 DB를 리스트에 입력
			String info = br.readLine();
			if(info != null) {
				pList.add(new Person(info));
			} else {
				break;
			}
		}
		
		System.out.println("****************************************");
		System.out.println("*        전화번호 관리 프로그램        *");
		System.out.println("****************************************");
		while(flag) {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("----------------------------------------");
			System.out.print(">메뉴번호: ");
			
			String sMenu = sc.nextLine();
			
			switch(sMenu) {
				case "1":	//리스트를 출력
					for(int i = 0; i < pList.size(); i++) {
						System.out.println((i + 1) + pList.get(i).toString());
					}
					break;
					
				case "2":
					Writer add = new FileWriter("C:\\JavaStudy\\file\\PhoneDB.txt");	//DB를 재작성
					BufferedWriter bAdd = new BufferedWriter(add);
					
					System.out.println("<2.등록>");
					System.out.print(">이름: ");
					String sName = sc.nextLine();
					System.out.print(">휴대전화: ");
					String sHp = sc.nextLine();
					System.out.print(">회사전화: ");
					String sCp = sc.nextLine();
					System.out.println("[등록 되었습니다.]");
					
					pList.add(new Person(sName, sHp, sCp));
					
					for(Person info : pList) {
						bAdd.write(info.reWrite());
						bAdd.newLine();
					}
					bAdd.flush();
					bAdd.close();		
					break;
					
				case "3":
					
					Writer remove = new FileWriter("C:\\JavaStudy\\file\\PhoneDB.txt");	//DB를 재작성
					BufferedWriter bRemove = new BufferedWriter(remove);
					
					System.out.println("<3.삭제>");
					System.out.print(">번호: ");
					int iNum = sc.nextInt();
					
					System.out.println("[삭제 되었습니다.]");
					
					pList.remove(iNum - 1);
					
					for(Person info : pList) {
						bRemove.write(info.reWrite());
						bRemove.newLine();
					}

					bRemove.flush();
					bRemove.close();	//닫지 않으면 이전의 내용이 들어있는 채로 다시 출력하게 된다
					break;
					
				case "4":
					System.out.println("<4.검색>");
					System.out.print(">이름: ");	//리스트 내부에 해당 문자열이 포함된 Person 객체를 출력
					String name = sc.nextLine();
					
					for(int i = 0; i < pList.size(); i++) {
						if(pList.get(i).search(name)) {		//.search(name)으로 해당 객체의 이름에 name 문자열이 포함되는지를 불린으로 리턴
							System.out.println((i + 1) + pList.get(i).toString());
						}
					}
					break;
					
				case "5":
					System.out.println("****************************************");
					System.out.println("*              감사합니다              *");
					System.out.println("****************************************");
					
					flag = false;
					
					br.close();
					sc.close();
					break;
					
				default:
					System.out.println("[다시 입력해주세요.]");
					break;
			}
			
		}
	}

}
