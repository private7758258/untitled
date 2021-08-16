<template>
    <div>
        <el-row :gutter="20">
          <el-col :span="4"></el-col>
          <el-col :span="16">
            <div class="grid-content bg-purple">
                    <!-- 表单 -->
                <el-form ref="form" :model="form" label-width="80px">
                    <el-form-item label="用户姓名">
                      <el-input v-model="form.userName"></el-input>
                    </el-form-item>
                    <el-form-item label="用户密码">
                      <el-input v-model="form.password"></el-input>
                    </el-form-item>
                    <el-form-item label="电话">
                      <el-input v-model="form.tel"></el-input>
                      
                    </el-form-item>
                     <el-form-item label="验证码">
                        <el-input v-model="form.code" style="width: 100px;"></el-input>
                     <el-button disable="disabled" class="btnCode" @click="countDown">{{content}}</el-button>
                    </el-form-item>
                </el-form>
                <el-button style="margin-left:250px" type="primary" :loading="loading" @click="btn">提交</el-button>
            </div>
            
          </el-col>
        </el-row>
    </div>
</template>

<script>
//哪里需要引哪里
import $ from 'jquery'
export default {
  name: 'register',
  data () {
    return {
      content: '发送验证码',
      totalTime:"30",
      loading:false,
      form: {
          userName: '',
          password:'',
          tel:"",
          code:""
      }
    }
  },
  methods:{
    //倒计时
    countDown() {
      $(".btnCode").attr("disabled","disabled");
      this.content = this.totalTime + 's后重新发送' //这里解决60秒不见了的问题
      let clock = window.setInterval(() => {
        this.totalTime--
        this.content = this.totalTime + 's后重新发送'
        if (this.totalTime < 0) {     //当倒计时小于0时清除定时器
          window.clearInterval(clock)
          this.content = '重新发送验证码'
          this.totalTime = 30
          $('.btnCode').removeAttr("disabled");
          }
      },1000)
    },
    //提交按钮
    btn(){
      this.$router.push("/userLogin")
      this.loading=true
    }
  }
}
</script>
<style  scoped>
</style>