import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { EMPTY, Observable, Subject, catchError, map } from "rxjs";
import { Motorista } from "src/app/models/motorista.model";
import { ResponseId } from "../models/responseId.model";
import { Carro } from "../models/carro.model";


@Injectable ({
    providedIn: 'root'
  })
export class CarroSerivce{

  apiUrl = "http://localhost:8080/carros";

    constructor(private http : HttpClient){}

    cadastrarCarro(carro: any): Observable<ResponseId> {

        const headers= new HttpHeaders()
            .set('content-type', 'application/json')
            .set('Access-Control-Allow-Origin', '*');

        return this.http.post<ResponseId>(`${ this.apiUrl }`, JSON.stringify(carro), {
            headers : headers
        });
    }

    readById(id: any): Observable<Carro> {
        const url = `${this.apiUrl}/${id}`
        return this.http.get<Carro>(url).pipe(
          map((obj) => obj),
          catchError((e) => this.errorHandler(e))
          );
    
    }

    readCarrosByMotoristaId(motoristaId: any): Observable<Carro[]> {
        const url = `${this.apiUrl}/motorista/${motoristaId}`
        return this.http.get<Carro[]>(url).pipe(
          map((obj) => obj),
          catchError((e) => this.errorHandler(e))
          );
    
    }

    atualizarCarro(carro: any){

        const headers= new HttpHeaders()
            .set('content-type', 'application/json')
            .set('Access-Control-Allow-Origin', '*');

        this.http.put(`${ this.apiUrl }/${carro.id}`, JSON.stringify(carro), {
            headers : headers
        })
        .subscribe(resultado => resultado);
    }

    deleteById(id: any): Observable<void> {
        const url = `${this.apiUrl}/${id}`
        return this.http.delete<void>(url).pipe(
          map((obj) => obj),
          catchError((e) => this.errorHandler(e))
          );
    
    }

    errorHandler(e: any): Observable<any>{
        console.log("erro: " + e);
        return EMPTY
      }

}