package com.zhaoya.hgshop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.zhaoya.hgshop.common.FileUtils;
import com.zhaoya.hgshop.pojo.Sku;
import com.zhaoya.hgshop.pojo.SkuVo;
import com.zhaoya.hgshop.pojo.Spec;
import com.zhaoya.hgshop.pojo.SpecOption;
import com.zhaoya.hgshop.pojo.Spu;
import com.zhaoya.hgshop.service.SkuService;
import com.zhaoya.hgshop.service.SpecService;
import com.zhaoya.hgshop.service.SpuService;

@Controller
@RequestMapping("sku")
public class SkuController {

	@Reference
	SkuService skuService;

	@Reference
	SpuService spuService;

	@Reference
	SpecService specService;

	/**
	 * 
	 * @param request
	 * @param skuVo
	 * @param page
	 * @return
	 */
	@RequestMapping("list")
	public String list(HttpServletRequest request, SkuVo skuVo, @RequestParam(defaultValue = "1") int page) {

		// ��ȡ����
		PageInfo<Sku> pageInfo = skuService.list(page, skuVo);

		// ��ѯ��������
		request.setAttribute("skuVo", skuVo);
		request.setAttribute("pageInfo", pageInfo);
		return "sku/list";

	}

	/**
	 * ������Ʒ���sku
	 * 
	 * @param request
	 * @param spuId
	 * @return
	 */
	@RequestMapping("toadd")
	public String toAdd(HttpServletRequest request, int spuId) {

		Spu spu = spuService.getById(spuId);
		// ��ȡ���еĹ��
		// specList
		List<Spec> specList = specService.listAll();

		request.setAttribute("spu", spu);

		request.setAttribute("specList", specList);
		return "sku/add";
	}

	/**
	 * sku �����
	 * 
	 * @param request
	 * @param sku
	 * @param specId    ���id������
	 * @param optionId  ������ֵid������
	 * @param imageFile sku��ͼƬ
	 * @param cartFile  ���ﳵСͼ������
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public String add(HttpServletRequest request, Sku sku, int[] specId, int[] optionId, MultipartFile imageFile,
			MultipartFile cartFile) {

		// ����sku������
		List<SpecOption> specOptionList = new ArrayList<>();
		for (int i = 0; i < specId.length && i < optionId.length; i++) {
			SpecOption option = new SpecOption();
			option.setId(optionId[i]);
			option.setSpecId(specId[i]);
			// ��ӵ�������
			specOptionList.add(option);
		}
		// ��������ӵ���װbean��
		sku.setSpecOptionList(specOptionList);
		System.out.println("sku === " + sku);
		// �ϴ�ͼƬ
		try {
			sku.setImage(FileUtils.processFile(imageFile));
			sku.setCartThumbnail(FileUtils.processFile(cartFile));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("sku === " + sku);

		return skuService.add(sku) > 0 ? "success" : "failed";

	}

	/**
	 * ������Ʒ���sku
	 * 
	 * @param request
	 * @param spuId
	 * @return
	 */
	@RequestMapping("toupdate")
	public String toUpdate(HttpServletRequest request, int skuId) {

		Sku sku = skuService.getById(skuId);

		// ��ȡ���еĹ��
		// specList
		List<Spec> specList = specService.listAll();
		// ���Ե�����
		request.setAttribute("sku", sku);
		request.setAttribute("specList", specList);
		return "sku/update";
	}

	/**
	 * sku �����
	 * 
	 * @param request
	 * @param sku
	 * @param specId    ���id������
	 * @param optionId  ������ֵid������
	 * @param imageFile sku��ͼƬ
	 * @param cartFile  ���ﳵСͼ������
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public String update(HttpServletRequest request, Sku sku, int[] specId, int[] optionId, MultipartFile imageFile,
			MultipartFile cartFile) {

		// ����sku������
		List<SpecOption> specOptionList = new ArrayList<>();
		for (int i = 0; i < specId.length && i < optionId.length; i++) {
			SpecOption option = new SpecOption();
			option.setId(optionId[i]);
			option.setSpecId(specId[i]);
			// ��ӵ�������
			specOptionList.add(option);
		}
		// ��������ӵ���װbean��
		sku.setSpecOptionList(specOptionList);
		System.out.println("sku === " + sku);
		// �ϴ�ͼƬ
		try {
			sku.setImage(FileUtils.processFile(imageFile));
			sku.setCartThumbnail(FileUtils.processFile(cartFile));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("sku === " + sku);

		return skuService.update(sku) > 0 ? "success" : "failed";

	}

	/**
	 * ����ɾ��
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("delBatch")
	@ResponseBody
	public String delBatch(@RequestParam("ids[]") int ids[]) {
		int i = skuService.deleteBatch(ids);
		return i > 0 ? "success" : "failed";

	}

}
