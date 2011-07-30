package net.slipp.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;

public class IdeaTest {
	public static final Idea PARENT = new Idea(1L, "javajigi", "javajigi@gmail.com", "parent_contents", new Date(), "127.0.0.1");
	public static final Idea CHILD1 = new Idea(2L, "javajigi", "javajigi@gmail.com", "child1", new Date(), "127.0.0.1");
	public static final Idea CHILD2 = new Idea(3L, "javajigi", "javajigi@gmail.com", "child2", new Date(), "127.0.0.1");
	
	@Test
	public void link() throws Exception {
		Idea idea = PARENT.link(CHILD1);
		assertThat(PARENT.getLinkCount(), is(1));
		assertThat(idea.getParentId(), is(PARENT.getId()));
	}
	
	@Test
	public void is_root() throws Exception {
		assertThat(PARENT.isTop(), is(true));
		Idea child1 = PARENT.link(CHILD1);
		assertThat(child1.isTop(), is(false));
	}
}
