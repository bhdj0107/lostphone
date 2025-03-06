
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import DeviceDeviceManager from "./components/listers/DeviceDeviceCards"
import DeviceDeviceDetail from "./components/listers/DeviceDeviceDetail"

import LostdeviceLostDeviceManager from "./components/listers/LostdeviceLostDeviceCards"
import LostdeviceLostDeviceDetail from "./components/listers/LostdeviceLostDeviceDetail"

import DeviceStatusView from "./components/DeviceStatusView"
import DeviceStatusViewDetail from "./components/DeviceStatusViewDetail"
import NotificationNotificationManager from "./components/listers/NotificationNotificationCards"
import NotificationNotificationDetail from "./components/listers/NotificationNotificationDetail"

import DevicecontrolDeviceControlManager from "./components/listers/DevicecontrolDeviceControlCards"
import DevicecontrolDeviceControlDetail from "./components/listers/DevicecontrolDeviceControlDetail"

import MemberMemberManager from "./components/listers/MemberMemberCards"
import MemberMemberDetail from "./components/listers/MemberMemberDetail"


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
                path: '/lostdevices/deviceStatuses',
                name: 'DeviceStatusView',
                component: DeviceStatusView
            },
            {
                path: '/lostdevices/deviceStatuses/:id',
                name: 'DeviceStatusViewDetail',
                component: DeviceStatusViewDetail
            },
            {
                path: '/notifications/notifications',
                name: 'NotificationNotificationManager',
                component: NotificationNotificationManager
            },
            {
                path: '/notifications/notifications/:id',
                name: 'NotificationNotificationDetail',
                component: NotificationNotificationDetail
            },

            {
                path: '/devicecontrols/deviceControls',
                name: 'DevicecontrolDeviceControlManager',
                component: DevicecontrolDeviceControlManager
            },
            {
                path: '/devicecontrols/deviceControls/:id',
                name: 'DevicecontrolDeviceControlDetail',
                component: DevicecontrolDeviceControlDetail
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



    ]
})
