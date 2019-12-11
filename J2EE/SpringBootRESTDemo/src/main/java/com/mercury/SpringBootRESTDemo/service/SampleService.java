package com.mercury.SpringBootRESTDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRESTDemo.bean.Sample;
import com.mercury.SpringBootRESTDemo.dao.SampleDao;

@Service
public class SampleService {
	@Autowired
	SampleDao sampleDao;
	
	public List<Sample> getAllSamples() {
		return sampleDao.findAll();
	}
	
	public boolean findSampleById(String Id) {
		return sampleDao.existsById(Id);
	}
	
	public boolean addSample(Sample sample) {
		try {
			sampleDao.save(sample);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean updateSample(Sample newSample) {
		Optional<Sample> editSampleOption = 
		sampleDao.findById(newSample.getName());
		if (editSampleOption.isPresent()) {
			editSampleOption.get().setAge(newSample.getAge());
			sampleDao.flush();
			return true;
		} else {
			return false;
		}
	}
	
	public Sample deleteSampleById(String name) {
		// find the sample
		// exist: delete it
		// not exist: return null
		
		Sample deletedSample = null;
		if (sampleDao.existsById(name)) {
			deletedSample = sampleDao.findById(name).get();
			sampleDao.deleteById(name);
			sampleDao.flush();
		}
		return deletedSample;
	}
}



















