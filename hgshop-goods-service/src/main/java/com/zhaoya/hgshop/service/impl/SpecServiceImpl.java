package com.zhaoya.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhaoya.hgshop.dao.SpecDao;
import com.zhaoya.hgshop.pojo.Spec;
import com.zhaoya.hgshop.pojo.SpecOption;
import com.zhaoya.hgshop.service.SpecService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service(interfaceClass = SpecService.class)
public class SpecServiceImpl implements SpecService {

	@Autowired
	SpecDao specDao;

	@Override
	public int add(Spec spec) {
		// TODO Auto-generated method stub
		// 插入主表
		int result = specDao.addSpec(spec);
		List<SpecOption> optionList = spec.getOptionList();
		// 插入子表
		for (SpecOption specOption : optionList) {
			specOption.setSpecId(spec.getId());
			result += specDao.addSpecOption(specOption);
		}

		return result;
	}

	@Override
	public int update(Spec spec) {
		// TODO Auto-generated method stub
		int result = specDao.updateSpec(spec);

		// 删除子表数据
		result += specDao.deleteSpecOption(spec.getId());

		List<SpecOption> optionList = spec.getOptionList();

		// 重新插入子表
		for (SpecOption specOption : optionList) {
			specOption.setSpecId(spec.getId());
			result += specDao.addSpecOption(specOption);
		}

		return result;
	}

	@Override
	public Spec findById(int id) {
		// TODO Auto-generated method stub
		return specDao.getById(id);
	}

	@Override
	public int deleteBatch(int[] ids) {
		// TODO Auto-generated method stub
		// 删除主表
		int result = specDao.deteteBatch(ids);
		// 删除子表
		result += specDao.deteteOptionBatch(ids);

		return result;
	}

	@Override
	public PageInfo<Spec> list(String name, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);
		return new PageInfo<Spec>(specDao.list(name));
	}

	@Override
	public List<Spec> listAll() {
		// TODO Auto-generated method stub
		return specDao.listAll();
	}

}
