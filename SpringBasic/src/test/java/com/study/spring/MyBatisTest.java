package com.study.spring;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class MyBatisTest {
	@Inject
	private SqlSessionFactory sqlFactory;
	@Test
	public void testFactory(){
		System.out.println(sqlFactory);
	}
	@Test
	public void testSession()throws Exception{
		try(SqlSession session = sqlFactory.openSession()){
			System.out.println(session);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
