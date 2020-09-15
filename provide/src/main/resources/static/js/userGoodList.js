var goodsVue = { //JSON数据定义
    goods: [], //JSON空数组数据定义
    cart:{ img:'',username:'',name:'',num:0,pay:0,allpay:0 },
    pagination:{}
};
var vue = new Vue({ //ViewModel
    el: '#goodList',
    data: goodsVue,
    mounted:function(){ //mounted　表示这个 Vue 对象加载成功了
        this.list(1);
    },
    methods: {
        list:function(start){
            var url = "userGood?start=" + start;
            axios.get(url).then(function(response) {
                console.log("list_response:" + JSON.stringify(response));
                vue.pagination = response.data;
                vue.goods = response.data.list;
            })
        },
        addCart:function (good) {
            var url = "addCart";
            vue.cart.name = good.name;
            vue.cart.pay = good.pay;
            vue.cart.num = 1;
            vue.cart.allpay = vue.cart.num * vue.cart.pay;
            console.log("cart:" + vue.cart);
            axios.post( url,vue.cart,
                {headers:{'Content-Type':'application/json;charset=UTF-8'}} )
                .then(function(response){
                    location.href = "userCartList";
                    console.log("addCart_response:" + JSON.stringify(response));
            });
        },
        deleteGood:function (goodid) {
            var url = "userGood/"+goodid;
            axios.delete(url).then(function(response){
                console.log("delete_response:" + JSON.stringify(response));
                vue.list(1);
            });
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
        },
        changeSelect:function(id){
            switch (id)
            {
                case 1:
                    vue.goodAdd.name = $('#nameSelect option:selected').text();
                    break;
                case 2:
                    vue.goodAdd.num = $('#numSelect option:selected').text();
                    break;
                case 3:
                    vue.goodAdd.pay = $('#paySelect option:selected').text();
                    break;
                case 4:
                    vue.goodAdd.status = $('#statusSelect option:selected').text();
                    break;
                default:
                    alert("无效,请检查");
            }
        },
    }
});