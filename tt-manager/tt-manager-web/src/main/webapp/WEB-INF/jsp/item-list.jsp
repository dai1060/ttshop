<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="toolbar">
    <div style="padding: 5px; background-color: #fff;">
        <label>商品标题：</label>
        <input class="easyui-textbox" type="text" id="title">
        <label>商品状态：</label>
        <select id="status" class="easyui-combobox" >
            <option value="0">全部</option>
            <option value="1">正常</option>
            <option value="2">下架</option>
        </select>
        <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">搜索</button>
    </div>
    <div>
        <button onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
        <button onclick="down()" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true">下架</button>
        <button onclick="up()" class="easyui-linkbutton" data-options="iconCls:'icon-up',plain:true">上架</button>
    </div>
</div>
<table id="dg"></table>

<script>
    function searchForm(){
        $('#dg').datagrid('load',{
            title:$('#title').val(),
            status:$('#status').combobox('getValue')
        })
    }
    function  edit() {
        console.log('edit');
    }
    function  add() {
        ttshop.addTabs('新增商品','item-add');
    }
    function  remove() {
        //获取选中的行
        var selectRows = $('#dg').datagrid('getSelections');
        //没有选中任何行
        if(selectRows.length == 0){
            $.messager.alert('提示','未选中记录','warning');
            return;
        }
        //选中至少一行记录
        $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
            if (r){
                //点击了消息窗口上的确认按钮
                //将选中记录的编号写进一个数组中
                var ids = [];
                for(var i=0;i<selectRows.length;i++){
                    ids.push(selectRows[i].id);
                }
                //ajax提交数组给后台
                $.post(
                    //url:提交给后台的哪个动作去处理，只有第一个参数是必选的，其余的都是可选项
                    'items/batch',
                    //data:提交哪些数据给后台进行处理
                    {'ids[]':ids},
                    //function:处理后成功回调的函数
                    function(data){
                        $('#dg').datagrid('reload');
                    },
                    //datatype:返回的数据类型
                    'json'
                );
            }
        });
    }
    function  down() {
        var selectRows = $('#dg').datagrid('getSelections');
        if(selectRows.length == 0){
            $.messager.alert('提示','未选中记录','warning');
            return;
        }
        $.messager.confirm('确认','您确认想要下架吗？',function(r){
            if (r){
                var ids = [];
                for(var i=0;i<selectRows.length;i++){
                    ids.push(selectRows[i].id);
                }
                $.post(
                    'items/batchDown',
                    {'ids[]':ids},
                    function(data){
                        $('#dg').datagrid('reload');
                    },
                    //datatype:返回的数据类型
                    'json'
                );
            }
        });
    }
    function  up() {
        var selectRows = $('#dg').datagrid('getSelections');
        if(selectRows.length == 0){
            $.messager.alert('提示','未选中记录','warning');
            return;
        }
        $.messager.confirm('确认','您确认想要上架吗？',function(r){
            if (r){
                var ids = [];
                for(var i=0;i<selectRows.length;i++){
                    ids.push(selectRows[i].id);
                }
                $.post(
                    'items/batchUp',
                    {'ids[]':ids},
                    function(data){
                        $('#dg').datagrid('reload');
                    },
                    'json'
                );
            }
        });
    }

    $('#dg').datagrid({
        multiSort:true,
        pageSize:20,
        pageList:[20,40,50],
        toolbar:'#toolbar',
        fit:true,
        pagination:true,
        url:'items',
        columns:[[
            {field:'ck',checkbox:true},
            {field:'id',title:'商品编号',width:100,sortable:true},
            {field:'title',title:'商品名称',width:100,sortable:true},
            {field:'sellPoint',title:'卖点',width:100},
            {field:'catName',title:'类别',width:100},
            {field:'status',title:'状态',width:100,formatter:function(value,row,index){
                /*console.group();
                console.log(value);
                console.log(row);
                console.log(index);
                console.groupEnd();*/
                switch (value){
                    case 1:
                        return '正常';
                        break;
                    case 2:
                        return '下架';
                        break;
                    case 3:
                        return '删除';
                        break;
                    default:
                        return '未知';
                        break;
                }
            }},
            {field:'created',title:'创建时间',formatter:function(value,row,index){
                return moment(value).format('MMM Do YYYY');
            }},
            {field:'priceView',title:'价格',width:100}
        ]]
    });
    /*
    var toolbar = [{
        iconCls: 'icon-add',
        text: '新增',
        handler: function () {
            console.log('add');
        }
    },{
        iconCls: 'icon-remove',
        text: '删除',
        handler: function () {
            //获取选中的行
            var selectRows = $('#dg').datagrid('getSelections');
            //没有选中任何行
            if(selectRows.length == 0){
                $.messager.alert('提示','未选中记录','warning');
                return;
            }
            //选中至少一行记录
            $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
                if (r){
                    //点击了消息窗口上的确认按钮
                    //将选中记录的编号写进一个数组中
                    var ids = [];
                    for(var i=0;i<selectRows.length;i++){
                        ids.push(selectRows[i].id);
                    }
                    //ajax提交数组给后台
                    $.post(
                        //url:提交给后台的哪个动作去处理，只有第一个参数是必选的，其余的都是可选项
                        'items/batch',
                        //data:提交哪些数据给后台进行处理
                        {'ids[]':ids},
                        //function:处理后成功回调的函数
                        function(data){
                            $('#dg').datagrid('reload');
                        },
                        //datatype:返回的数据类型
                        'json'
                    );

                }
            });
        }
    },{
        iconCls: 'icon-edit',
        text: '编辑',
        handler: function () {
            console.log('edit');
        }
    },{
        iconCls: 'icon-up',
        text: '上架',
        handler: function () {
            //获取选中的行
            var selectRows = $('#dg').datagrid('getSelections');
            //没有选中任何行
            if(selectRows.length == 0){
                $.messager.alert('提示','未选中记录','warning');
                return;
            }
            //选中至少一行记录
            $.messager.confirm('确认','您确认想要上架吗？',function(r){
                if (r){
                    //点击了消息窗口上的确认按钮
                    //将选中记录的编号写进一个数组中
                    var ids = [];
                    for(var i=0;i<selectRows.length;i++){
                        ids.push(selectRows[i].id);
                    }
                    //ajax提交数组给后台
                    $.post(
                        //url:提交给后台的哪个动作去处理，只有第一个参数是必选的，其余的都是可选项
                        'items/batchUp',
                        //data:提交哪些数据给后台进行处理
                        {'ids[]':ids},
                        //function:处理后成功回调的函数
                        function(data){
                            $('#dg').datagrid('reload');
                        },
                        //datatype:返回的数据类型
                        'json'
                    );
                }
            });
        }
    },{
        iconCls: 'icon-down',
        text: '下架',
        handler: function () {
            //获取选中的行
            var selectRows = $('#dg').datagrid('getSelections');
            //没有选中任何行
            if(selectRows.length == 0){
                $.messager.alert('提示','未选中记录','warning');
                return;
            }
            //选中至少一行记录
            $.messager.confirm('确认','您确认想要下架吗？',function(r){
                if (r){
                    //点击了消息窗口上的确认按钮
                    //将选中记录的编号写进一个数组中
                    var ids = [];
                    for(var i=0;i<selectRows.length;i++){
                        ids.push(selectRows[i].id);
                    }
                    //ajax提交数组给后台
                    $.post(
                        //url:提交给后台的哪个动作去处理，只有第一个参数是必选的，其余的都是可选项
                        'items/batchDown',
                        //data:提交哪些数据给后台进行处理
                        {'ids[]':ids},
                        //function:处理后成功回调的函数
                        function(data){
                            $('#dg').datagrid('reload');
                        },
                        //datatype:返回的数据类型
                        'json'
                    );
                }
            });
        }
    }];*/


</script>