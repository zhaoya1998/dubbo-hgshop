package com.zhaoya.hgshop.pojo;

import java.io.Serializable;

/**
 * 规格的属性值
 *
 */
public class SpecOption  implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2673318397938607321L;
	private Integer id;
	
	// 黑色 白色  42M 43M  6.5 
	private  String optionName;//选项的内容
		
	//规格名称  颜色  尺寸  体积  容积 
	private  String specName;//选项的内容

	private  int specId;
	private int orders;
	
	
	
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public int getSpecId() {
		return specId;
	}
	public void setSpecId(int specId) {
		this.specId = specId;
	}
	public int getOrders() {
		return orders;
	}
	public void setOrders(int orders) {
		this.orders = orders;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + specId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpecOption other = (SpecOption) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (specId != other.specId)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "SpecOption [id=" + id + ", optionName=" + optionName + ", specName=" + specName + ", specId=" + specId
				+ ", orders=" + orders + "]";
	}
	
	

	
	

}
