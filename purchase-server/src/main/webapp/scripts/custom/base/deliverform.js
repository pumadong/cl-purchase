var DataTableCl = function () {
    var handleCl = function() {        
    	var grid = new Datatable();
        grid.init({
            src: $("#datatable_cl"),
            onSuccess: function(grid) {
                // execute some code after table records loaded
            },
            onError: function(grid) {
                // execute some code on network or other general error  
            },
            dataTable: {  // here you can define a typical datatable settings from http://datatables.net/usage/options
            	"iDisplayLength": 20,
                "bServerSide": true, // server side processing
                "sAjaxSource": "getDeliverFormDataTables.do", // ajax source
                "bSort": false,
                "aoColumnDefs" : [{  // 隐藏第一列
                    'bVisible' : false,
                    'aTargets' : [ 0 ]
                }],
                "aaSorting": [[ 1, "asc" ]] // set first column as a default sort by asc
            }
        });
    }
    return {
        //main function to initiate the module
        init: function () {
    		handleCl();
        },
        tableName: "datatable_cl"
    };
}();


var DeliverForm = function(){
	return {
		/**
		 * 点击增加按钮
		 */
		add_click: function() {
	    	Cl.action='create';
	    	//Cl.showModalWindow(Cl.modalName,"addform.do");
	    	alert(Cl.action);
		},
		/**
		 * 点击修改按钮
		 */
		update_click: function(id) {
			Cl.action='update';	
			//Cl.showModalWindow(Cl.modalName,"updateform.do?id="+id);
			alert(Cl.action);
		}

	}
}();

/**
 * 查询参数的处理，每个功能的DataTable都要处理自己的查询条件，并向服务器提交
 * 如果使用了DataTables控件，则都要定义这个函数
 */
var aoDataHandler = function(aoData) {
	//页面的查询条件
	//aoData.push( { "no": "no", "value": "" } );
}