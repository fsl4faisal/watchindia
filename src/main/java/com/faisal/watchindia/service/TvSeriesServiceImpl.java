package com.faisal.watchindia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faisal.watchindia.dao.TvSeriesDao;
import com.faisal.watchindia.domain.TvSeries;

@Service
public class TvSeriesServiceImpl implements TvSeriesService{
	
	@Autowired
	private TvSeriesDao tvSeriesDao;
	
	@Override
	@Transactional
	public void add(TvSeries tvSeries) {
		// TODO Auto-generated method stub
		tvSeriesDao.add(tvSeries);
		
	}

	@Override
	@Transactional
	public void edit(TvSeries tvSeries) {
		// TODO Auto-generated method stub
		tvSeriesDao.edit(tvSeries);
	}

	@Override
	@Transactional
	public void delete(int tvSeriesId) {
		// TODO Auto-generated method stub
		tvSeriesDao.delete(tvSeriesId);
	}

	@Override
	@Transactional
	public TvSeries getTvSeries(int tvSeriesId) {
		// TODO Auto-generated method stub
		return tvSeriesDao.getTvSeries(tvSeriesId);
	}

	@Override
	@Transactional
	public List<TvSeries> getAllTvSeries() {
		// TODO Auto-generated method stub
		return tvSeriesDao.getAllTvSeries();
	}

}
