<template>
                <el-row style="height:13vh;border-bottom: 1px solid rgb(158, 158, 158);">
                <el-col :span="4" style="display: flex;justify-content: center;align-items: center;">
                    <img src="https://misc.360buyimg.com/jdf/1.0.0/unit/global-header/5.0.0/i/jdlogo-201708-@2x.png"
                    style="width:60%;"
                    @click="toHome">
                </el-col>
                <el-col :span="16" style="display: flex;justify-content: center;align-items: center;">  
                   <div style="width:100%">
                    <div class="search-container">
                        <input type="text" class="search-input" v-model="searchContent" placeholder="搜索" style="color:rgb(158, 158, 158)"
                        @keyup.enter="getSearchData(1)">
                        <button class="search-button" @click.prevent="getSearchData(1)">搜索</button>
                    </div>
                   </div>
                </el-col>
                <el-col :span="4" style="display: flex;justify-content: center;align-items: center;">
                </el-col>
            </el-row> 
            <el-row style="margin-top: 5vh;">
                <el-col :span="2"/>
                <el-col :span="20">
                    <el-row>
                        <div class="card-container">
                                <div class="card" v-for="(item,index) in goodsDataList" :key="index" @click="toDetailPage(item.goodsId)">
                                    <img v-if="item.goodsTitleImages.length>0" :src="item.goodsTitleImages[0].goodsImageUrl.replace('n5','n0').replace('s54x54_','')" alt="Placeholder Image"
                                     class="card-image">
                                    <img v-else src="https://img11.360buyimg.com/n0/jfs/t1/255399/13/13544/204582/67886082Fc2d04ddf/129eea1956f8fa24.jpg.avif" alt="Placeholder Image"
                                     class="card-image">
                                    <div class="card-content">
                                        <span class="card-button" style="border:none">￥<span style="font-size: 20px;">{{ item.goodsNewPrice.split('.')[0] }}</span>.{{ item.goodsNewPrice.split('.')[1] }}</span>
                                        <span v-if="item.goodsOldPrice!=='None'">
                                            <span style="color:red"> 到手价 </span>
                                            <span style="font-size: 13px;color:gray">{{ item.goodsOldPrice }}</span>
                                        </span>
                                        <p class="card-description" style="font-size:13px;">{{ item.goodsInfo }}</p>
                                        <p style="font-size:13px;color:rgb(174, 186, 205)">
                                            <span style="color:rgb(101, 111, 176);font-weight: bold;">{{ item.commentNum }}</span>条评价
                                        </p>
                                        <p style="font-size:13px;color:rgb(174, 186, 205)" v-if="item.shop!==null">
                                            {{ item.shop.shopName }}
                                        </p>
                                        <div style="display: flex;justify-content:center;align-items: center;">
                                            <button 
                                            class="card-button" 
                                            style="margin-right: 10px;font-size: 18px;font-weight: bold;"
                                            @click.prevent="addToCart(item.goodsId)"><el-icon><ShoppingCart /></el-icon>加入购物车</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                    </el-row>
                    <el-row style="margin:5vh">
                        <el-col :span="24">
                            <div style="display: flex;justify-content:center;align-items: center;">
                                <el-pagination
                                background 
                                :hide-on-single-page="true"
                                :total="pageCount"
                                :pager-count="5"
                                :page-size="20"
                                layout="prev, pager, next"
                                @current-change="getSearchData"
                                />
                            </div>
                        </el-col>
                    </el-row>
                </el-col>
                <el-col :span="2"/>
            </el-row>  
            <SidebarView/>
</template>
<script>
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import SidebarView from '../sidebar/SidebarView.vue';
export default{
    components:{
        SidebarView
    },
    data(){
        return{
            searchContent:localStorage.searchContent || '',
            goodsDataList:[{
                goodsId:1,
                goodsInfo:'标签他',
                goodsOldPrice:'$199.00',
                goodsNewPrice:'169.00',
                commentNum:'2000+',
                shop:{
                    shopId:1,
                    merchantId:4,
                    shopName:'京东超市',
                },
                goodsTitleImages:[
                    {
                        goodsImageUrl:'https://img11.360buyimg.com/n5/jfs/t1/255399/13/13544/204582/67886082Fc2d04ddf/129eea1956f8fa24.jpg.avif',
                        goodsId:1,
                    }
                ]
            }],
            pageCount:20,
        }
    },
    methods:{
        getSearchData(pageNum){
            localStorage.searchContent=this.searchContent
            this.$api.getSearchData(pageNum,this.searchContent)
            .then(res=>{
                if(res.data.success){
                    this.pageCount=res.data.data.count
                    this.goodsDataList=res.data.data.data
                }
            })
        },
        toDetailPage:goodsId=>{
            localStorage.detailPageGoodsId=goodsId
            const baseUrl=window.location.origin
            const detailUrl=`${baseUrl}/#/detail/`
            window.open(detailUrl,'_blank')
        },
        toHome(){
            this.$router.push('/')
        },
        addToCart(goodsId){
            this.$api.addGoodsToShoppingCart(goodsId).then(res=>{
                if(res.data.success){
                    ElMessage({
                        message:res.data.msg,
                        type:'success'
                    })
                    // 成功后可以转跳到添加商品购物车的页面，到另一个页面中去通过这个商品的id去搜索商品的数据
                    localStorage.addGoodsId=goodsId
                    this.$router.push('/shopping')
                }
            })
        }
    },
    mounted(){
        this.getSearchData(1)
    }
}
</script>
<style scoped>

.search-container {
    width:100%; 
padding:2px;
padding-left:3px;
display: flex;
align-items: center;
background-color: red; /* 背景颜色 */
border-radius: 4px; /* 圆角 */
overflow: hidden; /* 隐藏溢出内容 */
}

.search-input {
padding: 10px; /* 内边距 */
border: none; /* 无边框 */
outline: none; /* 无轮廓 */
flex: 1; /* 占据剩余空间 */
font-size: 16px; /* 字体大小 */
border-radius: 1px;
}

.search-button {
padding: 10px 20px; /* 内边距 */
background-color: red; /* 背景颜色 */
color: white; /* 字体颜色 */
border: none; /* 无边框 */
cursor: pointer; /* 鼠标指针 */
font-size: 16px; /* 字体大小 */
}

.card-container {
    float: left;
}

.card {
    margin: 10px;
    display:inline-block;
    background-color: #fff;
    padding:5px;    
    overflow: hidden;
    width: 22%;
    text-align: center;
    transition: transform 0.3s ease;
}
.card-content{
    text-align: left;
}

.card:hover {
    /* transform: scale(1.05); */
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

.card-image {
    width: 100%;
    height: auto;
    border-bottom: 2px solid #ddd;
    border-end-end-radius: 0;
    border-end-start-radius: 0;
}

/* .card-content {
    padding: 20px;
} */

.card-description {
    text-align: left;
    line-height: 25px;
    margin-bottom: 10px;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
    overflow: hidden;
}

.card-button {
    color:red;
    background-color: white;
    border:solid 1px rgb(240, 240, 240);
    border-radius: 0;
    padding: 5px 10px;
}
</style>