package com.imooc.controller;

import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import com.imooc.utils.ResultVOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家端
 * 展示商品信息
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public ResultVO list(){
        //1.查询所有的上架商品
        List<ProductInfo> productInfoList=productService.findUpAll();
        //2.查询类目(一次性查询)
        //精简方法,lamba表达式
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        //获取到上架商品类型对象，从而获取到类型id和类型名
        List<ProductCategory> productCategoryList1 = categoryService.findByCategoryTypeIn(categoryTypeList);

         //3.数据拼装，就是把商品信息拼装到相应的对象中，最后返回一个大对象.
        List<ProductVO>  productVOListData=new ArrayList<>();
         for (ProductCategory productCategory: productCategoryList1){
             ProductVO productVO=new ProductVO();
             productVO.setCategoryType(productCategory.getCategoryType());
             productVO.setCategoryName(productCategory.getCategoryName());
             List<ProductInfoVO>  productInfoVOList=new ArrayList<>();
             for (ProductInfo productInfo:productInfoList){
                 if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                     ProductInfoVO productInfoVO=new ProductInfoVO();
                     BeanUtils.copyProperties(productInfo,productInfoVO); //把源对象存到目标对象中
                     productInfoVOList.add(productInfoVO);
                 }
             }
             productVO.setProductInfoVOList(productInfoVOList);
             productVOListData.add(productVO);
         }

        return ResultVOUtils.success(productVOListData);
    }
}
