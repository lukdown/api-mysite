package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

@Service
public class BoardService {

	// 필드
	@Autowired
	private BoardDao boardDao;
	// 필드
	@Autowired
	private UserDao userDao;

	// 회원정보수정폼(1명 데이터가져오기)
	public UserVo exeUserInfoForm(int no) {
		System.out.println("UserService.exeModifyForm()");

		UserVo userVo = userDao.userSelectOneByNo(no);
		return userVo;
	}

	// 리스트
	public List<BoardVo> exeList() {
		System.out.println("BoardService.exeList()");

		List<BoardVo> boardList = boardDao.boardSelect();

		return boardList;
	}

	// 등록
	public BoardVo exeWrite(BoardVo boardVo) {
		System.out.println("BoardService.exeWrite()");

		int count = boardDao.boardInsert(boardVo);

		// no 의 데이터 가져오기
		// no값 확인
		int no = boardVo.getNo();
		// no데이터 가져오기

		BoardVo bVo = boardDao.boardSelectOne(no);

		return bVo;
	}

	// 읽기폼(데이터 1개 가져오기)
	public BoardVo exeReadForm(int no) {
		System.out.println("BoardService.exeReadForm()");

		// 비지니스로직X

		BoardVo boardVo = boardDao.boardSelectOne(no);

		return boardVo;

	}

	// 수정폼폼(데이터 1개 가져오기)
	public BoardVo exeModifyForm(int no) {
		System.out.println("BoardService.exeModifyForm()");

		// 비지니스로직X

		BoardVo boardVo = boardDao.boardSelectOne(no);

		return boardVo;

	}

	// 수정
	public int exeModify(BoardVo boardVo) {
		System.out.println("BoardService.exeModify()");

		int count = boardDao.boardModify(boardVo);
		return count;
	}

	// 삭제
	public int exeDelete(BoardVo boardVo) {
		System.out.println("BoardService.exeDelete()");

		int count = boardDao.boardDelete(boardVo);

		return count;
	}

}
