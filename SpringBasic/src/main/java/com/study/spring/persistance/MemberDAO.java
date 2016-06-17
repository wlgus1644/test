package com.study.spring.persistance;
//persistance를 DAO라고 생각하면됨
//인터페이스는 내용이 있으면 안됨. 구현체만 있어야함

import java.util.List;

import com.study.spring.domain.MemberVO;

public interface MemberDAO {
	
	public String getNow();
	public void insertMember(MemberVO vo);
	public MemberVO get(String user_id);
	public List<MemberVO> getList();
	public void deleteMember(String user_id);
	public void updateMember(MemberVO vo);
	

}
