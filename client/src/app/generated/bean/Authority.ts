import {
	User
}
 from "@bean/User";
import {
	Restaurant
}
 from "@bean/Restaurant";
import {
	Page
}
 from "@bean/Page";
export class Authority     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public restaurants!:Array<Restaurant>;
	 public pages!:Array<Page>;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):Authority{
		return Object.assign(new Authority(), json_obj)
	}
	public  clone():Authority{
		const obj:Authority=Object.assign(new Authority(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
