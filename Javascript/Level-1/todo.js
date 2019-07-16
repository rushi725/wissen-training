

// //Model

// class Todo{
//     constructor(title){
//         this.id = Todo.count++;
//         this.title = title;
//         this.completed = false;
//     }
// }

// Todo.count  = 0;

// //Service

// class Service{

//     constructor(){
//         this.todoList = [];
//     }
//     //addTodo
//     addTodo(title){
//         let newTodo = new Todo(title);
//         this.todoList.push(newTodo);
//     }

//     editTodo(id,title){
//         let newTodo = this.todoList.find((ob)=>ob.id===id);
//         newTodo.title = title;
//     }

//     deleteTodoById(id){
//         let index = this.todoList.findIndex((ob)=>ob.id===id);
//         this.todoList.splice(index,1);
//     }

//     toggleCompleteById(id){
//         let newTodo = this.todoList.find((ob)=>ob.id===id);
//         newTodo.completed = !newTodo.completed; 
//     }

//     completeAll(){
//         this.todoList.forEach(ob => {
//                 ob.completed = true;            
//         });
//     }

//     clearCompleted(){
//         this.todoList.forEach(ob => {
//             if(ob.completed){
//                 this.deleteTodoById(ob.id);
//             }
//         });
//     }

//     filterByCompleted(){
//         let newList = this.todoList.filter(ob =>{
//             return ob.completed;
//         });
//         return newList;
//     }

//     sortTodo(){
//         this.todoList.sort((ob1,ob2)=>ob1.title > ob2.title);
//     }

//     display(){
//         this.todoList.forEach(ob => {
//             console.log(ob);
//         });
//         console.log("---------------------------------------------------------");
//     }
// }






// let ser = new Service();
// ser.addTodo("todo-2");
// ser.addTodo("todo-1");
// ser.addTodo("todo-5");
// ser.addTodo("todo-4");
// ser.addTodo("todo-6");
// ser.addTodo("todo-3");
// ser.display(Service.todoList);

// ser.editTodo(1,"todo-edited-2");
// ser.display(Service.todoList);

// ser.deleteTodoById(0);
// ser.display(Service.todoList);

// ser.toggleCompleteById(1);
// ser.display(Service.todoList);

// ser.clearCompleted();
// ser.display();

// ser.completeAll();
// ser.display();

// let newList = ser.filterByCompleted();
// ser.display();
// console.log(newList);

// ser.sortTodo();
// ser.display();


// let arr1 = [1,2,3,4]
// let arr2 = [1,3,5,6,7]

// let diff = arr1.filter(ob=>!arr2.find(i=>i==ob));
// let diff2 = arr1.filter(ob=>!arr2.includes(ob)).concat(arr2.filter(ob=>!arr1.includes(ob)));
// console.log(diff);
// console.log(diff2);

let pName = "Global";

let person = {
    pName: 'Nag',
    sayName: function () {
        let pName = "Local";
        console.log("im " + pName);
        console.log("im " + person.pName);
        console.log("im " + this.pName);
    }
}

person.sayName();
let oldPerson = person;
person = { pName: 'New-Person' }
oldPerson.sayName();


let consFunc = function(){
    this.func = function(){
        console.log(this)
    }
    console.log(this)
}

new consFunc();