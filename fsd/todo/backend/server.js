const http = require("http");
const fs = require("fs");
const path = require("path");
const PORT = 5000;
const DATA_FILE = path.join(__dirname, "todos.json");
// Helper: read todos
function loadTodos() {
try {
const data = fs.readFileSync(DATA_FILE, "utf8");
return JSON.parse(data);
} catch (err) {
return [];
}
}
// Helper: save todos
function saveTodos(todos) {
fs.writeFileSync(DATA_FILE, JSON.stringify(todos, null, 2));
}
const server = http.createServer((req, res) => {
// CORS headers
res.setHeader("Access-Control-Allow-Origin", "*");
res.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE,OPTIONS");
res.setHeader("Access-Control-Allow-Headers", "Content-Type");
if (req.method === "OPTIONS") {
res.writeHead(204);
return res.end();
}
// GET /todos
if (req.method === "GET" && req.url === "/todos") {
const todos = loadTodos();
res.writeHead(200, { "Content-Type": "application/json" });
return res.end(JSON.stringify(todos));
}
// POST /todos
if (req.method === "POST" && req.url === "/todos") {
let body = "";
req.on("data", chunk => {
body += chunk.toString();
});
req.on("end", () => {
let todos = loadTodos();
const newTodo = { id: Date.now(), text: JSON.parse(body).text };
todos.push(newTodo);
saveTodos(todos);
res.writeHead(200, { "Content-Type": "application/json" });
res.end(JSON.stringify(newTodo));
});
return;
}
// DELETE /todos/:id
if (req.method === "DELETE" && req.url.startsWith("/todos/")) {
const id = Number(req.url.split("/")[2]);
let todos = loadTodos();
todos = todos.filter(todo => todo.id !== id);
saveTodos(todos);
res.writeHead(200, { "Content-Type": "application/json" });
return res.end(JSON.stringify({ success: true }));
}
// Fallback
res.writeHead(404, { "Content-Type": "application/json" });
res.end(JSON.stringify({ error: "Not found" }));
});
// Start server
server.listen(PORT, () => {
console.log(`
Server running at http://localhost:${PORT}`);
});