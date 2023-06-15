import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { EMPTY, Observable, Subject, catchError, map } from "rxjs";
import { Motorista } from "src/app/models/motorista.model";
import { ResponseId } from "../models/responseId.model";
import { Carro } from "../models/carro.model";
import { Corrida } from "../models/corrida.model";


@Injectable ({
    providedIn: 'root'
  })
export class CorridaService{

  apiUrl = "http://localhost:8080/corridas";

    constructor(private http : HttpClient){}

    cadastrarCorrida(corrida: any): Observable<ResponseId> {

        const headers= new HttpHeaders()
            .set('content-type', 'application/json')
            .set('Access-Control-Allow-Origin', '*');

        return this.http.post<ResponseId>(`${ this.apiUrl }`, JSON.stringify(corrida), {
            headers : headers
        });
    }

    readById(id: any): Observable<Corrida> {
        const url = `${this.apiUrl}/${id}`
        return this.http.get<Corrida>(url).pipe(
          map((obj) => obj),
          catchError((e) => this.errorHandler(e))
          );
    
    }

    readCorridasByMotoristaId(motoristaId: any): Observable<Corrida[]> {
        const url = `${this.apiUrl}/${motoristaId}`
        return this.http.get<Corrida[]>(url).pipe(
          map((obj) => obj),
          catchError((e) => this.errorHandler(e))
          );
    
    }

    getAllCorridas(): Observable<Corrida[]> {
        const url = `${this.apiUrl}`
        return this.http.get<Corrida[]>(url).pipe(
          map((obj) => obj),
          catchError((e) => this.errorHandler(e))
          );
    
    }

    deleteById(id: any): Observable<void> {
        const url = `${this.apiUrl}/${id}`
        return this.http.delete<void>(url).pipe(
          map((obj) => obj),
          catchError((e) => this.errorHandler(e))
          );
    
    }

    adicionarOuRemoverPassageiro(dados:any): Observable<ResponseId> {
      const headers= new HttpHeaders()
          .set('content-type', 'application/json')
          .set('Access-Control-Allow-Origin', '*');
      return this.http.post<ResponseId>(`${ this.apiUrl }/passageiros`, JSON.stringify(dados),{
        headers : headers
    });
  }

    errorHandler(e: any): Observable<any>{
        console.log("erro: " + e);
        return EMPTY
      }

}