import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { CadastroMotoristaComponent } from './cadastro-motorista/cadastro-motorista.component';
import { CadastroPassageiroComponent } from './cadastro-passageiro/cadastro-passageiro.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CadastroMotoristaComponent,
    CadastroPassageiroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
