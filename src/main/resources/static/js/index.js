var app = new Vue({
    el: "#app",
    data: function () {
        return {
            endpointData: [],
            msg: '',
            endpoint: ''
        }

    },
    methods: {
        setErrorMessage: function (message) {
            this.msg = message['error'];
            console.log('Message = ' + message);
        },
        loadData: function () {
            var ref = this;
            axios.get("/endpoints")
                .then(function (response) {
                    if (response.status === 200) {
                        ref.endpointData = response.data;
                    } else {
                        ref.setErrorMessage(response.data)
                    }
                })
                .catch(function (error) {
                    ref.setErrorMessage(error.response.data);
                });
        },
        prettyJson: function (data) {
            return JSON.stringify(data, null, 2); // spacing level = 2
        },
        addItem: function () {
            if (this.endpoint === '') {
                return;
            }
            var ref = this;
            var formData = new FormData();
            formData.append("url", this.endpoint);
            axios.post("/endpoints", formData,
                {
                    headers:
                        {
                            'Content-Type':
                                'multipart/form-data'
                        }
                })
                .then(function (response) {
                    if (response.status === 200) {
                        ref.endpointData.push(response.data);
                    } else {
                        ref.setErrorMessage(response.data);
                    }
                })
                .catch(function (error) {
                    ref.setErrorMessage(error.response.data);
                });
        },
        updateItem: function (id) {
            var ref = this;
            axios.put("/endpoints/" + id)
                .then(function (response) {
                    if (response.status === 200) {
                        //Find index of specific object using findIndex method.
                        var objIndex = ref.endpointData.findIndex(function (obj) {
                            return obj.id === id;
                        });

                        //Update object
                        ref.endpointData.splice(objIndex, 1, response.data);
                    } else {
                        ref.setErrorMessage(response.data);
                    }
                })
                .catch(function (error) {
                    ref.setErrorMessage(error.response.data);
                });
        },
        deleteItem: function (id) {
            var ref = this;
            axios.delete("/endpoints/" + id)
                .then(function (response) {
                    if (response.status === 200) {
                        //Find index of specific object using findIndex method.
                        var objIndex = ref.endpointData.findIndex(function (obj) {
                            return obj.id === id;
                        });

                        //Update object
                        ref.endpointData.splice(objIndex, 1);
                    } else {
                        ref.setErrorMessage(response.data);
                    }
                })
                .catch(function (error) {
                    ref.setErrorMessage(error.response.data);
                });
        }

    },
    created: function () {
        this.loadData();
    }
});