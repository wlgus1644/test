package com.study.springrest.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.study.springrest.domain.RestVO;
import com.study.springrest.persistance.RestDAO;

@Service
public class RestServiceImpl implements RestService{
	
	@Inject
	private RestDAO dao;

	@Override
	public String getNow(){
		return dao.getNow();
	}
	
	@Override
	public void insert(RestVO vo){
		dao.insert(vo);
	}
	
	@Override
	public RestVO get(int board_no) {
		return dao.get(board_no);
	}
	
	@Override
	public List<RestVO> getList() {
		return dao.getList();
	}
	
	@Override
	public void delete(int board_no){
		dao.delete(board_no);
	}
	
	@Override
	public void update(RestVO vo){
		dao.update(vo);
	
	}


}
