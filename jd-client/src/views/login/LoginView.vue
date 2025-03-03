<template>
    <div class="container">
        <div style="padding: 20px;display: inline-block;border-radius:10px;width:20vw;background-color: white;">
            <el-row>
                <el-col :span="12">
                    <h2 @click="loginType=true" 
                    :style="{cursor: 'pointer',textAlign:'right',marginRight:'10px',color:loginType?'red':'black'}">密码登录</h2>
                </el-col>
                <el-col :span="12">
                    <h2 @click="loginType=false"
                    :style="{cursor: 'pointer',textAlign:'left',marginLeft:'10px',color:loginType?'black':'red'}">验证码登录</h2>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="24">
                    <PasswordLoginView v-if="loginType"/>
                    <VerificationCodeLoginView v-else/>
                </el-col>
            </el-row>
        </div>
    </div>
</template>
<script>
import PasswordLoginView from './PasswordLoginView.vue';
import VerificationCodeLoginView from './VerificationCodeLoginView.vue';
export default{
    components:{
        PasswordLoginView,
        VerificationCodeLoginView
    },
    data(){
        return{
            loginType:true
        }
    }
}
</script>
<style scoped>
.container{
    background-color:rgb(245, 246, 250);
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    caret-color: transparent;
}
</style>