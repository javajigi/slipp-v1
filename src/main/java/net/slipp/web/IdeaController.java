package net.slipp.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.slipp.domain.Idea;
import net.slipp.domain.IdeaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@Controller
@RequestMapping("/ideas")
public class IdeaController {
	static final int DEFAULT_PAGE_PER_COUNT = 5;

	@Autowired
	private IdeaDao ideaDao;

	@RequestMapping("")
	public String list(HttpServletRequest request, ModelMap model) throws Exception {
		int pageNo = ServletRequestUtils.getIntParameter(request, "pageNo", 1);
		int offset = (pageNo - 1) * DEFAULT_PAGE_PER_COUNT;

		int previousPageNo = pageNo == 1 ? pageNo : pageNo - 1;
		List<Idea> ideas = ideaDao.findsParent(offset, DEFAULT_PAGE_PER_COUNT);
		int nextPageNo = ideas.size() < DEFAULT_PAGE_PER_COUNT ? pageNo : pageNo + 1;
		model.addAttribute("previousPageNo", previousPageNo);
		model.addAttribute("nextPageNo", nextPageNo);
		model.addAttribute("ideas", ideas);
		return "idea/list";
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") Long id, ModelMap model) throws Exception {
		Idea idea = ideaDao.findById(id);

		if (!idea.isTop()) {
			idea = ideaDao.findById(idea.getParentId());
		}

		model.addAttribute("idea", idea);
		model.addAttribute("linkedIdeas", ideaDao.findsByParentId(idea.getId()));

		return "idea/show";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(String contents, HttpServletRequest request, ModelMap model) throws Exception {
		UserService userService = UserServiceFactory.getUserService();
		if (!userService.isUserLoggedIn()) {
			return "redirect:/ideas";
		}

		IdeaForm ideaForm = new IdeaForm();
		User user = userService.getCurrentUser();
		Idea idea = ideaForm.to(user.getNickname(), user.getEmail(), contents, request.getRemoteAddr());
		ideaDao.put(idea);

		return "redirect:/ideas";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String createLinked(@PathVariable("id") Long parentId, String contents, HttpServletRequest request,
			ModelMap model) throws Exception {
		UserService userService = UserServiceFactory.getUserService();
		if (!userService.isUserLoggedIn()) {
			return "redirect:/ideas";
		}

		IdeaForm ideaForm = new IdeaForm();
		User user = userService.getCurrentUser();
		Idea idea = ideaForm.to(user.getNickname(), user.getEmail(), contents, request.getRemoteAddr());
		Idea parent = ideaDao.findById(parentId);
		Idea linkedIdea = parent.link(idea);
		ideaDao.put(linkedIdea);
		ideaDao.put(parent);
		
		return "redirect:/ideas/" + parentId;
	}
}
