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
                <input type="password" placeholder="密码" v-model="password" @keydown.enter="clickLogin">
            </div>
        </el-col>
    </el-row>
    <el-row>
        <el-col :span="24" style="text-align: right;
        font-size: 13px;padding:10px;color:rgb(111, 118, 126);
        cursor: pointer;">
            忘记密码
        </el-col>
    </el-row>
    <el-row>
        <el-col :span="24">
            <div class="input-group" 
            :style="{backgroundColor:loginButton()?'rgb(250, 44, 25)':'rgb(253, 157, 148)'}"
            style="padding:10px 0;display: flex;justify-content: center;align-items: center;"
                @click.prevent="clickLogin">
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
import CryptoJS  from 'crypto-js';
import { ElMessage } from 'element-plus'
export default{
    data(){
        return{
            email:'',
            password:''
        }
    },
    methods:{
        loginButton(){
            return this.email.trim() && this.password.trim()
        },
        clickLogin(){
            // 定义一个正则表达式来验证邮箱格式
            const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
            // 验证邮箱格式
            if (!emailPattern.test(this.email)) {
                ElMessage({
                    message: '邮箱格式不正确',
                    type: 'error'
                })
                return
            }
            // 验证密码长度
            if (this.password.trim().length < 6) {
                ElMessage({
                    message: '密码长度不能小于6位',
                    type: 'error'
                })
                return
            }
            // 加密密码
            const encrypted=CryptoJS.AES.encrypt(this.password.trim(),CryptoJS.enc.Utf8.parse(this.email),{
                iv:CryptoJS.enc.Utf8.parse('1234567890123456'),
                mode:CryptoJS.mode.CBC,
                padding:CryptoJS.pad.Pkcs7
            })
            // 提取密文（Base64 编码）
            const encryptedJson = encrypted.ciphertext.toString(CryptoJS.enc.Base64);
            this.$api.loginToPassword(this.email,encryptedJson).then(res=>{
                if(res.data.success){
                    ElMessage({
                        message: res.data.msg,
                        type: 'success'
                    })
                    localStorage.token=res.data.data
                    setTimeout(()=>{
                        this.$router.push('/')
                    },1000)
                }else{
                    ElMessage({
                        message: res.data.msg,
                        type: 'error'
                    })
                }
            })
            
        }
    }
}
</script>
<style scoped>
@import url('./login.css');
</style>