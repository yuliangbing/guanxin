/**
 * 新增页面的js
 */
var fileUrl="";
var urlFileName="";
// 关闭弹窗监听
function exit() {
	var index = parent.layer.getFrameIndex(window.name); // 先得到当前iframe层的索引
	parent.layer.close(index); // 再执行关闭
}

function ajax_h(form, url, object, ids) {
	// 获取下拉列表(公共方法)
	$.ajax({
		url : url,
		type : "POST",
		dataType : "json",
		success : function(data) {
			console.log(data);
			// layer.msg("获取成功");
			console.log(data.data.length);
			if (data.code == 0) {
				if (ids == 'id') {
					let option = "";
					for (let i = 0; i < data.data.length; i++) {
						option += "<option value='" + data.data[i].id + "'>"
								+ data.data[i].name + "</option>";
					}
					$("#" + object).append(option);
					form.render('select');
				} else {
					let option = "";
					for (let i = 0; i < data.data.length; i++) {
						option += "<option value='" + data.data[i].code + "'>"
								+ data.data[i].name + "</option>";
					}
					$("#" + object).append(option);
					form.render('select');
				}

			} else {
				layer.msg(data.msg);
			}

		},
		error : function(code) {
			layer.alert("发生错误,请联系管理员");
		}
	});
}

layui.use(['element','upload'], function() {
	var element = layui.element;

	var upload = layui.upload;
	// 选完文件后不自动上传
	upload.render({
		elem : '#uploadFile',
		url : '/ueditor/jsp/controller.jsp?action=uploadfile',
	    method: 'post',
	    accept: 'file',
		auto : true,
		done : function(res) {
			console.log(res);
			fileUrl = res.url;
			urlFileName = res.original;
			$("#showFile").text(res.original);
		}
	})
});

layui.use([ 'form', 'laydate' ], function() {
	var form = layui.form;

	// 获取下拉框属性
	var url = "";
	var object = "";
	var ids = "";
	// 文件类型
	url = '/fileCategory/getFileCategoryList';
	object = 'cate_name';
	ids = 'code';
	ajax_h(form, url, object, ids);
	// 专业
	url = '/specialty/getSpecialtyList';
	object = 'specialty_id';
	ids = 'id';
	ajax_h(form, url, object, ids);
	/*
	 * 实现文件时间选择
	 */
	var laydate = layui.laydate;

	laydate.render({
		elem : '#date' // 指定元素
	});

	// 提交功能
	form.on('submit(submit)', function(data) {
		/* 获取$值存入params */
		var params = {};
		params.status = $("#status").val();
		params.date = $("#date").val();
		params.code = $("#code").val();
		params.name = $("#name").val();
		params.cate_name = $("#cate_name option:checked").text();
		params.reviser = $("#reviser").val();
		params.specialty_id = $("#specialty_id option:checked").val();
		params.specialty_name = $("#specialty_id option:checked").text();
		params.url_file = fileUrl;
		params.url_file_name = urlFileName;
		layer.confirm('确定提交吗?', {
			icon : 3,
			title : '提示'
		}, function(index) {
			$.ajax({
				type : "POST",
				url : '/specialtyFiles/addSpecialtyFiles',
				data : $.param(params),
				// 预期服务器返回数据的类型
				dataType : "json",
				success : function(data) {
					if (data) {
						if (data.code == 0) {
							layer.msg("成功");
							setTimeout(function() {
								parent.window.location.reload();
							}, 500);
						} else if (data.code != 0) {
							layer.msg("失败,可能为数据填写错误或缺少必要数据！");
						}
					}
				},
				error : function(code) {
					layer.alert("发生错误,请联系管理员");
				}
			});

			layer.close(index);
		});

		// return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
	});

});