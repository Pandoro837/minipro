package com.javaex.ex02;

import java.io.IOException;
import java.util.List;

import com.javaex.ex01.Person;

public class PhoneApp {

	public static void main(String[] args) throws IOException {
		
		PhoneAppManager pm = new PhoneAppManager();
		List<Person> pList = pm.boots();
		
		pm.start();
		
		boolean flag = true;	//while문 반복용
		while(flag) {
			
			switch(pm.menu()) {
			
			case "1":	//리스트
				
				pm.showList(pList);
				break;

			case "2":	//등록
				pm.add(pList);
				break;
			
			case "3":	//삭제
				pm.remove(pList);
				break;
			
			case "4":	//검색
				pm.search(pList);
				break;
			
			case "5":	//종료
				pm.quit();
				flag = false;
				break;
			
			default:	//없는 메뉴 호출
				System.out.println("[다시 입력해주세요.]");
				break;
			}
		}

	}

}
