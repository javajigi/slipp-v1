package net.slipp.web;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import net.slipp.domain.Diary;
import net.slipp.domain.DiaryDao;
import net.slipp.domain.Idea;
import net.slipp.domain.IdeaDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {
	@Mock
	private DiaryDao diaryDao;
	
	@Mock
	private IdeaDao ideaDao;
	
	@InjectMocks
	private HomeController dut = new HomeController();
	
    @Test
	public void index() throws Exception {
    	when(diaryDao.finds(HomeController.DEFAULT_DIARY_COUNT)).thenReturn(new ArrayList<Diary>());
    	when(ideaDao.findsParent(0, HomeController.DEFAULT_IDEA_COUNT)).thenReturn(new ArrayList<Idea>());
		ModelMap model = new ModelMap();
		String forwardUrl = dut.index(model);
		assertThat(forwardUrl, is("index"));
	}
}
