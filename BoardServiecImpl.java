package jdbcBoard;

import java.util.List;

public class BoardServiecImpl implements Serviec {
	
	private DAO dao;
	public  BoardServiecImpl() {
		dao=new BoardDAOImpl();
	}

	@Override
	public int register(BoardVO b) {
		System.out.println("register serviceImplu success");
		return dao.insert(b);
	}

	@Override
	public BoardVO getserach(int bno) {
		System.out.println("register serviceImplu success");
		return dao.serach(bno);
	}

	@Override
	public int modify(BoardVO b) {
		System.out.println("modify serviceImplu success");
		return dao.update(b);
	}

	@Override
	public int remove(int bno) {
		System.out.println("modify serviceImplu success");
		return dao.delete(bno);
	}

	@Override
	public List<BoardVO> getlist() {
		System.out.println("list serviceImplu success");
		return dao.list();
	}




}
