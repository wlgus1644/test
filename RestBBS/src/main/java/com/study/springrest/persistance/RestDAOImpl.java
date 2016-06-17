package com.study.springrest.persistance;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.study.springrest.domain.RestVO;

@Repository
public class RestDAOImpl implements RestDAO{
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace= "com.study.springrest.mappers.restMapper";

	@Override
	public String getNow(){
		return sqlSession.selectOne(namespace+".getNow"); //selectOne은 하나만 가져올때. MemberDAO에서 가져옴
	}
	@Override
	public void insert(RestVO vo){
		sqlSession.insert(namespace+".insert", vo);
	}
	@Override
	public RestVO get(int board_no) {
		return sqlSession.selectOne(namespace+".get", board_no);
	}
	@Override
	public List<RestVO> getList() {
		return sqlSession.selectList(namespace+".getList");
	}
	@Override
	public void delete(int board_no){
		sqlSession.delete(namespace+".delete", board_no);
	}
	
	@Override
	public void update(RestVO vo){
		sqlSession.update(namespace+".update", vo);
	
	}
	@Override
	public void increaseReply(int board_no) {
		sqlSession.update(namespace+".increaseReply", board_no);
		
	}


}
