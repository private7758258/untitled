z<template >
    <div>
      <div  class="demo">
        <video-player id="playVideos"  
          ref="videoPlayer" :playsinline="true"  :options="playerOptions">
        </video-player>
        <!-- 视频列表循坏的菜单 -->
      </div>
      <el-button @click="changeVideo">切换视频</el-button>
      <div style="margin-top:10px ;">
        <el-card >
          <div class="pic">
                <el-carousel :interval="4000" type="card" height="200px">
                  <el-carousel-item  v-for="item in pic" :key="item.name">
                    <h3 class="medium">{{ item.name }}</h3>
                    <img :src="item.src"/>
                  </el-carousel-item>
                </el-carousel>
          </div>
        </el-card>
        
      </div>
    </div>
</template>

<script>
import { videoPlayer } from 'vue-video-player';

import 'video.js/dist/video-js.css'
export default {
  name: 'userIndex',
  data () {
    return {
      //弹幕
      rollBarrageIndex: 0,		//用来固定位置的
   	rollBarrageList:[{		//滚动弹幕
   		canAdd: true,
   		time: '00:00',
   		color: '#fcf044',
   		cont: '1测试弹幕测试幕测试弹幕测试弹幕1'
   	},{
   		canAdd: true,
   		time: '00:00',
   		color: '#ffffff',
   		cont: '11测试弹幕测试弹幕测试弹幕幕测试弹幕测试弹幕测试弹幕测试弹幕测试弹幕1'
   	}],
      //刺客五六七
      pic:[
        {
          name:"1",
          src:require("../assets/五六七/1.png")
        },
        {
          name:"2",
          src:require("../assets/五六七/2.png")
        },
        {
          name:"3",
          src:require("../assets/五六七/3.png")
        },
        {
          name:"4",
          src:require("../assets/五六七/4.png")
        },

      ],
      //图片
      fits: ['fill', 'contain', 'cover', 'none', 'scale-down'],
      url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
        //视频
      playerOptions:{
        //播放速度
        playbackRates :[0.7,1.0,1.5,2.0],
        //如果true，浏览器准备好时开始回放
        autoplay:true,
        //默认情况下将会消除任何音频
        muted:false,
        //道中视频一结束就重新开始
        loop:false,
        //auto浏览器选择最佳行为
        preload:"auto",
        language:"zh-CN",
        aspectRatio:"16:9",
        fluid:true,
        sources:[
            {
              //类型
              type:"video/mp4",
              //url地址
              // src:"http//vjs.zendn.net/v/oceans.mp4"
              //src:"../assets/张泽熙 - 那个女孩.mp4"
              src: require("../assets/video/张泽熙 - 那个女孩.mp4")
            },
            // {
            //   //类型
            //   type:"video/mp4",
            //   //url地址
            //   src:"http//vjs.zendn.net/v/oceans.mp4"
            //   //src:"../assets/张泽熙 - 那个女孩.mp4"
            //   // src: require("../assets/张泽熙 - 那个女孩.mp4")
            // },
        ],
        //封面
        // poster:"../assets/thisgirl.jpg",
        // hls: true,
        poster: 'https://p1.music.126.net/5zs7IvmLv7KahY3BFzUmrg==/109951163635241613.jpg?param=600y500',
        //允许覆盖video.js无法播放媒体源时显示的默认信息
        notSupportedMessage:"此视频无法播放，请稍后重试",
        controlBar:{
          timeDivider:true,
          durationDisplay:true,
          remainingTimeDisplay:false,
          //全屏按钮
          fullscreenToggle:true
        },
        //弹幕
        // chatData: chatData, // 弹幕列表
        // liveHeight: { height: 0 },
        // bulletChat: {
        //   arr: [], // 传入的弹幕源数组
        //   isPause: false, // 控制是否暂停弹幕
        //   sendContent: "213", // 自己发送的弹幕内容
        //   isJs: false, // 是否解析html
        //   direction: 'default'
        // }
      }
    }
  },
  mounted() {
    window.addEventListener("scroll", this.scrollBottom, true);
  },
  methods:{
    changeVideo(){
      this.playerOptions.sources[0].src= require("../assets/video/haimian.mp4")
    },
    // scrollBottom() {
    //     // 滚动到页面底部时
    //     const el = document.getElementById("content");
    //     const windowHeight = window.screen.height;
    //     const scrollTop =
    //     document.documentElement.scrollTop || document.body.scrollTop;
    //     const contentHeight = el.clientHeight;
    //     const toBottom = contentHeight - windowHeight - scrollTop;
    //     if (toBottom < 10 && !this.finished && !this.loading) {
    //     this.loading = true;
    //     // 请求的数据未加载完成时
    //     this.getDataList();
    //     }
    // }
  },
  componets:{
    videoPlayer
  },
  computed:{
    player(){
      return this.$refs.videoPlayer.player
    }
  }
}
</script>

<style  scoped>
.pic{
    margin-left:20%;  
}
  .demo{
    display: inline-block;
    width: 800px;
    height: 500px;
    margin-left: 300px;
    text-align: center;
    line-height: 100px;
    border: 1px solid transparent;
    border-radius: 4px;
    overflow: hidden;
    background: #fff;
    position: relative;
    box-shadow: 0 1px rgba(0, 0, 0,.2)
  }
</style>