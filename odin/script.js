// async function loadJson(url) {
//     try {
//         let response = await fetch(url);
//         if (response.status == 200) {
//             let result = await response.json();
//             return result;
//         }
            
//         throw new Error(response.status);
//     } catch (e) {
//         alert(e);
//     }
// }

loadJson('https://javascript.info/no-such-user.json')


// part 2

class HttpError extends Error {
    constructor(response) {
      super(`${response.status} for ${response.url}`);
      this.name = 'HttpError';
      this.response = response;
    }
}

async function loadJson(url) {
    try {
        let response = await fetch(url);
        if (response.status == 200) {
            let result = await response.json();
            return result;
        }
            
        throw new HttpError(response);
    } catch (e) {
        alert(e);
    }
}

async function demoGithubUser() {
    let name = prompt("Enter a name?", "iliakan");

    try {
        let user = await loadJson(`https://api.github.com/users/${name}`)
        (user => {
          alert(`Full name: ${user.name}.`);
          return user;
        })(user);
    } catch(err) {
        if (err instanceof HttpError && err.response.status == 404) {
            alert("No such user, please reenter.");
            return demoGithubUser();
        } else {
            throw err;
        }
    };
}