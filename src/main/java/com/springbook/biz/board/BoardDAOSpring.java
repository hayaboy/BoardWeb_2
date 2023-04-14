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
	
	// SQL 명령어들
		private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";
		//private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values(?, ?, ?, ?)";
		private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
		private final String BOARD_DELETE = "delete board where seq=?";
		private final String BOARD_GET = "select * from board where seq=?";
		private final String BOARD_LIST = "select * from board order by seq desc";
		private final String BOARD_LIST_T = "select * from board where title like '%'||?||'%' order by seq desc";
		private final String BOARD_LIST_C = "select * from board where content like '%'||?||'%' order by seq desc";
		
		
		
		//getJdbcTemplate() 메소드가 JbcTemplate 객체를 리턴하려면 데이터소스 객체가 있어야 하므로 JdbcDaoSupport의 부모 메소드 호출하여 데이터 소스 객체르 의존성 주입		
		@Autowired  //주로 변수위에 선언하였는데 메서드 위해 선언해도 동작한다. 메소드 위에 붙이면 해당 메소드를 스프링 컨테이너가 자동으로 호출, 이 때 매소드 매개변수 타입(데이터소스)을 확인하고 해당 타입의 객체가 메모리에 존재하면 그 객체를 인자로 넘겨준다. 
		public void setSuperDataSource(DataSource dataSource) {
			super.setDataSource(dataSource);
		}
		
		
		// CRUD 기능의 메소드 구현
		// 글 등록
		public void insertBoard(BoardVO vo) {
			System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
			//Return the JdbcTemplate for this DAO,pre-initialized with the DataSource or set explicitly.
			//getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
			jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
		}

		// 글 수정
		public void updateBoard(BoardVO vo) {
			System.out.println("===> Spring JDBC로 updateBoard() 기능 처리");
			jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
		}

		// 글 삭제
		public void deleteBoard(BoardVO vo) {
			System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리");
			jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
		}

		// 글 상세 조회
		public BoardVO getBoard(BoardVO vo) {
			System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
			Object[] args = { vo.getSeq() };
			return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
		}

		// 글 목록 조회
		public List<BoardVO> getBoardList(BoardVO vo) {
			System.out.println("===> Spring JDBC로 getBoardList() 기능 처리");
			
			Object[] args ={ vo.getSearchKeyword() };  // 검색 키워드를 설정하기 위해 Object 배열을 사용한다는 것이 기존 소스와의 차이점
			
			if(vo.getSearchCondition().equals("TITLE")) {
				return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper());
			}else if(vo.getSearchCondition().equals("CONTENT")) {
				return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
			}
			
			
			return null;
		}
		
}






