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

스프링에서 쓰는 @ 종류
@도 객체다

@Controller 
@Service
@Repository
@Component

1. 사용자가 브라우저를 통해서 URI를 호출 

2. 톰캣에 설치된 [스프링 프레임웍]이 
	-> Controller 전체를 검색해서 @RequestMapping 을 찾아서
	-> @의 value 값들을 uri와 매칭을 시킨다.
	
3. uri와 매핑된 메소드에서 return 해주는 문자열과 이름이 같은 jsp파일을 사용자에게 넘겨준다.

@RunWith() 는 이거랑 같이 실행시키겠다는 것.

@Inject 의존성 주입
자동으로 객체를 저장해줌. private DataSource ds;

@Test
root-context.xml에 쓰인 bean id 값들을 src/test/java 안에 있는 MyBatisTest.java에서 가져다 써서 테스트해본다.


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
