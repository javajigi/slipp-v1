package net.slipp.domain;

import java.util.List;

import net.slipp.support.CustomJpaDao;

import org.springframework.stereotype.Repository;

@Repository
public class CommentDao extends CustomJpaDao<Comment> {
	public List<Comment> findByServiceType(ServiceType serviceType, Long commentedId) {
		return getObjectify().query(Comment.class).filter("serviceType", serviceType.name())
				.filter("commentedId", commentedId).list();
	}
}
