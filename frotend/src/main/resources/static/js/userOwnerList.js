function getUrlParms(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
    var result = window.location.search.substr(1).match(reg);
    console.log("location的search-URL参数:" + result ? decodeURI(result[2]):null);
    return result ? decodeURI(result[2]):null;
}
var userInfoVue = {
    userInfos: [],
    userInfo:[{ infoid:0, sex:'', nation:'', phone:'', address:'' }]
};
//ViewModel
var vue = new Vue({
    el: '#adminUserEdit',
    data: userInfoVue,
    mounted:function(){ //mounted　表示这个 Vue 对象加载成功了
        this.get();
    },
    methods: {
        get: function () {
            var userid = getUrlParms("userid");
            var url = "adminUserEdit/" + userid;
            axios.get(url).then(function(response) {
                vue.userInfo = response.data;
                console.log("get数据:" + JSON.stringify(vue.userInfo));
            })
        },
        update: function () {
            var url = "adminUserEdit/" + vue.userInfo.infoid;
            axios.put(url, vue.userInfo,
                {headers: {'Content-Type': 'application/json;charset=UTF-8'}})
                .then(function (response) {
                    console.log("update数据:" + response);
                    location.href = "adminUserList";
                });
        },
        cancel: function () {
            location.href = "adminUserList";
        }
    }
});