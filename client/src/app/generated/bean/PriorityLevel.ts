import {
	UserGroup
}
 from "@bean/UserGroup";
import {
	Task
}
 from "@bean/Task";
export class PriorityLevel     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public name!:string;
	 public levelInDecimal!:number;
	 public tasks!:Array<Task>;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):PriorityLevel{
		return Object.assign(new PriorityLevel(), json_obj)
	}
	public  clone():PriorityLevel{
		const obj:PriorityLevel=Object.assign(new PriorityLevel(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
