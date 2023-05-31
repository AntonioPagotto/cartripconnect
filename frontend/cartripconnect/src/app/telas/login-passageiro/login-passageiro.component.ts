import { Component } from '@angular/core';
import { PassageiroSerivce } from '../../services/passageiro.service';
import { FormControl } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { ResponseId } from 'src/app/models/responseId.model';

@Component({
  selector: 'login-passageiro-component',
  templateUrl: './login-passageiro.component.html',
  styleUrls: []
})
export class LoginPassageiroComponent {

  email = new FormControl('');
  senha = new FormControl(''); 
  idPassageiro!: ResponseId;
  error = false;

  constructor(private appService : PassageiroSerivce, private router: Router) {}


  async login(){
    this.error = false;
    const login = {
      email: this.email.value,
      senha: this.senha.value,
    };

    this.appService.loginPassageiro(login).subscribe(response =>{
      this.idPassageiro = response;
      if(response){
        this.router.navigate(['/meu-perfil-passageiro/', this.idPassageiro.id]);
      }
    }, err =>{
      this.error = true;
      console.log("Erro ao logar!: " + err)
    });
  }

}
