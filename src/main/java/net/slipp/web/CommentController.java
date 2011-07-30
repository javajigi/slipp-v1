package net.slipp.web;

import static net.slipp.support.DateTimeUtils.now;

import javax.servlet.http.HttpServletRequest;

import net.slipp.domain.Comment;
import net.slipp.domain.CommentDao;
import net.slipp.domain.Diary;
import net.slipp.domain.DiaryDao;
import net.slipp.domain.ServiceType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@Controller
@RequestMapping("/{serviceType}/{commentedId}/comments")
public class CommentController {
	@Autowired
	private DiaryDao diaryDao;
	
	@Autowired
	private CommentDao commentDao;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(@PathVariable ServiceType serviceType, @PathVariable Long commentedId, String contents,
			HttpServletRequest request, ModelMap model) throws Exception {
		UserService userService = UserServiceFactory.getUserService();
		if (!userService.isUserLoggedIn()) {
			return "redirect:/" + serviceType.name() + "/" + commentedId;
		}

		Diary diary = diaryDao.findById(commentedId);
		diary.commented();
		User user = userService.getCurrentUser();
		Comment comment = new Comment(serviceType, commentedId, user.getNickname(), user.getEmail(), contents, now(),
				request.getRemoteAddr());
		commentDao.put(comment);
		diaryDao.put(diary);

		return "redirect:/" + serviceType.name() + "/" + commentedId;
	}
}
