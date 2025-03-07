<template>

    <v-card outlined>
        <v-card-title>
            DeviceInfo # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="DeviceName" v-model="item.deviceName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Status" v-model="item.status" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Latitude" v-model="item.latitude" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Longitude" v-model="item.longitude" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Information" v-model="item.information" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'DeviceInfoViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/deviceInfos/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

