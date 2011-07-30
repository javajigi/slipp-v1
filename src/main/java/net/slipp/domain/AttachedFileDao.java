package net.slipp.domain;

import java.util.List;

import net.slipp.support.CustomJpaDao;

import org.springframework.stereotype.Repository;

@Repository
public class AttachedFileDao extends CustomJpaDao<AttachedFile> {

	public List<AttachedFile> findByServiceType(ServiceType serviceType, Long contentsId) {
		return getObjectify().query(AttachedFile.class).filter("serviceType", serviceType.name())
			.filter("contentsId", contentsId).list();
	}

}
