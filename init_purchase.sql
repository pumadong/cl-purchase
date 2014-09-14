#数据初始化-采购字典表
insert into `p_dictionary`(`group`,`code`,`name`,sort_no,create_person,create_date)
values
('supplier_type','1','经销',1,'system',now()),
('supplier_type','2','代销',2,'system',now()),
('supplier_type','3','联营',3,'system',now()),
('supplier_type','4','包销',4,'system',now()),
('supplier_type','5','对方发货',5,'system',now()),

('settle_type','1','月结',1,'system',now()),

('contract_type','1','经销',1,'system',now()),
('contract_type','2','代销',2,'system',now()),
('contract_type','3','联营',3,'system',now()),
('contract_type','4','包销',4,'system',now()),
('contract_type','5','对方发货',5,'system',now()),

('purchase_type','1','经销',1,'system',now()),
('purchase_type','2','代销',2,'system',now()),
('purchase_type','3','联营',3,'system',now()),
('purchase_type','4','包销',4,'system',now()),
('purchase_type','5','对方发货',5,'system',now()),

('purchase_form_status','-1','已作废',1,'system',now()),
('purchase_form_status','0','待确认',2,'system',now()),
('purchase_form_status','1','已确认',3,'system',now()),
('purchase_form_status','2','已完成',4,'system',now()),

('purchase_detail_status','0','待确认',1,'system',now()),
('purchase_detail_status','1','已确认',2,'system',now()),

('deliver_form_status','-1','已作废',1,'system',now()),
('deliver_form_status','0','待确认',2,'system',now()),
('deliver_form_status','1','已确认',3,'system',now()),
('deliver_form_status','2','已完成',4,'system',now()),

('backtrack_form_status','-1','已作废',1,'system',now()),
('backtrack_form_status','0','待确认',2,'system',now()),
('backtrack_form_status','1','已确认',3,'system',now()),
('backtrack_form_status','2','已完成',4,'system',now())
;

