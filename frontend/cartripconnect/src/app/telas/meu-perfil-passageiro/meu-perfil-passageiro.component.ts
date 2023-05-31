import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { PassageiroSerivce } from '../../services/passageiro.service';
import { MotoristaSerivce } from '../../services/motorista.service';
import { Passageiro } from 'src/app/models/passageiro.model';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'meu-perfil-passageiro-component',
  templateUrl: './meu-perfil-passageiro.component.html',
  styleUrls: []
})
export class MeuPerfilPassageiroComponent implements OnInit{

  id = "";
  nome = new FormControl('');
  cpf = new FormControl('');
  telefone = new FormControl('');
  email = new FormControl(''); 
  meioDePagamento = new FormControl(''); 
  passageiro: Passageiro | undefined;

  constructor(
    private passageiroService : PassageiroSerivce,
    private route: ActivatedRoute
    ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id')!;  
    this.id = id;
    if(id){
      this.passageiroService.readById(id).subscribe(response => {
        this.passageiro = response
        this.nome.setValue(this.passageiro!.nome);
        this.cpf.setValue(this.passageiro!.cpf);
        this.telefone.setValue(this.passageiro!.telefone);
        this.email.setValue(this.passageiro!.email);
        this.meioDePagamento.setValue(this.passageiro!.meioDePagamento);
      });
    }

  }

  atualizar(){

    const passageiro = {
      id: this.id,
      nome: this.nome.value,
      cpf: this.cpf.value,
      telefone: this.telefone.value,
      email: this.email.value,
      meioDePagamento: this.meioDePagamento.value,
    };

    console.log(JSON.stringify(passageiro));

    this.passageiroService.atualizarPassageiro(passageiro);    
  }

}
