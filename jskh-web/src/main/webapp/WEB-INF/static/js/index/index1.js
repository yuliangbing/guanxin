/**
 * 专业时间轴的js
 */
	
	var url = "";
	var param = "";
	var counts = "";
	var  rows = "";
	url = '/specialty/getSpecialtyList';
	ajax_hx(url);
	
	//获取到专业设立时间
	function ajax_hx(url) {
        	$.ajax({
        		url : url,
        		type : "POST",
        		dataType : "json",
        		async:false,
        		success : function(data) {
        			sort(data);
        			//console.log(JSON.stringify(data));
        			for(var i=0;i < rows.length;i++){
        				if(param == ""){//取出所有排序好的时间
        					param  = rows[i].setupDate.split(' ')[0];
        				}else{
	       					param += ","+rows[i].setupDate.split(' ')[0];
        				}
        				ajax_profile(rows[i].id,rows[i].setupDate.split(' ')[0],rows[i].name);//去拿该专业里的各种数据
        				//console.log(rows[i]);
        			}
        			
        			//console.log(param);
        		},
        		error : function(code) {
        			layer.alert("发生错误,请联系管理员");
        		}
        	});
        }
	
	//时间升序
	function sort(data){
		  	rows = data.data;  //
		    rows.sort(function(a,b){
		        return Date.parse(a.setupDate.split(' ')[0]) - Date.parse(b.setupDate.split(' ')[0]);//时间倒叙 如果是从小到大交换啊a ,b位置即可
		    });
		   /* for(var i =0,l=rows.length;i<l;i++){
		        console.log(" | " + rows[i].setupDate.split(' ')[0]); //输出
		    }
		    console.log("rows:"+JSON.stringify(rows));//输出
		*/
		}
	
	
	
		function ajax_profile(ids,date,name) {
    	// 获取下拉列表(公共方法)
    	$.ajax({
    		url :'specialtyProfile/ByIdSpecialtyProfile',
    		type : "POST",
    		dataType : "json",
    		data:{specialty_id:ids},
    		async:false,
    		success : function(data) {
    				var obj2 = eval(data); //使用eval方法
    				
	    			 var h = "";
	                 
	                 h += '<i class="layui-icon layui-timeline-axis">&#xe63f;</i>'
	 				    +'<div class="layui-timeline-content layui-text ">'
				      +'<h3 class="layui-timeline-title">'+date+'</h3>'+
				      '<p>'
				      	+'<a style="color:red;">'+name+'</a>专业诞生了'+'&nbsp;<i class="layui-icon" style="font-size: 17px; color: #d2ffa7;"></i>'
				        +'<br>'+'本专业'+'<a style="color:blue;">定位</a>'+'为'+'<a style="color:red;">-----</a>'+obj2.data[0].position
				        +'<br>'+'本专业'+'<a style="color:#cee6ff;">特色</a>'+'为'+'<a style="color:yellow;">-----------</a>'+obj2.data[0].characteristic +
				      '</p>'+
				    '</div>'+'<hr class="layui-bg-orange">';
	                
	                 $("#Timeline").append(h);
	    			
    		},
    		error : function(code) {
    			layer.alert("发生错误,请联系管理员");
    		}
    	});
		}
	
	