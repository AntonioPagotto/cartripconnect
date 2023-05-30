import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { PassageiroSerivce } from './passageiro.service';

@Component({
  selector: 'cadastro-passageiro-component',
  templateUrl: './cadastro-passageiro.component.html',
  styleUrls: ['./cadastro-passageiro.component.css']
})
export class CadastroPassageiroComponent {


  nome = new FormControl('');
  cpf = new FormControl('');
  telefone = new FormControl('');
  email = new FormControl(''); 
  senha = new FormControl(''); 
  meioDePagamento = new FormControl(''); 

  constructor(private appService : PassageiroSerivce) {}

  cadastrarPassageiro(){

    const passageiro = {
      nome: this.nome.value,
      cpf: this.cpf.value,
      telefone: this.telefone.value,
      email: this.email.value,
      senha: this.senha.value,
      meioDePagamento: this.meioDePagamento.value,
    };

    console.log(JSON.stringify(passageiro));

    this.appService.cadastrarPassageiro(passageiro);    
  }

}
