package com.zhaoya.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zhaoya.hgshop.pojo.Spec;
import com.zhaoya.hgshop.pojo.SpecOption;

public interface SpecDao {

	int addSpec(Spec spec);

	int addSpecOption(SpecOption specOption);

	int updateSpec(Spec spec); 

	int deleteSpecOption(Integer id);

	int deteteBatch(int[] ids);

	int deteteOptionBatch(int[] ids);

	List<Spec> list(@Param("name") String name);

	Spec getById(int id);
	
	@Select("select id ,spec_name specName  from hg_spec order by spec_name")
	List<Spec> listAll();

}
