package com.zhaoya.hgshop.kafka;

import org.apache.dubbo.config.annotation.Reference;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.listener.MessageListener;

import com.zhaoya.hgshop.pojo.Spu;
import com.zhaoya.hgshop.pojo.SpuEsVo;
import com.zhaoya.hgshop.service.SpuService;
import com.zhaoya.hgshop.utils.ElSearchUtil;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author 45466
 *
 */
public class SpuMessageListner implements MessageListener<String, String> {

	@Autowired
	private RedisTemplate<String, PageInfo<Spu>> redisTemplate;

	@Reference
	SpuService spuService;

	@Autowired
	private ElSearchUtil<SpuEsVo> elSearchUtil;
	private Logger logger = Logger.getLogger(SpuMessageListner.class);

	{
		System.out.println("------------���ﱻʵ�����ˡ�������������������������");
	}

	public void onMessage(ConsumerRecord<String, String> data) {

		System.out.println("get a message .......... ");
		// ��ȡkeyֵ
		String key = data.key();

		if (key != null) {
			// �ж�
			System.out.println("key is " + key);
			String value = data.value();
			System.out.println("value is " + value);
			switch (key) {
			case "add":
				//
				System.out.println("����ӵ���Ʒ��id��" + value);
				// ��ջ���
				redisTemplate.delete("GOODS_FIRST_PAGE");
				// ��ȡspu Ȼ����뵽es
				Spu spu = spuService.getById(Integer.parseInt(value));
				SpuEsVo esVo = new SpuEsVo(spu);
				// ����ES ����
				elSearchUtil.saveObject(value, esVo);
				break;
			case "delete":
				break;

			case "update":

				break;
			default:
				break;
			}
		} else {
			logger.info("keyδnullֵ");
		}

	}

}
