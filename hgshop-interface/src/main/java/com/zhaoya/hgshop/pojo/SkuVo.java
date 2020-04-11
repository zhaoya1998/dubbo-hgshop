package com.zhaoya.hgshop.pojo;

import java.math.BigDecimal;

/**
 * ���ڱ����ѯ��
 * @author zhuzg
 *
 */
public class SkuVo extends Sku {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2349824927751063479L;
	
	private BigDecimal maxPrice;
	
	private BigDecimal minPrice;
	
	private int maxStockCount;
	
	private int minStockCount;
	
	// ������߱��⵱�к��еĶ��ؼ���
	private String key;

	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}

	public BigDecimal getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	public int getMaxStockCount() {
		return maxStockCount;
	}

	public void setMaxStockCount(int maxStockCount) {
		this.maxStockCount = maxStockCount;
	}

	public int getMinStockCount() {
		return minStockCount;
	}

	public void setMinStockCount(int minStockCount) {
		this.minStockCount = minStockCount;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SkuVo [maxPrice=" + maxPrice + ", minPrice=" + minPrice + ", maxStockCount=" + maxStockCount
				+ ", minStockCount=" + minStockCount + ", key=" + key + "]";
	}
	
	
		
}
