(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5ac970aa"],{"1b19":function(e,t,a){},3928:function(e,t,a){"use strict";a("1b19")},"91e8":function(e,t,a){"use strict";a.r(t);var i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"app-container"},[a("el-card",{staticStyle:{"margin-top":"10px","font-size":"14px","line-height":"30px","margin-bottom":"15px"}},[a("el-row",{staticStyle:{"font-weight":"800"}},[e._v("\n      操作提示：\n    ")]),e._v(" "),a("el-row",[e._v("\n      1、这里可以创建一个个权限分组，每个权限分组包含若干个操作权限。\n    ")]),e._v(" "),a("el-row",[e._v("\n      2、然后，在“角色管理”中给角色增加某个“权限组”，这个角色就有了这部分权限。\n    ")])],1),e._v(" "),a("el-row",[a("el-button",{attrs:{type:"primary"},on:{click:e.handleCreate}},[e._v("创建")])],1),e._v(" "),a("el-card",{staticStyle:{"margin-top":"10px"}},[a("el-table",{ref:"multipleTable",staticStyle:{width:"100%","min-height":"300px","margin-bottom":"20px"},attrs:{data:e.tableData,"tooltip-effect":"dark"}},[a("el-table-column",{attrs:{label:"权限组名称"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(t.row.groupName))]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"groupRemark",label:"备注"}}),e._v(" "),a("el-table-column",{attrs:{align:"right"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini"},on:{click:function(a){return e.handleEdit(t.$index,t.row)}}},[e._v("编辑")]),e._v(" "),a("el-button",{attrs:{size:"mini"},on:{click:function(a){return e.handleDelete(t.$index,t.row)}}},[e._v("删除")])]}}])})],1)],1),e._v(" "),a("el-dialog",{attrs:{title:"",visible:e.dialogVisible,width:"70%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("el-form",{ref:"form",attrs:{"label-position":"top",model:e.form,"label-width":"80px","status-icon":""}},[a("el-form-item",{attrs:{label:"权限组名称"}},[a("el-input",{model:{value:e.form.groupName,callback:function(t){e.$set(e.form,"groupName",t)},expression:"form.groupName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"备注"}},[a("el-input",{model:{value:e.form.groupRemark,callback:function(t){e.$set(e.form,"groupRemark",t)},expression:"form.groupRemark"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"操作权限"}},[[a("el-checkbox",{attrs:{indeterminate:e.isIndeterminate},on:{change:e.handleCheckAllChange},model:{value:e.checkAll,callback:function(t){e.checkAll=t},expression:"checkAll"}},[e._v("全选")]),e._v(" "),a("el-checkbox-group",{on:{change:e.handleCheckedCitiesChange},model:{value:e.checkedAcl,callback:function(t){e.checkedAcl=t},expression:"checkedAcl"}},e._l(e.aclActionData,(function(t){return a("el-checkbox",{key:t.key,staticStyle:{width:"180px"},attrs:{label:t.key}},[e._v(e._s(t.label))])})),1)]],2)],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),e._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.handPostData()}}},[e._v("确 定")])],1)],1),e._v(" "),a("el-dialog",{attrs:{title:"",visible:e.dialogVisibleCreate,width:"70%"},on:{"update:visible":function(t){e.dialogVisibleCreate=t}}},[a("el-form",{ref:"form",attrs:{"label-position":"top",model:e.form,"label-width":"80px","status-icon":""}},[a("el-form-item",{attrs:{label:"权限组名称"}},[a("el-input",{model:{value:e.form.groupName,callback:function(t){e.$set(e.form,"groupName",t)},expression:"form.groupName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"备注"}},[a("el-input",{model:{value:e.form.groupRemark,callback:function(t){e.$set(e.form,"groupRemark",t)},expression:"form.groupRemark"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"操作权限"}},[[a("el-checkbox",{attrs:{indeterminate:e.isIndeterminate},on:{change:e.handleCheckAllChange},model:{value:e.checkAll,callback:function(t){e.checkAll=t},expression:"checkAll"}},[e._v("全选")]),e._v(" "),a("el-checkbox-group",{on:{change:e.handleCheckedCitiesChange},model:{value:e.checkedAcl,callback:function(t){e.checkedAcl=t},expression:"checkedAcl"}},e._l(e.aclActionData,(function(t){return a("el-checkbox",{key:t.key,staticStyle:{width:"180px"},attrs:{label:t.key}},[e._v(e._s(t.label))])})),1)]],2)],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.dialogVisibleCreate=!1}}},[e._v("取 消")]),e._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.handPostDataCreate()}}},[e._v("确 定")])],1)],1),e._v(" "),a("el-dialog",{attrs:{title:"提示",visible:e.dialogVisibleConfirmDelete,width:"30%"},on:{"update:visible":function(t){e.dialogVisibleConfirmDelete=t}}},[a("span",[e._v("确定删除该权限组："+e._s(e.prepareDeleteGroupName))]),e._v(" "),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.dialogVisibleConfirmDelete=!1}}},[e._v("取 消")]),e._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.handPostDataDelete()}}},[e._v("确 定")])],1)])],1)},o=[],l=(a("ac6a"),a("5c96")),r=["上海","北京","广州","深圳"],n={data:function(){return{dialogVisibleConfirmDelete:!1,dialogVisibleCreate:!1,dialogVisible:!1,isCreate:!1,form:{groupId:1,groupName:"",groupRemark:""},aclActionData:[],aclActionValue:[],prepareDeleteGroupId:null,prepareDeleteGroupName:null,checkAll:!1,checkedAcl:[],cities:r,isIndeterminate:!0}},computed:{tableData:function(){return this.$store.state.acl.groupList}},created:function(){this.load()},methods:{load:function(){this.$store.dispatch("acl/getGroupList"),this.$store.dispatch("acl/getActionList")},handleCheckAllChange:function(e){var t=this;this.aclActionValue=[],this.aclActionData.forEach((function(e){t.aclActionValue.push(e.key)})),this.checkedAcl=e?this.aclActionValue:[],this.isIndeterminate=!1},handleCheckedCitiesChange:function(e){var t=e.length;this.checkAll=t===this.aclActionData.length,this.isIndeterminate=t>0&&t<this.aclActionData.length},handleCreate:function(){var e=this;this.dialogVisibleCreate=!0,this.form.groupId=null,this.form.groupName="",this.form.groupRemark="";for(var t=this.$store.state.acl.actionList,a=[],i=[],o=0;o<t.length;o++){var l=t[o],r=l.id;a.push({key:r,label:l.actionName,disabled:!1})}e.aclActionData=a,e.aclActionValue=i},handleDelete:function(e,t){this.prepareDeleteGroupId=t.id,this.prepareDeleteGroupName=t.groupName,this.dialogVisibleConfirmDelete=!0},handleEdit:function(e,t){var a=this,i=this;this.form.groupName=t.groupName,this.form.groupRemark=t.groupRemark,this.form.groupId=t.id,this.$store.dispatch("acl/groupDetail",{id:this.form.groupId}).then((function(e){for(var t=a.$store.state.acl.groupDetail,o=[],l=[],r=t.listGroupActionDetail,n=0;n<r.length;n++){var c=r[n],s=c.actionId;o.push({key:s,label:c.actionName,disabled:!1}),c.selected&&l.push(s)}i.aclActionData=o,i.checkedAcl=l,i.dialogVisible=!0}))},handPostData:function(){console.log(this.checkedAcl);var e=this;console.log(1),this.$myLoading.myLoading.loading(),this.$store.dispatch("acl/groupDetailUpdate",{id:this.form.groupId,groupName:this.form.groupName,groupRemark:this.form.groupRemark,groupActionList:this.checkedAcl}).then((function(t){e.dialogVisible=!1,e.$myLoading.myLoading.closeLoading(),Object(l["Message"])({message:"修改完成",type:"success",duration:5e3}),e.load()}))},handPostDataCreate:function(){console.log(this.checkedAcl);var e=this;this.$store.dispatch("acl/groupAdd",{groupName:this.form.groupName,groupRemark:this.form.groupRemark,groupActionList:this.checkedAcl}).then((function(t){e.dialogVisible=!1,Object(l["Message"])({message:"添加完成",type:"success",duration:5e3}),e.dialogVisibleCreate=!1,e.load()}))},handPostDataDelete:function(){var e=this;this.$store.dispatch("acl/groupDelete",{id:this.prepareDeleteGroupId}).then((function(t){e.dialogVisible=!1,Object(l["Message"])({message:"完成",type:"success",duration:5e3}),e.dialogVisibleConfirmDelete=!1,e.load()}))}}},c=n,s=(a("3928"),a("2877")),u=Object(s["a"])(c,i,o,!1,null,"63fb138e",null);t["default"]=u.exports}}]);