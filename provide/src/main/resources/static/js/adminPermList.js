var permsVue = { //JSON数据定义
    perms: [], //JSON空数组数据定义
    pagination:{}
};
var vue = new Vue({ //ViewModel
    el: '#adminPermList',
    data: permsVue,
    mounted:function(){ //mounted　表示这个 Vue 对象加载成功了
        this.list(1);
    },
    methods: {
        list:function(start){
            var url = "adminPerm?start=" + start;
            axios.get(url).then(function(response) {
                vue.pagination = response.data;
                vue.perms = response.data.list;
                console.log("vue.pagination:" + JSON.stringify(vue.pagination));
                console.log("vue.perms:" + JSON.stringify(vue.perms));
            })
        },
        add:function () {
            var url = "adminPerm";
            axios.post( url,this.goodAdd,
                {headers:{'Content-Type':'application/json;charset=UTF-8'}} )
                .then(function(response){
                    console.log("add_response:" + JSON.stringify(response));
                    vue.list(1);
                    vue.permAdd = { name:'默认', num:'1', pay:'1', status:'可显' }
            });
        },
        deleteGood:function (goodid) {
            var url = "adminPerm/"+goodid;
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