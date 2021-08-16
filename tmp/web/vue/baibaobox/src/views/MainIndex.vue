<template>
    <div>

      <el-container>
        <el-container>
          <el-aside width="200px" style="height: 600px;">
            <el-card >
                    <el-col :span="24" >
                        <el-menu router 
                        default-active="2"
                        class="el-menu-vertical-demo"
                        @open="handleOpen"
                        @close="handleClose">
                        <el-submenu index="1">
                            <template slot="title">
                            <i class="el-icon-user-solid"></i>
                              <span>我的通讯</span>
                            </template>
                            <el-menu-item-group>
                            </el-menu-item-group>
                            <el-submenu :index="item.title" v-for="item in menu" :key="item.id" >
                                  <template slot="title" >{{item.title}}</template>
                                  <el-menu-item 
                                      v-for="emp in item.frend" 
                                      :key="emp.id" 
                                      @click="clickProp(emp)">
                                      {{emp.name}}
                                  </el-menu-item>
                            </el-submenu>
                        </el-submenu>
                        <el-menu-item index="/magicBox">
                            <i class="el-icon-box"></i>
                            <span slot="title">百宝箱</span>
                        </el-menu-item>
                        <el-menu-item index="logRecord">
                            <i class="el-icon-reading"></i>
                            <span slot="title">日志记录</span>
                        </el-menu-item>
                        </el-menu>
                    </el-col>
            </el-card>
          </el-aside>
          <el-main  >
              <router-view/>
          </el-main>
        </el-container>
      </el-container>
     
    </div>
</template>

<script>
  export default {
    name:"mainIndex",
     data() {
      return {
        menu:[
          {
            id:'1',
            title:"我的大学",
            frend:[
              {
              id:"858",
              name:"张三"
            },
            {
              id:"818",
              name:"笑笑"
            },
            {
              id:"883",
              name:"smile"
            },
            ]
          },
          {
            id:'2',
            title:"我的中学",
            frend:[{
              id:"77",
              name:"李四"
            }]
          },
          {
            id:'3',
            title:"我的小学",
            frend:[{
              id:"37",
              name:"张三"
            }]
          },
        ],
        activeIndex: '1',
        activeIndex2: '1'
      };
    },
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath){
        console.log(key, keyPath)
      },
      // 点击的人物id
      clickProp(prop){
        this.$router.push(
          {path: '/webSocket', 
          query: {
            id:prop.id,
            name:prop.name
        }});
      }
    }
  }
</script>

<style scoped>
.el-submenu__title{
  width: 200px;
}
</style>