import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-todo-form',
  templateUrl: './todo-form.component.html',
  styleUrls: ['./todo-form.component.css']
})
export class TodoFormComponent implements OnInit {

  todoForm: FormGroup;
  errors = {}
  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.todoForm = this.fb.group({
      title: ['', [Validators.required, Validators.minLength(3)]],
      body:''
    })

    let titleControl = this.todoForm.get('title');
    titleControl.valueChanges
      .subscribe(e => {
        // console.log(e)
      })

    titleControl.statusChanges
      .subscribe(e => {
        if (e === 'INVALID') {
          let errors = titleControl.errors;
          if (errors.required)
            this.errors['title'] = " title is required";
          if (errors.minlength)
            this.errors['title'] = " title requires min 3 chars";
        }
        else
          delete this.errors[' title']
      })


  }
  handleBlur(control) {
    control.setValue(control.value)
  }

  handleFormSubmit(event) {
    console.log("sdjskdjskdj")
    if (this.todoForm.valid) {
      let formModel = this.todoForm.value;
      console.log(formModel);
    } else {
      console.log("invalid form..")
    }
  }

}
