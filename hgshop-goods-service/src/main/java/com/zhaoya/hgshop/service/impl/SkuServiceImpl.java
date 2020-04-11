package com.zhaoya.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhaoya.hgshop.dao.SkuDao;
import com.zhaoya.hgshop.pojo.Sku;
import com.zhaoya.hgshop.pojo.SkuVo;
import com.zhaoya.hgshop.pojo.SpecOption;
import com.zhaoya.hgshop.service.SkuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author zhuzg
 *
 */
@Service(interfaceClass=SkuService.class)
public class SkuServiceImpl implements SkuService{
	
	@Autowired
	SkuDao skuDao;

	@Override
	public int add(Sku sku) {
		// TODO Auto-generated method stub
		// ������������  ��ӵ�����
		int resutl = skuDao.add(sku);
		
		List<SpecOption> optionList = sku.getSpecOptionList();
		//�����ӱ�
		for (SpecOption specOption : optionList) {
			//�����ӱ�
			resutl += skuDao.addSkuSpec(sku.getId(),specOption);
		}
		
		return resutl;
	}

	@Override
	public int deleteBatch(int[] ids) {
		// TODO Auto-generated method stub
		// ɾ������
		int result = skuDao.deleteBatch(ids);
		//ɾ���ӱ�
		result += skuDao.deleteSkuSpec(ids);
		
		return result;
	}

	@Override
	public int update(Sku sku) {
		// TODO Auto-generated method stub
		//���޸�����
		int resutl = skuDao.update(sku);
		//�������������id ɾ���ӱ��������
		resutl += skuDao.deleteSkuSpec(sku.getId());
		
		List<SpecOption> optionList = sku.getSpecOptionList();
		//���²����ӱ�
		for (SpecOption specOption : optionList) {
			//�����ӱ�
			resutl += skuDao.addSkuSpec(sku.getId(),specOption);
		}
		
		
		
		return resutl;
	}

	@Override
	public PageInfo<Sku> list(int page, SkuVo skuVo) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,10);
		return new PageInfo<Sku>(skuDao.list(skuVo));
		
	}

	@Override
	public Sku getById(int id) {
		// TODO Auto-generated method stub
		return skuDao.getById(id);
	}

	@Override
	public List<Sku> getBySpuId(int spuId) {
		// TODO Auto-generated method stub
		return skuDao.getBySpuId(spuId);
	}
	
}
