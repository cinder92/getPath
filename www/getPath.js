var exec = require('cordova/exec');

var getPath = {
	getInternal : function(success,error){
		exec(success,error,'getSdCard','getInteral',[])
	},
	getExternal : function(success,error){
		exec(success,error,'getSdCard','getExternal',[])
	}
}

module.exports = getPath;