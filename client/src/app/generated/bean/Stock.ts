import {
	User
}
 from "@bean/User";
import {
	Restaurant
}
 from "@bean/Restaurant";
import {
	StockSupplier
}
 from "@bean/StockSupplier";
export class Stock     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public name!:string;
	 public stockSupplier!:Array<StockSupplier>;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):Stock{
		return Object.assign(new Stock(), json_obj)
	}
	public  clone():Stock{
		const obj:Stock=Object.assign(new Stock(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
