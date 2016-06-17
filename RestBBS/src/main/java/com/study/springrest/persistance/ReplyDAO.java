package com.study.springrest.persistance;

import java.util.List;

import com.study.springrest.domain.Criteria;
import com.study.springrest.domain.ReplyVO;



public interface ReplyDAO {
	
	public String getNow();
	public ReplyVO get(int reply_no);
	public List<ReplyVO> getList(int board_no);
	public List<ReplyVO> getListPage(int board_no, Criteria cri);
	public void insert(ReplyVO vo);
	public void update(ReplyVO vo);
	public void delete(int reply_no);
	public int getTotalCount(int board_no);

}
