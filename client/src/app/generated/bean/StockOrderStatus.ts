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
import {
	Stock
}
 from "@bean/Stock";
import {
	StockOrder
}
 from "@bean/StockOrder";
import {
	Employee
}
 from "@bean/Employee";
export class StockOrderStatus     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public name!:string;
	 public guiColor!:string;
	 public stockOrder!:Array<StockOrder>;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):StockOrderStatus{
		return Object.assign(new StockOrderStatus(), json_obj)
	}
	public  clone():StockOrderStatus{
		const obj:StockOrderStatus=Object.assign(new StockOrderStatus(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
