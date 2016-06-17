package com.study.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
