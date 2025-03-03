<template>
    <el-row>
        <el-col :span="24" style="text-align: right;background-color: rgb(242, 242, 242);color:rgb(127, 127, 118);padding:10px;">
           {{ detailData.shop.shopName }}
        </el-col>
    </el-row>
    <el-row>
        <el-col :span="4"/>
        <el-col :span="16" style="min-height: 40vh;margin-top:10px;">
            <el-row>
                <el-col :span="8">
                    <el-row>
                        <el-col :span="24" >
                            <img style="width:100%" :src="titleImage">
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="24" style="margin-top: 10px;">
                            <img :src="item.goodsImageUrl" 
                            class="list-img" v-for="(item,index) in detailData.goodsTitleImages" :key="index"
                            @mouseover="changeTitleImage(item.goodsImageUrl)">
                        </el-col>
                    </el-row>
                </el-col>
                <el-col :span="13" style="padding:10px;">
                    <el-row >
                        <el-col :span="24" style="line-height: 26px;font-weight: bold;">
                            {{ detailData.goodsInfo }}
                        </el-col>
                    </el-row>
                    <el-row style="background-color:rgb(243, 243, 243);padding:10px;margin-top:10%">
                        <el-col :span="24">
                            <el-row>
                                <el-col :span="20">
                                    <el-row>
                                        <el-col :span="4" style="line-height:40px">
                                            价 格 :
                                        </el-col>
                                        <el-col :span="20">
                                            <span style="color:red;font-weight: bold;">
                                                ￥
                                                <span style="font-size: 26px;">
                                                    {{ detailData.goodsNewPrice }}
                                                </span>
                                                <span style="font-weight: normal;">
                                                    到手价
                                                </span>
                                            </span>
                                            <span v-if="detailData.goodsOldPrice!='None'">
                                               {{ detailData.goodsOldPrice }} 京东价
                                            </span>
                                            <span style="color:rgb(33, 104, 179)" v-if="detailData.goodsOldPrice!='None'">
                                                降价通知
                                            </span>
                                        </el-col>
                                    </el-row>
                                </el-col>
                                <el-col :span="4" style="text-align: right;">
                                    <div>
                                        累计评价
                                    </div>
                                    <div style="color:rgb(0, 94, 167)">
                                        {{ detailData.commentNum }}
                                    </div>
                                </el-col>
                            </el-row>
                        </el-col>
                    </el-row>
                    <el-row style="padding:10px;margin-top:10%">
                        <el-col :sapn="4">
                            配 送 服 务:
                        </el-col>
                        <el-col :span="20" style="font-size: 13px;margin-top: 10px;">
                            <span style="color:rgb(108, 124, 191);padding:10px;" v-for="(item,index) in detailData.deliveryServiceType" :key="index">
                                {{ item.serviceName }}
                            </span>
                        </el-col>
                    </el-row>
                    <el-row style="padding: 10px;margin-top:10%">
                        <el-col :span="24">
                            <input type="button" style="
                            color:white;
                            background-color: rgb(223, 48, 51);
                            font-weight: bold;
                            border:none;
                            padding:10px 20px;;" value="加 入 购 物 车"
                            @click.prevent="addToCart(detailData.goodsId)">
                        </el-col>
                    </el-row>
                </el-col>
                <el-col :span="3">
                    <h3 style="text-align: center;">看了又看</h3>
                </el-col>
            </el-row>
            <el-row style="margin-top:10vh">
                <el-col :span="24">
                    <el-row>
                        <el-col :span="24">
                            <h2>商品介绍</h2>   
                        </el-col>
                    </el-row>
                    <el-row style="padding:10px;">
                        <el-col :span="8">
                            <span class="detail-title">
                                商品名称：
                            </span>
                            <span class="detail-title-content">
                                {{ detailData.goodsInfo }}
                            </span>
                        </el-col>
                        <el-col :span="8">
                            <sapn class="detail-title">
                                商品编号：
                            </sapn>
                            <span class="detail-title-content">
                                {{ detailData.goodsId }}
                            </span>
                        </el-col>
                        <el-col :span="8">
                            <span class="detail-title">
                                店铺：
                            </span>
                            <span class="detail-title-content">
                                {{ detailData.shop.shopName }}
                            </span>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="24" style="margin-top:10vh">
                            <img v-for="(item,index) in detailData.goodsDetailsImages" :key="index" 
                            :src="item.goodsDetailsUrl">
                        </el-col>
                    </el-row>
                </el-col>
            </el-row>
            <!-- 评论区 -->
            <el-row style="margin-top:10vh">
                <el-col :span="24">
                    <h2>商品评价</h2>   
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="24">
                    <el-row v-for="(item,index) in commentList" :key="index" style="margin-top:5vh;margin-bottom: 5vh;border-bottom: 1px solid rgb(221, 221, 221);padding-bottom: 3vh;">
                        <el-col :span="3" style="display: flex; align-items: center;">
                            <el-avatar :size="30" :src="item.userPicture" />
                            <span style="font-size: 13px; line-height: normal; display: inline-block; height: auto; margin-left: 8px;">
                                {{ item.userName }}
                            </span>
                        </el-col>
                        <el-col :span="20">
                            <span>
                                {{ item.goodsCommentMessage }}
                            </span>
                        </el-col>
                    </el-row>
                </el-col>
            </el-row>
        </el-col>
        <el-col :span="4"/>
    </el-row>
</template>
<script>
import { ElMessage } from 'element-plus';
export default{
    data(){
        return{
            commentList:[
                {
                    goodsCommentId:1,
                    goodsId:171,
                    goodsCommentMessage:"终于换上心心念的洗烘一体的啦，非常完美，阴天再也不怕衣服没太阳了，小朋友的衣服都可以烘干一下，洗衣服的时候也没有噪音，很喜欢，遇到国补，非常划算",
                    userPicture:'https://misc.360buyimg.com/user/myjd-2015/css/i/peisong.jpg',
                    userName:'j***e'
                }
            ],
            titleImage:"https://img10.360buyimg.com/n1/jfs/t1/264409/38/13856/102861/678dcfdaFb723c58f/5b97cf154bbba96c.jpg.avif",
            detailData:{
        "goodsId": 171,
        "goodsInfo": "小米 REDMI K80 国家补贴 第三代骁龙 8 6550mAh大电池 澎湃OS 玄夜黑 12GB+256GB 红米5G至尊手机",
        "goodsOldPrice": "None",
        "goodsNewPrice": "2499.00",
        "goodsTypeId": 2,
        "commentNum": "20万+",
        "shop": {
            "shopId": 69,
            "merchantId": null,
            "shopName": "小米京东自营旗舰店"
        },
        "goodsTitleImages": [
            {
                "goodsImageUrl": "https://img10.360buyimg.com/n5/s54x54_jfs/t1/264409/38/13856/102861/678dcfdaFb723c58f/5b97cf154bbba96c.jpg.avif",
                "goodsId": 171
            }
        ],
        "goodsDetailsImages": [],
        "deliveryServiceType": [
            {
                "deliveryServiceTypeID": 7,
                "serviceName": "59元免基础运费"
            }
        ]
    }
        }
    },
    mounted(){
        this.$api.getDeliveryDataByGoodsId(
            localStorage.detailPageGoodsId
        ).then(res=>{
            if(res.data.success){
                this.detailData=res.data.data
                this.titleImage=this.detailData.goodsTitleImages[0].goodsImageUrl.replace('n5','n1').replace('s54x54_','')
                //第一次的请求完成后开始第二次的请求获取商品的评论
                this.$api.goodsComments(this.detailData.goodsId).then(res=>{
                    if(res.data.success){
                        this.commentList=res.data.data
                    }
                })
            }
        })
    },
    methods:{
        changeTitleImage(imageUrl){
            this.titleImage=imageUrl.replace('n5','n1').replace('s54x54_','')
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
    }
}
</script>
<style scoped>
.list-img{
    padding:5px
}
.list-img:hover{
    border:solid 2px red;
}
div{
    color:rgb(117, 117, 117)
}
.detail-title{
    display:inline-block;
}
.detail-title-content{
    margin-left: 2rem;
    display:block;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space:nowrap;
    width:60%;
}
</style>