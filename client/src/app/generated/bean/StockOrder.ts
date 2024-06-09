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
	StockOrderStatus
}
 from "@bean/StockOrderStatus";
import {
	Employee
}
 from "@bean/Employee";
export class StockOrder     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public stock!:Stock;
	 public orderedEmployee!:Employee;
	 public orderedQuantity!:number;
	 public recievedEmployee!:Employee;
	 public stockOrderStatus!:StockOrderStatus;
	 public recievedQuantity!:number;
	 public price!:number;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):StockOrder{
		return Object.assign(new StockOrder(), json_obj)
	}
	public  clone():StockOrder{
		const obj:StockOrder=Object.assign(new StockOrder(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
