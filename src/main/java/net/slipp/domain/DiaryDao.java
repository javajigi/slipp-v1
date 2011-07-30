package net.slipp.domain;

import java.util.List;

import net.slipp.support.CustomJpaDao;

import org.springframework.stereotype.Repository;

import com.googlecode.objectify.Objectify;

@Repository
public class DiaryDao extends CustomJpaDao<Diary> {
	public List<Diary> finds(int limit) {
		Objectify objectify = getObjectify();
		return objectify.query(Diary.class).order("-createdDate").limit(limit).list();
	}

	public List<Diary> findsBeforeDiary(Diary current) {
		List<Diary> diaries = getObjectify().query(Diary.class)
			.filter("createdDate <", current.getCreatedDate())
			.offset(0)
			.limit(5)
		    .order("-createdDate")
		    .list();
	    return diaries;
    }
}
