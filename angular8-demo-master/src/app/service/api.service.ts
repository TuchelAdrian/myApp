import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../model/user.model';
import {Observable} from 'rxjs/index';
import {ApiResponse} from '../model/api.response';
import {ApiUserResponse} from '../model/api.user.response';
import {SimpleResponse} from '../response/simple.response';

@Injectable()
export class ApiService {

  constructor(private http: HttpClient) {
  }

  baseUrl = 'http://localhost:8080/user/';

  login(loginPayload): Observable<ApiResponse> {
    return this.http.post<ApiResponse>('http://localhost:8080/' + 'token/generate-token', loginPayload);
  }

  getUsers(): Observable<ApiUserResponse> {
    return this.http.get<ApiUserResponse>(this.baseUrl + 'all');
  }

  getUserById(id: number): Observable<ApiUserResponse> {
    return this.http.get<ApiUserResponse>(this.baseUrl + id);
  }

  createUser(user: User): Observable<SimpleResponse> {
    return this.http.post<SimpleResponse>(this.baseUrl + 'add', user);
  }

  updateUser(user: User): Observable<SimpleResponse> {
    return this.http.put<SimpleResponse>(this.baseUrl + 'update/' + user.id, user);
  }

  deleteUser(id: number): Observable<SimpleResponse> {
    return this.http.delete<SimpleResponse>(this.baseUrl + 'delete/' + id);
  }
}
