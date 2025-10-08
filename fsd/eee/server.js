const express = require("express");
const mongoose = require("mongoose");
const bodyParser = require("body-parser");
const path = require("path");

const app = express();
const port = 3000;

// ================== Middleware ==================
app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static("public"));

// ================== MongoDB Connection ==================
mongoose.connect("mongodb://127.0.0.1:27017/eventdb", {
    useNewUrlParser: true,
    useUnifiedTopology: true
})
.then(() => console.log("Connected to MongoDB database"))
.catch(err => console.error("Database connection failed:", err));

// ================== Mongoose Schema ==================
const eventSchema = new mongoose.Schema({
    name: String,
    date: Date,
    location: String,
    description: String
});

const Event = mongoose.model("Event", eventSchema);

// ================== Routes ==================

// Serve index.html
app.get("/", (req, res) => {
    res.sendFile(path.join(__dirname, "public", "index.html"));
});

// Create Event
app.post("/add-event", async (req, res) => {
    try {
        const { name, date, location, description } = req.body;
        const event = new Event({ name, date, location, description });
        await event.save();
        res.send("Event added successfully! <a href='/'>Go Back</a>");
    } catch (err) {
        console.error(err);
        res.status(500).send("Error adding event");
    }
});

// Read Events
app.get("/events", async (req, res) => {
    try {
        const events = await Event.find();
        res.json(events);
    } catch (err) {
        console.error(err);
        res.status(500).send("Error fetching events");
    }
});

// Update Event
app.post("/update-event", async (req, res) => {
    try {
        const { id, name, date, location, description } = req.body;
        await Event.findByIdAndUpdate(id, { name, date, location, description });
        res.send("Event updated successfully! <a href='/'>Go Back</a>");
    } catch (err) {
        console.error(err);
        res.status(500).send("Error updating event");
    }
});

// Delete Event
app.post("/delete-event", async (req, res) => {
    try {
        const { id } = req.body;
        await Event.findByIdAndDelete(id);
        res.send("Event deleted successfully! <a href='/'>Go Back</a>");
    } catch (err) {
        console.error(err);
        res.status(500).send("Error deleting event");
    }
});

// ================== Start Server ==================
app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
});
