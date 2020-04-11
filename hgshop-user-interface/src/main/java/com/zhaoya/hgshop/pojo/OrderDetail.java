package com.zhaoya.hgshop.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ��������
 * 
 * @author 45466
 *
 */
public class OrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2796063167312103157L;
	private Integer id;
	private int skuId;// sku
	private BigDecimal total;// �ܼ۸�
	private int oid;// ����id
	private int pnum;// ��������

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getSkuId() {
		return skuId;
	}

	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", skuId=" + skuId + ", total=" + total + ", oid=" + oid + ", pnum=" + pnum
				+ "]";
	}

}
