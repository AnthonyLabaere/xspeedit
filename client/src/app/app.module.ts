import {BrowserModule} from '@angular/platform-browser';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';

import {MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';

import {OktaAuthModule, OktaCallbackComponent} from '@okta/okta-angular';
import {AuthInterceptor} from './shared/okta/auth.interceptor';
import {HomeComponent} from './home/home.component';
import {SupplyChainAddComponent} from './supply-chain-add/supply-chain-add.component';
import {SupplyChainListComponent} from './supply-chain-list/supply-chain-list.component';
import {SupplyChainService} from "./shared/supply-chain/supply-chain.service";

const config = {
  issuer: 'https://dev-144974.oktapreview.com/oauth2/default',
  redirectUri: 'http://localhost:4200/implicit/callback',
  clientId: '0oaes8zv363uOSkxT0h7'
};

const appRoutes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'supply-chain-list',
    component: SupplyChainListComponent
  },
  {
    path: 'supply-chain-add',
    component: SupplyChainAddComponent
  },
  {
    path: 'implicit/callback',
    component: OktaCallbackComponent
  }

];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SupplyChainAddComponent,
    SupplyChainListComponent
  ],
  imports: [
    FormsModule,
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    OktaAuthModule.initAuth(config)
  ],
  providers: [SupplyChainService,
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
