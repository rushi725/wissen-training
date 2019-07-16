
//avoid var keyword 
"use strict"
let x = 2;
let y = 3;
let z = 4;
let w = x+y+z;

var l = "javascript is good";
console.log(z);


/*let enjoy = "this";
let me = "do this";
let it = " go Joye";
let me = "go";
let destroy = "var";
let killed = "var";
let go = null;
let not = "do this";
let out = "is get out with l";
let me = "see";
let it = "be";*/
/*let  v ={
    r : function(){
        do{
            console.log(1);
        }
        while(false);
        

    }

}*/


/*var myFunctions =[];
for(var i=0;i<2;i++){
    var getFunc = function(i){
    var func = function(){ 
        console.log(i);
    };
    myFunctions.push(func);
    };
    getFunc(i);
}*/


var myFunctions =[];
for(var i=0;i<2;i++){
    var func = (function(){ 
        console.log(i);
    });
    myFunctions.push(func);
}
  

myFunctions[0]();
myFunctions[1]();


function sessionStart(){
    function Trainer(name){
        this.name = name;
    }

    function Employee(name){
        this.name = name;
    }

    function doTeach(sub){
        console.log(this.name + "teaching.....")
        let self = this;
        let todoLearn = function(){
            console.log(this.name + " learning from " + self.name)
        }
        return todoLearn;
    }

    let tnr = new Trainer("Nag");
    let e1 = new Employee("Rushabh");
    let e2 = new Employee("Mohit");

    let doLearn = doTeach.call(tnr,"JS");
    doLearn.call(e1);
    doLearn.call(e2);
}
console.log(name="Hello");
sessionStart();

//mode
let tnr = {
    name: 'Nag'
}

let tngService = {
    name: "tnfService",
    doTeach:function(){
        console.log(this);
        console.log(this.name + " teaching.js");
    }
}

//view 

let teachBtn = document.getElementById("btn")
teachBtn.addEventListener('click',function(){
    console.log(this);
    tngService.doTeach();
    tngService.doTeach.call(tnr);
})

teachBtn.addEventListener('click',()=>{
    console.log(this);
    tngService.doTeach();
    tngService.doTeach.call(tnr);
})

teachBtn.addEventListener('click',tngService.doTeach())




