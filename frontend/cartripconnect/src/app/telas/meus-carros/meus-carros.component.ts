import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MotoristaSerivce } from '../../services/motorista.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Motorista } from 'src/app/models/motorista.model';
import { CarroSerivce } from 'src/app/services/carro.service';
import { Carro } from 'src/app/models/carro.model';

@Component({
  selector: 'meus-carros-component',
  templateUrl: './meus-carros.component.html',
  styleUrls: []
})
export class MeusCarrosComponent implements OnInit{

  id = "";
  carroNome = new FormControl('');
  carros: Carro[] | undefined;
  novoCarro = false;

  constructor(
    private carroService: CarroSerivce,
    private route: ActivatedRoute,
    private router: Router
    ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id')!;  
    this.id = id;
    if(id){
      this.carroService.readCarrosByMotoristaId(id).subscribe(response => {
        this.carros = response;
      });
    }

  }

  ativarCadastro(){
    this.novoCarro = !this.novoCarro;
  }

  cadastrarCarro(){

    const carro = {
      modelo: this.carroNome.value,
      motoristaId: this.id
    };

    this.carroService.cadastrarCarro(carro).subscribe(res => {
      this.novoCarro = !this.novoCarro
      this.ngOnInit();
    });    
  }

  apagar(id: string){
    this.carroService.deleteById(id).subscribe(response => this.ngOnInit());
  }

  voltar(){
    this.router.navigate(['/meu-perfil-motorista/', this.id]);
  }
}
