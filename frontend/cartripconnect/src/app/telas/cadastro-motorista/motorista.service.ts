import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";


@Injectable ({
    providedIn: 'root'
  })
export class MotoristaSerivce{

  apiUrl = "http://localhost:8080";

    constructor(private http : HttpClient){}

    cadastrarMotorista(motorista: any){

        const headers= new HttpHeaders()
  .set('content-type', 'application/json')
  .set('Access-Control-Allow-Origin', '*');

        this.http.post(`${ this.apiUrl }/motoristas`, JSON.stringify(motorista), {
            headers : headers
        })
        .subscribe(resultado => {
            console.log("response " + resultado)
        }, err =>{
            console.log("erro: " + err)
        });
    }
}