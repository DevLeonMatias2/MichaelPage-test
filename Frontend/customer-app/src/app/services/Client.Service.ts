import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {ClientModel} from "../models/ClientModel";
import {map} from "rxjs/operators";


@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private url = 'http://localhost:8081/michaelpage';

  headers: HttpHeaders;

  constructor(private http: HttpClient) {
  }

  createClient(client: ClientModel) {
    return this.http.post(`${this.url}/client/new`, client)
      .pipe(
        map((resp: ClientModel) => {
          return resp;
        })
      )
  }


  getUsuarios() {
    return this.http.get(`${this.url}/client/report`, {headers: this.headers}).pipe(
      map((resp: ClientModel) => {
        return resp;
      })
    )
  }

}
