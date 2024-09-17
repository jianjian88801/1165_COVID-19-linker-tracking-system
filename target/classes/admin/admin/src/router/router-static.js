import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

         import users from '@/views/modules/users/list'
        import dictionary from '@/views/modules/dictionary/list'
        import didian from '@/views/modules/didian/list'
        import gonggao from '@/views/modules/gonggao/list'
        import guiji from '@/views/modules/guiji/list'
        import hesuan from '@/views/modules/hesuan/list'
        import kouzhao from '@/views/modules/kouzhao/list'
        import kouzhaoyuyue from '@/views/modules/kouzhaoyuyue/list'
        import yihu from '@/views/modules/yihu/list'
        import yimiao from '@/views/modules/yimiao/list'
        import yimiaoyuyue from '@/views/modules/yimiaoyuyue/list'
        import yonghu from '@/views/modules/yonghu/list'
        import dictionaryDidian from '@/views/modules/dictionaryDidian/list'
        import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
        import dictionaryJiance from '@/views/modules/dictionaryJiance/list'
        import dictionaryJiankang from '@/views/modules/dictionaryJiankang/list'
        import dictionaryKouzhao from '@/views/modules/dictionaryKouzhao/list'
        import dictionaryKouzhaoyuyue from '@/views/modules/dictionaryKouzhaoyuyue/list'
        import dictionarySex from '@/views/modules/dictionarySex/list'
        import dictionaryYimiao from '@/views/modules/dictionaryYimiao/list'
        import dictionaryYimiaoyuyue from '@/views/modules/dictionaryYimiaoyuyue/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryDidian',
        name: '地点状态',
        component: dictionaryDidian
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型名称',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryJiance',
        name: '检测结果',
        component: dictionaryJiance
    }
    ,{
        path: '/dictionaryJiankang',
        name: '健康状态',
        component: dictionaryJiankang
    }
    ,{
        path: '/dictionaryKouzhao',
        name: '口罩类型',
        component: dictionaryKouzhao
    }
    ,{
        path: '/dictionaryKouzhaoyuyue',
        name: '状态',
        component: dictionaryKouzhaoyuyue
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型名称',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryYimiao',
        name: '疫苗类型',
        component: dictionaryYimiao
    }
    ,{
        path: '/dictionaryYimiaoyuyue',
        name: '状态',
        component: dictionaryYimiaoyuyue
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/didian',
        name: '地点',
        component: didian
      }
    ,{
        path: '/gonggao',
        name: '公告信息',
        component: gonggao
      }
    ,{
        path: '/guiji',
        name: '用户轨迹',
        component: guiji
      }
    ,{
        path: '/hesuan',
        name: '核算检测',
        component: hesuan
      }
    ,{
        path: '/kouzhao',
        name: '口罩',
        component: kouzhao
      }
    ,{
        path: '/kouzhaoyuyue',
        name: '口罩预订',
        component: kouzhaoyuyue
      }
    ,{
        path: '/yihu',
        name: '医护人员',
        component: yihu
      }
    ,{
        path: '/yimiao',
        name: '疫苗',
        component: yimiao
      }
    ,{
        path: '/yimiaoyuyue',
        name: '疫苗预约',
        component: yimiaoyuyue
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
