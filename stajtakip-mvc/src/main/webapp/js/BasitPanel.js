/**
 * 
 */
 
var panel = new Ext.Panel({
	autoHeight:true,
	border:false,
	items:[{html:'Selamlar geyik'}]
});

Ext.getCmp('tabs').add({id:'BasitPanel',items:[panel],title:'Panel', border:false,frame:true, autoHeight:true, closable:true});
Ext.getCmp('tabs').setActiveTab('BasitPanel');