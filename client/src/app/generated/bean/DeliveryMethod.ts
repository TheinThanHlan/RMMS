import {
	User
}
 from "@bean/User";
import {
	Restaurant
}
 from "@bean/Restaurant";
import {
	Delivery
}
 from "@bean/Delivery";
export class DeliveryMethod     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public user!:User;
	 public deliveries!:Array<Delivery>;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):DeliveryMethod{
		return Object.assign(new DeliveryMethod(), json_obj)
	}
	public  clone():DeliveryMethod{
		const obj:DeliveryMethod=Object.assign(new DeliveryMethod(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
