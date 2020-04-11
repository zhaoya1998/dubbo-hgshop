package com.zhaoya.hgshop.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Sku implements Serializable {

	private static final long serialVersionUID = -3465304710954176724L;
	private Integer id;// id
	private String title;// 标题
	private String sellPoint;// 卖点
	private BigDecimal price;// 在售价格
	private int stockCount;// 库存数量
	private String barcode;// 条形码
	private String image;// 图片
	private int status;// 状态
	@DateTimeFormat( pattern = "yyyy-MM-dd")
	private Date createTime;// 发布时间
	private Date updateTime;// 最后更新时间
	private BigDecimal costPrice;// 成本价格
	private BigDecimal marketPrice;// 市场价格
	private int spuId;// spu
	private String cartThumbnail;// 购物车中小图
	private Spu spu;// spu
	/**
	 * 规格属性列表
	 */
	private List<SpecOption> specOptionList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSellPoint() {
		return sellPoint;
	}

	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public int getSpuId() {
		return spuId;
	}

	public void setSpuId(int spuId) {
		this.spuId = spuId;
	}

	public Spu getSpu() {
		return spu;
	}

	public void setSpu(Spu spu) {
		this.spu = spu;
	}

	public List<SpecOption> getSpecOptionList() {
		return specOptionList;
	}

	public void setSpecOptionList(List<SpecOption> specOptionList) {
		this.specOptionList = specOptionList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Sku other = (Sku) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sku [id=" + id + ", title=" + title + ", sellPoint=" + sellPoint + ", price=" + price + ", stockCount="
				+ stockCount + ", barcode=" + barcode + ", image=" + image + ", status=" + status + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", costPrice=" + costPrice + ", marketPrice="
				+ marketPrice + ", spuId=" + spuId + ", cartThumbnail=" + cartThumbnail + ", spu=" + spu
				+ ", specOptionList=" + specOptionList + "]";
	}

	public String getCartThumbnail() {
		return cartThumbnail;
	}

	public void setCartThumbnail(String cartThumbnail) {
		this.cartThumbnail = cartThumbnail;
	}

}
