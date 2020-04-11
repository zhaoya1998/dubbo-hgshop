package com.zhaoya.hgshop.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * ¶©µ¥
 * @author 45466
 *
 */
public class Orders implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1579818203846908869L;
	
	private Integer oid;
	private int  uid;
	private BigDecimal  sumtotal;
	private String address;
	private Date  createTime;
	
	private List<OrderDetail> detailList;

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public BigDecimal getSumtotal() {
		return sumtotal;
	}

	public void setSumtotal(BigDecimal sumtotal) {
		this.sumtotal = sumtotal;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<OrderDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<OrderDetail> detailList) {
		this.detailList = detailList;
	}

	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", uid=" + uid + ", sumtotal=" + sumtotal + ", address=" + address
				+ ", createTime=" + createTime + ", detailList=" + detailList + "]";
	}
	
	
	
	
	
	

}
