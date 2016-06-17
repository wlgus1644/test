package com.study.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.spring.domain.MemberVO;
import com.study.spring.service.MemberService;

/**
 * Handles requests for the application home page.
 * 
 * 

���������� ���� @ ����
@�� ��ü��

@Controller 
@Service
@Repository
@Component

1. ����ڰ� �������� ���ؼ� URI�� ȣ�� 

2. ��Ĺ�� ��ġ�� [������ �����ӿ�]�� 
	-> Controller ��ü�� �˻��ؼ� @RequestMapping �� ã�Ƽ�
	-> @�� value ������ uri�� ��Ī�� ��Ų��.
	
3. uri�� ���ε� �޼ҵ忡�� return ���ִ� ���ڿ��� �̸��� ���� jsp������ ����ڿ��� �Ѱ��ش�.

@RunWith() �� �̰Ŷ� ���� �����Ű�ڴٴ� ��.

@Inject ������ ����
�ڵ����� ��ü�� ��������. private DataSource ds;

@Test
root-context.xml�� ���� bean id ������ src/test/java �ȿ� �ִ� MyBatisTest.java���� ������ �Ἥ �׽�Ʈ�غ���.


 */
@Controller
public class MemberController {
	
	@Inject
	private MemberService service;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String Member(Locale locale, Model model) {
		List<MemberVO> member_list = service.getList();
		model.addAttribute("list",member_list);
		return "member_list";
	}
	
	
	@RequestMapping(value = "/member", method = RequestMethod.POST)
	public String MemberInsert(MemberVO vo, Model model) {
		service.insertMember(vo);
		return "redirect:/member";
	}
	
	@RequestMapping(value = "/memberWrite", method = RequestMethod.GET)
	public void MemberWrite() {
	}
	
	@RequestMapping(value = "/memberUpdate", method = RequestMethod.GET)
	public void memberUpdate(MemberVO vo, Model model) {
		service.updateMember(vo);
	}
	
	@RequestMapping(value = "/memberDelete", method = RequestMethod.POST)
	public String deleteMember(@RequestParam("user_id") String user_id, Model model) {
		
		//@RequestParam("user_id") String user_id
		//String user_id= request.getParameter("user_id");
		service.deleteMember(user_id);
		return "redirect:/member";
	}
	

}
