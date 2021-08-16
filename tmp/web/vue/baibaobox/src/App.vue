<template>
<div id="app">
  <el-container >
  <el-header  style="background-color:white">
      

        <el-menu   router :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
              <el-menu-item style="float:right" index="/userLogin">登录</el-menu-item>
              <div class="musicDio">
                  <audio id="audio1" controls="controls">
                      <!--    <source src="富士山下.mp3" type="audio/ogg">-->
                      <source :src="music" type="audio/ogg" >
                  </audio>
              </div>
             <div style="float: left;" >
                <el-select v-model="value" @change="changeMusic(value)" placeholder="请选择播放歌曲">
                  <el-option
                    v-for="item in options"
                    
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
             </div>
          
              <el-submenu style="float:right;width: 90px;" index="2">
                <template slot="title">个人中心</template>
                <el-menu-item index="/magicBox">百宝箱</el-menu-item>
                <el-menu-item index="#">安全中心</el-menu-item>
                <el-menu-item index="/">选项3</el-menu-item>
              </el-submenu>
              <el-menu-item style="float:right" index="/">主页</el-menu-item>
              <el-menu-item @click="changeWife"  style="float:right">切换老婆</el-menu-item>
        </el-menu>
  </el-header>
  <!--主框展示内容-->
  <el-main style="background-color:white">
    <router-view />
  </el-main>
</el-container>
</div>


</template>
<script>
  export default {
    name:"App",
     data() {
      return {
        music:"",
        // music:require("./assets/只要平凡.flac"),
        // music:require("./assets/胡歌 - 天亮以后.flac"),
        options: [
            {
              value: require("./assets/胡歌 - 天亮以后.flac"),
              label: '天亮以后'
            }, 
            {
              value:require("./assets/只要平凡.flac"),
              label: '只要平凡'
            }
        ],
        value: '',
        model: 'haru_1',
        activeIndex: '1',
        activeIndex2: '1',
        play:"https://unpkg.com/live2d-widget-model-koharu@1.0.5/assets/koharu.model.json",
        playes:[
          {
          src: '/live2dw/live2d-widget-model-hijiki/assets/hijiki.model.json',
          },
          {
          src: '/live2dw/live2d-widget-model-shizuku/assets/shizuku.model.json',
          },
          {
          src: '/live2dw/live2d-widget-model-tororo/assets/tororo.model.json',
          },
          {
          src: '/live2dw/live2d-widget-model-wanko/assets/wanko.model.json',
          },
          {
          src: '/live2dw/live2d-widget-model-z16/assets/z16.model.json',
          },
        ]
      };
    },
     /*看板娘初始化
      参数说明
      model 模型的配置
         json 文件资源路径，可以支持网络路径，此处使用的是相对路径
         scale 模型缩放系数
      display 模型布局
         position 位置
         width 宽度
         height 高度
         hOffset 水平偏移量
         vOffset 垂直偏移量
      mobile 移动端配置
         show 显示/隐藏
         scale 缩放比例
      react 模型矩形框样式
         opacity 透明度
         opacityDefault 默认透明度
         opacityOnHover 鼠标悬浮透明度
    */
    //看板娘
 created () {   
    L2Dwidget.on('*', (name) => {
      // console.log('事件为： ' + name)
    })
   //页面钩子函数:页面加载完成后触发
    setTimeout(() => {                             //定时器,created执行一秒后触发
      window.L2Dwidget.init({
        //  dialog: {
        //       enable: true,
        //       script: {
        //           'tap body': '哎呀！别碰我！',
        //           'tap face': '人家是在认真写博客哦--前端妹子',
        //       }
        //   },
            pluginRootPath: 'live2dw/',                 //指向你的目录
            pluginJsPath: 'lib/',                       //指向你的目录
            pluginModelPath: 'live2d-widget-model-nico/assets/',                                   //中间这个koharu就是你的老婆,想换个老婆,换这个就可以了
            tagMode: false,
            debug: false,
            //黑猫
            // model: { jsonPath: '/live2dw/live2d-widget-model-hijiki/assets/hijiki.model.json' },
            //书桌女孩
            //  model: { jsonPath: '/live2dw/live2d-widget-model-shizuku/assets/shizuku.model.json' },       //中间这个koharu就是你的老婆,想换个老婆,换这个就可以了
            //白猫
            // model: { jsonPath: '/live2dw/live2d-widget-model-tororo/assets/tororo.model.json' },
            //小哈狗
            //model: { jsonPath: '/live2dw/live2d-widget-model-wanko/assets/wanko.model.json' },
            //制服女孩
            model: { jsonPath: this.playes[1].src},
            display: { 
              position: 'left', 
              width: 200, 
              height: 230,
              hOffset:30,//canvas水平偏移
              vOffset:0,//canvas垂直偏移
              superSample: 2, // 超采样等级 
            },                               //调整大小,和位置
            mobile: { show: true },   
            react:{//透明度条件
              opacityDefault:0.2,//默认透明度
              opacityOnHover: 0.5//鼠标移上透明度
            },     
            dialog:{
              enable:true,//显示人物对话框
              hitokoto:true,//使用一言API
              // script: {
              //     // 每空闲 10 秒钟，显示一条一言
              //     "every idle 5s": "$hitokoto$",
              //     // 当触摸到星星图案
              //     "hover .star": "星星在天上而你在我心里 (*/ω＼*)",
              //     // 当触摸到角色身体
              //     tapbody: "哎呀！别碰我！",
              //     "tap": "哎呀！别碰我！",
              //     // 当触摸到角色头部
              //     "tapface": "人家已经不是小孩子了！",
              //   },
            },                                                        
            //要不要盯着你的鼠标看
            log: true  
      })
      }, 300)    
    },   
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      },
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      //换老婆
      changeWife(){
      },
      changeMusic(item){
        $('#audio1').attr('src', item);
        //自动播放  
        $('#audio1').attr('autoplay', true);
      }
    }
  }
</script>
<style scoped>
  .musicDio{
    float: left;
  }
  .el-input__inner{
    margin-top: -20px;
  }
</style>