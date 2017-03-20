package com.faisal.watchindia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.faisal.watchindia.domain.TvSeries;

@Service
public interface TvSeriesService {
	void add(TvSeries tvSeries);
	void edit(TvSeries tvSeries);
	void delete(int tvSeriesId);
	TvSeries getTvSeries(int tvSeriesId);
	List<TvSeries> getAllTvSeries();
}
