import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupplyChainAddComponent } from './supply-chain-add.component';

describe('SupplyChainAddComponent', () => {
  let component: SupplyChainAddComponent;
  let fixture: ComponentFixture<SupplyChainAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupplyChainAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupplyChainAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
