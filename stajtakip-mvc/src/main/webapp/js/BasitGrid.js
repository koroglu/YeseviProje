/**
 * 
 */
 
var grid = new Ext.grid.GridPanel({
    store: new Ext.data.JsonStore({
        autoDestroy: true,
        autoLoad:true,
        idProperty: 'nodeId',
        fields: ['nodeId', 'parentId', 'leaf','cls','text','componentName'],
        root:'list',
        url:'./staj/listNodes.ajax'
    }),
    colModel: new Ext.grid.ColumnModel({
        defaults: {
            width: 120,
            sortable: true
        },
        columns: [
            {id: 'nodeId', header: 'Node ID', width: 200, sortable: true, dataIndex: 'nodeId'},
            {header: 'Parent ID',  dataIndex: 'parentId'},
            {header: 'Class', dataIndex: 'cls'},
            {header: 'TEXT', width: 135, dataIndex: 'text'},
            {header:'LEAF', dataIndex:'leaf'},
            {header:'Component Name',dataIndex:'componentName'}
        ]
    }),
    viewConfig: {
        forceFit: true,
    },
    sm: new Ext.grid.RowSelectionModel({singleSelect:true}),
    width: 600,
    height: 300,
    frame: true,
    tbar:[new Ext.Button({text:'Buton1',iconCls:'icon-save'})],
    iconCls: 'icon-grid'
});


Ext.getCmp('tabs').add({id:'GridPanel',items:[grid],title:'GridPanel', border:false,frame:true, autoHeight:true, closable:true});
Ext.getCmp('tabs').setActiveTab('GridPanel');