import {
	User
}
 from "@bean/User";
import {
	Restaurant
}
 from "@bean/Restaurant";
import {
	Stock
}
 from "@bean/Stock";
export class StockSupplier     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public user!:User;
	 public stock!:Array<Stock>;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):StockSupplier{
		return Object.assign(new StockSupplier(), json_obj)
	}
	public  clone():StockSupplier{
		const obj:StockSupplier=Object.assign(new StockSupplier(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
