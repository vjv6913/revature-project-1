import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcceptedOrderComponent } from './accepted-order.component';

describe('AcceptedOrderComponent', () => {
  let component: AcceptedOrderComponent;
  let fixture: ComponentFixture<AcceptedOrderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AcceptedOrderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AcceptedOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
