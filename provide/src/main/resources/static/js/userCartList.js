var cartVue = { //JSON数据定义
    carts: [], //JSON空数组数据定义
    cart: { cartid:0,username:'',name:'',num:0,pay:0,allpay:0 },
    pagination:{}
};
var vue = new Vue({ //ViewModel
    el: '#cartList',
    data: cartVue,
    mounted:function(){ //mounted　表示这个 Vue 对象加载成功了
        this.list(1);
    },
    methods: {
        list:function(start){
            var url = "userCart?start=" + start;
            axios.get(url).then(function(response) {
                vue.pagination = response.data;
                vue.carts = response.data.list;
                console.log("carts_response:" + JSON.stringify(vue.carts));
            })
        },
        addOrder:function (cart) {
            var url = "addOrder";
            axios.post( url,cart,
                {headers:{'Content-Type':'application/json;charset=UTF-8'}} )
                .then(function(response){
                    var url = "userCart/"+cart.cartid;
                    axios.delete(url).then(function(response){
                        console.log("delete_response:" + JSON.stringify(response));
                    });
                    location.href = "userOrderList";
                    console.log("update_response:" + response);
            });
        },
        deleteCart:function (cartid) {
            var url = "userCart/"+cartid;
            axios.delete(url).then(function(response){
                vue.list(1);
                console.log("delete_response:" + JSON.stringify(response));
            });
        },
        updateAllPay: function(cart){
            cart.allpay = cart.num * cart.pay;
            console.log("allpay改变为:" + cart.allpay);
        },
        jump:function(page){
            if('首页' == page && 1 != vue.pagination.pageNum)
                vue.list(1);
            else if('上一页' == page && vue.pagination.hasPreviousPage )
                vue.list(vue.pagination.prePage);
            else if('下一页' == page && vue.pagination.hasNextPage)
                vue.list(vue.pagination.nextPage);
            else if('末页' == page && vue.pagination.pageNum != vue.pagination.pages)
                vue.list(vue.pagination.pages);
        },
        jumpByNumber:function(start){
            if(start != vue.pagination.pageNum)
                vue.list(start);
        }
    }
});