import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class IsbnService {

  constructor(private http: HttpClient) { }

  getIsbn(isbn: any) {
    return this.http.get<{}[]>(`/api/v1/isbn/${isbn}`);
  }  

}
