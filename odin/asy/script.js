const server = {
    people: [
      {
        name: "Odin",
        age: 20,
      },
      {
        name: "Thor",
        age: 35,
      },
      {
        name: "Freyja",
        age: 22,
      },
    ],
  
    getPeople() {
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve(this.people);
        }, 2000);
      });
    },
};


function getinfo(name) {
    return server.getPeople().then(people => {
        return people.find(person => { return person.name === name });
    });
}

console.log(getinfo("Freyja").then(person => {
    return person.name;
}));

async function getinfos(name) {
    const people = await server.getPeople();
    const person = people.find(person => { return person.name === name});
    return person;
}

console.log(getinfos("Odin"));