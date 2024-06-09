import {
	User
}
 from "@bean/User";
import {
	AccountTransaction
}
 from "@bean/AccountTransaction";
export class Account     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public name!:string;
	 public number!:number;
	 public normal!:number;
	 public transactions!:Array<AccountTransaction>;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):Account{
		return Object.assign(new Account(), json_obj)
	}
	public  clone():Account{
		const obj:Account=Object.assign(new Account(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
