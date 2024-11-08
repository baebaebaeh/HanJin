import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AboutView from '../views/AboutView.vue'
import UserView from '@/views/UserView.vue'
import LoginView from '@/views/LoginView.vue'
import BoardView from '@/views/BoardView.vue'
import BoardList from '@/components/board/BoardList.vue'
import BoardCreate from '@/components/board/BoardCreate.vue'

const isAuth = true  //false : 로그인이 안되었음

const router = createRouter({
  
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/about',
      name: 'about',
      component: AboutView,
    },
    {
      path: '/user/:id', //동적라우팅
      name: 'user',
      component: UserView,
    },
    {
      path: '/login', //동적라우팅
      name: 'login',
      component: LoginView,
      // 특정 라우터와 관련
      beforeEnter: (to, from) => {
        if (isAuth) {
          console.log("이미 로그인이 된 상태")
          return { name: 'home' }
        }
      }
    },
    {
      path: '/board',
      name: 'board',
      component: BoardView,
      children: [
        {
          path: '',
          name: 'boardList',
          component: BoardList
        },
        {
          path: 'create',
          name: 'boardCreate',
          component: BoardCreate
        }
      ]
    }
  ],
})

//전체라우팅과 관련
router.beforeEach((to, from) => {
  // console.log(to)
  // console.log(from)

  if (!isAuth && to.name !== 'login') {
    console.log("로그인이 필요합니다.")
    return { name: 'login' }
  }


})

export default router
