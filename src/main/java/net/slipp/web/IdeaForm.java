package net.slipp.web;

import static net.slipp.support.DateTimeUtils.now;
import net.slipp.domain.Idea;

public class IdeaForm {
	public Idea to(String nickname, String email, String contents, String ipAddress) {
		return new Idea(nickname, email, contents, now(), ipAddress);
	}
}
