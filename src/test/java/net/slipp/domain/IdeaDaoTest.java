package net.slipp.domain;

import static net.slipp.domain.IdeaTest.CHILD1;
import static net.slipp.domain.IdeaTest.CHILD2;
import static net.slipp.domain.IdeaTest.PARENT;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import net.slipp.support.AbstractDaoTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IdeaDaoTest extends AbstractDaoTest {
	private IdeaDao dut;
	
	@Before
	public void setUp(){
		helper.setUp();
		dut = new IdeaDao();
		dut.setObjectifyFactory(objectifyFactory);
	}
	
	@Test
	public void base() throws Exception {
		Idea idea = PARENT;
		dut.put(idea);
		assertThat(dut.findById(idea.getId()), is(idea));
		
		dut.delete(idea.getId());
		assertThat(dut.findById(idea.getId()), nullValue());
	}
	
	@Test
	public void get_children() throws Exception {
		Idea parent = PARENT;
		dut.put(parent);
		Idea child1 = parent.link(CHILD1);
		dut.put(child1);
		Idea child2 = parent.link(CHILD2);
		dut.put(child2);		
		
		List<Idea> children = dut.findsByParentId(parent.getId());
		assertThat(children.size(), is(2));
	}
	
	@Test
	public void finds_parent() throws Exception {
		int countPerPage = 5;
		int offset = 0;
		dut.put(PARENT);
		Idea child1 = PARENT.link(CHILD1);
		dut.put(child1);
		Idea child2 = PARENT.link(CHILD2);
		dut.put(child2);
		List<Idea> ideas = dut.findsParent(offset, countPerPage);
		assertThat(ideas.size(), is(1));
		assertThat(ideas.get(0), is(PARENT));
	}
	
	
	@After
	public void tearDown() {
		helper.tearDown();
	}
}
