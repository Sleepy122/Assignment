import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import{HttpClient, HttpClientModule, HttpHeaders, HttpParams} from '@angular/common/http';
import { FormsModule, ReactiveFormsModule }   from '@angular/forms';

import{HttpServiceService} from './services/http-service.service'
import{ValidationService} from './services/validation.service'

import { AppComponent } from './app.component';
import { TableComponent } from './components/table/table.component';
import { ErrorMessagesComponent } from './components/error-messages/error-messages.component';


@NgModule({
  declarations: [
    AppComponent,
    TableComponent,
    ErrorMessagesComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [
    HttpServiceService,
    ValidationService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
