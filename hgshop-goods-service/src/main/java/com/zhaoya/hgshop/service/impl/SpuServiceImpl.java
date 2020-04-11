package com.zhaoya.hgshop.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.zhaoya.hgshop.dao.SkuDao;
import com.zhaoya.hgshop.dao.SpuDao;
import com.zhaoya.hgshop.pojo.Spu;
import com.zhaoya.hgshop.pojo.SpuVo;
import com.zhaoya.hgshop.service.SpuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service(interfaceClass = SpuService.class)
public class SpuServiceImpl implements SpuService {

	@Autowired
	SpuDao spuDao;

	@Autowired
	SkuDao skuDao;

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	@Override
	public PageInfo<Spu> list(int page, SpuVo spuVo) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 12);
		return new PageInfo<Spu>(spuDao.list(spuVo));
	}

	@Override
	public int add(Spu spu) {
		// TODO Auto-generated method stub
		int result = spuDao.add(spu);
		// ���Ϳ�����Ϣ
		if (result > 0) {
			System.out.println("������Ϣ-------------");
			kafkaTemplate.send("spu", "add", spu.getId().toString());
		}
		return result;

	}

	@Override
	public int deleteBatch(int[] ids) {
		// TODO Auto-generated method stub

		// ˳���ܴ���
		// ɾ��sku������
		int result = skuDao.deleteSkuSpecBySpu(ids);
		// ɾ��sku
		result += skuDao.deleteBatchBySpu(ids);
		// ɾ��spu
		result += spuDao.deleteBatch(ids);

		return result;
	}

	@Override
	public int update(Spu spu) {
		// TODO Auto-generated method stub
		return spuDao.update(spu);
	}

	@Override
	public Spu getById(int id) {
		// TODO Auto-generated method stub
		return spuDao.getById(id);
	}

	@Override
	public int updateMarkable(int id, int marketable) {
		// TODO Auto-generated method stub
		return spuDao.updateMarkable(id, marketable);
	}

}
