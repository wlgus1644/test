package com.study.springrest.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.springrest.domain.Criteria;
import com.study.springrest.domain.ReplyVO;
import com.study.springrest.persistance.ReplyDAO;
import com.study.springrest.persistance.RestDAO;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Inject
	private ReplyDAO dao;
	
	@Inject
	private RestDAO restDao;

	public String getNow(){
		return dao.getNow();
	}
	
	public void insert(ReplyVO vo){
		restDao.increaseReply(vo.getBoard_no());
		dao.insert(vo);
	}
	
	public ReplyVO get(int reply_no) {
		return dao.get(reply_no);
	}
	public List<ReplyVO> getList(int board_no) {
		return dao.getList(board_no);
	}
	public void delete(int reply_no){
		dao.delete(reply_no);
	}
	
	public void update(ReplyVO vo){
		dao.update(vo);
	
	}
	@Override
	public List<ReplyVO> getListPage(int board_no, Criteria cri) {
		return dao.getListPage(board_no, cri);
	}
	@Override
	public int getTotalCount(int board_no) {
		return dao.getTotalCount(board_no);
	}
}
