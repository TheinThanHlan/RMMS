import {
	User
}
 from "@bean/User";
import {
	Authority
}
 from "@bean/Authority";
import {
	Table_
}
 from "@bean/Table_";
import {
	MenuPrice
}
 from "@bean/MenuPrice";
export class Restaurant     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public name!:string;
	 public email!:string;
	 public phone!:string;
	 public address!:string;
	 public manager!:User;
	 public table_s!:Array<Table_>;
	 public authorities!:Array<Authority>;
	 public menuPices!:Array<MenuPrice>;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):Restaurant{
		return Object.assign(new Restaurant(), json_obj)
	}
	public  clone():Restaurant{
		const obj:Restaurant=Object.assign(new Restaurant(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
