import { TestBed, inject } from '@angular/core/testing';

import { SupplyChainService } from './supply-chain.service';

describe('SupplyChainService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SupplyChainService]
    });
  });

  it('should be created', inject([SupplyChainService], (service: SupplyChainService) => {
    expect(service).toBeTruthy();
  }));
});
