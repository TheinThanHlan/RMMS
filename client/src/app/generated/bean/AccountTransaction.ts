import {
	User
}
 from "@bean/User";
import {
	Account
}
 from "@bean/Account";
import {
	Voucher
}
 from "@bean/Voucher";
import {
	EmployeeSalary
}
 from "@bean/EmployeeSalary";
import {
	StockOrder
}
 from "@bean/StockOrder";
export class AccountTransaction     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public direction!:number;
	 public description!:string;
	 public reciever!:User;
	 public payer!:User;
	 public account!:Account;
	 public voucher!:Voucher;
	 public employeeSalary!:EmployeeSalary;
	 public stockOrder!:StockOrder;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):AccountTransaction{
		return Object.assign(new AccountTransaction(), json_obj)
	}
	public  clone():AccountTransaction{
		const obj:AccountTransaction=Object.assign(new AccountTransaction(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
