delete from `p_module` where name='采购中心';
INSERT INTO `p_module`(id,name,flag,url,sort_no,create_person,create_date,update_person,update_date) 
VALUES
(4,'采购中心','pu','http://127.0.0.1:10007/purchase-server',40,'system',NOW(),'system',NOW())
;


delete from `p_resource` where module_flag='pu';
INSERT INTO `p_resource`(id,name,url,remark,parent_id,structure,sort_no,module_flag,create_person,create_date,update_person,update_date) 
VALUES
(100,'基础管理','','',0,'s-1',1,'pu','system',NOW(),'system',NOW()),
(101,'采购管理','','',0,'s-2',2,'pu','system',NOW(),'system',NOW()),
(102,'返厂管理','','',0,'s-3',3,'pu','system',NOW(),'system',NOW()),

(111,'供应商管理','/controller/supplier/list.do','',100,'s-1-1',1,'pu','system',NOW(),'system',NOW()),
(121,'合同管理','/controller/contract/list.do','',101,'s-2-1',1,'pu','system',NOW(),'system',NOW()),
(122,'采购单管理','/controller/purchase/list.do','',101,'s-2-2',2,'pu','system',NOW(),'system',NOW()),
(123,'发货单管理','/controller/deliver/list.do','',101,'s-2-3',3,'pu','system',NOW(),'system',NOW()),
(131,'返厂单管理','/controller/backtrack/list.do','',102,'s-3-1',1,'pu','system',NOW(),'system',NOW())
;