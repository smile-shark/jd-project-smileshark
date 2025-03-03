<template>
    <div style="
    position: fixed;
    right:0;
    top:40%;
    display: inline-block;
    background-color: white;
    padding:20px 5px;
    border-radius: 10px;
    border-top-right-radius: 0;
    border-end-end-radius: 0;
    border:solid 1px gray">
        <el-row>
            <!-- 个人管理 -->
            <el-col :span="24" style="
            display: flex;
            align-items: center;
            justify-content: center;
            flex-direction: column;
            cursor: pointer;"
            @click="my=true">
                <el-icon :size="20"><UserFilled /></el-icon>
                <p>
                    我的
                </p>
            </el-col>
            <!-- 购物车 -->
            <el-col :span="24" style="
            display: flex;
            align-items: center;
            justify-content: center;
            flex-direction: column;
            border-top:1px solid black;
            padding-top:10px;
            cursor: pointer; "
            @click="shoping=true">
                <el-icon :size="20"><ShoppingTrolley /></el-icon>
                <p>
                    购物车
                </p>
            </el-col>
        </el-row>
    </div>
    <el-drawer
        v-model="my"
        title="个人管理"
        direction="ltr"
    >
        <el-row>
            <el-col :span="6">
                <span style="color:gray">账号：</span>
            </el-col>
            <el-col :span="18">
                <span>{{email}}</span>  
            </el-col>
        </el-row>
    </el-drawer>
    <el-drawer
        v-model="shoping"
        title="购物车"
        direction="ltr"
    >
        <h2 v-if="shopingCartList.length==0" @click="goHome" style="cursor: pointer;" class="go-home">去逛逛吧</h2>

    </el-drawer>
</template>
<script>
import { watch } from 'vue';

export default{
    data(){
        return{
            shoping:false,
            my:false,
            email:'',
            shopingCartList:[]
        }
    },
    watch:{
        shoping(newVal,oldVal){
            // 获取购物车信息
            if(newVal){
                this.$api.getShoppingCart().then(res=>{
                    if(res.data.success){
                        this.shopingCartList=res.data.data
                    }
                }).catch(err=>{
                    console.log(err)
                    this.$router.push('/login')
                    this.shoping=false
                })
            }
        },
        my(newVal,oldVal){
            // 获取用户的信息
            if(newVal){
                this.$api.getEmail().then(res=>{
                    if(res.data.success){
                        this.email=res.data.data
                    }
                }).catch(err=>{
                    console.log(err)
                    this.$router.push('/login')
                    this.my=false
                })
            }
        }
    },
    methods:{
        goHome(){
            this.$router.push('/')
            this.shoping=false
        }
    }
}
</script>
<style>
.go-home:hover{
    color:red;
    text-decoration: underline;
}
</style>