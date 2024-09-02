const url = require('url');

const adr = "https://www.google.com/search?q=windbreaker+ch+511&oq=wind&gs_lcrp=EgZjaHJvbWUqCAgBEEUYJxg7MgYIABBFGDwyCAgBEEUYJxg7MgYIAhBFGDwyBggDEEUYPDIGCAQQRRg8MgYIBRBFGDwyBggGEEUYQTIGCAcQLhhA0gEIODE5OGowajGoAgCwAgA&sourceid=chrome&ie=UTF-8";
const q = url.parse(adr, true);

console.log(q.hostname);
console.log(q.query);
console.log(q.search);
