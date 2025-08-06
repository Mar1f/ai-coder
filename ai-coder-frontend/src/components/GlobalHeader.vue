<template>
  <a-layout-header class="global-header">
    <div class="header-content">
      <!-- 左侧：Logo和网站标题 -->
      <div class="header-left">
        <img src="@/assets/logo.jpeg" alt="Logo" class="logo" />
      </div>

      <!-- 中间：导航菜单 -->
      <div class="header-center">
        <a-menu
          v-model:selectedKeys="selectedKeys"
          mode="horizontal"
          :items="menuItems"
          class="header-menu"
          @click="handleMenuClick"
        />
      </div>

      <!-- 右侧：用户信息 -->
      <div class="header-right">
        <a-button type="primary" @click="handleLogin">
          <template #icon>
            <UserOutlined />
          </template>
          登录
        </a-button>
      </div>
    </div>
  </a-layout-header>
</template>

<script setup lang="ts">
import { ref, watch } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { UserOutlined, HomeOutlined, FolderOutlined, InfoCircleOutlined } from '@ant-design/icons-vue'
import type { MenuProps } from 'ant-design-vue'
import { h } from 'vue'

const router = useRouter()
const route = useRoute()

// 菜单配置
const menuItems: MenuProps['items'] = [
  {
    key: 'home',
    label: '首页',
    icon: () => h(HomeOutlined)
  },
  {
    key: 'projects',
    label: '项目',
    icon: () => h(FolderOutlined)
  },
  {
    key: 'about',
    label: '关于',
    icon: () => h(InfoCircleOutlined)
  }
]

// 当前选中的菜单项
const selectedKeys = ref<string[]>(['home'])

// 监听路由变化，更新选中的菜单项
watch(() => route.name, (newRouteName) => {
  if (newRouteName) {
    selectedKeys.value = [newRouteName as string]
  }
}, { immediate: true })

// 菜单点击处理
const handleMenuClick: MenuProps['onClick'] = ({ key }) => {
  switch (key) {
    case 'home':
      router.push('/')
      break
    case 'projects':
      router.push('/projects')
      break
    case 'about':
      router.push('/about')
      break
  }
}

// 登录处理
const handleLogin = () => {
  console.log('登录按钮点击')
  // TODO: 实现登录逻辑
}
</script>

<style scoped>
.global-header {
  background: #fff;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 1000;
  height: 64px;
  line-height: 64px;
  padding: 0 !important; /* 移除ant-layout-header的默认padding */
}

/* 深度选择器覆盖ant-layout-header的默认样式 */
.global-header :deep(.ant-layout-header) {
  padding: 0 !important;
}

.global-header :deep(.ant-layout-header) {
  padding-left: 0 !important;
  padding-right: 0 !important;
}

.header-content {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%; /* 使用100%宽度而不是max-width */
  margin: 0; /* 移除auto margin */
  padding: 0; /* 完全移除padding，让内容贴边 */
  height: 100%;
}

.header-left {
  display: flex;
  align-items: center;
  flex-shrink: 0; /* 防止被压缩 */
  padding-left: 16px; /* 完全移除左侧间距 */
}

.logo {
  width: 40px;
  height: 40px;
  border-radius: 4px;
  object-fit: cover;
}

.site-title {
  margin: 0;
  font-size: 20px;
  font-weight: 600;
  color: #1890ff;
}

.header-center {
  flex: 1;
  display: flex;
  justify-content: center;
}

.header-menu {
  border: none;
  background: transparent;
}

.header-menu :deep(.ant-menu-item) {
  margin: 0 8px;
}

.header-right {
  display: flex;
  align-items: center;
  flex-shrink: 0; /* 防止被压缩 */
  padding-right: 16px; /* 只给右侧一点点间距 */
}

/* 响应式设计 */
@media (max-width: 768px) {
  .header-left {
    padding-left: 8px; /* 小屏幕也完全贴边 */
  }

  .header-right {
    padding-right: 8px; /* 小屏幕减少右侧间距 */
  }

  .header-menu {
    display: none; /* 移动端隐藏菜单，可以考虑使用抽屉菜单 */
  }
}

@media (max-width: 480px) {
  .header-left {
    padding-left: 4px; /* 超小屏幕也完全贴边 */
  }

  .header-right {
    padding-right: 4px; /* 超小屏幕进一步减少间距 */
  }
}
</style>
