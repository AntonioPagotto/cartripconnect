import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroMotoristaComponent } from './telas/cadastro-motorista/cadastro-motorista.component';
import { CadastroPassageiroComponent } from './telas/cadastro-passageiro/cadastro-passageiro.component';
import { LoginComponent } from './telas/login/login.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'cadastro-motorista', component: CadastroMotoristaComponent },
  { path: 'cadastro-passageiro', component: CadastroPassageiroComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 



}
