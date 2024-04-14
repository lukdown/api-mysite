package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.BoardService;
import com.javaex.service.UserService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class BoardController {

	// 필드
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private UserService userService;

	// 회원정보 수정폼(1명 데이터가져오기)
	@GetMapping("/api/boards/write")
	public JsonResult modifyform(HttpServletRequest request) {
		System.out.println("UserController.modifyform()");

		int no = JwtUtil.getNoFromHeader(request);

		if (no != -1) {
			// 정상
			UserVo userVo = userService.exeModifyForm(no);
			System.out.println(userVo);
			return JsonResult.success(userVo);
		} else {
			// 토큰이 없거나(로그인 상태 아님) 변조된 경우
			return JsonResult.fail("토큰X, 비로그인, 변조");
		}

	}

	// 저장
	@PostMapping(value = "/api/boards/write")
	public JsonResult add(@RequestBody BoardVo boardVo, HttpServletRequest request) {
		System.out.println("GuestbookController.add()");
		System.out.println(boardVo);

		// BoardVo bVo = boardService.exeWrite(boardVo);
		// System.out.println(bVo);
		int no = JwtUtil.getNoFromHeader(request);
		if (no != -1) { // 정상
			// db에 저장시킨다
			boardService.exeWrite(boardVo);
			return JsonResult.success(boardVo.getName());
		} else {
			return JsonResult.fail("로그인하지않음");
		}
	}

	// 수정
	@PutMapping(value = "/api/boards/boardmodify/{no}")
	public String modify(@RequestBody BoardVo boardVo, @PathVariable(value = "no") int no) {
		System.out.println("PhonebookController.modify()");

		boardVo.setNo(no);
		System.out.println(boardVo);

		// 삭제
		// 코드작성할것
		int count = boardService.exeModify(boardVo);

		String result = "{\"count\": " + count + "}";
		System.out.println(result);

		return result;
	}

	// 수정폼
	@GetMapping(value = "/api/boards/boardmodify/{no}")
	public BoardVo modifyform(@PathVariable(value = "no") int no) {
		System.out.println("PhonebookController.modifyform()");

		// 코드작성할것
		BoardVo bVo = boardService.exeModifyForm(no);

		return bVo;
	}

	// 읽기폼
	@GetMapping(value = "/api/boards/boardread/{no}")
	public BoardVo readform(@PathVariable(value = "no") int no) {
		System.out.println("PhonebookController.readform()");

		// 코드작성할것
		BoardVo bVo = boardService.exeReadForm(no);

		return bVo;
	}

	// 삭제
	@DeleteMapping(value = "/api/boards")
	public String remove(@RequestBody BoardVo boardVo) {
		System.out.println("BoardController.remove()");

		// 삭제
		// 코드작성할것
		int count = boardService.exeDelete(boardVo);

		String result = "{\"count\": " + count + "}";
		System.out.println(result);

		return result;
	}

	// 리스트 가져오기
	@GetMapping(value = "/api/boards")
	public List<BoardVo> list() {
		System.out.println("BoardController.list()");

		List<BoardVo> boardList = boardService.exeList();

		System.out.println(boardList);
		return boardList;
	}

}
