import {
	User
}
 from "@bean/User";
import {
	Restaurant
}
 from "@bean/Restaurant";
import {
	StockOrder
}
 from "@bean/StockOrder";
import {
	Task
}
 from "@bean/Task";
import {
	EmployeeSalary
}
 from "@bean/EmployeeSalary";
export class Employee     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public user!:User;
	 public orderedStock!:Array<StockOrder>;
	 public recievedStock!:Array<StockOrder>;
	 public tasks!:Array<Task>;
	 public employeeSalary!:Array<EmployeeSalary>;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):Employee{
		return Object.assign(new Employee(), json_obj)
	}
	public  clone():Employee{
		const obj:Employee=Object.assign(new Employee(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
