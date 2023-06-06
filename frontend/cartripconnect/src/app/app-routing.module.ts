import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroMotoristaComponent } from './telas/cadastro-motorista/cadastro-motorista.component';
import { CadastroPassageiroComponent } from './telas/cadastro-passageiro/cadastro-passageiro.component';
import { MeuPerfilPassageiroComponent } from './telas/meu-perfil-passageiro/meu-perfil-passageiro.component';
import { LoginPassageiroComponent } from './telas/login-passageiro/login-passageiro.component';
import { LoginMotoristaComponent } from './telas/login-motorista/login-motorista.component';
import { InicioComponent } from './telas/inicio/inicio.component';
import { MeuPerfilMotoristaComponent } from './telas/meu-perfil-motorista/meu-perfil-motorista.component';
import { MeusCarrosComponent } from './telas/meus-carros/meus-carros.component';
import { CorridasMotoristaComponent } from './telas/corridas-motorista/corridas-motorista.component';
import { CorridasPassageiroComponent } from './telas/corridas-passageiro/corridas-passageiro.component';

export const ROUTES: Routes = [
  { path: '', component: InicioComponent },
  { path: 'inicio', component: InicioComponent },
  { path: 'login-passageiro', component: LoginPassageiroComponent },
  { path: 'login-motorista', component: LoginMotoristaComponent },
  { path: 'meu-perfil-passageiro/:id', component: MeuPerfilPassageiroComponent },
  { path: 'meu-perfil-motorista/:id', component: MeuPerfilMotoristaComponent },
  { path: 'cadastro-motorista', component: CadastroMotoristaComponent },
  { path: 'cadastro-passageiro', component: CadastroPassageiroComponent },
  { path: 'meus-carros/:id', component: MeusCarrosComponent },
  { path: 'corridas-motorista/:id', component: CorridasMotoristaComponent },
  { path: 'corridas-passageiro/:id', component: CorridasPassageiroComponent },
];


