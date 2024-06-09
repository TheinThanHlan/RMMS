import {
	UserGroup
}
 from "@bean/UserGroup";
import {
	Task
}
 from "@bean/Task";
export class Schedule     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public name!:string;
	 public cronJobCode!:string;
	 public tasks!:Array<Task>;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):Schedule{
		return Object.assign(new Schedule(), json_obj)
	}
	public  clone():Schedule{
		const obj:Schedule=Object.assign(new Schedule(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
