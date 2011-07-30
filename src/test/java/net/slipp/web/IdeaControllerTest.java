package net.slipp.web;

import static net.slipp.domain.IdeaTest.CHILD1;
import static net.slipp.domain.IdeaTest.PARENT;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import net.slipp.domain.Idea;
import net.slipp.domain.IdeaDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;

@RunWith(MockitoJUnitRunner.class)
public class IdeaControllerTest {
	@Mock
	private IdeaDao ideaDao;
	
	@InjectMocks
	private IdeaController dut = new IdeaController();
	
	@SuppressWarnings("unchecked")
	@Test
	public void list() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		ModelMap model = new ModelMap();
		int offset = 0;
		when(ideaDao.findsParent(offset, IdeaController.DEFAULT_PAGE_PER_COUNT)).thenReturn(Arrays.asList(PARENT, CHILD1));
		String forwardUrl = dut.list(request, model);
		verify(ideaDao).findsParent(offset, IdeaController.DEFAULT_PAGE_PER_COUNT);
		assertThat(forwardUrl, is("idea/list"));
		List<Idea> ideas = (List<Idea>)model.get("ideas");
		assertThat(ideas.size(), is(2));
		assertThat((Integer)model.get("previousPageNo"), is(1));
		assertThat((Integer)model.get("nextPageNo"), is(1));
	}
	
	@Test
	public void show_when_top() throws Exception {
		Long id=PARENT.getId();
		ModelMap model = new ModelMap();
		when(ideaDao.findById(id)).thenReturn(PARENT);
		String forwardUrl = dut.show(id, model);
		assertThat(forwardUrl, is("idea/show"));
		assertThat((Idea)model.get("idea"), is(PARENT));
	}
	
	@Test
	public void show_when_child() throws Exception {
		Idea child1 = CHILD1.link(PARENT);
		ModelMap model = new ModelMap();
		
		when(ideaDao.findById(child1.getId())).thenReturn(child1);
		when(ideaDao.findById(child1.getParentId())).thenReturn(PARENT);
		
		String forwardUrl = dut.show(child1.getId(), model);
		
		verify(ideaDao).findById(child1.getId());
		verify(ideaDao).findById(child1.getParentId());
		
		assertThat(forwardUrl, is("idea/show"));
		assertThat((Idea)model.get("idea"), is(PARENT));
	}
}
