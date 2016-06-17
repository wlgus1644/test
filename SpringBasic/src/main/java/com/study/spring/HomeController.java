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
