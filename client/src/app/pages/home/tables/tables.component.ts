
import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Restaurant } from '@bean/Restaurant';
import { Table_ } from '@bean/Table_';
import { Table_Service } from '@service/Table_.service';
import { withFetch } from '@angular/common/http';
import { VarsService } from '../../../global/vars/vars.service';
import { State } from '@bean/State';
import { AddSomethingNewComponent } from '../../../components/add-something-new/add-something-new.component';


@Component({
  selector: 'app-tables',
  standalone: true,
  imports: [CommonModule, FormsModule, AddSomethingNewComponent],
  templateUrl: './tables.component.html',
  styleUrl: './tables.component.scss'
})
export class TablesComponent {
  add_table_modal_data = {
    name: "Add table",
    show: false,
    ERROR_MESSAGE: "",
    ok: "Add",
    cancel: "Cancel"
  }



  tableNo: string = "";
  maxServe: number = 1;
  filterTable_Name: string = ""

  tmp_table: Table_ = new Table_();


  constructor(private table_Service: Table_Service, public vars: VarsService) { }
  ngOnInit() {
    this.resetAllData()
  }

  addTable() {
    if (this.tmp_table.name != "" && this.vars.getCurrentRestaurantTable_s().filter((data) => {
      return data.name == this.tmp_table.name
    }).length == 0
    ) {
      this.table_Service.createTable_(this.tmp_table).subscribe((data) => {
        if (data != null) {
          this.vars.addCurrentRestaurantTable_(Table_.fromJson(data))
          this.resetAllData()
        }
      })
      this.add_table_modal_data.ERROR_MESSAGE = ""
    }
    else {
      this.add_table_modal_data.ERROR_MESSAGE = "Table name already exists!"
    }
  }

  resetAllData() {
    this.tmp_table.name = ""
    this.tmp_table.maxServeCustomer = 1
    this.tmp_table.state = this.vars.getTableStates().at(0) ?? new State();
    this.add_table_modal_data.ERROR_MESSAGE = ""
    this.tmp_table.restaurant = new Restaurant();
    this.tmp_table.restaurant.id = this.vars.getCurrentRestaurant().id
  }

  delete(id: number) {
    this.table_Service.deleteTable_(id).subscribe((data) => {
      if (data == true) {
        this.vars.removeCurrentRestaurantTable_(id)
        this.resetAllData()
      }
    });
  }
  edit() {

  }
  filterTable_s(): Table_[] {
    return this.vars.getCurrentRestaurantTable_s().filter((data: Table_) => {
      return data.name.includes(this.filterTable_Name)
    }).sort((a, b) => {
      return a.name <= b.name ? -1 : 1
    })
  }
}
