import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Motorista } from 'src/app/models/motorista.model';
import { CorridaService } from 'src/app/services/corrida.service';
import { Corrida } from 'src/app/models/corrida.model';
import { format } from 'date-fns';
import { CarroSerivce } from 'src/app/services/carro.service';

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
  passageiroEstaNaCorrida=false;

  constructor(
    private corridaService: CorridaService,
    private carroService: CarroSerivce,
    private route: ActivatedRoute,
    private router: Router
    ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id')!;  
    this.id = id;
    if(id){
      this.corridaService.getAllCorridas().subscribe(response =>{
        this.corridas = response;
          console.log(response)
        this.corridas.forEach(corrida => {
          if(corrida.passageiros != null){
            if(corrida.passageiros.includes(this.id)){
              corrida.souPassageiro =  true;
            }
          }
          this.carroService.readById(corrida.carro).subscribe(carro=>{
            corrida.carro = carro.modelo
          })
        });
      })
      console.log(id)
    }

  }

  participarCorrida(corrida: string){
    console.log("entrei participar com id " + corrida)

    const bodyCorrida = {
      corridaId: corrida,
      passageiroId: this.id
    };

    this.corridaService.adicionarOuRemoverPassageiro(bodyCorrida).subscribe(response => this.ngOnInit(),
    err=>{
      if(err){

      }
    });
  }

  ativarCadastro(){
    this.novaCorrida = !this.novaCorrida;
  }

  formataEssaMerda(data: string): string{
    return format(new Date(data), "'Dia 'dd'/'MM'/'yyyy, 'às' HH'h'mm");
  }
}
