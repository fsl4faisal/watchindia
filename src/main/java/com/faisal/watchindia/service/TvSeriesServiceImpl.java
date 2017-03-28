package com.faisal.watchindia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faisal.watchindia.dao.TvSeriesDao;
import com.faisal.watchindia.dto.TvSeries;

@Service
public class TvSeriesServiceImpl implements TvSeriesService {

	@Autowired
	private TvSeriesDao tvSeriesDao;

	@Override
	@Transactional
	public void add(TvSeries tvSeriesDTO) {
		com.faisal.watchindia.domain.TvSeries tvSeriesModel = new com.faisal.watchindia.domain.TvSeries();
		BeanUtils.copyProperties(tvSeriesDTO, tvSeriesModel);
		tvSeriesDao.add(tvSeriesModel);

	}

	@Override
	@Transactional
	public void edit(TvSeries tvSeriesDTO) {
		com.faisal.watchindia.domain.TvSeries tvSeriesModel = new com.faisal.watchindia.domain.TvSeries();
		BeanUtils.copyProperties(tvSeriesDTO, tvSeriesModel);
		tvSeriesDao.edit(tvSeriesModel);
	}

	@Override
	@Transactional
	public void delete(int tvSeriesId) {
		tvSeriesDao.delete(tvSeriesId);
	}

	@Override
	@Transactional
	public TvSeries getTvSeries(int tvSeriesId) {
		com.faisal.watchindia.domain.TvSeries tvSeriesModel = tvSeriesDao.getTvSeries(tvSeriesId);
		TvSeries tvSeriesDTO = new TvSeries();
		BeanUtils.copyProperties(tvSeriesModel, tvSeriesDTO);
		return tvSeriesDTO;
	}

	@Override
	@Transactional
	public List<TvSeries> getAllTvSeries() {
		List<TvSeries> tvSeriesListDTO = new ArrayList<TvSeries>();
		List<com.faisal.watchindia.domain.TvSeries> tvSeriesListDomain = tvSeriesDao.getAllTvSeries();
		for(int i=0;i<tvSeriesListDomain.size();i++){
			TvSeries target=new TvSeries();
			BeanUtils.copyProperties(tvSeriesListDomain.get(i), target);
			tvSeriesListDTO.add(target);
		}
		
		return tvSeriesListDTO;
	}

}
