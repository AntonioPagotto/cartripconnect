import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { ROUTES } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { LoginMotoristaComponent } from './telas/login-motorista/login-motorista.component';
import { CadastroMotoristaComponent } from './telas/cadastro-motorista/cadastro-motorista.component';
import { CadastroPassageiroComponent } from './telas/cadastro-passageiro/cadastro-passageiro.component';
import { ReactiveFormsModule } from '@angular/forms';
import { PassageiroSerivce } from './services/passageiro.service';
import { MeuPerfilPassageiroComponent } from './telas/meu-perfil-passageiro/meu-perfil-passageiro.component';
import { MeuPerfilMotoristaComponent } from './telas/meu-perfil-motorista/meu-perfil-motorista.component';
import { LoginPassageiroComponent } from './telas/login-passageiro/login-passageiro.component';
import { RouterModule } from '@angular/router';
import { InicioComponent } from './telas/inicio/inicio.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginMotoristaComponent,
    LoginPassageiroComponent,
    CadastroMotoristaComponent,
    CadastroPassageiroComponent,
    MeuPerfilPassageiroComponent,
    MeuPerfilMotoristaComponent,
    InicioComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(ROUTES)
  ],
  providers: [PassageiroSerivce],
  bootstrap: [AppComponent],
  exports:[RouterModule]
})
export class AppModule { }
