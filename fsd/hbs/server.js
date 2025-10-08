const express = require("express");
const bodyParser = require("body-parser");
const fs = require("fs");
const path = require("path");
const app = express();
const PORT = 3000;
// Middleware
app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static("public"));
app.set("view engine", "hbs");
app.set("views", path.join(__dirname, "views"));
// Routes
app.get("/", (req, res) => {
res.render("form");
});
app.post("/submit", (req, res) => {
const formData = req.body;
// Save data to a file
fs.writeFile("data.json", JSON.stringify(formData, null, 2), (err) => {
if (err) {
console.error("Error writing file", err);
return res.status(500).send("Server error");
}
res.redirect("/display");
});
});
app.get("/display", (req, res) => {
    fs.readFile("data.json", "utf-8", (err, data) => {
if (err) {
console.error("Error reading file", err);
return res.status(500).send("Server error");
}
const parsedData = JSON.parse(data);
res.render("display", parsedData);
});
});
// Start server
app.listen(PORT, () => {
console.log(`Server running at http://localhost:${PORT}`);
});