package com.mercury.spring_mvc_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.spring_mvc_demo.bean.Sample;
import com.mercury.spring_mvc_demo.dao.SampleDao;

@Service
public class SampleService {
	
	@Autowired
	SampleDao sampleDao;
	
	public List<Sample> getAllSamples() {
		return sampleDao.findAll();
	}
	
	public Sample findSampleByName(String name) {
		return sampleDao.findOne(name);
	}
	
	public boolean insertSample(Sample sample) {
		// business logic
		if(findSampleByName(sample.getName()) == null) {
			sampleDao.addSample(sample);
			return true;
		} else {
			return false;
		}
	}
	
	
}








