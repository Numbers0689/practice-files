const container = document.querySelector('#container');

const content = document.createElement('div');
content.classList.add('content');
content.textContent = 'This is the glorious text-content!';

container.appendChild(content);

const para = document.createElement('p');
para.textContent = "Hey I'm red!";
container.appendChild(para);
para.setAttribute('style', "color: red;");

const head3 = document.createElement('h3');
head3.textContent = "I'm a blue h3!";
container.appendChild(head3);
head3.style.color = 'blue';

const box = document.createElement('div');
box.classList.add('box');

const head1 = document.createElement('h1');
head1.textContent = "I'm in a div";
const para1 = document.createElement('p');
para1.textContent = "ME TOO!";


box.setAttribute('style', 'background-color: pink; border: 5px solid black;');
box.appendChild(head1);
box.appendChild(para1);

container.appendChild(box);

btn.addEventListener('click', function (e) {
    e.target.style.background = 'blue';
  });
