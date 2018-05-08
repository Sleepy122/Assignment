import { Injectable } from '@angular/core';
import{HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Inventory } from '../entities/Inventory';



@Injectable()

export class HttpServiceService {
  url: string = "http://localhost:8080/inventory/";
  

  constructor(private http:HttpClient) { }

  getAllInventory():Observable<Inventory[]>{
    return this.http.get<Inventory[]>(this.url + "getAllItems");

  }

  updateInventory(item:Inventory){
    this.http.post(this.url + "setItem",item).subscribe();
  }

  createInventory(item:Inventory){
    console.log("got here");
    this.http.post(this.url + "createItem",item).subscribe();
  }

  deleteInventory(pk:string){
    this.http.post(this.url + "deleteItem",pk).subscribe();
  }

}
