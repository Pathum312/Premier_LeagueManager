import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WinsPageComponent } from './wins-page.component';

describe('PointsPageComponent', () => {
  let component: WinsPageComponent;
  let fixture: ComponentFixture<WinsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [WinsPageComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WinsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
