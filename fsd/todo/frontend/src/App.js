import { useEffect, useState } from "react";
function App() {
const [todos, setTodos] = useState([]);
const [newTodo, setNewTodo] = useState("");
// Fetch todos on load
useEffect(() => {
fetch("http://localhost:5000/todos")
.then(res => res.json())
.then(data => setTodos(data));
}, []);
// Add todo
const addTodo = () => {
if (!newTodo.trim()) return;
fetch("http://localhost:5000/todos", {
method: "POST",
headers: { "Content-Type": "application/json" },
body: JSON.stringify({ text: newTodo })
})
.then(res => res.json())
.then(todo => {
setTodos([...todos, todo]);
setNewTodo("");
});
};
// Delete todo
const deleteTodo = (id) => {
fetch(`http://localhost:5000/todos/${id}`, { method: "DELETE" })
.then(() => {
setTodos(todos.filter(t => t.id !== id));
});
};
return (
<div style={{ textAlign: "center", marginTop: "50px" }}>
<h1>
Todo App (No Express)</h1>
<input
value={newTodo}
onChange={(e) => setNewTodo(e.target.value)}
placeholder="Enter todo"
/>
<button onClick={addTodo}>Add</button>
<ul style={{ listStyle: "none", padding: 0 }}>
{todos.map(todo => (
<li key={todo.id} style={{ margin: "10px 0" }}>
{todo.text}{" "}
<button onClick={() => deleteTodo(todo.id)}> </button>
</li>
))}
</ul>
</div>
);
}
export default App;