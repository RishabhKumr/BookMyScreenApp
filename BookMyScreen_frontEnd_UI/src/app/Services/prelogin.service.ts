import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs';

const API_URL ="http://localhost:8086/auth/v1/";

@Injectable({
  providedIn: 'root'
})
export class PreloginService {

  constructor(private http: HttpClient) { }

  fetchMovies(): Observable<any>{
    return this.http.get(API_URL+"allmovies");
  }
}
