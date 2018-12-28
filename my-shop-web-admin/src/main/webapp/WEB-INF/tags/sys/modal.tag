<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="title" type="java.lang.String" required="false" description="模态框的标题"%>
<%@ attribute name="msg" type="java.lang.String" required="false" description="模态框的消息"%>
<%@ attribute name="opts" type="java.lang.String" required="false" description="操作类型：info confirm--确认对话框" %>
<%@ attribute name="url" type="java.lang.String" required="false" description="跳转类型，删除对话框（url和opts默认一起使用）" %>

<%--批量删除的提示模态框--%>
<div class="modal fade" id="modal-default">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">${title == null ? "提示" : title}</h4>
            </div>
            <div class="modal-body">
                <p id="modalMsg">${msg}&hellip;</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">取消</button>
                <button id="modalBtnOK" type="button" class="btn btn-primary">确定</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->
