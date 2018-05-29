import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable()
export class AppService {

  constructor(private _http: HttpClient) { }

  getTruckList() {
    return this._http.get('http://www.ktrucker.tk/api/vehicles/')
    .pipe(map(r => r));
  }
}
