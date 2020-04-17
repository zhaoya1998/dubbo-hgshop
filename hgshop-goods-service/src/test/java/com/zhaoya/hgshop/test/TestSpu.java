package com.zhaoya.hgshop.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhaoya.hgshop.pojo.Spu;
import com.zhaoya.hgshop.service.SpuService;



@ContextConfiguration({"classpath:applicationContext-dao.xml",
	"classpath:applicationContext-dubbo-provider.xml",
	"classpath:applicationContext-kafka-producer.xml"})
@RunWith(SpringRunner.class)
public class TestSpu {
	
	@Autowired
	SpuService supService;
	
	@Test
	public void testAdd(){
		Spu spu = new Spu();
		spu.setBrandId(1);
		spu.setCategoryId(10);
		spu.setGoodsName("ceshi shangping");
		spu.setCaption("test caption");
		supService.add(spu);
	}
	

}
