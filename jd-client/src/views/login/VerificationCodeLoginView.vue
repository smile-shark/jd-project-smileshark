<template>
    <el-row>
        <el-col :span="24">
            <div class="input-group">
                <input type="text" placeholder="邮箱" v-model="email">
            </div>
        </el-col>
    </el-row>
    <el-row>
        <el-col :span="24">
            <div class="input-group">
                <input type="password" placeholder="请输入验证码" style="width:76%" v-model="password">
                <span style="font-size: 13px;color:rgb(199, 184, 170);cursor: pointer;">获取验证码</span>
            </div>
        </el-col>
    </el-row>
    <el-row>
        <el-col :span="24" style="text-align: right;
        font-size: 13px;padding:10px;color:rgb(111, 118, 126);
        cursor: pointer;">
        </el-col>
    </el-row>
    <el-row>
        <el-col :span="24">
            <div class="input-group" 
            :style="{backgroundColor:loginButton()?'rgb(250, 44, 25)':'rgb(253, 157, 148)'}"
            style="padding:10px 0;display: flex;justify-content: center;align-items: center;">
                <input 
                type="button" 
                class="input-button" 
                value="登     录"
                :style="{backgroundColor:loginButton()?'rgb(250, 44, 25)':'rgb(253, 157, 148)'}">
            </div>
        </el-col>
    </el-row>
</template>
<script>
export default{
    data(){
        return{
            email:'',
            password:'',
        }
    },
    methods:{
        loginButton(){
            return this.email.trim()!== '' && this.password.trim()!== ''
        }
    }
}
</script>
<style scoped>
@import url('./login.css');
</style>