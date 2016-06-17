package com.study.spring.persistance;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.spring.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOImplTest {
	
	@Inject
	private MemberDAO dao;
	@Test
	public void test(){
		System.out.println("Test DAO= "+dao);
	}
	@Test
	public void getNowTest(){
		System.out.println("Test DAO now= "+dao.getNow());
	}
	
	@Test
	public void insertMemberTest() throws Exception{
		MemberVO vo = new MemberVO();
		vo.setUser_id("id1234");
		vo.setUser_name("커몬");
		vo.setPw("baby");
		vo.setEmail("baby@gmail.com");
		dao.insertMember(vo);
	}
	
	@Test
	public void getTest() throws Exception{
		MemberVO vo= dao.get("박가네");
		//System.out.println("이름 :"+vo.user_name);
	}
	
	@Test
	public void deleteMemberTest() throws Exception{
		 dao.deleteMember("id3");
	}
	
	@Test
	public void updateMemberTest() throws Exception{
		MemberVO vo = new MemberVO();
		vo.setUser_id("id3333");
		vo.setUser_name("새로운이름");
		vo.setPw("new_password");
		vo.setEmail("test22@gmail.com");
		dao.updateMember(vo);
	}
	
	@Test
	public void getListTest() throws Exception{
		List<MemberVO> list= dao.getList();
		Iterator<MemberVO> it=list.iterator();
		while(it.hasNext()){
			MemberVO vo= it.next();
			//System.out.println("이름 :"+vo.user_name);	
		}
		
	}

}
