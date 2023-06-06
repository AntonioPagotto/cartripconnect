import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MotoristaSerivce } from '../../services/motorista.service';
import { Router } from '@angular/router';

@Component({
  selector: 'cadastro-motorista-component',
  templateUrl: './cadastro-motorista.component.html',
  styleUrls: []
})
export class CadastroMotoristaComponent {

  nome = new FormControl('');
  cpf = new FormControl('');
  telefone = new FormControl('');
  email = new FormControl(''); 
  senha = new FormControl(''); 
  meioDePagamento = new FormControl(''); 

  constructor(private appService : MotoristaSerivce, private router: Router) {}

  cadastrarMotorista(){

    const motorista = {
      nome: this.nome.value,
      cpf: this.cpf.value,
      telefone: this.telefone.value,
      email: this.email.value,
      senha: this.senha.value,
    };

    console.log(JSON.stringify(motorista));

    this.appService.cadastrarMotorista(motorista).subscribe(response => {
      this.router.navigate(['/meu-perfil-motorista/', response.id]);
    });    
  }
}
