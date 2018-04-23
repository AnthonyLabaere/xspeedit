import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupplyChainListComponent } from './supply-chain-list.component';

describe('SupplyChainListComponent', () => {
  let component: SupplyChainListComponent;
  let fixture: ComponentFixture<SupplyChainListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupplyChainListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupplyChainListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
