const prefix='/api'
const urls={
    homeData:prefix+'/home/data',//获取首页的主要数据
    homeTitleData:prefix+'/home/title/data',//获取首页的标题数据
    deliveryDataByGoodsId:prefix+'/delivery/data',//根据商品id获取商品详细信息
    goodsComments:prefix+'/goods/comment',//获取商品的评论数据
    searchContent:prefix+'/search/content',//搜索内容
    loginPassword:prefix+'/login/password',//登录密码
    getEmail:prefix+'/get/email',//获取邮箱
    getShoppingCart:prefix+'/get/shopping/cart',//获取购物车数据
    addGoodsToShoppingCart:prefix+'/add/goods/to/shopping/cart',//添加商品到购物车
}
export default urls