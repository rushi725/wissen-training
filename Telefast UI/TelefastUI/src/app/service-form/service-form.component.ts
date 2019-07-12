import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-service-form',
  templateUrl: './service-form.component.html',
  styleUrls: ['./service-form.component.scss']
})
export class ServiceFormComponent implements OnInit {

  serviceForm: FormGroup;
  errors = {}

  constructor(private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute) {}

  ngOnInit() {
    this.serviceForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      desc:''
    })

    // this.route.params.subscribe((e: any) => {
    //   this.serviceForm.patchValue(e)
    // })

    let nameControl = this.serviceForm.get('name');
    nameControl.valueChanges
      .subscribe(e => {
         //console.log(e)
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

  handleFormSubmit() {
    console.log("heueu");
    if (this.serviceForm.valid) {
      let formModel = this.serviceForm.value;
      console.log(formModel);
    } else {
      console.log("invalid form..")
    }
  }

}
