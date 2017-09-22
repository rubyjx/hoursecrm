//创建异步对象createXMLHttpRequest
function createXMLHttpRequest(){
	//alert("1111");
	try{
     return new XMLHttpRequest();    //支持大部分浏览器
	}catch( e){
		try{
		  return new ActiveXObject("Msxm12.XMLHTTP");  //支持ie6.0
		}catch( e){
			try{
			return new ActiveXObject("Microsoft.XMLHTTP");	//支持ie5.5
				
			}catch(e){
				alert("你的浏览器不支持!");
				throw e;
			}
		}
		
	}
	
}
/*
 *      method,
		url,
		asyn,
		params,
		回掉方法
		服务器返回数据转换成什么类型 
		 */
 
function ajax(option){
	//alert("1111");
	var xmlHttp=createXMLHttpRequest();  //得到xmlhttp

	if(!option.method){//如果method不存，设置成get请求
		option.method="GET";
	}
	if(option.asyn==undefined){
		option.asyn=true;
	}
	//alert(11111111);
	//alert("方法："+option.method+"url:"+option.url+"asyn:"+option.asyn)
	xmlHttp.open(option.method,option.url,option.asyn);//打开链接
	/*问题所在*/
	
	if("POST"==option.method){  //判断是不是post请求，是设置请求头
 		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	}
	
	xmlHttp.send(option.params);//发送请求
	
	xmlHttp.onreadystatechange=function(){
		
		if(xmlHttp.readyState==4&&xmlHttp.status==200){
			//相应成功
			/*1.获取响应数据 
			 */
			
		    var data;
	     	if(!option.type){
	     		data=xmlHttp.responseText;
	     	}else if(option.type=="xml"){   //判断是不是xml
				data=xmlHttp.responseXML;
			}else if(option.type=="text"){   //判断是不是文本
				data=xmlHttp.responseText;
				
			}else if(option.type=="json"){  //判断格式是不是json。 
				var text=xmlHttp.responseText;
				data=eval("("+text+")");
			}
	     	//alert(data);
			option.callback(data);
		}
	}
	
	
}