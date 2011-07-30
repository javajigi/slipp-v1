package net.slipp.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import net.slipp.support.AbstractDaoTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AttachedFileDaoTest extends AbstractDaoTest {
	private AttachedFileDao dut;

	@Before
	public void setup() {
		helper.setUp();
		dut = new AttachedFileDao();
		dut.setObjectifyFactory(objectifyFactory);
	}

	@Test
	public void findsByService() throws Exception {
		AttachedFile file1 = new AttachedFile(ServiceType.diaries, 1L, "amjw_qn8zILOF0RRufoWTQ");
		AttachedFile file2 = new AttachedFile(ServiceType.diaries, 1L, "amjw_qn8zILOF0RRufoEEE");
		dut.put(file1);
		dut.put(file2);
		List<AttachedFile> files = dut.findByServiceType(ServiceType.diaries, 1L);
		assertThat(files.size(), is(2));
	}

	@After
	public void teardown() {
		helper.tearDown();
	}

}
