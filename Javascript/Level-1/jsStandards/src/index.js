// (function (exports, require, module, __filename, __dirname) {

// import primaryItem, { softDrink1,softDrink2 } from './hotel/menu'
// import primaryItem, { softDrink1 as drink1, softDrink2 as drink2 } from './hotel/menu'

 import * as items from './hotel/menu'
 import 'bootstrap/dist/css/bootstrap.min.css'
 //import * as _ from lodash
 //import * as greetMod from 'nex-greet' 
// or
//let items=require('./hotel/menu');
//let greetMod = require('nex-greet')
//var _ = require('lodash');
 //var config=require('./config')

//import config from './config'

console.log('-index.js-')
//greetMod.greet('en')

let arr1 = [1, 2, 3, 4]
let arr2 = [3, 4]
//let diff = _.difference(arr1, arr2);
//console.log(diff);

console.log(items.default);
console.log(items.softDrink1); 
console.log(items.softDrink2) 



//var imgs = [
//   'https://img.etimg.com/thumb/height-480,width-640,imgsize-59043,msid-56975814/.jpg',
//    'https://rukminim1.flixcart.com/image/704/704/poster/m/z/n/tom-and-jerry-cartoon-poster-tj-1918-small-original-imae8vhueg8wnnk3.jpeg?q=70',
//    'https://thegoldenhammer.net/wp-content/uploads/2018/12/chase-clipart-tom-and-jerry-1.gif'
//]


function loadTodos(count) {
    let url = `https://jsonplaceholder.typicode.com/todos?_limit=${count}`;
    let todoListEle = document.getElementById('todo-list');
    let promise = fetch(url)
    document.getElementById('progress').innerHTML = "Loading todos....";
    promise.then(response=>response.json())
            .then(todos => {
                document.getElementById('progress').innerHTML = ""
                let todoEles = todos.map(todo => {
                    let liTemplate = `<tr class= ${todo.completed ? 'table-dark text-dark' : ''}>
                    <td><span class="badge badge-dark">${todo.id}</span></td>
                    <td>${todo.title}</td>
                    <td>${todo.completed}</td
                    </tr>
                `
                    return liTemplate;
            })
            todoListEle.innerHTML = todoEles.join(' ');
        })
}

var todoBtn = document.querySelector('.btn-dark');
todoBtn.addEventListener('click',loadTodos(5));

''
var subBtn = document.getElementById('btn2');
subBtn.addEventListener('click',()=>{
    loadTodos(document.getElementById('todocount').value);
})






// });