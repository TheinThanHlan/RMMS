import { Component } from '@angular/core';
import { AddSomethingNewComponent } from '../../../components/add-something-new/add-something-new.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Employee } from '@bean/Employee';
import { User } from '@bean/User';
import { VarsService } from '../../../global/vars/vars.service';
import { withFetch } from '@angular/common/http';
import { UserService } from '@service/User.service';
import { EmployeeService } from '@service/Employee.service';
import { catchError, from } from 'rxjs';
import { Clipboard } from "@angular/cdk/clipboard"
@Component({
  selector: 'app-employees',
  standalone: true,
  imports: [CommonModule, FormsModule, AddSomethingNewComponent],
  templateUrl: './employees.component.html',
  styleUrl: './employees.component.scss'
})
export class EmployeesComponent {
  public filterEmployee = ""
  tmpEmployee: Employee = new Employee();
  copiedText = ""
  constructor(private clipboard: Clipboard, public userService: UserService, public employeeService: EmployeeService, public vars: VarsService) {
    this.resetAllData()
  }

  add_employee_modal_data = {
    name: "Add employee",
    show: false,
    ERROR_MESSAGE: "",
    ok: "Add",
    cancel: "Cancel"
  }
  add_employee_type_modal_data = {
    name: "Add employee type",
    show: false,
    ERROR_MESSAGE: "",
    ok: "Add",
    cancel: "Cancel"
  }

  ngOnInit() {
    /*
    navigator.permissions.query({ name: "write-on-clipboard" }).then((result) => {
      if (result.state == "granted" || result.state == "prompt") {
        alert("Write access granted!");
      }
    });*/
  }

  addEmployee() {
    if (this.tmpEmployee.user.name != "" && this.tmpEmployee.user.userGroup != null) {
      this.userService.createUser(this.tmpEmployee.user).subscribe((data) => {
        if (data != null) {
          this.tmpEmployee.user.id = data.id
          this.tmpEmployee.user.password = data.password
          this.employeeService.createEmployee(this.tmpEmployee).subscribe((data) => {
            if (data != null) {
              this.vars.getEmployees().set(data.id, data)
              this.add_employee_modal_data.show = false
              this.resetAllData()
            }
          })
        }
      })
    } else {
      this.add_employee_modal_data.ERROR_MESSAGE = "Please fill the employee name"
    }
  }
  resetAllData() {
    this.tmpEmployee = new Employee();
    this.tmpEmployee.user = new User();
    this.tmpEmployee.user.restaurant = [this.vars.getCurrentRestaurant()!]
    this.tmpEmployee.user.loginableStatus = true
    this.add_employee_modal_data.ERROR_MESSAGE = ""

  }
  filterEmployees() {
    return [...this.vars.getEmployees().values()];
  }

  deleteEmployee(employee: Employee) {
    this.employeeService.deleteEmployee(employee.id).subscribe((data) => {
      if (data == true) {
        this.userService.deleteUser(employee.user.id).subscribe((data) => {
          if (data == true) {
            this.vars.getEmployees().delete(employee.id)
          }
        })
      }
    })
  }

  copyToClipBoard(text: string) {
    this.clipboard.copy(text)
    this.copiedText = text




  }
}
