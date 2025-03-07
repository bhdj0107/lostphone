
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import DeviceDeviceManager from "./components/listers/DeviceDeviceCards"
import DeviceDeviceDetail from "./components/listers/DeviceDeviceDetail"

import DeviceInfoView from "./components/DeviceInfoView"
import DeviceInfoViewDetail from "./components/DeviceInfoViewDetail"
import LostdeviceLostDeviceManager from "./components/listers/LostdeviceLostDeviceCards"
import LostdeviceLostDeviceDetail from "./components/listers/LostdeviceLostDeviceDetail"

import MemberMemberManager from "./components/listers/MemberMemberCards"
import MemberMemberDetail from "./components/listers/MemberMemberDetail"

import MemberInfoView from "./components/MemberInfoView"
import MemberInfoViewDetail from "./components/MemberInfoViewDetail"
import MemberInformationView from "./components/MemberInformationView"
import MemberInformationViewDetail from "./components/MemberInformationViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/devices/devices',
                name: 'DeviceDeviceManager',
                component: DeviceDeviceManager
            },
            {
                path: '/devices/devices/:id',
                name: 'DeviceDeviceDetail',
                component: DeviceDeviceDetail
            },

            {
                path: '/devices/deviceInfos',
                name: 'DeviceInfoView',
                component: DeviceInfoView
            },
            {
                path: '/devices/deviceInfos/:id',
                name: 'DeviceInfoViewDetail',
                component: DeviceInfoViewDetail
            },
            {
                path: '/lostdevices/lostDevices',
                name: 'LostdeviceLostDeviceManager',
                component: LostdeviceLostDeviceManager
            },
            {
                path: '/lostdevices/lostDevices/:id',
                name: 'LostdeviceLostDeviceDetail',
                component: LostdeviceLostDeviceDetail
            },

            {
                path: '/members/members',
                name: 'MemberMemberManager',
                component: MemberMemberManager
            },
            {
                path: '/members/members/:id',
                name: 'MemberMemberDetail',
                component: MemberMemberDetail
            },

            {
                path: '/members/memberInfos',
                name: 'MemberInfoView',
                component: MemberInfoView
            },
            {
                path: '/members/memberInfos/:id',
                name: 'MemberInfoViewDetail',
                component: MemberInfoViewDetail
            },
            {
                path: '/members/memberInformations',
                name: 'MemberInformationView',
                component: MemberInformationView
            },
            {
                path: '/members/memberInformations/:id',
                name: 'MemberInformationViewDetail',
                component: MemberInformationViewDetail
            },


    ]
})
