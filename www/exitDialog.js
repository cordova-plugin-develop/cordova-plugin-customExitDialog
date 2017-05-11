
var exec = require("cordova/exec");
module.exports = {
	showExit: function(content,success,error){
		exec(
		success,
		error,
		"ExitDialog",
		"showExit",
		[content]);
	}
}
