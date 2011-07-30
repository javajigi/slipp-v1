package net.slipp.web;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.slipp.domain.AttachedFile;
import net.slipp.domain.AttachedFileDao;
import net.slipp.domain.CommentDao;
import net.slipp.domain.Diary;
import net.slipp.domain.DiaryDao;
import net.slipp.domain.ServiceType;
import net.slipp.support.DateTimeUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@Controller
@RequestMapping("/diaries")
public class DiaryController {
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

	@Autowired
	private DiaryDao diaryDao;
	@Autowired
	private AttachedFileDao attachedFileDao;

	@Autowired
	private CommentDao commentDao;

	private boolean isUserAdmin() {
		UserService userService = UserServiceFactory.getUserService();
		if (userService.isUserLoggedIn()) {
			return userService.isUserAdmin();
		} else {
			return false;
		}
	}

	@RequestMapping("/form")
	public String createForm(HttpServletRequest request, ModelMap model) {
		if (!isUserAdmin()) {
			return "redirect:/";
		}

		model.addAttribute("diary", new DiaryForm());
		model.addAttribute("attachFiles", new ArrayList<AttachedFile>());
		return "diary/create";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(DiaryForm diaryForm) {
		if (!isUserAdmin()) {
			return "redirect:/";
		}

		diaryDao.put(diaryForm.to());
		return "redirect:/";
	}

	@RequestMapping("/{id}")
	public String show(@PathVariable Long id, ModelMap model) {
		Diary diary = diaryDao.findById(id);
		model.addAttribute("comments", commentDao.findByServiceType(ServiceType.diaries, id));
		model.addAttribute("diary", diary);
		model.addAttribute("diaries", diaryDao.findsBeforeDiary(diary));
		return "diary/show";
	}

	@RequestMapping("/{id}/upload/form")
	public String uploadForm(@PathVariable Long id, ModelMap model) {
		Diary diary = diaryDao.findById(id);
		model.addAttribute("uploadUrl", blobstoreService.createUploadUrl(diary.getUrl() + "/upload"));
		model.addAttribute("diary", diary);
		return "diary/upload";
	}

	@RequestMapping(value = "/{id}/upload", method = RequestMethod.POST)
	public String upload(@PathVariable Long id, HttpServletRequest request) {
		Map<String, BlobKey> blobs = blobstoreService.getUploadedBlobs(request);
		Set<String> keys = blobs.keySet();
		for (String key : keys) {
			BlobKey blobKey = blobs.get(key);
			attachedFileDao.put(new AttachedFile(ServiceType.diaries, id, blobKey.getKeyString()));
		}
		return "redirect:/diaries/" + id + "/upload/completed";
	}
	
	@RequestMapping("/{id}/upload/completed")
	public String uploadCompleted() {
		return "diary/upload_completed";
	}	

	@RequestMapping("/{id}/form")
	public String updateForm(@PathVariable Long id, HttpServletRequest request, ModelMap model) {
		if (!isUserAdmin()) {
			return "redirect:/";
		}

		DiaryForm diaryForm = new DiaryForm();
		model.addAttribute("diary", diaryForm.from(diaryDao.findById(id)));
		model.addAttribute("attachFiles", attachedFileDao.findByServiceType(ServiceType.diaries, id));
		return "diary/create";
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public String update(DiaryForm diaryForm) {
		if (!isUserAdmin()) {
			return "redirect:/";
		}

		diaryDao.put(diaryForm.to());
		return "redirect:/";
	}

	@RequestMapping("/rss")
	public String rss(HttpServletResponse response, ModelMap model) {
		response.setContentType("text/xml;charset=utf-8");
		model.addAttribute("now", DateTimeUtils.now());
		model.addAttribute("diaries", diaryDao.finds(10));
		return "diary/rss";
	}
}
