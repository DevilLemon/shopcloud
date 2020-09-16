$.support.cors = true;
function showLoading(){ //展示loading
	var idx = layer.msg('处理中...', {icon: 16,shade: [0.5, '#f5f5f5'],scrollbar: false,offset: '0px', time:100000}) ;  
	return idx;
}
var passsword_salt="1a2b3c4"; //salt加密信息
function getQueryString(name){ //获取地址栏参数
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null) return unescape(r[2]);
    return null;
}
function getUuid(userId){ //根据时间自动生成userid
    var date = new Date();
    var uuid = ""+userId+date.getDay()+ date.getHours()+ date.getMinutes()+date.getSeconds()+date.getMilliseconds();
    return uuid;
}
