package com.study.spring.service;
import java.util.List;

import com.study.spring.domain.MemberVO;


public interface MemberService {
	
		public String getNow();
		public void insertMember(MemberVO vo);
		public MemberVO get(String user_id);
		public List<MemberVO> getList();
		public void deleteMember(String user_id);
		public void updateMember(MemberVO vo);
	
}
