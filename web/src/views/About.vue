<template>
    <div>
        <div>
            <v-list two-line subheader>
                <v-subheader>开发者信息</v-subheader>

                <v-list-item @click="">
                    <v-list-item-content>
                        <v-list-item-title>开发者</v-list-item-title>
                        <v-list-item-subtitle>李林南</v-list-item-subtitle>
                    </v-list-item-content>
                </v-list-item>

                <v-list-item @click="dialog.contact=true">
                    <v-list-item-content>
                        <v-list-item-title>QQ</v-list-item-title>
                        <v-list-item-subtitle>1170909542</v-list-item-subtitle>
                    </v-list-item-content>
                </v-list-item>
            </v-list>

            <v-divider></v-divider>

            <v-list three-line subheader>
                <v-subheader>支持开发者</v-subheader>
                <v-list-item @click="dialog.donate=true">
                    <v-list-item-content>
                        <v-list-item-title>赞赏开发者</v-list-item-title>
                        <v-list-item-subtitle>如果感觉本网站还不错，可以点击这里赞赏开发者，谢谢您</v-list-item-subtitle>
                    </v-list-item-content>
                </v-list-item>
            </v-list>

            <v-divider></v-divider>

            <v-list three-line subheader>
                <v-subheader>反馈</v-subheader>
                <v-list-item @click="dialog.feedback=true">
                    <v-list-item-content>
                        <v-list-item-title>反馈方式1</v-list-item-title>
                        <v-list-item-subtitle>点击这里提交在线反馈，并留下联系方式，开发者将会主动与您联系。</v-list-item-subtitle>
                    </v-list-item-content>
                </v-list-item>
                <v-list-item @click="dialog.contact=true">
                    <v-list-item-content>
                        <v-list-item-title>反馈方式2</v-list-item-title>
                        <v-list-item-subtitle>点击这里或者上方的QQ，与开发者在线交流。</v-list-item-subtitle>
                    </v-list-item-content>
                </v-list-item>
            </v-list>
        </div>

        <template>
            <v-row justify="center">
                <v-dialog v-model="dialog.contact" persistent max-width="290">
                    <v-card>
                        <v-card-title class="headline">提示</v-card-title>
                        <v-card-text>是否要与开发者在线交流？
                        </v-card-text>
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn color="primary" text @click="dialog.contact = false">取消</v-btn>
                            <v-btn color="primary" text @click="openQQ">确定</v-btn>
                        </v-card-actions>
                    </v-card>
                </v-dialog>
            </v-row>
        </template>

        <template>
            <v-row justify="center">
                <v-dialog v-model="dialog.simple" persistent max-width="290">
                    <v-card>
                        <v-card-title class="headline">提示</v-card-title>
                        <v-card-text>{{dialog.simpleMessage}}
                        </v-card-text>
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn color="primary" text @click="dialog.simple=false">好的</v-btn>
                        </v-card-actions>
                    </v-card>
                </v-dialog>
            </v-row>
        </template>

        <template>
            <v-row justify="center">
                <v-dialog v-model="dialog.feedback" fullscreen hide-overlay transition="dialog-bottom-transition">
                    <v-card>
                        <v-toolbar dark color="primary">
                            <v-btn icon dark @click="dialog.feedback = false">
                                <v-icon>mdi-close</v-icon>
                            </v-btn>
                            <v-toolbar-title>在线反馈</v-toolbar-title>
                        </v-toolbar>
                        <v-container>
                            <v-row no-gutters>
                                <v-col cols="12" md="4" offset-md="4" :align="alignment">
                                    <v-textarea v-model="feedback.feedback"
                                                color="primary"
                                                placeholder="在这里输入您的意见、建议或者使用过程中遇到的bug或一些麻烦等，提交后我会尽快联系您。"></v-textarea>
                                    <v-text-field
                                        v-model="feedback.contact" placeholder="请输入您的联系方式，QQ/微信/手机号等"></v-text-field>
                                    <v-btn @click="submit" :disabled="submitConfig.disabled">提交</v-btn>
                                </v-col>
                            </v-row>
                        </v-container>
                    </v-card>
                </v-dialog>
            </v-row>
        </template>

        <template>
            <v-row justify="center">
                <v-dialog v-model="dialog.donate" fullscreen hide-overlay transition="dialog-bottom-transition">
                    <v-card>
                        <v-toolbar dark color="primary">
                            <v-btn icon dark @click="dialog.donate = false">
                                <v-icon>mdi-close</v-icon>
                            </v-btn>
                            <v-toolbar-title>捐赠</v-toolbar-title>
                        </v-toolbar>
                        <v-container>
                            <v-row no-gutters>
                                <v-col cols="12" md="4" offset-md="4" :align="alignment">
                                    <v-img width="100%" src="../assets/image/alipay.png"/>
                                    <v-img width="100%" src="../assets/image/mmpay.png"/>
                                    <v-img width="100%" src="../assets/image/qqpay.png"/>
                                </v-col>
                            </v-row>
                        </v-container>
                    </v-card>
                </v-dialog>
            </v-row>
        </template>
    </div>
</template>

<script>
    export default {
        data: () => ({
            dialog: {
                contact: false,
                feedback: false,
                donate: false,
                simple: false,
                simpleMessage: ""
            },
            feedback: {
                feedback: "",
                contact: ""
            },
            submitConfig: {
                disabled: false
            },
            alignment: "center",
        }),
        methods: {
            openQQ() {
                this.dialog.contact = false;
                window.location.href = "https://wpa.qq.com/msgrd?v=3&uin=1170909542&site=qq&menu=yes";
            },
            async submit() {
                if (this.feedback.feedback.trim().length === 0 || this.feedback.contact.trim().length === 0) {
                    return this.showDialog("请将信息填写完整")
                }
                this.submitConfig.disabled = true;

                const {data: res} = await this.$http.post("feedback", this.feedback).catch(reason => {
                    this.showDialog("提交失败");
                    this.submitConfig.disabled = false;
                });

                this.submitConfig.disabled = false;

                if (res['status'] !== 200) {
                    return this.showDialog(res['message']);
                }
                this.clear()
                this.showDialog("提交成功");
                this.dialog.feedback = false;

            },
            showDialog(message) {
                this.dialog.simple = true;
                this.dialog.simpleMessage = message;
            },
            clear() {
                this.feedback.feedback = "";
                this.feedback.contact = "";
            }
        }
    }
</script>