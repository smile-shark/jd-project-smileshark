<template>
    <div class="out-container">
        <div class="top-container">
            <el-row style="height:13vh">
                <el-col :span="4" style="position: relative;">
                    <img src="//img10.360buyimg.com/img/jfs/t1/263328/37/804/9143/67654ff3F2f1642a7/6ab1caef9fc05136.png"
                    style="width:80%;position: absolute;bottom:10px;right:10px;">
                </el-col>
                <el-col :span="16" style="display: flex;justify-content: center;align-items: center;">  
                   <div style="width:100%">
                    <div class="search-container">
                        <input type="text" class="search-input" v-model="searchContent" placeholder="搜索" style="color:rgb(158, 158, 158)"
                        @keydown.enter="searchGoods">
                        <button class="search-button" @click.prevent="searchGoods">搜索</button>
                    </div>
                    <div class="little-words">
                        <span>
                            家电家居年货节
                        </span>
                        <span>
                            1元抽新年限定新品
                        </span>
                        <span>
                            黄金项链
                        </span>
                        <span>
                            茅台预约1499元
                        </span>
                        <span>
                            电脑整机
                        </span>
                        <span>
                            燃气热水器 
                        </span>
                        <span>
                            包包
                        </span>
                        <span>
                            空气炸锅 
                        </span>
                        <span>
                            多功能沙发床
                        </span>
                        <span>
                            尼龙双肩包
                        </span>
                    </div>
                   </div>
                </el-col>
                <el-col :span="4" style="display: flex;justify-content: center;align-items: center;">
                    <img src="https://m.360buyimg.com/babel/jfs/t1/245477/19/25250/137555/004e5401F967d88df/e8080506451ff133.gif"
                    style="width:60%">
                </el-col>
            </el-row>
            <el-row style="height:22vh;background-image: url('https://m.360buyimg.com/babel/jfs/t20280120/255838/2/14992/40591/678e26a5F915a7311/a65756bea867b919.png');
            background-size: 82%;background-position: center 85%;background-repeat: no-repeat;">
                <el-col :span="3">
                </el-col>  
                <el-col :span="18" style="background: url(&quot;https://m.360buyimg.com/babel/jfs/t20280120/261284/24/13981/132784/004e8c01F3d971dcb/187b828d063b811e.gif&quot;) center center / contain no-repeat;">
                    <el-row class="top-middlen-container-title" style="position: relative;">
                        <div style="position: absolute;width:22vh;left:110px"
                        :style="{background:`url(${image1.goodsImageUrl}) center center / 50% no-repeat`}"
                        @click="toDetailPage(image1.goodsId)">
                            <h3 class="top-middlen-title" style="text-align: center;">
                                京造年货
                            </h3>
                            <h3 class="top-middlen-title-button">
                                领90元补贴
                            </h3>
                        </div>
                        <div style="position: absolute;width:22vh;left:272px"
                        :style="{background:`url(${image2.goodsImageUrl}) center center / 50% no-repeat`}"
                        @click="toDetailPage(image2.goodsId)">
                            <h3 class="top-middlen-title" style="text-align: center;">
                                京东自营
                            </h3>
                            <h3 class="top-middlen-title-button">
                                9.9好货
                            </h3>
                        </div>
                        <div style="position: absolute;width:22vh;left:835px;"
                        :style="{background:`url(${image3.goodsImageUrl}) center center / 50% no-repeat`}"
                        @click="toDetailPage(image3.goodsId)">
                            <h3 class="top-middlen-title" style="text-align: center;">
                                企采排行榜
                            </h3>
                            <h3 class="top-middlen-title-button">
                                新品抢先购
                            </h3>
                        </div>
                        <div style="position: absolute;width:22vh;left:995px;"
                        :style="{background:`url(${image4.goodsImageUrl}) center center / 50% no-repeat`}"
                        @click="toDetailPage(image4.goodsId)">
                            <h3 class="top-middlen-title" style="text-align: center;">
                                家居家电
                            </h3>
                            <h3 class="top-middlen-title-button">
                                每200减30
                            </h3>
                        </div>
                        <div style="position: absolute;width:22vh;left:434px;"
                        :style="{background:`url(${image5.goodsImageUrl}) center center / 60% no-repeat`}"
                        @click="toDetailPage(image5.goodsId)">
                            
                        </div>
                    </el-row>
                </el-col>
                <el-col :span="3">
                </el-col>
            </el-row>
            <el-row style="height: 50vh;width: 100vw;display: flex; justify-content: space-between; background: url('//m.360buyimg.com/babel/jfs/t20280120/255524/1/14787/339617/678e2795F4d7ac6e5/933c6357458f6aa8.png') left top / 300px 590px no-repeat, url('//m.360buyimg.com/babel/jfs/t20280120/257735/10/14329/366159/678e2799Ffa4fb6d5/b4b27f51b458571c.png') right top / 300px 590px no-repeat; position: absolute; left: 50%; transform: translateX(-50%); height: 710px;">
                <el-col :sapn="24">
                    <el-row>
                        <el-col :span="4"></el-col>
                        <el-col :span="16" style="min-height: 50vh;background-color: white;border-radius: 10px;padding:0px">
                           
                            <div class="card-container">
                                <div class="card" v-for="(item,index) in homeData" :key="index" @click="toDetailPage(item.goodsId)">
                                    <img v-if="item.goodsTitleImages.length>0" :src="item.goodsTitleImages[0].goodsImageUrl.replace('n5','n0').replace('s54x54_','')" alt="Placeholder Image"
                                     class="card-image">
                                    <img v-else src="https://img11.360buyimg.com/n0/jfs/t1/255399/13/13544/204582/67886082Fc2d04ddf/129eea1956f8fa24.jpg.avif" alt="Placeholder Image"
                                     class="card-image">
                                    <div class="card-content">
                                        <p class="card-description">{{ item.goodsInfo }}</p>
                                        <span class="card-button">￥<span style="font-size: 20px;">{{ item.goodsNewPrice.split('.')[0] }}</span>.{{ item.goodsNewPrice.split('.')[1] }}</span>
                                        <span v-if="item.goodsOldPrice!=='None'">
                                            <span style="color:red"> 到手价</span>
                                            <span style="font-size: 13px;color:gray">{{ item.goodsOldPrice }}</span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </el-col>
                        <el-col :span="4"></el-col>
                    </el-row>
                </el-col>
            </el-row>
        </div>
    </div>
    <el-backtop :right="50" :bottom="50" />
</template>
<script>
import { ElMessage } from 'element-plus';
export default {
    data(){
        return {
            homeData:[],
            image1:{},
            image2:{},
            image3:{},
            image4:{},
            image5:{},
            searchContent:''
        }
    },
    mounted(){
        for(let i=1;i<=5;i++){
            this.$api.getHomeTitleData().then(res=>{
                if(res.data.success){
                    res.data.data.goodsImageUrl=res.data.data.goodsImageUrl.replace('n5','n0').replace('s54x54_','')
                    this[`image${i}`]=res.data.data
                }
            })
        }

        this.$api.getHomeData().then(res=>{
            if(res.data.success){
                this.homeData=res.data.data
            }
        })
    },
    methods:{
        newPriceStart:newPrice=>{
            return newPrice.split('.')[0]
        },
        newPriceEnd:newPrice=>{
            return newPrice.split('.')[1]
        },
        toDetailPage:goodsId=>{
            localStorage.detailPageGoodsId=goodsId
            const baseUrl=window.location.origin
            const detailUrl=`${baseUrl}/#/detail/`
            window.open(detailUrl,'_blank')
        },
        searchGoods:function(){
            if(this.searchContent.trim()===''){
                ElMessage.warning('请输入搜索内容')
                return
            }
            localStorage.searchContent=this.searchContent
            this.$router.push({path:'/search'})
        }
    }
}
</script>
<style scoped>
ul{
    list-style: none;
}
.out-container {
    width:100vw;
    background: linear-gradient(to bottom, #c60a07 80%, white 100%);  
    height:100vh;
}
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
border-radius: 4px;
}

.search-button {
padding: 10px 20px; /* 内边距 */
background-color: red; /* 背景颜色 */
color: white; /* 字体颜色 */
border: none; /* 无边框 */
cursor: pointer; /* 鼠标指针 */
font-size: 16px; /* 字体大小 */
}
.little-words{
    margin-top:10px;
}
.little-words span{
    color:white;
    margin: 10px;
    cursor:pointer;
}
.top-middlen-container-title div{
    /* border:solid 1px black; */
    height:22vh
}
.top-middlen-title-button{
    background-color: rgba(255, 27, 22, 1);
    text-align: center;
    display: flex;
    color: white;
    justify-content: center;
    align-items: center;
    margin: auto;
    margin-top:77px;
    padding:6px;
    width: 70%;
    border-radius: 4px;
    font-weight: lighter;
}
.cate_menu_icon{
    -webkit-font-smoothing: antialiased;
    font: 12px/1.5 PingFang SC,Source Han Sans CN,Microsoft YaHei,Heiti SC,tahoma,arial,Hiragino Sans GB,"\5B8B\4F53",sans-serif;
    color: #636363;
    list-style: none;
    line-height: 34px;
    font-size: 0;
    margin: 0;
    padding: 0;
    font-style: normal;
    width: 14px;
    height: 14px;
    vertical-align: middle;
    display: inline-block;
    margin-top: -10px;
    margin-right: 8px;
    background: url(//img14.360buyimg.com/imagetools/jfs/t1/95664/15/40921/296/66d13f7cF7ed5ab7d/bd4d68f33a69c7dc.png);
    background-size: 100%;
}


.card-container {
    float: left;
}

.card {
    margin: 10px;
    display:inline-block;
    background-color: #fff;
    padding:5px;
    border:solid 1px rgba(254, 48, 65, 1);
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    overflow: hidden;
    width: 22%;
    text-align: center;
    transition: transform 0.3s ease;
}
.card-content{
    text-align: left;
}

.card:hover {
    transform: scale(1.05);
}

.card-image {
    width: 100%;
    height: auto;
    border-bottom: 2px solid #ddd;
    border-radius: 5px;
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
    text-align: left;
    color: rgba(255, 16, 36,1);
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 1rem;
    transition: background-color 0.3s ease;
    font-weight: bold;
}
</style>