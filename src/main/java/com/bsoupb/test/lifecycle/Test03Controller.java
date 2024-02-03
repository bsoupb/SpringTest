package com.bsoupb.test.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test03Controller {
	
	@RequestMapping("/lifecycle/test03")
	public String test03View() {  // jsp 경로 return
		return "lifecycle/test03";
	}
}
