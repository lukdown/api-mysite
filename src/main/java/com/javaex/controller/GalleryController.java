package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.GalleryVo;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class GalleryController {

	@Autowired
	private GalleryService galleryService;

	// 회원정보 수정폼(1명 데이터가져오기)
	@GetMapping("/api/galleryone")
	public JsonResult selectone(@RequestBody GalleryVo galleryVo) {
		System.out.println("GalleryController.modifyform()");
		System.out.println(galleryVo);
		
		//GalleryVo galleryVo = galleryService.exeSelectOne(no);
		//System.out.println(galleryVo);
		
		return null;
		//return JsonResult.success(galleryVo);
	}
	

	@PostMapping("/api/gallery")
	public JsonResult upload(@RequestParam MultipartFile file, @ModelAttribute GalleryVo galleryVo) {
		System.out.println("GalleryController.upload()");
		System.out.println("fileName: " + file.getOriginalFilename());
		System.out.println("toString: " + file);
		System.out.println("fdsfdsfsdfgsd" + galleryVo);

		String saveName = galleryService.exeUpload(file, galleryVo);

		// return null;
		return JsonResult.success(saveName);
	}

	// 리스트 가져오기
	@GetMapping(value = "/api/gallery")
	public List<GalleryVo> list() {
		System.out.println("GalleryController.list()");

		List<GalleryVo> galleryList = galleryService.exeList();

		System.out.println(galleryList);
		return galleryList;
	}

}
