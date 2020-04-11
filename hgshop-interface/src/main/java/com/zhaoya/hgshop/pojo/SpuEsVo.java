package com.zhaoya.hgshop.pojo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * ���ڹ�������ʹ��
 * @author 45466
 *
 */
@Document(indexName = "hgshop",type ="spu" )
public class SpuEsVo implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8122761574877150908L;
	
	@Id
    private Integer id	;//����������
	
	private String goodsName	;//��Ʒ������
	private int brandId	;//Ʒ��
	private  String caption	;//����
	
	private  int categoryId;//	����
	private String smallPic	;//ͼƬ
	
	private String brandName;//Ʒ�Ƶ�������
	private String categoryName;//��������� 
	
	
	public SpuEsVo() {
		super();
	}
	
	public SpuEsVo(Spu spu) {
		
		super();
		this.id=spu.getId();
		this.brandName= spu.getBrand()==null?"": spu.getBrand().getName();
		this.categoryName=spu.getCategory()==null?"":spu.getCategory().getName();
		this.smallPic=spu.getSmallPic();
		this.brandId=spu.getBrandId();
		this.categoryId=spu.getCategoryId();
		this.caption=spu.getCaption();
		this.goodsName=spu.getGoodsName();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getSmallPic() {
		return smallPic;
	}
	public void setSmallPic(String smallPic) {
		this.smallPic = smallPic;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "SpuEsVo [id=" + id + ", goodsName=" + goodsName + ", brandId=" + brandId + ", caption=" + caption
				+ ", categoryId=" + categoryId + ", smallPic=" + smallPic + ", brandName=" + brandName
				+ ", categoryName=" + categoryName + "]";
	}
	
	
	
}
