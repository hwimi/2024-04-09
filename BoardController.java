package jdbcBoard;

import java.util.List;
import java.util.Scanner;



public class BoardController {
	private Scanner sc;
	private Serviec svc;
	private boolean flag;

	public BoardController() {
		sc=new Scanner(System.in);
		svc=new BoardServiecImpl();
		flag=true;
		printMenu();
	}
	private void printMenu() {
		while(flag) {
			System.out.println("보드관리 프로그램");
			System.out.println("1.게시글추가|2.게시글검색|3.게시글수정");
			System.out.println("4.게시글삭제|5.게시글 출력|6.종료");
			int menu=sc.nextInt();
			
			switch(menu) {
			case 1:
				register();
				break;
			case 2:
				serach();
				break;
			case 3:
				modify();
				break;
			case 4:
				remove();
				break;
			case 5:
				list();
				break;
			}
			
		}
	}
	private void list() {
		List<BoardVO>list=svc.getlist();
		for(BoardVO p:list) {
			System.out.println(p);
		}
		
	}
	private void remove() {
		System.out.println("삭제할 번호를 입력하세요");
		int bno=sc.nextInt();
		int isOk=svc.remove(bno);
		System.out.println("삭제"+((isOk>0)? "성공":"실패"));
		
	}
	private void modify() {
		System.out.println("수정하려는 번호를 입력하세요");
		int bno=sc.nextInt();
		System.out.println("제목");
		sc.nextLine();
		String title=sc.nextLine();
		System.out.println("작성자");
		String writer=sc.nextLine();
		System.out.println("내용");
		String content=sc.nextLine();
		BoardVO b=new BoardVO(bno, title, writer, content);
		int isOk=svc.modify(b);
		System.out.println("수정"+((isOk>0)? "성공":"실패"));
		
		
		
		
	}
	private void serach() {
		System.out.println("번호를 입력하세요");
		int bno=sc.nextInt();
		BoardVO b=svc.getserach(bno);
		System.out.println(b);
		
		
		
	}
	private void register() {
		System.out.println("제목을 입력하세요");
		sc.nextLine();
		String title=sc.nextLine();
		System.out.println("작성자를 입력하세요");
//		sc.nextLine();
		String writer=sc.nextLine();
		System.out.println("내용을 입력하세요");
//		sc.nextLine();
		String content=sc.nextLine();
		BoardVO b=new BoardVO(title, writer, content);
		
		int isOk=svc.register(b);
		System.out.println("board등록"+((isOk>0)? "성공":"실패"));
		
		
	}
}
