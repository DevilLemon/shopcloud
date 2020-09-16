function getUrlParms(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
    var result = window.location.search.substr(1).match(reg);
    console.log("location的search-URL参数:" + result ? decodeURI(result[2]):null);
    return result ? decodeURI(result[2]):null;
}
var goodsVue = {
    goods: [],
    goodUpdate:[{ goodid:0, name:'', num:0, pay:0, status:''}]
};
//ViewModel
var vue = new Vue({
    el: '#adminGoodEdit',
    data: goodsVue,
    mounted:function(){ //mounted　表示这个 Vue 对象加载成功了
        this.get();
    },
    methods: {
        get: function () {
            var goodid = getUrlParms("goodid");
            var url = "adminGood/" + goodid;
            axios.get(url).then(function(response) {
                console.log("get数据:" + JSON.stringify(response));
                vue.goodUpdate = response.data;
            })
        },
        update: function (event) {
            var url = "adminGood/" + vue.goodUpdate.id;
            axios.put(url, vue.goodUpdate,
                {headers: {'Content-Type': 'application/json;charset=UTF-8'}})
                .then(function (response) {
                    console.log("update数据:" + response);
                    location.href = "adminGoodList";
                });
        },
        cancel: function () {
            location.href = "adminGoodList";
        }
    }
});