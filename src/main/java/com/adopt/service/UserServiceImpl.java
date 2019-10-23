package com.adopt.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adopt.dao.UserDao;
import com.adopt.pojo.User;
import com.adopt.pojo.UserExample;
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao ud;

	@Override
	public long countByExample(UserExample example) {
		// TODO 自动生成的方法存根
		return ud.countByExample(example);
	}

	@Override
	public int deleteByExample(UserExample example) {
		// TODO 自动生成的方法存根
		return ud.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO 自动生成的方法存根
		return ud.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(User record) {
		// TODO 自动生成的方法存根
		return ud.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		// TODO 自动生成的方法存根
		return ud.insertSelective(record);
	}

	@Override
	public List<User> selectByExample(UserExample example) {
		// TODO 自动生成的方法存根
		return ud.selectByExample(example);
	}

	@Override
	public User selectByPrimaryKey(Integer id) {
		// TODO 自动生成的方法存根
		return ud.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(User record, UserExample example) {
		// TODO 自动生成的方法存根
		return ud.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(User record, UserExample example) {
		// TODO 自动生成的方法存根
		return ud.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO 自动生成的方法存根
		return ud.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		// TODO 自动生成的方法存根
		return ud.updateByPrimaryKey(record);
	}

}
