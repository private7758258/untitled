<template>
    <div>

        <el-container style="height: 500px;">
            <el-header >
              <el-card >
              你正在于{{this.$route.query.name}}聊天
              </el-card>
            </el-header>
            <el-container>
                <!--聊天对话框-->
                <el-main style="border-radius:10%">
                  <div >
                    <el-card >
                    <ul class="input"  style="overflow:auto">
                        <li class="liLeft" v-for="f in frend.Msg" :key="f.id">  
                          <!--头像-->
                          <div class="leftLi">
                              <img class="imgs" :src="frend.img"/>
                          </div>
                          <div class="leftLi">
                            <div class="newTime" style="margin-left:292px ;" v-text='"时间:"+f.time'></div>
                            <div class="yourWord" v-text='frend.name+"说:"+f.msg'></div>
                          </div>
                        </li>
                    </ul>
                    </el-card>
                    <el-popover
                    style="float:left;margin-left:80px ;"
                      placement="top"
                      trigger="click">
                      <div style="width=60px;height: 70px;">
                          <button>按钮一</button>
                          <button>按钮一</button>
                          <button>按钮一</button>
                          <button>按钮一</button>
                          <button>按钮一</button>
                          <button>按钮一</button>
                          <button>按钮一</button>
                          <button>按钮一</button>
                          <button>按钮一</button>
                      </div>
                      <el-button slot="reference">选择表情</el-button>
                    </el-popover>

                    <el-input style="width: 320px;margin-top:0px;float:left" v-model="msg" placeholder="请输入内容"/>
                    <el-button    @click="sendMsg(msg,user)">发送</el-button>
                  </div>
                </el-main>
                <el-aside width="400px">
                  <el-card >
                  信息资料
                  </el-card>  
                </el-aside>
            </el-container>
        </el-container>
    </div>
</template>

<script>
import $ from "jquery"
  export default {
    name:"webSocket",
    data() {
      return {
        frend:{
          id:"1",
          name:'小王',
          img:"https://img2.baidu.com/it/u=3180617861,931894008&fm=26&fmt=auto&gp=0.jpg",
          Msg:[
            {
              time:"2020-8-04 15时:20分28秒",
              msg:"放假了过来完",
            },
            {
              time:"2020-8-05 15时:20分28秒",
              msg:"来了没有",
            },
          ]
        },
        user:{
          id:'2',
          name:"用户",
          img:"https://img2.baidu.com/it/u=2240787100,3751231880&fm=26&fmt=auto&gp=0.jpg",
          Msg:[
            {
              id:"123",
              time:"2012-4-12",
              msg:"好的"
            },
          ]
        },
        msg:""
      }
    },
    methods: {
        sendMsg(msg,user){
            if(msg==""){
              alert("输入内容不能为空")
              return
            }
            var v=this.$options.methods.crentTime()
            user.Msg.time=v
            user.Msg.msg=msg
            console.log(user.Msg.time)
            $(".input").append( 
              '<li style="margin-top: 5px;line-height: 20px;height: 40px;width: 100% ; list-style: none;">'+
                            '  <div style=" float: right;">'+
              '       <img style="width: 40px;height: 40px;float: left;" src="'+user.img+'"/>'+
              '  </div>'+
              '   <div style=" float: right;">'+
              '        <div style="margin-right:225px;;font-size: 10px;color: rgb(192, 178, 178);">时间：'+user.Msg.time+'</div>'+
              '        <div style=" float: right;font-size: 15px;filter: shadow(color=#AF0530);color: #f90b46; float: right;text-align:right;font-family: "隶书"" >'+user.Msg.msg+'</div>'+
              '  </div>'+

              '</li>')
              //将输入框制空
              this.msg=""
        },
        submit(){
          alert("ss")
          sendMsg()
        },
         //当前时间
        crentTime(){
          var time=new Date()
          var v=time.getFullYear()+"-"+parseInt(time.getMonth()+1)+"-"+time.getDate()+" "+time.getHours()+"时"+":"+time.getMinutes()+"分"+time.getSeconds()+"秒"
          return v;
        }
    },
    beforeMount () {
        console.log("=====开始执行钩子函数====")
        var v=this.$route.query
    },
   
  }
</script>
<style scoped>

    .newTime{
      font-size: 10px; 
      color: rgb(192, 178, 178);
    }
    .input{
      height: 200px;
    }
    .imgsR{
      width: 40px;
      height: 40px;
      float: right;
    }
    .imgs{
      width: 40px;
      height: 40px;
      float: left;
    }
    .liLeft{
        margin-top: 9px;
        line-height: 20px;
        height: 40px;
        width: 100%;
       list-style: none;
    }
    .yourWord{
        font-size: 15px; 
        color: #730404; 
        text-align:left;
        font-family: "华文行楷"
    }
/* 布局样式 */
 
</style>