import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { VarsService } from '../../../global/vars/vars.service';
import { SalesDetailComponent } from './sales-detail/sales-detail.component';
import { Voucher } from '@bean/Voucher';
import { Table_ } from '@bean/Table_';
import { AddSomethingNewComponent } from '../../../components/add-something-new/add-something-new.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatIconModule } from '@angular/material/icon';
import { VoucherListComponent } from './voucher-list/voucher-list.component';
import { RouterModule } from '@angular/router';
import { VoucherVarsService } from '../../../global/voucherVars/voucher-vars.service';
import { LoadingComponent } from '../../../components/loading/loading.component';
@Component({
  selector: 'app-sales',
  standalone: true,
  imports: [LoadingComponent, RouterModule, VoucherListComponent, MatIconModule, MatFormFieldModule, MatSelectModule, MatInputModule, AddSomethingNewComponent, CommonModule, FormsModule, SalesDetailComponent],
  templateUrl: './sales.component.html',
  styleUrl: './sales.component.scss'
})
export class SalesComponent {
  isAllDataLoaded = false
  constructor(public vars: VarsService,
    public voucherVars: VoucherVarsService) {
  }

  ngAfterViewInit() {
    this.voucherVars.loadTodayVouchers().then((data) => {
      if (data != undefined) {
        this.isAllDataLoaded = data
      }
    })
  }
}
