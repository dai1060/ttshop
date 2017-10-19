<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="dg"></table>

<script>
    $('#dg').datagrid({
        fit:true,
        pagination:true,
        url:'items',
        columns:[[
            {field:'id',title:'商品编号',width:100},
            {field:'title',title:'商品名称',width:100},
            {field:'sellPoint',title:'卖点',width:100}
        ]]
    });

</script>