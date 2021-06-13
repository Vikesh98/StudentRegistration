import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Qualification } from '../qualification';
import { Student } from '../student';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-student-registration',
  templateUrl: './student-registration.component.html',
  styleUrls: ['./student-registration.component.css']
})
export class StudentRegistrationComponent implements OnInit {

  student: Student = new Student();
  students: Observable<Student[]>;
  submitted = false;
  qual: Qualification[];
  test :{ 'id':number, 'qualification':string};
  selectedType: Qualification;
  date: Date;
  form: FormGroup;
  show = false;
  populate = false;
 

  constructor(private studentService: StudentService, private router: Router, private formBuilder: FormBuilder) {
 

    
  }

  ngOnInit():void {

  
    this.getQualification();
    this.reloadData();

  }

  public getQualification() {

    this.studentService.getQualificationList().subscribe(
      response => {
        if (response != null && response != undefined) {
            console.log(response);
            debugger;
            this.qual = response;
        }

      });
  }

  addStudent(student){
  
    this.show = !this.show;
    this.submitted = !this.submitted;

    let day = JSON.stringify(this.date);
    day = day.replace(/[{()}"]/g, '');
    var res = day.split(",");
    let year = res[0].replace( /^\D+/g, '');
    let month = res[1].replace( /^\D+/g, '');
    month = month.length > 1 ? month : '0' + month;
    let da = res[2].replace( /^\D+/g, '');
    da = da.length > 1 ? da : '0' + da;
    console.log(da+""+month+""+year);
    let value =year + '-' + month + '-' + da + 'T' + '00:00:00.000+0000';

    student.dob = value;
    student.qualification= this.test.qualification;


 


  this.studentService
    .createStudent(this.student).subscribe(data => {
      console.log(data)
      this.student = new Student();
   //   this.gotoList();
    }, 
    error => console.log(error));
    

  }

  getStudents()
  {
    this.populate = !this.populate;
  }

  reloadData() {
    this.students = this.studentService.getStudentsList();
  }


  gotoList() {
    this.router.navigate(['/employees']);
  }



    submit() {
      console.log(this.form.value);
    }


    
}
