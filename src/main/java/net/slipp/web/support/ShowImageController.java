package net.slipp.web.support;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

@Controller
@RequestMapping("/show/images")
public class ShowImageController {
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
	@RequestMapping("/{key}")
	public ModelAndView showImage(@PathVariable String key, HttpServletResponse response) throws Exception {
		BlobKey blobKey = new BlobKey(key);
		blobstoreService.serve(blobKey, response);
		return null;
	}
}
