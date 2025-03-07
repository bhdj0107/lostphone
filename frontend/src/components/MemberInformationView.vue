<template>

    <v-data-table
        :headers="headers"
        :items="memberInformation"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'MemberInformationView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "name", value: "name" },
                { text: "contact", value: "contact" },
            ],
            memberInformation : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/memberInformations'))

            temp.data._embedded.memberInformations.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.memberInformation = temp.data._embedded.memberInformations;
        },
        methods: {
        }
    }
</script>

