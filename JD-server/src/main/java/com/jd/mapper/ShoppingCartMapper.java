package com.jd.mapper;

import com.jd.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ShoppingCartMapper {
    List<ShoppingCart> selectShoppingCartByCustomerId(@Param("customerId") int customerId);
    ShoppingCart selectShoppingCartByGoodsIdAndNotOrderId(
            @Param("goodsId") int goodsId,
            @Param("customerId") int customerId);
    int addNewShoppingCart(@Param("shoppingCart") ShoppingCart shoppingCart);
    int updateShoppingCart(
            @Param("goodsId") int goodsId,
            @Param("customerId") int customerId,
            @Param("goodsNum") int goodsNum);
}
