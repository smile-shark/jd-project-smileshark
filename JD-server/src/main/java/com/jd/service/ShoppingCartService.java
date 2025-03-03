package com.jd.service;

import com.jd.common.Result;
import com.jd.entity.Customer;
import com.jd.entity.ShoppingCart;
import com.jd.mapper.CustomerMapper;
import com.jd.mapper.GoodsInfoMapper;
import com.jd.mapper.ShoppingCartMapper;
import com.jd.request.param.RequestParam;
import com.jd.utils.JwtUtils;
import com.jd.utils.SqlSessionUtils;
import io.jsonwebtoken.Claims;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShoppingCartService {

    private SqlSession sqlSession;

    public Result getShoppingCart(String token){
        /*
        * 1. 先解析令牌获取到email
        * 2. 通过email获取用户id
        * 3. 通过用户id获取购物车中的信息*/
        try {
            String email = JwtUtils.parseJWTTokenToCustomer(token).get("customerEmail", String.class);
            sqlSession = SqlSessionUtils.getSqlSession();
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            Customer customer = customerMapper.selectCustomerByCustomerEmail(email);
            ShoppingCartMapper shoppingCartMapper = sqlSession.getMapper(ShoppingCartMapper.class);
            List<ShoppingCart> shoppingCarts = shoppingCartMapper.selectShoppingCartByCustomerId(customer.getCustomerId());
            sqlSession.close();
            return Result.success().setData(shoppingCarts);
        }catch (Exception e){
            if(sqlSession != null){
                sqlSession.close();
            }
            e.printStackTrace();
            return Result.error();
        }
    }
    public Result addGoodsToShoppingCart(String token, RequestParam requestParam){
        Integer customerId = JwtUtils.parseJWTTokenToCustomer(token).get("customerId", Integer.class);
        Integer goodsId = requestParam.getGoodsId();
        Result result;
        try{
            int i;
            // 查询是否已有当前商品
            sqlSession = SqlSessionUtils.getSqlSession();
            ShoppingCartMapper shoppingCartMapper = sqlSession.getMapper(ShoppingCartMapper.class);
            ShoppingCart shoppingCartHave = shoppingCartMapper.selectShoppingCartByGoodsIdAndNotOrderId(goodsId, customerId);
            if(shoppingCartHave == null){
                //没有该该商品的购物车数据
                ShoppingCart shoppingCart = new ShoppingCart();
                shoppingCart.setGoodsId(goodsId);
                shoppingCart.setCustomerId(customerId);
                GoodsInfoMapper mapper = sqlSession.getMapper(GoodsInfoMapper.class);
                shoppingCart.setShop(mapper.selectGoodsInfoByGoodsId(goodsId).getShop());
                i = shoppingCartMapper.addNewShoppingCart(shoppingCart);
            }else{
                //有当前商品的购物车数据
                i = shoppingCartMapper.updateShoppingCart(
                        shoppingCartHave.getGoodsId(),
                        shoppingCartHave.getCustomerId(),
                        shoppingCartHave.getGoodsNum() + 1
                );
            }
            if(i > 0){
                result = Result.success().setMsg("商品数据添加成功");
            }else{
                result = Result.error().setMsg("商品数据添加失败");
            }
        }catch (Exception e){
            sqlSession.close();
            result=Result.error().setMsg("错误？商品数据添加失败");
            e.printStackTrace();
        }
        sqlSession.close();
        return result;
    }
}
