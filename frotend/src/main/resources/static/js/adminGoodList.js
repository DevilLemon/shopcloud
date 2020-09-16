var goodsVue = { //JSON数据定义
    goods: [], //JSON空数组数据定义
    goodAdd: { name:'默认', num:9, pay:99, status:'可显' }, //JSON单对象数据定义
    pagination:{},
    nameSelect:[ {name:"CPU"}, //JSON数组数据定义
                 {name:"2080TI泰坦显卡"},
                 {name:"清华同方屏幕"},
                 {name:"西数硬盘"} ],
    numSelect:[ {num:6},
                {num:60},
                {num:600} ],
    paySelect:[ {pay:8},
                {pay:80},
                {pay:800} ],
    statusSelect:[ {status:"可显"},
                   {status:"不可显"} ]
};
var vue = new Vue({ //ViewModel
    el: '#adminGoodList',
    data: goodsVue,
    mounted:function(){ //mounted　表示这个 Vue 对象加载成功了
        this.list(1);
    },
    methods: {
        list:function(start){
            var url = "adminGood?start=" + start;
            axios.get(url).then(function(response) {
                console.log("list_response:" + JSON.stringify(response));
                vue.pagination = response.data;
                vue.goods = response.data.list;
            })
        },
        add:function (event) {
            var url = "adminGood";
            axios.post( url,this.goodAdd,
                {headers:{'Content-Type':'application/json;charset=UTF-8'}} )
                .then(function(response){
                    console.log("add_response:" + JSON.stringify(response));
                    vue.list(1);
                    vue.goodAdd = { name:'默认', num:'1', pay:'1', status:'可显' }
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
                    console.log("无效,请检查");
            }
        }
    }
});