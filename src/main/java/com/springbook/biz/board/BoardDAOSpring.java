package com.springbook.biz.board;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


//DAO(Data Access Object)
@Repository
public class BoardDAOSpring extends JdbcDaoSupport{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// SQL ��ɾ��
		private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";
		//private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values(?, ?, ?, ?)";
		private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
		private final String BOARD_DELETE = "delete board where seq=?";
		private final String BOARD_GET = "select * from board where seq=?";
		private final String BOARD_LIST = "select * from board order by seq desc";
		private final String BOARD_LIST_T = "select * from board where title like '%'||?||'%' order by seq desc";
		private final String BOARD_LIST_C = "select * from board where content like '%'||?||'%' order by seq desc";
		
		
		
		//getJdbcTemplate() �޼ҵ尡 JbcTemplate ��ü�� �����Ϸ��� �����ͼҽ� ��ü�� �־�� �ϹǷ� JdbcDaoSupport�� �θ� �޼ҵ� ȣ���Ͽ� ������ �ҽ� ��ü�� ������ ����		
		@Autowired  //�ַ� �������� �����Ͽ��µ� �޼��� ���� �����ص� �����Ѵ�. �޼ҵ� ���� ���̸� �ش� �޼ҵ带 ������ �����̳ʰ� �ڵ����� ȣ��, �� �� �żҵ� �Ű����� Ÿ��(�����ͼҽ�)�� Ȯ���ϰ� �ش� Ÿ���� ��ü�� �޸𸮿� �����ϸ� �� ��ü�� ���ڷ� �Ѱ��ش�. 
		public void setSuperDataSource(DataSource dataSource) {
			super.setDataSource(dataSource);
		}
		
		
		// CRUD ����� �޼ҵ� ����
		// �� ���
		public void insertBoard(BoardVO vo) {
			System.out.println("===> Spring JDBC�� insertBoard() ��� ó��");
			//Return the JdbcTemplate for this DAO,pre-initialized with the DataSource or set explicitly.
			//getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
			jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
		}

		// �� ����
		public void updateBoard(BoardVO vo) {
			System.out.println("===> Spring JDBC�� updateBoard() ��� ó��");
			jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
		}

		// �� ����
		public void deleteBoard(BoardVO vo) {
			System.out.println("===> Spring JDBC�� deleteBoard() ��� ó��");
			jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
		}

		// �� �� ��ȸ
		public BoardVO getBoard(BoardVO vo) {
			System.out.println("===> Spring JDBC�� getBoard() ��� ó��");
			Object[] args = { vo.getSeq() };
			return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
		}

		// �� ��� ��ȸ
		public List<BoardVO> getBoardList(BoardVO vo) {
			System.out.println("===> Spring JDBC�� getBoardList() ��� ó��");
			
			Object[] args ={ vo.getSearchKeyword() };  // �˻� Ű���带 �����ϱ� ���� Object �迭�� ����Ѵٴ� ���� ���� �ҽ����� ������
			
			if(vo.getSearchCondition().equals("TITLE")) {
				return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper());
			}else if(vo.getSearchCondition().equals("CONTENT")) {
				return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
			}
			
			
			return null;
		}
		
}






