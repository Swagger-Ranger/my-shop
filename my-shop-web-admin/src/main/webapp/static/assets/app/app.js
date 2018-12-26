var App = function () {

    var _masterCheckbox;
    var _checkbox;


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



    return {
        init: function () {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },

        getCheckbox:function () {
            return _checkbox;
        }
    }

}();

$(document).ready(function () {
    App.init();
});