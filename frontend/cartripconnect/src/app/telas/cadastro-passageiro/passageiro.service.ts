import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";


@Injectable ({
    providedIn: 'root'
  })
export class PassageiroSerivce{

  apiUrl = "http://localhost:8080";

    constructor(private http : HttpClient){}

    cadastrarPassageiro(passageiro: any){

        const headers= new HttpHeaders()
  .set('content-type', 'application/json')
  .set('Access-Control-Allow-Origin', '*');

        this.http.post(`${ this.apiUrl }/passageiros`, JSON.stringify(passageiro), {
            headers : headers
        })
        .subscribe(resultado => {
            console.log("response " + resultado)
        }, err =>{
            console.log("erro: " + err)
        });
    }
}