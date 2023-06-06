import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Motorista } from 'src/app/models/motorista.model';
import { CorridaService } from 'src/app/services/corrida.service';
import { Corrida } from 'src/app/models/corrida.model';

@Component({
  selector: 'corridas-passageiro-component',
  templateUrl: './corridas-passageiro.component.html',
  styleUrls: []
})
export class CorridasPassageiroComponent implements OnInit{

  id = "";
  origem = new FormControl('');
  destino = new FormControl('');
  motorista: Motorista | undefined;
  novaCorrida = false;
  corridas: Corrida[] | undefined; 

  constructor(
    private corridaService: CorridaService,
    private route: ActivatedRoute,
    private router: Router
    ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id')!;  
    this.id = id;
    if(id){
      this.corridaService.getAllCorridas().subscribe(response =>{
        this.corridas = response;
      })
      console.log(id)
    }

  }

  ativarCadastro(){
    this.novaCorrida = !this.novaCorrida;
  }

}
