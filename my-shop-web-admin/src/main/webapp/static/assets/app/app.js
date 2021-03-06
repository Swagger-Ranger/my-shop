var App = function () {

    //icheck复选框
    var _masterCheckbox;
    var _checkbox;

    //批量删除的ID数组
    var _idArray;

    //默认的dropzone参数
    var defaultDropzoneOpts = {
        url: "",
        dictDefaultMessage: '拖动文件至此或者点击上传', // 设置默认的提示语句
        paramName: "dropFile", // 传到后台的参数名称,这个名称要和上传控制器类里的上传方法参数一致
        maxFiles: 1,// 一次性上传的文件数量上限
        maxFilesize: 2, // 文件大小，单位：MB
        acceptedFiles: ".jpg,.gif,.png,.jpeg", // 上传的类型
        addRemoveLinks: true,
        parallelUploads: 1,// 一次上传的文件数量
        dictMaxFilesExceeded: "您最多只能上传" + this.maxFiles + "个文件！",
        dictResponseError: '文件上传失败!',
        dictInvalidFileType: "文件类型只能是*.jpg,*.gif,*.png,*.jpeg。",
        dictFallbackMessage: "浏览器不受支持",
        dictFileTooBig: "文件过大上传文件最大支持.",
        dictRemoveLinks: "删除",
        dictCancelUpload: "取消",
    };

    /**
     * @Description 私有方法，激活ICheck
     */
    var handlerInitCheckbox = function () {
        //激活checkbox
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        })

        //获取控制端的checkbox
        _masterCheckbox = $('input[type="checkbox"].minimal.iCheck_master');
        //获取所有的checkbox
        _checkbox = $('input[type="checkbox"].minimal');
    };

    /**
     * @Description checkbox全选功能
     */
    var handlerCheckboxAll = function () {

        _masterCheckbox.on("ifClicked", function (e) {
            // console.log(e.target.checked)
            // 注意这里的选中状态,false为选中，true为未选中
            if (e.target.checked) {
                _checkbox.iCheck("uncheck");
            }
            //选中
            else {
                _checkbox.iCheck("check");
            }
        });
    };

    /**
     * @Description 单个删除
     */
    var handlerDeleteSingle = function (url,id,msg) {
        //JS可选参数,让代码更加简洁
        if(!msg) msg = null;

        console.log(id);

        _idArray = new Array();
        _idArray.push(id);
        console.log(_idArray.toString());

        $("#modalMsg").html(msg == null ? "确认删除?" : msg);
        $("#modal-default").modal("show");

        //绑定删除事件
        $("#modalBtnOK").bind("click", function () {
            handlerDeleteData(url);
        });

    };



    /**
     * @Description 批量删除
     */
    var handlerDeleteMulti = function (url) {
        _idArray = new Array();

        //将ID取到放入数组
        // var _checkbox = this.getCheckbox();
        _checkbox.each(function () {
            var _id = $(this).attr("id");
            if (_id != null && _id != "undefine" && $(this).is(":checked")) {
                _idArray.push(_id);
            }
        });

        if (_idArray.length === 0) {
            $("#modalMsg").html("您还未选择任何数据项，请选择一项！");
        }

        else {
            $("#modalMsg").html("您确定删除选中数据项吗？");
        }
        $("#modal-default").modal("show");

        $("#modalBtnOK").bind("click",function () {
            handlerDeleteData(url);
        });

    };

    /**
     * @Description AJAX异步删除
     * @Param       url
     */
    var handlerDeleteData = function (url) {
        $("#modal-default").modal("hide");
        //如果没有选中数据，点击确定就关闭模态框
        if (_idArray.length > 0) {
            setTimeout(function () {
                $.ajax({
                    "url": url,
                    "type": "POST",
                    "data": {"ids": _idArray.toString()},
                    "dataType": "JSON",
                    "success": function (data) {

                        //请求成功后，都有弹出模态框，所以先解绑
                        $("#modalBtnOK").unbind("click");
                        $("#modalMsg").html(data.message);
                        $("#modal-default").modal("show");
                        //请求成功刷新页面
                        if (data.status === 200) {
                            $("#modalBtnOK").bind("click", function () {
                                window.location.reload();
                            });
                        }

                        //请求失败，隐藏模态框
                        else {
                            $("#modalBtnOK").bind("click", function () {
                                $("#modal-default").modal("hide");
                            });
                        }
                    }
                });
            }, 500);

        }

    };


    /**
     * @Description 初始化DataTables
     * @Param
     * @return
     * @exception
     */
    var handlerInitDataTables = function (url,columns) {

        //dataTable的初始化，以及配置参数
        var _dataTable = $("#dataTable").DataTable({
            "paging": true,
            "info": true,
            "lengthChange": true,//一页显示多少数据
            "ordering": false,
            "processing": true,
            "searching": false,
            "serverSide": true,//将分页设置在服务器端进行
            //服务器请求数据的地址
            "ajax": {
                "url": url,
                "data": {
                    // "username": "swar"
                }
            },
            "columns": columns,
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "drawCallback": function (settings) {
                handlerInitCheckbox();
                handlerCheckboxAll();
            }

        });

        return _dataTable;
    };

    /**
     * @Description 查看详情,通过ajax请求，将内容加载进模态框
     * @Param       url
     */
    var handlerShowDetail = function (url) {
        $.ajax({
            url: url,
            type: "get",
            dataType: "html",
            success: function (data) {
                $("#modal-detail-body").html(data);
                $("#modal-detail").modal("show");
            }
        });
    };

    //url:请求地址，返回json；autoParam:ZTree插件自动会加载下个节点，加载时的参数，callback回调函数
    var handlerInitZTree = function (url,autoParam,callback) {
        var setting = {
            view: {
                selectedMulti: false
            },
            async: {
                enable: true,
                url: url,
                autoParam:autoParam
            }
        };

        $.fn.zTree.init($("#myTree"), setting);

        $("#modalBtnOK").bind("click",function () {
            var zTree = $.fn.zTree.getZTreeObj("myTree");
            var nodes = zTree.getSelectedNodes();

            //添加内容，模态框已选择类别
            if (nodes.length == 0) {
                alert("请选择一个节点");
            }
            //已选择
            else {
                callback(nodes);
            }

        });

    };

    /**
     * @Description 初始化dropzone,这里使用方法二，不用dropzone的自动功能，手动操作dropzone
     * @Param
     * @return      
     * @exception
     *
     方法一，直接自动发现，但相对而言自定义比较差
     Dropzone.options.dropz = {
            url: "/upload",
            dictDefaultMessage: '拖动文件至此或者点击上传', // 设置默认的提示语句
            paramName: "dropzoneFile", // 传到后台的参数名称,这个名称要和上传控制器类里的上传方法参数一致
            init: function () {
                this.on("success", function (file, data) {
                    // 上传成功触发的事件
                    // console.log(file);
                    // console.log(data);
                    $("#pic").val(data.fileName);
                });
            }
        };

     //dropzone的方法二,但需要关闭dropzone的自动发现功能即：Dropzone.autoDiscover = false;
     */
    var handlerInitDropzone = function (opts) {
        Dropzone.autoDiscover = false;//关闭dropzone的自动发现功能

        //合并两个参数并返回前一个参数defaultDropzoneOpts
        $.extend(defaultDropzoneOpts, opts);

        new Dropzone(defaultDropzoneOpts.id, defaultDropzoneOpts);

    };

    return {
        /**
         * @Description 初始化
         */
        init: function () {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },

        /**
         * @Description 批量删除
         */
        deleteMulti: function (url) {
            handlerDeleteMulti(url);
        },

        /**
         * @Description 单个删除
         */
        deleteSingle: function (url,id,msg) {
            handlerDeleteSingle(url,id,msg);
        },

        initDataTables: function (url,columns) {
            return handlerInitDataTables(url, columns);
        },

        /**
         * @Description 显示详情,
         */
        showDetail: function (url) {
            handlerShowDetail(url);
        },

        /**
         * @Description 初始化ZTree
         * @Param
         * @return
         * @exception
         */
        initZTree: function (url, autoParam, callback) {
            handlerInitZTree(url, autoParam, callback);
        },

        /**
         * @Description 初始化dropzone
         * @Param
         * @return
         * @exception
         */
        initDropzone: function (opts) {
            handlerInitDropzone(opts);

        }
    }

}();

$(document).ready(function () {
    App.init();
});