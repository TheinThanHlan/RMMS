import {
	User
}
 from "@bean/User";
import {
	Restaurant
}
 from "@bean/Restaurant";
import {
	DeliveryMethod
}
 from "@bean/DeliveryMethod";
export class Delivery     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public user!:User;
	 public deliveryMethods!:Array<DeliveryMethod>;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):Delivery{
		return Object.assign(new Delivery(), json_obj)
	}
	public  clone():Delivery{
		const obj:Delivery=Object.assign(new Delivery(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
