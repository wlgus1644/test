package com.study.spring.persistance;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.study.spring.domain.MemberVO;

//데이터를 가져오는 행위를 하는게 @Repository
//namespace의 경로를 따라가서 거기 아이디가 getNow 인거, insertMember인거로 접근. 
//즉, mappers 패키지의 memberMapper.xml로 접근하면 됨

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Inject
	private SqlSession sqlSession;
	private static final String namespace= "com.study.spring.mapper.memberMapper";

	@Override
	public String getNow(){
		return sqlSession.selectOne(namespace+".getNow"); //selectOne은 하나만 가져올때. MemberDAO에서 가져옴
	}
	@Override
	public void insertMember(MemberVO vo){
		sqlSession.insert(namespace+".insertMember", vo);
	}
	@Override
	public MemberVO get(String user_id) {
		return sqlSession.selectOne(namespace+".get", user_id);
	}
	@Override
	public List<MemberVO> getList() {
		return sqlSession.selectList(namespace+".getList");
	}
	@Override
	public void deleteMember(String user_id){
		sqlSession.delete(namespace+".deleteMember", user_id);
	}
	
	@Override
	public void updateMember(MemberVO vo){
		sqlSession.update(namespace+".updateMember", vo);
	
	}

}
