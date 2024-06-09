import {
	Employee
}
 from "@bean/Employee";
import {
	Restaurant
}
 from "@bean/Restaurant";
import {
	Authority
}
 from "@bean/Authority";
export class EmployeeSalary     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public employee!:Employee;
	 public salary!:number;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):EmployeeSalary{
		return Object.assign(new EmployeeSalary(), json_obj)
	}
	public  clone():EmployeeSalary{
		const obj:EmployeeSalary=Object.assign(new EmployeeSalary(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
