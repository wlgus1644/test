package com.study.springrest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.study.springrest.controller.Reply;
import com.study.springrest.domain.Criteria;
import com.study.springrest.domain.PageMaker;
import com.study.springrest.domain.ReplyVO;
import com.study.springrest.domain.RestVO;
import com.study.springrest.service.ReplyService;
import com.study.springrest.service.RestService;

@RestController
@RequestMapping("/reply")
public class Reply {
	
	@Inject
	private ReplyService service;

	//	/����/ ���
	@RequestMapping(value = "/{board_no}", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("board_no") Integer board_no) {
		
		ResponseEntity<List<ReplyVO>> entity = null;
		try{
			entity=	new ResponseEntity<>(service.getList(board_no), HttpStatus.OK);
		}catch(Exception e){
			entity= new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	
	}
	
	//	/����/�۹�ȣ	��
//	@RequestMapping(value = "/{reply_no}", method = RequestMethod.GET)
//	public ModelAndView detail(@PathVariable("reply_no") Integer reply_no) {
//		ModelAndView aaa = new ModelAndView();
//		aaa.setViewName("detail");
//		ReplyVO vo = service.get(reply_no);
//		aaa.addObject("vo", vo);
//		return aaa;
//	}
	
	
	//	/����/ method=post
	@RequestMapping(value = "/{board_no}", method = RequestMethod.POST)
	public ResponseEntity<String> insert(@RequestBody ReplyVO vo, 
										 @PathVariable("board_no") Integer board_no) {	
		ResponseEntity<String> entity = null;
		
		try{
			vo.setBoard_no(board_no);
			service.insert(vo);
			entity= new ResponseEntity<>("SUCCESS",HttpStatus.OK);
		}catch(Exception e){
			entity= new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
		
		return entity;
	}

	
//	/����/��� ���� method=post
	@RequestMapping(value = "/{reply_no}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("reply_no") Integer reply_no) {	
		ResponseEntity<String> entity = null;
		
		try{
			service.delete(reply_no);
			entity= new ResponseEntity<>("SUCCESS",HttpStatus.OK);
		}catch(Exception e){
			entity= new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
		
		return entity;
	}
	
	
	
	//	/����/ ���
	@RequestMapping(value = "/{board_no}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> listPage(
			@PathVariable("board_no") Integer board_no,
			@PathVariable("page") Integer page) {
		
		ResponseEntity<Map<String,Object>> entity = null;
		
		try{
			//������ ó���� ���� Criteria ����
			Criteria criteria = new Criteria();
			criteria.setPage(page);
			
			//��� ���� ��������
			int replyTotal = service.getTotalCount(board_no);
			//��� ��������
			List<ReplyVO> list = service.getListPage(board_no,criteria);
			
			//������ ����Ŀ�� �� ��� ������, ������������ �ִ� Criteria �Ѱܼ� ����¡ ���� ����Ѵ�.
			PageMaker pm = new PageMaker(criteria, replyTotal);
			
			//���������� Map�� ��� ��ϰ� ����¡ ó�� ���� ��Ƽ� 
			Map<String,Object> map = new HashMap<>();
			map.put("l", list);
			map.put("p", pm);
			
			//�������� �����Ѵ�.
			entity=	new ResponseEntity<>(map, HttpStatus.OK);
			
		}catch(Exception e){
			entity= new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	
	}


}
