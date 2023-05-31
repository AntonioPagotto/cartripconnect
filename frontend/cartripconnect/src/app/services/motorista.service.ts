import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { EMPTY, Observable, Subject, catchError, map } from "rxjs";
import { Motorista } from "src/app/models/motorista.model";
import { ResponseId } from "../models/responseId.model";


@Injectable ({
    providedIn: 'root'
  })
export class MotoristaSerivce{

  apiUrl = "http://localhost:8080/motoristas";

    constructor(private http : HttpClient){}

    loginMotorista(login: any): Observable<ResponseId> {
    
        const headers= new HttpHeaders()
            .set('content-type', 'application/json')
            .set('Access-Control-Allow-Origin', '*');

        return this.http.post<ResponseId>(`${ this.apiUrl }/login`, JSON.stringify(login), {
            headers : headers
        });
    }

    cadastrarMotorista(motorista: any){

        const headers= new HttpHeaders()
            .set('content-type', 'application/json')
            .set('Access-Control-Allow-Origin', '*');

        this.http.post(`${ this.apiUrl }`, JSON.stringify(motorista), {
            headers : headers
        })
        .subscribe(resultado => {
            console.log("response " + resultado)
        }, err =>{
            console.log("erro: " + err)
        });
    }

    readById(id: any): Observable<Motorista> {
        const url = `${this.apiUrl}/${id}`
        return this.http.get<Motorista>(url).pipe(
          map((obj) => obj),
          catchError((e) => this.errorHandler(e))
          );
    
    }

    atualizarMotorista(motorista: any){

        const headers= new HttpHeaders()
            .set('content-type', 'application/json')
            .set('Access-Control-Allow-Origin', '*');

        this.http.put(`${ this.apiUrl }/${motorista.id}`, JSON.stringify(motorista), {
            headers : headers
        })
        .subscribe(resultado => resultado);
    }

    errorHandler(e: any): Observable<any>{
        console.log("erro: " + e);
        return EMPTY
      }

}