package com.mercury.spring_mvc_demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mercury.spring_mvc_demo.bean.Sample;

@Repository
public class SampleDao {
	List<Sample> samples = new ArrayList<>();
	
	public SampleDao() {
		samples.add(new Sample("bob", 21));
		samples.add(new Sample("alice", 22));
		samples.add(new Sample("alex", 23));
	}
	
	public List<Sample> findAll() {
		return samples;
	}
	
	public void addSample(Sample sample) {
		samples.add(sample);	
	}
	
	public Sample findOne(String name) {
		return samples.stream()
				.filter(s -> s.getName().equals(name))
				.findAny().orElse(null); // 如果找不到返回 null.
	}
}









