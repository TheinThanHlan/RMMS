import { TestBed } from '@angular/core/testing';

import { MenuOrderVarsService } from './menu-order-vars.service';

describe('MenuOrderVarsService', () => {
  let service: MenuOrderVarsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MenuOrderVarsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
