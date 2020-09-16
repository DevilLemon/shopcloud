var orderVue = { //JSON数据定义
    orders: [], //JSON空数组数据定义
    pagination:{}
};
var vue = new Vue({ //ViewModel
    el: '#orderList',
    data: orderVue,
    mounted:function(){ //mounted　表示这个 Vue 对象加载成功了
        this.list(1);
    },
    methods: {
        list:function(start){
            var url = "userOrder?start=" + start;
            axios.get(url).then(function(response) {
                console.log("list_response:" + JSON.stringify(response));
                console.log("list_response:" + JSON.stringify(response.data.list));
                vue.pagination = response.data;
                vue.orders = response.data.list;
            })
        },
        add:function (event) {
            var url = "userOrder";
            axios.post( url,this.goodAdd,
                {headers:{'Content-Type':'application/json;charset=UTF-8'}} )
                .then(function(response){
                    console.log("add_response:" + JSON.stringify(response));
                    vue.list(1);
                    vue.goodAdd = { name:'默认', num:'1', pay:'1', status:'可显' }
            });
        },
        deleteOrder:function (orderid) {
            var url = "userOrder/"+orderid;
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