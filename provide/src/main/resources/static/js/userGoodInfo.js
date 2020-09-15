function getUrlParms(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var result = window.location.search.substr(1).match(reg);
    console.log(result ? decodeURI(result[2]):null);
    return result ? decodeURI(result[2]):null;
}
var goodsVue = {
    goods: [],
    goodInfo:[{ goodid:0, username:'', name:'', num:0, pay:0, allpay:0, status:''}]
};
//ViewModel
var vue = new Vue({
    el: '#goodInfo',
    data: goodsVue,
    mounted:function(){ //mounted　表示这个 Vue 对象加载成功了
        this.get();
    },
    methods: {
        get: function () {
            var goodid = getUrlParms("goodid");
            var url = "userGood/" + goodid;
            var test = goods.toString();
            var w = test.parseJSON();
            console.log(goods.toString());
            axios.get(url).then(function(response) {
                console.log("get数据:" + JSON.stringify(response));
                vue.goodInfo = response.data;
                vue.goodInfo.allpay = response.data.num * response.data.pay;
            })
        },
        updateAllPay: function(id){
            switch (id){
                case 1:
                    vue.goodInfo.allpay = this.goodInfo.num * this.goodInfo.pay;
                    console.log("allpay改变为:" + vue.goodInfo.allpay);
                    break;
                case 2:
                    vue.goodInfo.allpay = this.goodInfo.num * this.goodInfo.pay;
                    console.log("allpay改变为:" + vue.goodInfo.allpay);
                    break;
                default:
                    console.log("错误,请检查!");
            }
        },
        addOrder: function () {
            var url = "addOrder";
            axios.post(url, vue.goodInfo,
                {headers: {'Content-Type': 'application/json;charset=UTF-8'}})
                .then(function (response) {
                    location.href = "userOrderList";
                    console.log("update_response:" + response);
                });
        },
        cancel: function () {
            console.log("cancel数据:" + response);
            location.href = "userGoodList";
        }
    }
});