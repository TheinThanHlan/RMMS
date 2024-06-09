import { TestBed } from '@angular/core/testing';

import { VoucherVarsService } from './voucher-vars.service';

describe('VoucherVarsService', () => {
  let service: VoucherVarsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VoucherVarsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
