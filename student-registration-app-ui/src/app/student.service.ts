import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http: HttpClient) { }

 

  getQualificationList(): Observable<any>{
    return this.http.get(`http://localhost:8081/student-registration/api/v1/qualification`);
  }

  createStudent(student : Object): Observable<Object> {
    return this.http.post(`http://localhost:8081/student-registration/api/v1/student`, student);
  }

  getStudentsList(): Observable<any> {
    return this.http.get(`http://localhost:8081/student-registration/api/v1/students`);
  }

}
