package com.mercury.spring_mvc_demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mercury.spring_mvc_demo.bean.Sample;
import com.mercury.spring_mvc_demo.service.SampleService;

// GET /samples
// POST /samples

@Controller
@RequestMapping(value="/samples")
public class SampleController {
	
	@Autowired
	SampleService sampleService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<Sample> getSamples() {
		return sampleService.getAllSamples();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> postSamples(@RequestBody Sample sample) {
		Map<String, Object> response = new HashMap<>();
		response.put("success", sampleService.insertSample(sample));
		return response;
	}
}






