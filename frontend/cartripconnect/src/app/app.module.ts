import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { LoginComponent } from './telas/login/login.component';
import { CadastroMotoristaComponent } from './telas/cadastro-motorista/cadastro-motorista.component';
import { CadastroPassageiroComponent } from './telas/cadastro-passageiro/cadastro-passageiro.component';
import { ReactiveFormsModule } from '@angular/forms';
import { PassageiroSerivce } from './telas/cadastro-passageiro/passageiro.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CadastroMotoristaComponent,
    CadastroPassageiroComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [PassageiroSerivce],
  bootstrap: [AppComponent]
})
export class AppModule { }
