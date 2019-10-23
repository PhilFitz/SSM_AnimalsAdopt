package com.adopt.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adopt.dao.StarDao;
import com.adopt.pojo.Star;
import com.adopt.pojo.StarExample;
@Transactional
@Service("starService")
public class StarServiceImpl implements StarService {
	
	@Resource
	private StarDao sd;

	@Override
	public long countByExample(StarExample example) {
		// TODO 自动生成的方法存根
		return sd.countByExample(example);
	}

	@Override
	public int deleteByExample(StarExample example) {
		// TODO 自动生成的方法存根
		return sd.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO 自动生成的方法存根
		return sd.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Star record) {
		// TODO 自动生成的方法存根
		return sd.insert(record);
	}

	@Override
	public int insertSelective(Star record) {
		// TODO 自动生成的方法存根
		return sd.insertSelective(record);
	}

	@Override
	public List<Star> selectByExample(StarExample example) {
		// TODO 自动生成的方法存根
		return sd.selectByExample(example);
	}

	@Override
	public Star selectByPrimaryKey(Integer id) {
		// TODO 自动生成的方法存根
		return sd.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(Star record, StarExample example) {
		// TODO 自动生成的方法存根
		return sd.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Star record, StarExample example) {
		// TODO 自动生成的方法存根
		return sd.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Star record) {
		// TODO 自动生成的方法存根
		return sd.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Star record) {
		// TODO 自动生成的方法存根
		return sd.updateByPrimaryKey(record);
	}

}
