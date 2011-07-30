package net.slipp.web.support;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

@Controller
@RequestMapping("/upload/file")
public class UploadFileController {
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
	@RequestMapping("/form")
	public String uploadForm(ModelMap model) throws Exception {
		model.addAttribute("uploadUrl", blobstoreService.createUploadUrl("/upload/file"));
		return "support/upload";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String upload(HttpServletRequest request) throws Exception {
		Map<String, BlobKey> blobs = blobstoreService.getUploadedBlobs(request);
		BlobKey blobKey = blobs.get("uploadFile");
		
		return "redirect:/serve/file?key=" + blobKey.getKeyString();
	}
}
