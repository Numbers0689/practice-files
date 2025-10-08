const http = require('http');
const fs = require('fs');
const path = require('path');
const PORT = 3000;
const filePath = path.join(__dirname, 'index.html');
const server = http.createServer((req, res) => {
if (req.url === '/') {
fs.readFile(filePath, (err, content) => {
if (err) {
res.writeHead(500);
res.end('Server error');
} else {
res.writeHead(200, { 'Content-Type': 'text/html' });
res.end(content);
}
});
} else {
res.writeHead(404);
res.end('404 - Not Found');
}
});
server.listen(PORT, () => {
console.log(`Server running at http://localhost:${PORT}`);
});
