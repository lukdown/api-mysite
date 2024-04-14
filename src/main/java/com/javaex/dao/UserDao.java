package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;
import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;

	// 방명록 글 저장 ajax selectKey
	public int insertSelectKey(UserVo userVo) {
		System.out.println("UserDao.insertSelectKey()");
		int count = sqlSession.insert("user.userInsert", userVo);
		return count;
	}

	// 1개정보
	public UserVo userSelectOne(int no) {
		System.out.println("UserDao.userSelectOne()");

		UserVo userVo = sqlSession.selectOne("user.selectOneByNo", no);
		return userVo;
	}

	// 수정(회원정보수정)
	public int userUpdate(UserVo userVo) {
		System.out.println("UserDao.userUpdate()");

		int count = sqlSession.update("user.update", userVo);
		return count;
	}

	// no로 한명데이터 가져오기(회원정보수정 폼)
	public UserVo userSelectOneByNo(int no) {
		System.out.println("UserDao.userSelectOneByNo()");

		UserVo userVo = sqlSession.selectOne("user.selectOneByNo", no);
		return userVo;
	}

	// id, pw로 한명데이터 가져오기(로그인)
	public UserVo userSelectByIdPw(UserVo userVo) {
		System.out.println("UserDao.userSelectByIdPw()");

		System.out.println(userVo); // id pw
		UserVo authUser = sqlSession.selectOne("user.selectByIdPw", userVo);
		System.out.println(authUser); // no name

		return authUser;
	}

}
