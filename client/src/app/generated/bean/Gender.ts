import {
	User
}
 from "@bean/User";
import {
	Restaurant
}
 from "@bean/Restaurant";
export class Gender     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public name!:string;
	 public users!:Array<User>;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):Gender{
		return Object.assign(new Gender(), json_obj)
	}
	public  clone():Gender{
		const obj:Gender=Object.assign(new Gender(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
