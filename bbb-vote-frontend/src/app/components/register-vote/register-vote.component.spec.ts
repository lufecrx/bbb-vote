import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterVoteComponent } from './register-vote.component';

describe('RegisterVoteComponent', () => {
  let component: RegisterVoteComponent;
  let fixture: ComponentFixture<RegisterVoteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RegisterVoteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RegisterVoteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
