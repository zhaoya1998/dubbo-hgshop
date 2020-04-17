package com.zhaoya.hgshop.test;

import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.zhaoya.hgshop.pojo.Spu;
import com.zhaoya.hgshop.pojo.SpuVo;
import com.zhaoya.hgshop.service.SpuService;

@ContextConfiguration({"classpath:DubboConsumer.xml"})
@RunWith(SpringRunner.class)
public class TestSpu {
	
	@Reference
	SpuService spuService;
	
	@Test
	public  void testGet() {
		
		PageInfo<Spu> pageInfo = spuService.list(1, new SpuVo());
		List<Spu> list = pageInfo.getList();
		
		for (Spu spu : list) {
			System.out.println(" data is " + spu);
		}
		
		
	}
	

}
