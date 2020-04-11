package com.zhaoya.hgshop.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Cart implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2464402261154050481L;
	
	private Integer id;
	private int uid;
	private int skuid;
	private int pnum;
	private Date createtime;
	private Date updatetime;
	private BigDecimal sumTotal;
	private Sku sku;
	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", uid=" + uid + ", skuid=" + skuid + ", pnum=" + pnum + ", createtime=" + createtime
				+ ", updatetime=" + updatetime + ", sumTotal=" + sumTotal + ", sku=" + sku + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getSkuid() {
		return skuid;
	}
	public void setSkuid(int skuid) {
		this.skuid = skuid;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public BigDecimal getSumTotal() {
		return sumTotal;
	}
	public void setSumTotal(BigDecimal sumTotal) {
		this.sumTotal = sumTotal;
	}
	public Sku getSku() {
		return sku;
	}
	public void setSku(Sku sku) {
		this.sku = sku;
	}
	
	


}
