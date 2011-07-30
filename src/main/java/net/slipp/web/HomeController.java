package net.slipp.web;

import net.slipp.domain.DiaryDao;
import net.slipp.domain.IdeaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	static final int DEFAULT_DIARY_COUNT = 3;
	static final int DEFAULT_IDEA_COUNT = 5;
	
	@Autowired
	private DiaryDao diaryDao;
	
	@Autowired
	private IdeaDao ideaDao;
	
	@RequestMapping("")
	public String index(ModelMap model) {
		model.addAttribute("diaries", diaryDao.finds(DEFAULT_DIARY_COUNT));
		model.addAttribute("ideas", ideaDao.finds(0, DEFAULT_IDEA_COUNT));
		return "index";
	}
}
