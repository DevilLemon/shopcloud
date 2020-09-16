var ordersVue = { //JSON数据定义
    orders: [], //JSON空数组数据定义
    pagination:{}
};
var vue = new Vue({ //ViewModel
    el: '#adminOrderList',
    data: ordersVue,
    mounted:function(){ //mounted　表示这个 Vue 对象加载成功了
        this.list(1);
    },
    methods: {
        list:function(start){
            var url = "adminOrder?start=" + start;
            axios.get(url).then(function(response) {
                vue.pagination = response.data;
                vue.orders = response.data.list;
                console.log("vue.orders" + JSON.stringify(vue.orders));
            });
        },
        deleteGood:function (goodid) {
            var url = "adminGood/"+goodid;
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
        }
    }
});