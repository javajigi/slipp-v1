package net.slipp.web;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalUserServiceTestConfig;

public class SignonControllerTest {
	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalUserServiceTestConfig());

	private SignonController dut = new SignonController();
	
	@Before
	public void setUp() {
		helper.setUp();
	}
	
	@Test
	public void login_when_already_login() throws Exception {
		helper.setEnvIsLoggedIn(true);
		String forwardUrl = dut.login();
		assertThat(forwardUrl, is("redirect:/"));
	}
	
	@Test
	public void login_when_logout() throws Exception {
		helper.setEnvIsLoggedIn(false);
		String forwardUrl = dut.login();
		assertThat(forwardUrl, notNullValue());
	}
	
	@Test
	public void logout_when_already_logout() throws Exception {
		helper.setEnvIsLoggedIn(false);
		String forwardUrl = dut.logout();
		assertThat(forwardUrl, is("redirect:/"));
	}
	
	@Test
	public void logout_when_login() throws Exception {
		helper.setEnvIsLoggedIn(true);
		String forwardUrl = dut.logout();
		assertThat(forwardUrl, notNullValue());
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}
}
