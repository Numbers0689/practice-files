const http = require("http");

http.createServer(function (req, res) {
	res.writeHead(200, {'Content-Type': 'text/html'});
	res.end('dont connnet to my server, not on this port!');
}).listen(8080);
