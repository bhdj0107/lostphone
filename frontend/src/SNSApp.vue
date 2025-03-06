<template>
    <v-app id="inspire">
        <div>
            <v-app-bar color="primary" app clipped-left flat>
                <v-toolbar-title>
                    <span class="second-word font uppercase"
                        style="font-weight:700;"
                    >
                        <v-app-bar-nav-icon
                            @click="openSideBar()"
                            style="z-index:1;
                            height:56px;
                            width:30px;
                            margin-right:10px;
                            font-weight:300;
                            font-size:55px;"
                        >
                            <div style="line-height:100%;">≡</div>
                        </v-app-bar-nav-icon>
                    </span>
                </v-toolbar-title>
                <span v-if="urlPath!=null" 
                    class="mdi mdi-home" 
                    key="" 
                    to="/" 
                    @click="goHome()"
                    style="margin-left:10px; font-size:20px; cursor:pointer;"
		        ></span> 
                <v-spacer></v-spacer>

            </v-app-bar>

            <v-navigation-drawer app clipped flat v-model="sideBar">
                <v-list>
                    <v-list-item
                        class="px-2"
                        key="devices"
                        to="/devices/devices"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        단말기
                    </v-list-item>
                    <v-list-item
                        class="px-2"
                        key="lostDevices"
                        to="/lostdevices/lostDevices"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        분실신고
                    </v-list-item>
                    <v-list-item
                        class="px-2"
                        key="deviceStatuses"
                        to="/lostdevices/deviceStatuses"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        신고자/고객센터
                    </v-list-item>
                    <v-list-item
                        class="px-2"
                        key="notifications"
                        to="/notifications/notifications"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        알림
                    </v-list-item>
                    <v-list-item
                        class="px-2"
                        key="deviceControls"
                        to="/devicecontrols/deviceControls"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        단말기제어
                    </v-list-item>
                    <v-list-item
                        class="px-2"
                        key="members"
                        to="/members/members"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        회원
                    </v-list-item>
                </v-list>
            </v-navigation-drawer>
        </div>

        <v-main>
            <v-container style="padding:0px;" v-if="urlPath" fluid>
                <router-view></router-view>
            </v-container>
            <v-container style="padding:0px;" v-else fluid>
                <div style="width:100%; position: relative;">
                    <v-img style="width:100%; height:200px;"
                        src=""
                    ></v-img>
                    <div class="App-main-text-overlap"></div>
                    <div class="App-sub-text-overlap"></div>
                </div>
                <v-row class="pa-0 ma-0">
                    <v-col cols="12" lg="3" md="4" sm="6" class="pa-0 pa-0" v-for="(aggregate, index) in aggregate" :key="index">
                        <div class="pa-4">
                            <v-card
                                :key="aggregate.key"
                                :to="aggregate.route"
                                @click="changeUrl()"
                                class="mx-auto main-card pa-4"
                                style="text-align: center; border-radius: 10px;"
                                outlined
                            >
                                <div class="d-flex justify-center" style="width:120px; height:120px; border-radius: 10px; margin: 0 auto; background-color:white;">
                                    <v-img style="width:100%; height:100%; object-fit:contain; border-radius: 10px;" :src="aggregate.ImageUrl"></v-img>
                                </div>
                                <div style="text-align: center;">
                                    <h2 class="main-card-title">{{ aggregate.title }}</h2>
                                </div>
                            </v-card>
                        </div>
                    </v-col>
                </v-row>
            </v-container>
        </v-main>
    </v-app>
</template>

<script>

export default {
    name: "App",
    data: () => ({
        useComponent: "",
        drawer: true,
        components: [],
        sideBar: true,
        urlPath: null,
        flipped: [],
        ImageUrl: '',
        aggregate: [
            { 
                title: '단말기', 
                description: 'Device을 관리하는 화면입니다.', 
                key: 'devices', 
                route: '/devices/devices',
                ImageUrl: '',
            },
            { 
                title: '분실신고', 
                description: 'LostDevice을 관리하는 화면입니다.', 
                key: 'lostDevices', 
                route: '/lostdevices/lostDevices',
                ImageUrl: '',
            },
            { 
                title: '알림', 
                description: 'Notification을 관리하는 화면입니다.', 
                key: 'notifications', 
                route: '/notifications/notifications',
                ImageUrl: '',
            },
            { 
                title: '단말기제어', 
                description: 'DeviceControl을 관리하는 화면입니다.', 
                key: 'deviceControls', 
                route: '/devicecontrols/deviceControls',
                ImageUrl: '',
            },
            { 
                title: '회원', 
                description: 'Member을 관리하는 화면입니다.', 
                key: 'members', 
                route: '/members/members',
                ImageUrl: '',
            },
            { 
                title: '신고자/고객센터', 
                description: 'DeviceStatus을 관리하는 화면입니다.', 
                key: 'deviceStatuses', 
                route: '/lostdevices/deviceStatuses',
                ImageUrl: '',
            },
            
        ],
    }),
    
    async created() {
      var path = document.location.href.split("#/")
      this.urlPath = path[1];

    },
    watch: {
        cards(newCards) {
            this.flipped = new Array(newCards.length).fill(false);
        },
    },

    mounted() {
        var me = this;
        me.components = this.$ManagerLists;
    },

    methods: {
        openSideBar(){
            this.sideBar = !this.sideBar
        },
        changeUrl() {
            var path = document.location.href.split("#/")
            this.urlPath = path[1];
            this.flipped.fill(false);
        },
        goHome() {
            this.urlPath = null;
        },
        flipCard(index) {
            this.$set(this.flipped, index, true);
        },
        unflipCard(index) {
            this.$set(this.flipped, index, false);
        },
    }
};
</script>
<style>
</style>
