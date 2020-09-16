var shop_objectsVue = {
    shop_obs: [],
    shop_ob: {name:'默认',password:'moren',repeatpass:'moren'}
};
var vue = new Vue({
    el: '#register',
    data: shop_objectsVue,
    mounted:function(){},
    methods: {
        register_submit: function () {
            var url = "/register_check";
            var StringData = JSON.stringify(this.shop_ob); //转换为JSON字符串
            console.log("未转换的数据:" + this.shop_ob);
            console.log("转换后的数据:" + StringData);
            axios.post( url,this.shop_ob,
                {headers:{'Content-Type':'application/json;charset=UTF-8'}} )
                .then(function(response){
                var jsonData = JSON.stringify(response);
                console.log("转换的返回数据是jsonData：" + jsonData);
                location.href = "login";
            });
        }
    }
});