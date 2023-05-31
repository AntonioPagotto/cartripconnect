import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { EMPTY, Observable, Subject, catchError, map } from "rxjs";
import { Passageiro } from "src/app/models/passageiro.model";
import { ResponseId } from "src/app/models/responseId.model";


@Injectable ({
    providedIn: 'root'
  })
export class PassageiroSerivce{

  apiUrl = "http://localhost:8080/passageiros";

    constructor(private http : HttpClient){}

    loginPassageiro(login: any): Observable<ResponseId> {

        const headers= new HttpHeaders()
            .set('content-type', 'application/json')
            .set('Access-Control-Allow-Origin', '*');

        return this.http.post<ResponseId>(`${ this.apiUrl }/login`, JSON.stringify(login), {
            headers : headers
        });
    }

    cadastrarPassageiro(passageiro: any){

        const headers= new HttpHeaders()
            .set('content-type', 'application/json')
            .set('Access-Control-Allow-Origin', '*');

        this.http.post(`${ this.apiUrl }`, JSON.stringify(passageiro), {
            headers : headers
        })
        .subscribe(resultado => resultado);
    }

    readById(id: any): Observable<Passageiro> {
        const url = `${this.apiUrl}/${id}`
        return this.http.get<Passageiro>(url).pipe(
          map((obj) => obj),
          catchError((e) => this.errorHandler(e))
          );
    
    }

    atualizarPassageiro(passageiro: any){

        const headers= new HttpHeaders()
            .set('content-type', 'application/json')
            .set('Access-Control-Allow-Origin', '*');

        this.http.put(`${ this.apiUrl }/${passageiro.id}`, JSON.stringify(passageiro), {
            headers : headers
        })
        .subscribe(resultado => resultado);
    }

    errorHandler(e: any): Observable<any>{
        console.log("erro: " + e);
        return EMPTY
      }


}