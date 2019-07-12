import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-team-form',
  templateUrl: './team-form.component.html',
  styleUrls: ['./team-form.component.scss']
})
export class TeamFormComponent implements OnInit {

  teamForm: FormGroup;
  errors = {}

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.teamForm = this.fb.group({
      manager_id :[],
      name: ['', [Validators.required, Validators.minLength(3)]],
      desc:''
    })

    let nameControl = this.teamForm.get('name');
    nameControl.valueChanges
      .subscribe(e => {
        // console.log(e)
      })

    nameControl.statusChanges
      .subscribe(e => {
        if (e === 'INVALID') {
          let errors = nameControl.errors;
          if (errors.required)
            this.errors[' name'] = " name is required";
          if (errors.minlength)
            this.errors[' name'] = " name requires min 3 chars";
        }
        else
          delete this.errors[' name']
      })


  }
  handleBlur(control) {
    control.setValue(control.value)
  }
  handleFormSubmit(event) {
    if (this.teamForm.valid) {
      let formModel = this.teamForm.value;
      console.log(formModel);
    } else {
      console.log("invalid form..")
    }
  }

}
