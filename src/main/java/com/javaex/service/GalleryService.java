package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.GalleryDao;
import com.javaex.vo.GalleryVo;

@Service
public class GalleryService {

	// 필드
	@Autowired
	private GalleryDao galleryDao;

	// 1개 데이터 읽기
	public GalleryVo exeSelectOne(int no) {
		System.out.println("GalleryService.exeReadForm()");

		GalleryVo galleryVo = galleryDao.gallerySelectOne(no);

		return galleryVo;

	}

	public String exeUpload(MultipartFile file, GalleryVo gVo) {
		System.out.println("GalleryService.exeUpload()");

		// 파일저장디렉토리
		String saveDir = "D:\\javaStudy\\upload";

		// (1)파일관련 정보 추출///////////////////////////////////////////////////

		// 오리지널 파일명
		String orgName = file.getOriginalFilename();
		System.out.println(orgName);

		// 확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		System.out.println(exName);

		// 저장파일명(겹치지 않아야 된다)
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println(saveName);

		// 파일사이즈
		long fileSize = file.getSize();
		System.out.println(fileSize);

		// 파일전체경로
		String filePath = saveDir + "\\" + saveName;
		System.out.println(filePath);

		int uNo = gVo.getUser_no();
		String content = gVo.getContent();

		// vo로묶기
		GalleryVo galleryVo = new GalleryVo(uNo, content, filePath, orgName, saveName, fileSize);
		System.out.println(galleryVo);

		// Dao만들기 --> DB저장 과제
		System.out.println(galleryVo + "DB저장");
		galleryDao.galleryInsert(galleryVo);

		// (2)파일저장(서버쪽 하드디스크에 저장)///////////////////////////////////////////////////
		try {
			byte[] fileData;
			fileData = file.getBytes();

			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			bos.write(fileData);
			bos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// (3)DB저장 /////////////////////////////////////////////////////
		int count = 1;
		return saveName;
	}

	// 리스트
	public List<GalleryVo> exeList() {
		System.out.println("GalleryService.exeList()");

		List<GalleryVo> galleryList = galleryDao.gallerySelect();

		return galleryList;
	}

}
