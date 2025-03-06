<template>
    <v-card outlined>
        <v-card-title>
            ChangeLocation
        </v-card-title>

        <v-card-text>
            <Number label="Latitude" v-model="value.latitude" :editMode="editMode"/>
            <Number label="Longitude" v-model="value.longitude" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="changeLocation"
            >
                ChangeLocation
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'ChangeLocationCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.latitude = 0;
            this.value.longitude = 0;
        },
        watch: {
        },
        methods: {
            changeLocation() {
                this.$emit('changeLocation', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

