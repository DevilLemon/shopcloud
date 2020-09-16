var uploadVue = { //JSON数据定义
    goods: [], //JSON空数组数据定义
    goodAdd: { name:'默认', num:9, pay:99, status:'可显',img:'' }, //JSON单对象数据定义
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
    el: '#uploadList',
    data: uploadVue,
    mounted: function () { //mounted　表示这个 Vue 对象加载成功了
        this.list(1);
        console.log("组件已加载");
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
        getFile: function (event) {
            var filename = event.target.files[0].name;
            var imgURL = window.URL.createObjectURL(event.target.files[0]);
            $("#url img").attr("src", imgURL);
            console.log("准备上传的图片名：" + filename);
            console.log("未上传的图片路径：" + imgURL);
        },
        submitForm: function (event) {
            var formData = new FormData();
            formData.append("file", $("#" + "file")[0].files[0]);
            var url = "lessUpload";
            axios.post(url, formData,
                {headers: {'Content-Type': 'multipart/form-data;'}})
                .then(function (data) {
                    console.log("图片上传成功返回：" + JSON.stringify(data));
                    uploadVue.goodAdd.img = data.data.fileName;
                    console.log("返回的图片名赋值：" + JSON.stringify(uploadVue.goodAdd.img));
                    var url = "adminGood";
                    console.log("准备保存的商品：" + JSON.stringify(uploadVue.goodAdd));
                    axios.post( url,uploadVue.goodAdd,
                        {headers:{'Content-Type':'application/json;charset=UTF-8'}} )
                        .then(function(response){
                            console.log("新增商品成功返回:" + JSON.stringify(response));
                            vue.list(1);
                            uploadVue.goodAdd = { name:'默认', num:'1', pay:'1', status:'可显',img:'' }
                        });
                });
        }
    }
});