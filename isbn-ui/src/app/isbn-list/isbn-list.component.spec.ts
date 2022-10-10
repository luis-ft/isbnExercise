import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IsbnListComponent } from './isbn-list.component';

describe('IsbnListComponent', () => {
  let component: IsbnListComponent;
  let fixture: ComponentFixture<IsbnListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IsbnListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IsbnListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
