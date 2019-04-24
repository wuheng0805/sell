package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
/**
 *  problem :时间不会更新，继续看下一章节
 */
public class ProductCategoryRepositoryTest {

@Autowired(required=false)
    private  ProductCategoryRepository repository;

@Test
    public void findOneTest(){
   ProductCategory category= repository.findOne(4);
   category.setCategoryType(7);
   repository.save(category);
//    System.out.println(category.toString());
//  System.out.println(category.toString());
}
@Test
@Transactional   //测试完会事务回滚，不会保存在数据库中
    public void saveOne(){
    ProductCategory one1=new ProductCategory("男生最爱",4);
    ProductCategory result=repository.save(one1);
    Assert.assertNotNull(result);
}
@Test
    public void  findCategoryTypeList(){
        List<Integer>  list=Arrays.asList(1,2,4,6,7,8,9);

    List<ProductCategory> result=repository.findByCategoryTypeIn(list);
//    for(int i=0;i<result.size();i++){
//        ProductCategory p=result.get(i);
//        System.out.println(p);
//    }
    Assert.assertNotEquals(0,result.size());
 }
}