package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;

	// no로 한명데이터 가져오기(회원정보수정 폼)
	public UserVo userSelectOneByNo(int no) {
		System.out.println("UserDao.userSelectOneByNo()");

		UserVo userVo = sqlSession.selectOne("user.selectOneByNo", no);
		return userVo;
	}

	// 전체가져오기
	public List<BoardVo> boardSelect() {
		System.out.println("BoardDao.boardSelect()");

		List<BoardVo> boardList = sqlSession.selectList("board.selectList");
		// System.out.println(personList);

		return boardList;
	}

	// 게시판등록
	public int boardInsert(BoardVo boardVo) {

		int count = sqlSession.insert("boardInsert", boardVo);

		return count;
	}

	// 게시판등록2
	public int boardInsert2(Map<String, String> bMap) {
		System.out.println("boardDao.boardInsert2()");
		System.out.println(bMap);

		int count = sqlSession.insert("boardDao.boardInsert2", bMap);

		return count;
	}

	// 1개 가져오기
	public BoardVo boardSelectOne(int no) {
		System.out.println("BoardDao.boardSelectOne()");

		BoardVo boardVo = sqlSession.selectOne("board.selectOne", no);
		// System.out.println(boardVo);
		return boardVo;
	}

	// 1개 가져오기2
	public Map<String, Object> boardSelectOne2(int no) {
		System.out.println("BoardDao.boardSelectOne()");

		Map<String, Object> pMap = sqlSession.selectOne("board.selectOne2", no);
		// System.out.println(pMap);
		// System.out.println(pMap.get("name"));

		return pMap;
	}

	// 수정
	public int boardModify(BoardVo boardVo) {
		System.out.println("BoardDao.boardModify()");

		int count = sqlSession.update("board.boardUpdate", boardVo);

		return count;

	}

	// 삭제
	public int boardDelete(BoardVo boardVo) {

		int count = sqlSession.delete("board.boardDelete", boardVo);
		// System.out.println(count);

		return count;
	}

}
