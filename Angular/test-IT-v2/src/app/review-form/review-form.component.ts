import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-review-form',
  templateUrl: './review-form.component.html',
  styleUrls: ['./review-form.component.css']
})
export class ReviewFormComponent implements OnInit {
  reviewForm: FormGroup;
  errors = {}

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    // this.userForm = new FormGroup({
    //   firstName: new FormControl(''),
    //   lastName: new FormControl(''),
    //   email: new FormControl('')
    // });
    // or
    this.reviewForm = this.fb.group({
      author: ['', [Validators.required, Validators.minLength(3)]],
      stars: 0,
      body:''
    })

    let authorControl = this.reviewForm.get('author');
    authorControl.valueChanges
      .subscribe(e => {
        // console.log(e)
      })

    authorControl.statusChanges
      .subscribe(e => {
        if (e === 'INVALID') {
          let errors = authorControl.errors;
          if (errors.required)
            this.errors[' authore'] = " author is required";
          if (errors.minlength)
            this.errors[' author'] = " author requires min 3 chars";
        }
        else
          delete this.errors[' author']
      })


  }
  handleBlur(control) {
    control.setValue(control.value)
  }
  loadUser(event) {
    //..
    let userModel = {
      author: 'Nag',
      stars: 4,
      //email: 'Nag@mail.com'
    }
    //this.userForm.setValue(userModel)
    this.reviewForm.patchValue(userModel);
  }
  handleFormSubmit(event) {
    if (this.reviewForm.valid) {
      let formModel = this.reviewForm.value;
      console.log(formModel);
    } else {
      console.log("invalid form..")
    }
  }

}
