var App = function () {

    //icheck复选框
    var _masterCheckbox;
    var _checkbox;

    //批量删除的ID数组
    var _idArray;

    /**
     * @Description 私有方法，激活ICheck
     */
    var handlerInitCheckbox = function () {
        //激活checkbox
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        })
    };

    //获取控制端的checkbox
    _masterCheckbox = $('input[type="checkbox"].minimal.iCheck_master');
    //获取所有的checkbox
    _checkbox = $('input[type="checkbox"].minimal');


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
            del();
        });


        /**
         * @Description 当前私有函数的私有函数
         */
        function del() {
            $("#modal-default").modal("hide");
            //如果没有选中数据，点击确定就关闭模态框
            if (_idArray.length === 0) {
                //...
            }
            //否则就删除数据
            else {
                setTimeout(function () {
                    $.ajax({
                        "url": url,
                        "type": "POST",
                        "data": {"ids": _idArray.toString()},
                        "dataType": "JSON",
                        "success": function (data) {

                            $("#modalBtnOK").unbind("click");
                            $("#modalMsg").html(data.message);
                            $("#modal-default").modal("show");

                            if (data.status === 200) {
                                $("#modalBtnOK").bind("click", function () {
                                    window.location.reload();
                                });
                            }

                            else {
                                $("#modalBtnOK").bind("click", function () {
                                    $("#modal-default").modal("hide");
                                });
                            }
                        }
                    });
                }, 500);

            }
        }
    };

    return {
        init: function () {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },

        getCheckbox:function () {
            return _checkbox;
        },

        deleteMulti: function (url) {
            handlerDeleteMulti(url);
        }
    }

}();

$(document).ready(function () {
    App.init();
});