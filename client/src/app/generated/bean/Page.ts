import {
	User
}
 from "@bean/User";
import {
	Restaurant
}
 from "@bean/Restaurant";
import {
	Authority
}
 from "@bean/Authority";
export class Page     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public name!:string;
	 public authorities!:Array<Authority>;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):Page{
		return Object.assign(new Page(), json_obj)
	}
	public  clone():Page{
		const obj:Page=Object.assign(new Page(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
