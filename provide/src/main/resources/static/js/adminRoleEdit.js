function getUrlParms(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
    var result = window.location.search.substr(1).match(reg);
    console.log("location的search-URL参数:" + result ? decodeURI(result[2]):null);
    return result ? decodeURI(result[2]):null;
}
var userRoleVue = {
    userRoles: [],
    userRole:[{ urid:0, userid:0, name:'', roleid:0, role:''}]
};
//ViewModel
var vue = new Vue({
    el: '#adminRoleEdit',
    data: userRoleVue,
    mounted:function(){ //mounted　表示这个 Vue 对象加载成功了
        this.get();
    },
    methods: {
        get: function () {
            var userid = getUrlParms("userid");
            var url = "adminRoleEdit/" + userid;
            axios.get(url).then(function(response) {
                vue.userRole = response.data;
                console.log("get数据:" + JSON.stringify(vue.userRole));
            })
        },
        update: function (event) {
            var url = "adminRoleEdit/" + vue.userRole.urid;
            axios.put(url, vue.userRole,
                {headers: {'Content-Type': 'application/json;charset=UTF-8'}})
                .then(function (response) {
                    console.log("update数据返回:" + response);
                    location.href = "adminUserList";
                });
        },
        cancel: function () {
            location.href = "adminUserList";
        }
    }
});