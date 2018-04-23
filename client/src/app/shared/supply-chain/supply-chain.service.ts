import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";
import {OptimizeParameter, SupplyChainDTO} from "../entities";

@Injectable()
export class SupplyChainService {
  public API = '//localhost:8080';
  public SUPPLY_CHAIN_API = this.API + '/api/supplyChain';

  constructor(private http: HttpClient) { }

  getAll(): Observable<SupplyChainDTO[]> {
    return this.http.get<SupplyChainDTO[]>(this.SUPPLY_CHAIN_API + '/getAll');
  }

  optimize(parameter: OptimizeParameter): Observable<SupplyChainDTO> {
    return this.http.post<SupplyChainDTO>(this.SUPPLY_CHAIN_API + '/optimize', parameter);
  }

}
