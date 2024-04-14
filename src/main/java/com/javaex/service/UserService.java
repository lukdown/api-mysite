package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.GuestbookVo;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	// 필드
	@Autowired
	private UserDao userDao;

	// 저장 +1개 가져오기
	public UserVo exeAddandUser(UserVo userVo) {
		System.out.println("UserService.exeAddandUser()");

		// 등록
		int count = userDao.insertSelectKey(userVo);

		// no 의 데이터 가져오기
		// no값 확인
		int no = userVo.getNo();
		// no데이터 가져오기

		UserVo uVo = userDao.userSelectOne(no);
		return uVo;
	}

	// 회원정보 수정
	public int exeModify(UserVo userVo) {
		System.out.println("UserService.exeModify()");

		int count = userDao.userUpdate(userVo);
		return count;
	}

	// 회원정보수정폼(1명 데이터가져오기)
	public UserVo exeModifyForm(int no) {
		System.out.println("UserService.exeModifyForm()");

		UserVo userVo = userDao.userSelectOneByNo(no);
		return userVo;
	}

	// 로그인
	public UserVo exeLogin(UserVo userVo) {
		System.out.println("UserService.exeLogin()");

		UserVo authUser = userDao.userSelectByIdPw(userVo);

		return authUser;
	}

}
