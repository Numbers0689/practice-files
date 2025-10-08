import React, { Component } from "react";
class CounterClass extends Component {
constructor(props) {
super(props);
this.state = { count: 0 };
}
increment = () => {
this.setState(prev => ({ count: prev.count + 1 }));
};
decrement = () => {
this.setState(prev => ({ count: prev.count - 1 }));
};
reset = () => {
this.setState({ count: 0 });
};
render() {
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
<h2>Class Component Counter</h2>
<h1>{this.state.count}</h1>
<div
style={{
display: "flex",
gap: "0.5rem",
justifyContent: "center"
}}
>
<button onClick={this.increment}>+</button>
<button onClick={this.decrement}>-</button>
<button onClick={this.reset}>Reset</button>
</div>
</div>
);
}
}
export default CounterClass;