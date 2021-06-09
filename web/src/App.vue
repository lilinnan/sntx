<template>
  <v-app id="inspire">
    <v-navigation-drawer v-model="drawer" :clipped="$vuetify.breakpoint.lgAndUp" app>
      <v-list dense>
        <template v-for="item in items">
          <v-list-item :key="item.text" :to="item.link" link>
            <v-list-item-action>
              <v-icon>{{ item.icon }}</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title>
                {{ item.text }}
              </v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </template>
      </v-list>
    </v-navigation-drawer>
    <v-app-bar :clipped-left="$vuetify.breakpoint.lgAndUp" color="primary" dark app>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title style="width: 300px" class="ml-0 pl-4">
        <span>闪暖历史头像查询</span>
      </v-toolbar-title>
    </v-app-bar>
    <v-content>
      <v-container fluid>
        <router-view :key="$route.name"/>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
export default {
  data: () => ({
    drawer: null,
    items: [
      {text: '国服', icon: 'mdi-alpha-m-box-outline', link: '/mainland'},
      {text: '台服', icon: 'mdi-alpha-t-box-outline', link: '/taiwan'},
      {text: '日服', icon: 'mdi-alpha-j-box-outline', link: '/japan'},
      {text: '关于', icon: 'mdi-information-outline ', link: '/about'},
      {text: '更新日志', icon: 'mdi-update', link: '/update'},
    ]
  }),
}
</script>
<style>
::-webkit-scrollbar{
  display: none;
}
</style>