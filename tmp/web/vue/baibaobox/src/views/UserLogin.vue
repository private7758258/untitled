<template>


    <el-container style="height=200px;">
    <el-aside width="900px" style="background-color:white;" >
      <el-card>
           <!--轮播-->
           <el-carousel height="400px" direction="vertical" :autoplay="false">
              <el-carousel-item v-for="item in 3" :key="item">
                <h3 class="medium">{{ item }}</h3>
              </el-carousel-item>
            </el-carousel>
      </el-card>
    </el-aside>
          <el-card>
            <div>
                <span>雨纷纷</span>
                <el-divider direction="vertical"></el-divider>
                <span>旧故里</span>
                <el-divider direction="vertical"></el-divider>
                <span>草木深</span>
            </div>
            <div>
                <span> 记得小苹初见，两重心字罗衣。</span>
                <el-divider direction="vertical"></el-divider>
                <br>
                <span>琵琶弦上说相思。</span>
                <el-divider direction="vertical"></el-divider>
                <br>
                <span>当时明月在，曾照彩云归</span>
            </div>
            <div>
               <el-form ref="form" :model="User" label-width="80px" style="margin-top:185px;">
                <el-form-item label="用户账户">
                    <el-input v-model="User.name"></el-input>
                </el-form-item>
                <el-form-item label="用户密码">
                    <el-input v-model="User.pwd"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-link type="info">密码忘记了？去找回</el-link>
                    <el-button type="primary" @click="onSubmit">立即登录</el-button>
                    <el-button @click="onRegister">去注册</el-button>
                </el-form-item>
              </el-form>
            </div>
          </el-card>
    </el-container>
</template>
<script>
  export default {
    name:"userLogin",
    data() {
      return {
        User: {
          name: '',
          pwd: '',
        }
      }
    },
    methods: {
      onSubmit() {
          this.$axios.post("http://localhost:8888/token/userLogin").then((resp) => {
                console.log("后段传的")
                console.log(resp.data)
    })
        // this.$router.push('/magicBox');
      },
      onRegister(){
        this.$router.push('/register')
      }
    }
  }
</script>

<style scoped>


  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }
  
  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 750px;
  }
  
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }
  
  body > .el-container {
    margin-bottom: 40px;
  }
  
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }
  
  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
  /* 轮播样式 */

 .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }
  
  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
</style>