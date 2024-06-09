import {
	UserGroup
}
 from "@bean/UserGroup";
import {
	Employee
}
 from "@bean/Employee";
import {
	Schedule
}
 from "@bean/Schedule";
import {
	PriorityLevel
}
 from "@bean/PriorityLevel";
export class Task     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public description!:string;
	 public dueDateTime!:Date;
	 public employeeGroup!:UserGroup;
	 public employees!:Array<Employee>;
	 public priorityLevel!:PriorityLevel;
	 public schedule!:Schedule;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):Task{
		return Object.assign(new Task(), json_obj)
	}
	public  clone():Task{
		const obj:Task=Object.assign(new Task(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
