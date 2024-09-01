const fs = require("node:fs/promises");

const content = "this gonna be the content!\n";
const address = "text.txt";

async function example() {
    try {
        const data = await fs.readFile(address, 'utf-8');
        console.log(data);
        await fs.writeFile(address, content);
        await fs.writeFile(address, content, {flag: 'a+'});
        await fs.appendFile(address, content);
        const data1 = await fs.readFile(address, 'utf-8');
        console.log(data1);
    } catch (err) {
        console.log(err);
    }
}

example();