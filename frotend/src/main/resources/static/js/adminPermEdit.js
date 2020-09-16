function getUrlParms(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
    var result = window.location.search.substr(1).match(reg);
    console.log("location的search-URL参数:" + result ? decodeURI(result[2]):null);
    return result ? decodeURI(result[2]):null;
}
var rolePermsVue = {
    rolePerms: [],
    rolePerm:[{ urpid:0,userid:0, name:'', permid:0, perm:'' }]
};
//ViewModel
var vue = new Vue({
    el: '#adminPermEdit',
    data: rolePermsVue,
    mounted:function(){ //mounted　表示这个 Vue 对象加载成功了
        this.get();
    },
    methods: {
        get: function () {
            var userid = getUrlParms("userid");
            var url = "adminPermEdit/" + userid;
            axios.get(url).then(function(response) {
                console.log("get数据:" + JSON.stringify(response));
                vue.rolePerms = response.data.list;
            })
        },
        update: function (rolePerm) {
            var url = "adminPermEdit";
            vue.rolePerm = rolePerm;
            alert("vue.perm被覆盖赋值：" + JSON.stringify(vue.rolePerm));
            axios.put(url, vue.rolePerm,
                {headers: {'Content-Type': 'application/json;charset=UTF-8'}})
                .then(function (response) {
                    console.log("update_response:" + response);
                    location.reload();
                });
        },
        deletePerm: function(urpid){
            var url = "adminPermEdit/" + urpid;
            axios.delete(url,{headers: {'Content-Type': 'application/json;charset=UTF-8'}})
                .then(function (response) {
                    console.log("update_response:" + response);
                    location.reload();
                });
        },
        cancel: function () {
            location.href = "adminUserList";
        }
    }
});