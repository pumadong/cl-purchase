#BEGIN*************************表单列表***************************BEGIN
#. p_supplier ：供应商表
#. p_contract ：合同表
#. p_supplier_brand ：供应商品牌限定表，即供应商下有哪些品牌
#. p_supplier_category ：供应商分类限定表，即供应商下有哪些分类
#. p_purchase_form ：采购单
#. p_purchase_detail ：采购单明细
#. p_deliver_form ：发货单
#. p_deliver_detail ：发货单明细
#. p_backtrack_form ：返厂单
#. p_backtrack_detail ：返厂单明细
#. p_dictionary ：字典表，状态类型等字典数据都要存储于此，方便使用
#. 以上表单，信息并不完整，尤其是一些财务相关的选项，在实际生产中需要添加，比如：税率，结算比例等
#END***************************表单列表***************************END

#供应商表
DROP TABLE IF EXISTS `p_supplier`;
CREATE TABLE `p_supplier` (
`id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键' ,
`name`  varchar(50) NOT NULL DEFAULT '' COMMENT '名称' ,
`province`  varchar(30) NOT NULL DEFAULT '' COMMENT '省份' ,
`city`  varchar(30) NOT NULL DEFAULT '' COMMENT '城市' ,
`address`  varchar(200) NOT NULL DEFAULT '' COMMENT '地址' ,
`postcode`  varchar(6) NOT NULL DEFAULT '' COMMENT '邮编' ,
`contact`  varchar(50) NOT NULL DEFAULT '' COMMENT '联系人' ,
`telephone`  varchar(50) NOT NULL DEFAULT '' COMMENT '电话' ,
`fax`  varchar(30) NOT NULL DEFAULT '' COMMENT '传真' ,
`email`  varchar(50) NOT NULL DEFAULT '' COMMENT 'Email' ,
`website`  varchar(200) NOT NULL DEFAULT '' COMMENT '网址' ,
`bi_no`  varchar(50) NOT NULL DEFAULT '' COMMENT '营业执照编号' ,
`bi_address`  varchar(200) NOT NULL DEFAULT '' COMMENT '营业执照地址' ,
`bi_period`  varchar(50) NOT NULL DEFAULT '' COMMENT '营业执照有效期' ,
`tax_no`  varchar(50) NOT NULL DEFAULT '' COMMENT '税务登记证号' ,
`tax_payid`  varchar(50) NOT NULL DEFAULT '' COMMENT '纳税人识别号' ,
`tax_rate`  decimal(20,3) NOT NULL DEFAULT 0 COMMENT '税率' ,
`bank_name`  varchar(50) NOT NULL DEFAULT '' COMMENT '开户行名称' ,
`bank_no`  varchar(50) NOT NULL DEFAULT '' COMMENT '开户行账号' ,
`bank_address`  varchar(50) NOT NULL DEFAULT '' COMMENT '开户行所在地' ,
`supplier_type`  tinyint(4) NOT NULL DEFAULT 0 COMMENT '合作方式：经销、代销、联营、包销、对方发货' ,
`settle_type`  tinyint(4) NOT NULL DEFAULT 0 COMMENT '结算类型：' ,
`is_delete`  tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除：1是0否' ,
`create_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '记录生成人' ,
`create_date`  datetime NOT NULL COMMENT '记录生成时间' ,
`update_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '更新人' ,
`update_date`  datetime NOT NULL COMMENT '更新时间' ,
PRIMARY KEY (`id`)
)
COMMENT='供应商表'
;

#合同表
DROP TABLE IF EXISTS `p_contract`;
CREATE TABLE `p_contract` (
`no`  varchar(50) NOT NULL COMMENT '合同编号' ,
`supplier_id`  int(11) UNSIGNED NOT NULL COMMENT '供应商ID' ,
`contract_type`  tinyint(4) NOT NULL DEFAULT 0 COMMENT '合同类型：经销、代销、联营、包销、对方发货' ,
`validate_date_begin`  datetime NOT NULL COMMENT '生效开始日期' ,
`validate_date_end`  datetime NOT NULL COMMENT '生效结束日期' ,
`status`  tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态：-1已作废0待审核1已审核' ,
`create_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '记录生成人' ,
`create_date`  datetime NOT NULL COMMENT '记录生成时间' ,
`update_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '更新人' ,
`update_date`  datetime NOT NULL COMMENT '更新时间' ,
PRIMARY KEY (`no`)
)
COMMENT='合同表'
;

#供应商品牌限定表
DROP TABLE IF EXISTS `p_supplier_brand`;
CREATE TABLE `p_supplier_brand` (
`id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键' ,
`supplier_id`  int(11) UNSIGNED NOT NULL COMMENT '供应商ID' ,
`brand_id`  int(11) UNSIGNED NOT NULL COMMENT '品牌ID' ,
`create_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '记录生成人' ,
`create_date`  datetime NOT NULL COMMENT '记录生成时间' ,
PRIMARY KEY (`id`) ,
INDEX `idx_supplier_brand_supplier_id` (`supplier_id`) USING BTREE ,
INDEX `idx_supplier_brand_brand_id` (`brand_id`) USING BTREE 
)
COMMENT='供应商品牌限定表'
;

#供应商分类限定表
DROP TABLE IF EXISTS `p_supplier_category`;
CREATE TABLE `p_supplier_category` (
`id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键' ,
`supplier_id`  int(11) UNSIGNED NOT NULL COMMENT '供应商ID' ,
`category_id`  int(11) UNSIGNED NOT NULL COMMENT '分类ID' ,
`create_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '记录生成人' ,
`create_date`  datetime NOT NULL COMMENT '记录生成时间' ,
PRIMARY KEY (`id`) ,
INDEX `idx_supplier_category_supplier_id` (`supplier_id`) USING BTREE ,
INDEX `idx_supplier_category_category_id` (`category_id`) USING BTREE 
)
COMMENT='供应商分类限定表'
;

#采购单表
DROP TABLE IF EXISTS `p_purchase_form`;
CREATE TABLE `p_purchase_form` (
`no` varchar(50) NOT NULL COMMENT '采购单号' ,
`supplier_id`  int(11) UNSIGNED NOT NULL COMMENT '供应商ID' ,
`contract_no` varchar(50) NOT NULL COMMENT '合同编号' ,
`name`  varchar(50) NOT NULL DEFAULT '' COMMENT '名称' ,
`purchase_type`  int(1) NOT NULL DEFAULT 0 COMMENT '采购类型：经销、代销、联营、包销、对方发货' ,
`status`  tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态：-1已作废0待确认1已确认2已完成' ,
`approve_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '审批人' ,
`approve_date`  datetime NULL COMMENT '审批时间' ,
`create_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '记录生成人' ,
`create_date`  datetime NOT NULL COMMENT '记录生成时间' ,
`update_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '更新人' ,
`update_date`  datetime NOT NULL COMMENT '更新时间' ,
PRIMARY KEY (`no`),
INDEX `idx_purchase_form_supplier_id` (`supplier_id`) USING BTREE ,
INDEX `idx_purchase_form_contract_no` (`contract_no`) USING BTREE 
)
COMMENT='采购单表'
;

#采购明细表
DROP TABLE IF EXISTS `p_purchase_detail`;
CREATE TABLE `p_purchase_detail` (
`product_no`  varchar(20) NOT NULL COMMENT '货品编号' ,
`purchase_no` varchar(50) NOT NULL COMMENT '采购单号' ,
`purchase_quality`  smallint(6) NOT NULL DEFAULT 0 COMMENT '采购数量' ,
`storage_quality`  smallint(6) NOT NULL DEFAULT 0 COMMENT '已入库数量' ,
`status`  tinyint(4) NOT NULL DEFAULT 0 COMMENT '0未完成1已完成' ,
`purchase_price`  decimal(18,2) NOT NULL DEFAULT 0 COMMENT '采购价格' ,
`create_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '记录生成人' ,
`create_date`  datetime NOT NULL COMMENT '记录生成时间' ,
`update_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '更新人' ,
`update_date`  datetime NOT NULL COMMENT '更新时间' ,
PRIMARY KEY (`product_no`) ,
INDEX `idx_purchase_detail_purchase_no` (`purchase_no`) USING BTREE 
)
COMMENT='采购明细表'
;

#发货单表
DROP TABLE IF EXISTS `p_deliver_form`;
CREATE TABLE `p_deliver_form` (
`no` varchar(50) NOT NULL COMMENT '发货单号' ,
`purchase_no` varchar(50) NOT NULL COMMENT '采购单号' ,
`warehouse_id` int(11) NOT NULL COMMENT '收货仓库ID' ,
`status`  tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态：-1已作废0待确认1已确认2已完成' ,
`deliver_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '对方发货人' ,
`deliver_date`  datetime NULL COMMENT '对方发货时间' ,
`confirm_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '我方确认人' ,
`confirm_date`  datetime NULL COMMENT '我方确认时间' ,
`create_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '记录生成人' ,
`create_date`  datetime NOT NULL COMMENT '记录生成时间' ,
`update_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '更新人' ,
`update_date`  datetime NOT NULL COMMENT '更新时间' ,
PRIMARY KEY (`no`),
INDEX `idx_deliver_form_purchase_no` (`purchase_no`) USING BTREE 
)
COMMENT='发货单表'
;

#发货单明细表
DROP TABLE IF EXISTS `p_deliver_detail`;
CREATE TABLE `p_deliver_detail` (
`product_no`  varchar(20) NOT NULL COMMENT '货品编号' ,
`deliver_no` varchar(50) NOT NULL COMMENT '发货单号' ,
`deliver_quality`  smallint(6) NOT NULL DEFAULT 0 COMMENT '发货数量' ,
`storage_quality`  smallint(6) NOT NULL DEFAULT 0 COMMENT '入库数量' ,
`storage_normal_quality`  smallint(6) NOT NULL DEFAULT 0 COMMENT '入库正品数量' ,
`storage_broken_quality`  smallint(6) NOT NULL DEFAULT 0 COMMENT '入库残品数量' ,
`purchase_price`  decimal(18,2) NOT NULL DEFAULT 0 COMMENT '采购价格' ,
`create_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '记录生成人' ,
`create_date`  datetime NOT NULL COMMENT '记录生成时间' ,
`update_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '更新人' ,
`update_date`  datetime NOT NULL COMMENT '更新时间' ,
PRIMARY KEY (`product_no`),
INDEX `idx_deliver_detail_deliver_no` (`deliver_no`) USING BTREE 
)
COMMENT='发货单明细表'
;

#返厂单表
DROP TABLE IF EXISTS `p_backtrack_form`;
CREATE TABLE `p_backtrack_form` (
`no` varchar(50) NOT NULL COMMENT '返厂单号' ,
`supplier_id`  int(11) UNSIGNED NOT NULL COMMENT '供应商ID' ,
`warehouse_id` int(11) NOT NULL COMMENT '仓库ID' ,
`status`  tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态：-1已作废0待确认1已确认2已完成' ,
`backtrack_type`  tinyint(4) NOT NULL DEFAULT 0 COMMENT '返厂类型：采购返厂/库内返厂' ,
`commodity_type`  tinyint(4) NOT NULL DEFAULT 0 COMMENT '商品类型：正品/残品' ,
`create_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '记录生成人' ,
`create_date`  datetime NOT NULL COMMENT '记录生成时间' ,
`update_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '更新人' ,
`update_date`  datetime NOT NULL COMMENT '更新时间' ,
PRIMARY KEY (`no`) ,
INDEX `idx_backtrack_form_supplier_id` (`supplier_id`) USING BTREE
)
COMMENT='返厂单表'
;

#返厂单明细表
DROP TABLE IF EXISTS `p_backtrack_detail`;
CREATE TABLE `p_backtrack_detail` (
`product_no`  varchar(20) NOT NULL COMMENT '货品编号' ,
`backtrack_no` varchar(50) NOT NULL COMMENT '返厂单号' ,
`backtrack_quality`  smallint(6) NOT NULL DEFAULT 0 COMMENT '计划返厂数量' ,
`storage_quality`  smallint(6) NOT NULL DEFAULT 0 COMMENT '仓库确认数量' ,
`storage_normal_quality`  smallint(6) NOT NULL DEFAULT 0 COMMENT '返厂正品数量' ,
`storage_broken_quality`  smallint(6) NOT NULL DEFAULT 0 COMMENT '返厂残品数量' ,
`backtrack_price`  decimal(18,2) NOT NULL DEFAULT 0 COMMENT '返厂价格' ,
`create_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '记录生成人' ,
`create_date`  datetime NOT NULL COMMENT '记录生成时间' ,
`update_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '更新人' ,
`update_date`  datetime NOT NULL COMMENT '更新时间' ,
PRIMARY KEY (`product_no`),
INDEX `idx_backtrack_detail_backtrack_no` (`backtrack_no`) USING BTREE 
)
COMMENT='返厂单明细表'
;

#类型状态字典表
DROP TABLE IF EXISTS `p_dictionary`;
CREATE TABLE `p_dictionary` (
`id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键' ,
`group`  varchar(50) NOT NULL COMMENT '状态分组' ,
`code`  tinyint(4) NOT NULL COMMENT '状态代码' ,
`name`  varchar(100) NOT NULL COMMENT '状态名称' ,
`sort_no`  tinyint(4) NOT NULL DEFAULT 0 COMMENT '排序号' ,
`create_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '记录生成人' ,
`create_date`  datetime NOT NULL COMMENT '记录生成时间' ,
PRIMARY KEY (`id`) ,
INDEX `idx_dictionary_group` (`group`) USING BTREE 
)
COMMENT='类型状态字典表'
;