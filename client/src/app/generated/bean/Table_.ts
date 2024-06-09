import {
	User
}
 from "@bean/User";
import {
	Restaurant
}
 from "@bean/Restaurant";
import {
	Voucher
}
 from "@bean/Voucher";
import {
	State
}
 from "@bean/State";
export class Table_     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public name!:string;
	 public restaurant!:Restaurant;
	 public maxServeCustomer!:number;
	 public vouchers!:Array<Voucher>;
	 public state!:State;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):Table_{
		return Object.assign(new Table_(), json_obj)
	}
	public  clone():Table_{
		const obj:Table_=Object.assign(new Table_(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
