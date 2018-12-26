
/**
 * @Description 函数对象--函数后面加了()
 * @Param
 * @return
 * @exception
 */
var  Validate=function () {

    /**
     * @Description 初始化jquery validation
     * @Param
     * @return
     * @exception
     */
    var handlerInitValidate=function () {
        // console.log("初始化jquery validation ")//控制台打印

        $("#inputForm").validate({
            errorElement: 'span',
            errorClass: 'help-block',

            errorPlacement: function (error, element) {
                element.parent().parent().attr("class", "form-group has-error");
                error.insertAfter(element);
            }
        });

        $.validator.addMethod("mobile", function(value, element) {
            var length = value.length;
            var mobile =  /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
            return this.optional(element) || (length == 11 && mobile.test(value));
        }, "手机号码格式错误");
    }


        /**
         * return里是公共方法，其它位置为私有方法
         * init:**就是在将私有的方法暴露出来，给外界使用
         */
    return{
        init:function () {
            handlerInitValidate();
        }
    }

}();

/**
 * @Description 这里就是在页面加载完成之后，自动加载内容
 */
$(document).ready(function () {
    Validate.init();
});