import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { MotoristaSerivce } from '../../services/motorista.service';
import { ResponseId } from 'src/app/models/responseId.model';

@Component({
  selector: 'login-motorista-component',
  templateUrl: './login-motorista.component.html',
  styleUrls: []
})
export class LoginMotoristaComponent {

  email = new FormControl('');
  senha = new FormControl(''); 
  idMotorista!: ResponseId;
  error = false;

  constructor(private appService : MotoristaSerivce, private router: Router) {}


  login(){
    this.error = false;
    const login = {
      email: this.email.value,
      senha: this.senha.value,
    };

    this.appService.loginMotorista(login).subscribe(response =>{
      this.idMotorista = response;
      if(response){
        this.router.navigate(['/meu-perfil-motorista/', this.idMotorista.id]);
      }
    }, err =>{
      this.error = true;
      console.log("Erro ao logar!: " + err)
    });

  }


}
