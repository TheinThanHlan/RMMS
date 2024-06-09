import { Component } from '@angular/core';
import { VarsService } from '../../../../global/vars/vars.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Table_ } from '@bean/Table_';
import { Voucher } from '@bean/Voucher';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { AddSomethingNewComponent } from '../../../../components/add-something-new/add-something-new.component';
import { FormsModule } from '@angular/forms';
import { SalesDetailComponent } from '../sales-detail/sales-detail.component';
import { VoucherService } from '@service/Voucher.service';
import { Restaurant } from '@bean/Restaurant';
import { State } from '@bean/State';
import { Table_Service } from '@service/Table_.service';
import { VoucherVarsService } from '../../../../global/voucherVars/voucher-vars.service';
import { LoadingComponent } from '../../../../components/loading/loading.component';

@Component({
  selector: 'app-voucher-list',
  standalone: true,
  imports: [LoadingComponent, RouterModule, MatIconModule, MatFormFieldModule, MatSelectModule, MatInputModule, AddSomethingNewComponent, CommonModule, FormsModule, SalesDetailComponent],
  templateUrl: './voucher-list.component.html',
  styleUrl: './voucher-list.component.scss'
})
export class VoucherListComponent {
  salesOutlet = "salesOutlet"
  isVoucherLoaded = false
  constructor(public vars: VarsService,
    private voucherService: VoucherService,
    private table_Service: Table_Service,
    public voucherVarsService: VoucherVarsService
  ) { }






  filterTable_name = ""
  openedDetail = false
  add_voucher_model_data = {
    name: "Add voucher",
    show: false,
    ERROR_MESSAGE: "",
    ok: "Add",
    cancel: "Cancel"
  }

  public voucher_table!: Table_;




  goDetailPage() {
    this.openedDetail = true;
  }
  backFromDetailPage() {
    this.openedDetail = false;
  }



  sortTableByVoucher() {
    return this.vars.getCurrentRestaurantTable_s().sort((a: Table_, b: Table_) => {
      return a.name <= b.name ? -1 : 1;
    })
  }

  sortVoucherByTable() {
    return [...this.voucherVarsService.getVouchers().values()].sort((a: Voucher, b: Voucher) => {
      if (a.state.id == this.vars.getVoucherStates().get("Open")!.id) {
        if (a.table_.name < b.table_.name) {
          return -5
        }
        else {
          return -4
        }
      } else {
        return 1
      }
    })
  }



  addVoucher() {
    let tmp_voucher = new Voucher();
    tmp_voucher.table_ = new Table_();
    tmp_voucher.restaurant = new Restaurant();
    tmp_voucher.table_.id = this.voucher_table.id
    tmp_voucher.restaurant.id = this.vars.getCurrentRestaurant().id
    tmp_voucher.state = this.vars.getVoucherStates().get("Open")!;
    this.voucherService.createVoucher(tmp_voucher).subscribe((data) => {
      if (data != null) {
        data.table_ = this.voucher_table
        this.voucherVarsService.getVouchers().set(data.id, data)
        this.resetAllData()
        this.add_voucher_model_data.show = false
      }
      else {
        this.add_voucher_model_data.ERROR_MESSAGE = "Server Error"
      }
    })
  }


  resetAllData() {
    this.voucher_table = new Table_()
  }

}
