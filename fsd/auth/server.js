const express = require("express");
const mongoose = require("mongoose");
const bodyParser = require("body-parser");
const cookieParser = require("cookie-parser");
const bcrypt = require("bcryptjs");
const app = express();
const PORT = 3000;
// Middleware
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());
app.use(cookieParser());
// MongoDB Connection (local)
mongoose.connect("mongodb://127.0.0.1:27017/auth_demo", {
useNewUrlParser: true,
useUnifiedTopology: true,
})
.then(() => console.log("Connected to MongoDB"))
.catch((err) => console.error("DB Error:", err));// User Schema
const userSchema = new mongoose.Schema({
username: { type: String, unique: true, required: true },
password: { type: String, required: true },
});
const User = mongoose.model("User", userSchema);

// Routes
app.get("/", (req, res) => {
if (req.cookies.userId) {
res.send(`Welcome! You are logged in. <a
href="/logout">Logout</a>`);
} else {
res.sendFile(__dirname + "/index.html");
}
});
app.post("/signup", async (req, res) => {
const { username, password } = req.body;
if (!username || !password)
return res.send("Please provide username and password");
const hashedPassword = await bcrypt.hash(password, 10);
try {
    const newUser = new User({ username, password: hashedPassword });
await newUser.save();
res.send("Sign Up successful! <a href='/'>Login now</a>");
} catch (err) {
res.send("User already exists or DB error");
}
});
app.post("/login", async (req, res) => {
const { username, password } = req.body;
if (!username || !password)
return res.send("Please provide username and password");
const user = await User.findOne({ username });
if (!user) return res.send("User not found");
const isMatch = await bcrypt.compare(password, user.password);
if (!isMatch) return res.send("Invalid password");
res.cookie("userId", user._id.toString(), { httpOnly: true });
res.send(`Login successful! <a href="/">Go to Home</a>`);
});
app.get("/logout", (req, res) => {
res.clearCookie("userId");
res.send("Logged out! <a href='/'>Login</a>");
});
app.listen(PORT, () =>
console.log(`
Server running on http://localhost:${PORT}`)
);