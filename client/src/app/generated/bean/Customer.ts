import {
	User
}
 from "@bean/User";
import {
	Restaurant
}
 from "@bean/Restaurant";
export class Customer     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public user!:User;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):Customer{
		return Object.assign(new Customer(), json_obj)
	}
	public  clone():Customer{
		const obj:Customer=Object.assign(new Customer(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
