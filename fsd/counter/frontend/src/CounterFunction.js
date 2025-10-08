import React, { useState } from "react";
function CounterFunction() {
const [count, setCount] = useState(0);
const increment = () => setCount(c => c + 1);
const decrement = () => setCount(c => c - 1);
const reset = () => setCount(0);
return (
<div
style={{
display: "inline-block",
margin: "1rem",
padding: "1rem",
border: "1px solid #ddd",
borderRadius: "12px",
textAlign: "center"
}}
>
<h2>Function Component Counter</h2>
<h1>{count}</h1>
<div
style={{
display: "flex",
gap: "0.5rem",
justifyContent: "center"
}}
>
<button onClick={increment}>+</button>
<button onClick={decrement}>-</button>
<button onClick={reset}>Reset</button>
</div>
</div>
);
}
export default CounterFunction;