import {Component, OnInit} from '@angular/core';
import {SupplyChainService} from "../shared/supply-chain/supply-chain.service";
import {SupplyChainDTO} from "../shared/entities";

@Component({
  selector: 'app-supply-chain-list',
  templateUrl: './supply-chain-list.component.html',
  styleUrls: ['./supply-chain-list.component.css']
})
export class SupplyChainListComponent implements OnInit {
  supplyChains: SupplyChainDTO[];

  constructor(private supplyChainService: SupplyChainService) { }

  ngOnInit() {
    this.supplyChainService.getAll().subscribe(data => {
      this.supplyChains = data;
    });
  }

}
