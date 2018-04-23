import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {SupplyChainService} from "../shared/supply-chain/supply-chain.service";
import {OptimizeParameter} from "../shared/entities";

@Component({
  selector: 'app-supply-chain-add',
  templateUrl: './supply-chain-add.component.html',
  styleUrls: ['./supply-chain-add.component.css']
})
export class SupplyChainAddComponent implements OnInit, OnDestroy {
  parameter: OptimizeParameter = new OptimizeParameter();

  constructor(private route: ActivatedRoute,
              private router: Router,
              private supplyChainService: SupplyChainService){

  }

  ngOnInit() {
  }

  ngOnDestroy() {
  }

  gotoList() {
    this.router.navigate(['/supply-chain-list']);
  }

  save() {
    this.supplyChainService.optimize(this.parameter).subscribe(() => {
      this.gotoList();
    }, error => console.error(error));
  }
}
