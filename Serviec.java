package jdbcBoard;

import java.util.List;

public interface Serviec {

	int register(BoardVO b);

	BoardVO getserach(int bno);

	int modify(BoardVO b);

	int remove(int bno);

	List<BoardVO> getlist();

}
