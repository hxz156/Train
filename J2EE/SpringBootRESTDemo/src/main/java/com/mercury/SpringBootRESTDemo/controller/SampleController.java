package com.mercury.SpringBootRESTDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRESTDemo.bean.Sample;
import com.mercury.SpringBootRESTDemo.service.SampleService;

@RestController // === @Controller + @ResponseBody
@RequestMapping("/samples")
public class SampleController {
	
	@Autowired
	SampleService sampleService;
	
	// GET /samples
	// GET /samples?minAge=20&nameContains=b
	// request query parameter
	@PreAuthorize("isAuthenticated()") // corresponding to @EnableGlobalMethodSecurity(prePostEnabled=true)
	@GetMapping // === @RequestMapping(Request......)
	public List<Sample> getSample(
			@RequestParam(value="minAge", required=false) Integer minAge) {
		if (minAge == null) {
			return sampleService.getAllSamples();
		} else {
			// TODO: change to get samples using min age
			return sampleService.getAllSamples(); 
		}
	}
	
	// POST /samples (use request body)
	// PUT /samples/{name}
	// DELETE /samples/{name}
	
	@PutMapping("/{name}") // means which name you want to put
	public Boolean putSamples(@RequestBody Sample sample, 
			@PathVariable("name") String name) {
		
		// 从 url 拿到参数：
		// @PathVariable("name") String name:
		// String name from "name" which is from "/{name}"
		
		// find if the name is already exist.
		// exist: update the corresponding Sample
		// not exist: POST the new Sample
		if (sampleService.findSampleById(sample.getName())) {
			sampleService.updateSample(sample);
		} else {
			sampleService.addSample(sample);
		}
		return true;
	}
	
	@DeleteMapping
	public Sample deleteSample(@RequestBody Sample sample) {
		Sample deletedSample = sampleService.deleteSampleById(sample.getName());
		return sample;
	}
	
	@PostMapping
	public boolean postSample(@RequestBody Sample sample) {
		// find the sample
		// exist: return false
		// not exist: add it, then return true.
		
		if (sampleService.findSampleById(sample.getName())) {
			return false;
		} else {
			sampleService.addSample(sample);
			return true;
		}
	}
}








