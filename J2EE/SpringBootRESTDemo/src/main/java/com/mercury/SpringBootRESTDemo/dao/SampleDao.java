package com.mercury.SpringBootRESTDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRESTDemo.bean.Sample;

// must: extends JpaRepository<Sample, String>
public interface SampleDao extends JpaRepository<Sample, String> {

}

// SpringDataJPA will help implements: class SampleDaoIm implements SampleDao {}
