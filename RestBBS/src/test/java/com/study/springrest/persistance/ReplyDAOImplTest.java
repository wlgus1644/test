package com.study.springrest.persistance;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.springrest.domain.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ReplyDAOImplTest {
	
	@Inject
	private ReplyDAO dao;
	@Test
	public void test(){
		System.out.println("Test DAO= "+dao);
	}

	
	@Test
	public void insertTest() throws Exception{
		ReplyVO vo = new ReplyVO();
		vo.setContent("new���1");
		vo.setUser_name("new����1");
		vo.setBoard_no(1);
		dao.insert(vo);
	}
	
	@Test
	public void getTest() throws Exception{
		ReplyVO vo= dao.get(2);
	//	System.out.println("�̸� :"+vo.getUser_name());
	}
	
	@Test
	public void deleteTest() throws Exception{
		 dao.delete(3);
	}
	
	@Test
	public void updateTest() throws Exception{
		ReplyVO vo = new ReplyVO();
		vo.setContent("������ ����");
		vo.setUser_name("������ ����");
		dao.update(vo);
	}
	
	@Test
	public void getListTest() throws Exception{
		List<ReplyVO> list= dao.getList(3);
		Iterator<ReplyVO> it=list.iterator();
		while(it.hasNext()){
			ReplyVO vo= it.next();
			//System.out.println("�̸� :"+vo.user_name);	
		}
		
	}

}
