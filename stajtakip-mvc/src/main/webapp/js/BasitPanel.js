/**
 * 
 */
 
var panel = new Ext.Panel({
	autoHeight:true,
	border:false,
	script:true,
	items:[{html:'<section class="inset"><h2>This is the main heading of the document</h2></section>'}]
});

Ext.getCmp('tabs').add({id:'BasitPanel',items:[panel],title:'Panel', border:false,frame:true, autoHeight:true, closable:true});
Ext.getCmp('tabs').setActiveTab('BasitPanel');