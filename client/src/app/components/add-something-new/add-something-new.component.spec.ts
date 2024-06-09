import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSomethingNewComponent } from './add-something-new.component';

describe('AddSomethingNewComponent', () => {
  let component: AddSomethingNewComponent;
  let fixture: ComponentFixture<AddSomethingNewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddSomethingNewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddSomethingNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
