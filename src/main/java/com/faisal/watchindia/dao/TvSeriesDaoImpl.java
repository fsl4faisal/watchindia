package com.faisal.watchindia.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faisal.watchindia.domain.TvSeries;

@Repository
public class TvSeriesDaoImpl implements TvSeriesDao {
	
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(TvSeries tvSeries) {
		session.getCurrentSession().save(tvSeries);
		
	}

	@Override
	public void edit(TvSeries tvSeries) {
		session.getCurrentSession().update(tvSeries);
		
	}

	@Override
	public void delete(int tvSeriesId) {
		session.getCurrentSession().delete(getTvSeries(tvSeriesId));
		
	}

	@Override
	public TvSeries getTvSeries(int tvSeriesId) {
		return (TvSeries)session.getCurrentSession().get(TvSeries.class, tvSeriesId);
	}

	@Override
	public List<TvSeries> getAllTvSeries() {
		return session.getCurrentSession().createQuery("from TvSeries").list();
	}

}
