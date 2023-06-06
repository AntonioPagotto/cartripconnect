import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { PassageiroSerivce } from '../../services/passageiro.service';
import { MotoristaSerivce } from '../../services/motorista.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Motorista } from 'src/app/models/motorista.model';

@Component({
  selector: 'meu-perfil-motorista-component',
  templateUrl: './meu-perfil-motorista.component.html',
  styleUrls: []
})
export class MeuPerfilMotoristaComponent implements OnInit{

  id = "";
  nome = new FormControl('');
  cpf = new FormControl('');
  telefone = new FormControl('');
  email = new FormControl(''); 
  senha = new FormControl(''); 
  motorista: Motorista | undefined;

  constructor(
    private motoristaService: MotoristaSerivce,
    private route: ActivatedRoute,
    private router: Router
    ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id')!;  
    this.id = id;
    if(id){
      this.motoristaService.readById(id).subscribe(response => {
        this.motorista = response
        this.nome.setValue(this.motorista!.nome);
        this.cpf.setValue(this.motorista!.cpf);
        this.telefone.setValue(this.motorista!.telefone);
        this.email.setValue(this.motorista!.email);
      });
      console.log(id)
    }

  }

  atualizar(){

    const motorista = {
      id: this.id,
      nome: this.nome.value,
      cpf: this.cpf.value,
      telefone: this.telefone.value,
      email: this.email.value,
    };

    console.log(JSON.stringify(motorista));

    this.motoristaService.atualizarMotorista(motorista);    
  }

  apagar(){
    this.motoristaService.deleteById(this.id).subscribe(response => this.router.navigate(['/inicio']))
  }

  meusCarros(){
    this.router.navigate(['/meus-carros/', this.id]);
  }

}
