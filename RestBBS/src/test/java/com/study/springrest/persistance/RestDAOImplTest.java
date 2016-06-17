package com.study.springrest.persistance;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.springrest.domain.RestVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class RestDAOImplTest {
	
	@Inject
	private RestDAO dao;
	@Test
	public void test(){
		System.out.println("Test DAO= "+dao);
	}
	@Test
	public void getNowTest(){
		System.out.println("Test DAO now= "+dao.getNow());
	}
	
	@Test
	public void insertTest() throws Exception{
		RestVO vo = new RestVO();
		vo.setTitle("타이틀5");
		vo.setContent("내용5");
		vo.setUser_name("타이틀5빠");
		dao.insert(vo);
	}
	
	@Test
	public void getTest() throws Exception{
		int board_no=1;
		RestVO vo= dao.get(board_no);
		System.out.println("이름 :"+vo.getUser_name());
	}
	
	@Test
	public void deleteTest() throws Exception{
		 dao.delete(4);
	}
	
	@Test
	public void updateTest() throws Exception{
		RestVO vo = new RestVO();
		vo.setTitle("새로운 타이틀");
		vo.setContent("새로운내용");
		vo.setUser_name("새로운 사용자이름");
		dao.update(vo);
	}
	
	@Test
	public void getListTest() throws Exception{
		List<RestVO> list= dao.getList();
		Iterator<RestVO> it=list.iterator();
		while(it.hasNext()){
			RestVO vo= it.next();
			//System.out.println("이름 :"+vo.user_name);	
		}
		
	}

}
