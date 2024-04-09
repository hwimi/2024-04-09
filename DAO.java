package jdbcBoard;

import java.util.List;

public interface DAO {

	

	int insert(BoardVO b);

	BoardVO serach(int bno);

	int update(BoardVO b);

	int delete(int bno);

	List<BoardVO> list();

}
