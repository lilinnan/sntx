<template>
  <div>
    <template>
      <div>
        <v-timeline>
          <v-timeline-item>
            <span slot="opposite">2021.6.9</span>
            <v-card class="elevation-2">
              <v-card-text>
                <div>
                  1.更新日服历史头像查询
                </div>
                <div>
                  2.更新依赖版本
                </div>
              </v-card-text>
            </v-card>
          </v-timeline-item>
          <v-timeline-item>
            <span slot="opposite">2020.9.24</span>
            <v-card class="elevation-2">
              <v-card-text>
                <div>
                  1.解决了chrome将图片链接自动提升为https，而叠纸图片服务器不支持https导致的图片加载失败问题
                </div>
              </v-card-text>
            </v-card>
          </v-timeline-item>
          <v-timeline-item>
            <span slot="opposite">2020.6.19</span>
            <v-card class="elevation-2">
              <v-card-text>
                <div>
                  1.重写关于界面
                </div>
                <div>
                  2.增加反馈渠道
                </div>
                <div>
                  3.将台服的ID输入框的计数器设置为10，避免某些用户出现误解
                </div>
                <div>
                  4.更新侧边栏图标
                </div>
                <div>
                  5.增加赞赏二维码
                </div>
              </v-card-text>
            </v-card>
          </v-timeline-item>
          <v-timeline-item>
            <span slot="opposite">2020.6.17</span>
            <v-card class="elevation-2">
              <v-card-text>
                <div>
                  1.解决了部分玩家头像无法查询的问题
                </div>
              </v-card-text>
            </v-card>
          </v-timeline-item>
          <v-timeline-item>
            <span slot="opposite">更早</span>
            <v-card class="elevation-2">
              <v-card-text>
                <div>
                  无日志记录
                </div>
              </v-card-text>
            </v-card>
          </v-timeline-item>
        </v-timeline>
      </div>
    </template>
  </div>
</template>

<script>
export default {
  data: () => ({
    reverse: true,
  }),
}
</script>