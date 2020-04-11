package com.zhaoya.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhaoya.hgshop.pojo.Spec;

/**
 * ������ķ���
 */
public interface SpecService {
	
	
	/**
	 * 
	 * @param spec
	 * @return
	 */
	int add(Spec spec);
	
	//�޸�
	int update(Spec spec);
		
	//����  �޸ĵĻ���
	Spec findById(int id);
	
	/**
	* ����ɾ��
	* @param ids
	* @return
	*/
	int deleteBatch(int[] ids);
	
	//��ҳ��ѯ
	PageInfo<Spec> list(String name,int page);
		
	//��ȡ���еĹ��
	List<Spec> listAll();
	
	
}
