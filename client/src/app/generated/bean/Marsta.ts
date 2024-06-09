import {
	User
}
 from "@bean/User";
import {
	Restaurant
}
 from "@bean/Restaurant";
export class Marsta     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public name!:string;
	 public users!:Array<User>;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):Marsta{
		return Object.assign(new Marsta(), json_obj)
	}
	public  clone():Marsta{
		const obj:Marsta=Object.assign(new Marsta(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
