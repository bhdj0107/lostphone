<template>

    <v-data-table
        :headers="headers"
        :items="deviceStatus"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'DeviceStatusView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            deviceStatus : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/deviceStatuses'))

            temp.data._embedded.deviceStatuses.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.deviceStatus = temp.data._embedded.deviceStatuses;
        },
        methods: {
        }
    }
</script>

