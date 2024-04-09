package jdbcBoard;

public class BoardVO {
	private int bno;
	private String title; //제목
	private String writer; //작성자
	private String content; //내용
	private String regdate; //생성일
	private String moddate;	//수정일
	
	//생성자
	public BoardVO(){
		
	}
	//글등록
	public BoardVO(String title,String writer, String content) {
		this.title=title;
		this.writer=writer;
		this.content=content;
	}
	//글리스트
	public BoardVO(int bno,String title,String writer,String content) {
		this.title=title;
		this.writer=writer;
		this.content=content;
		this.bno=bno;
		
	}
	//모든거 전부다
	public BoardVO(int bno,String title,String writer,String content,String regdate,String moddate) {
		this.title=title;
		this.writer=writer;
		this.content=content;
		this.bno=bno;
		this.regdate=regdate;
		this.moddate=moddate;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getModdate() {
		return moddate;
	}
	public void setModdate(String moddate) {
		this.moddate = moddate;
	}
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + ", moddate=" + moddate + "]";
	}
	
}
