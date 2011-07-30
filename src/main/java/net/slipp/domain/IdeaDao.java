package net.slipp.domain;

import java.util.List;

import net.slipp.support.CustomJpaDao;

import org.springframework.stereotype.Repository;

@Repository
public class IdeaDao extends CustomJpaDao<Idea> {
	public List<Idea> findsByParentId(Long parentId) {
		return getObjectify().query(Idea.class).filter("parentId", parentId).order("-createdDate").list();
	}
	
	public List<Idea> finds(int offset, int countPerPage) {
		return getObjectify()
				.query(Idea.class)
				.order("-createdDate")
				.offset(offset)
				.limit(countPerPage)
				.list();
	}

	public List<Idea> findsParent(int offset, int countPerPage) {
		return getObjectify()
				.query(Idea.class)
				.filter("parentId", null)
				.order("-createdDate")
				.offset(offset)
				.limit(countPerPage)
				.list();
	}

}
