var path = require('path');
var ExtractTextPlugin = require("extract-text-webpack-plugin");

module.exports = {
	entry: {
		app: './src/main/javascript/reset.js'
	},
	output: {
		filename: 'js/[name].js',
		path: __dirname + '/src/main/resources/static'
	},
	module: {
		rules: [
	      {
	        test: /.jsx?$/,
	        exclude: /node_modules/,
	        use: {
	        	loader: 'babel-loader'
	        }
	      }
	    ]
	}
}