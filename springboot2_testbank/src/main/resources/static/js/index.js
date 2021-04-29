let vm = new Vue({
    el: "#app",
    data: {
        accountId: '',
        money: 0.0,
        inAccountId: '',
        result: ''
    },
    methods: {
        OpenAccounts: function () {
            var params = new URLSearchParams();
            params.append("money", this.money);
            axios.post('/open/11').then(response => {
                if (response.data.code == 1) {
                    this.result = "新开账号:" + response.data.data.accountId +
                        "余额为:<span class='point'>" + response.data.data.balance + "</span>";
                } else {
                    this.result = "<span class='sp'>" + response.data.msg + "</span>";
                }

            }).catch(function (error) {
                this.result = "<span class='sp'>" + error + "</span>";
            })
        }
    }
});