
"use strict"
console.log("Javascript is working");

var v = 5;
var name = "Rushabh";
var dynamicString = "the triner" + name + ", always coming late";
var dynamicString2 = `the trainer ${name}, teaching javascript`

console.log(dynamicString + "\n" + dynamicString2);

var template = `
<br/>
<div class="container">
    <ul>
        <li>Item-1</li>
    </ul>
</div>
`
document.write(template);

// Method 1 for class Creation
/*function Person(name,age){
    this.name = name;
    this.age = age;
    this.sayName = function(){
        console.log(`i am ${name}`);
    }
    this.sayAge = function(){
        console.log(`i am ${age} old`);
    }
}*/

//method 2 for class creation
/*function Person(name,age){
    this.name = name;
    this.age = age;
}

Person.prototype.sayName = function(){
    console.log(`i am ${this.name}`);
} 

Person.prototype.sayAge = function(){
    console.log(`i am ${this.age} old');
} */



//Method 3 for class creation
class Person{
    constructor(name,age){
        this.name = name;
        this.age = age;
    }
    sayName(){
        console.log(`i am ${this.name}`);
    }

    sayAge(){
        console.log(`i am ${this.age} old`)
    }
}

var p1 = new Person("Rushabh",22);
var p2 = new Person("Rishin",24)


//Method 1 for object creation
var httpReqConfig = new Object();
httpReqConfig.url = "http://localhost:8181/todos";
httpReqConfig.httpMethod = "GET";
httpReqConfig.onSuccess = function(response){
    //....
}

//Method 2 for object creation
var httpReqConfigNew = {
    url:"http://localhost:8181/todos",
    httpMethod: "GET",
    onSuccess: function(response){
        return "true";
    }
};

console.log(httpReqConfigNew.onSuccess("hello"));

//Method 3 of Object Creation
var add = new Function("n1", "n2", "var result=n1+n2;return result;")

//Method 4 of Object Creation
function addNew(n1, n2) {
    var result = n1 + n2;
    return result;
}



//Javascript Objects are extensible

p1.skills = "java javascript..";


//Prevent extensible

Object.preventExtensions(p2);

//p2.skills = "c++"; //error

//console.log(Object.isSealed()); // true -> allows deleting
//delete p1.age;
//Object.seal(p1); //seal() --> won't allow to delete


//Object.freeze(p1) // No Modify No delete No extension
//p1.age = 15;


function myFunction(){
    if(document.getElementById("hello").innerHTML == "Hello World"){
        document.getElementById("hello").innerHTML = "Javascript";
        document.getElementById("btn").innerHTML = "Hello World";
    }
    else{
        document.getElementById("hello").innerHTML = "Hello World";
        document.getElementById("btn").innerHTML = "javascript";
    }
}


var adharPattern = new RegExp("\\d{4}-\\d{4}-//d{4}");

var adharPattern = /\d{4}-\d{4}-\d{4}/;

var add  = addNew(1,2);
console.log(add);

/*
    2 ways
    -> '.' , if property-name dont have space or '-' or digit
    else
    -> '[]' , for any property
*/


var person = {
    name: 'Nag',
    'home-address': 'chennai',
    1: 'one',
    100: 'hundred',
    add: function(name){
        return name;
    }
};

console.log(person.name)
console.log(person["home-address"])
console.log(person["1"])
console.log(person[100])
console.log(person.add("Hello Rushabh"))
person.name = "Rushabh"


let tnr = {
    tnrName : 'Rushabh2',
    tnrFunc : ()=>{
        return function(){
                    let callback = ()=>{
                    console.log(this);
                    console.log(this.tnrName);
                }
                setTimeout(callback,4000) 
            }
    }
}

tnr.tnrFunc().call(tnr);