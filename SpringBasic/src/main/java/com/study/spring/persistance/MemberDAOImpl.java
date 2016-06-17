package com.study.spring.persistance;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.study.spring.domain.MemberVO;

//�����͸� �������� ������ �ϴ°� @Repository
//namespace�� ��θ� ���󰡼� �ű� ���̵� getNow �ΰ�, insertMember�ΰŷ� ����. 
//��, mappers ��Ű���� memberMapper.xml�� �����ϸ� ��

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Inject
	private SqlSession sqlSession;
	private static final String namespace= "com.study.spring.mapper.memberMapper";

	@Override
	public String getNow(){
		return sqlSession.selectOne(namespace+".getNow"); //selectOne�� �ϳ��� �����ö�. MemberDAO���� ������
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
