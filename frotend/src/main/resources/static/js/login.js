var loginVue = {
    login: {name:'',password:''}
};
var vue = new Vue({
    el: '#login',
    data: loginVue,
    mounted:function(){},
    methods: {
        login_submit: function () {
            var url = "http://127.0.0.1:8040/api-view/login";
            var StringData = JSON.stringify(loginVue.login); //转换为JSON字符串
            axios.post( url,loginVue.login,
                {xhrFields: {withCredentials: true}},
                {headers:{'Content-Type':'application/json;charset=UTF-8'}} )
                .success(function(response){
                alert("登陆返回的信息：" + response.result);
                alert("转换的信息：" + JSON.stringify(response));
                if ( response.result = 1){
                    alert("登陆成功：" + response.result);
                    location.href = "index";
                }
                else if ( response.result = 1 ){
                    alert("登陆失败：" + response.result);
                    location.reload();
                }
            });
        }
    }
});