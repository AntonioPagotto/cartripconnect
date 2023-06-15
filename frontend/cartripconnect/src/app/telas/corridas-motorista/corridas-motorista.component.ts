import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { PassageiroSerivce } from '../../services/passageiro.service';
import { MotoristaSerivce } from '../../services/motorista.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Motorista } from 'src/app/models/motorista.model';
import { CorridaService } from 'src/app/services/corrida.service';
import { Corrida } from 'src/app/models/corrida.model';
import { format } from 'date-fns';
import { CarroSerivce } from 'src/app/services/carro.service';
import { Carro } from 'src/app/models/carro.model';

@Component({
  selector: 'corridas-motorista-component',
  templateUrl: './corridas-motorista.component.html',
  styleUrls: []
})
export class CorridasMotoristaComponent implements OnInit{

  id = "";
  origem = new FormControl('');
  destino = new FormControl('');
  data = new FormControl('');
  carro = new FormControl('');
  motorista: Motorista | undefined;
  novaCorrida=false;
  corridas: Corrida[] | undefined; 
  carros: Carro[] | undefined;

  constructor(
    private corridaService: CorridaService,
    private motoristaService: MotoristaSerivce,
    private carroService: CarroSerivce,
    private route: ActivatedRoute,
    private router: Router
    ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id')!;  
    this.id = id;
    if(id){
      this.motoristaService.readById(id).subscribe(response => {
        this.motorista = response
      });
      this.corridaService.readCorridasByMotoristaId(this.id).subscribe(response =>{
        this.corridas = response;
      })
      this.carroService.readCarrosByMotoristaId(id).subscribe(response => {
        this.carros = response;
      });
      console.log(id)
    }

  }

  ativarCadastro(){
    this.novaCorrida = !this.novaCorrida;
  }

  cadastrarCorrida(){

    const corrida = {
      origem: this.origem.value,
      destino: this.destino.value,
      data: this.data.value,
      carro: this.carro.value,
      motoristaId: this.id
    };

    this.corridaService.cadastrarCorrida(corrida).subscribe(res => {
      this.novaCorrida = !this.novaCorrida
      this.ngOnInit();
    });    
  }


  apagar(id: string){
    this.corridaService.deleteById(id).subscribe(response => this.ngOnInit());
  }

  formataEssaMerda(data: string): string{
    return format(new Date(data), "'Dia 'dd'/'MM'/'yyyy, 'às' HH'h'mm");
  }

}
