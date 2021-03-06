Ext.define('More.view.ships.Main', {
    extend: 'Ext.Panel',
    xtype: 'ships',
    requires: ['More.view.ships.ShipsGrid'],
    
    layout: 'border',
    defaults: {
    	split: true,
    },
    height: 670,
    
    items: [{
    	title: 'Список судов',
    	region: 'center',
    	xtype: 'shipsgrid'
    },{
    	title: 'Карточка детализации',
    	region: 'east',
    	collapsible: true,
    	collapsed: true,
    	width: 750,
    	html: '<iframe src="shipDetails" style="width:100%; height:100%;border:none;"/>'
    }]
});