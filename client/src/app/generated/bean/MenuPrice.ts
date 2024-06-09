import {
	User
}
 from "@bean/User";
import {
	Restaurant
}
 from "@bean/Restaurant";
import {
	Authority
}
 from "@bean/Authority";
import {
	Menu
}
 from "@bean/Menu";
export class MenuPrice     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public price!:number;
	 public menu!:Menu;
	 public restaurant!:Restaurant;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):MenuPrice{
		return Object.assign(new MenuPrice(), json_obj)
	}
	public  clone():MenuPrice{
		const obj:MenuPrice=Object.assign(new MenuPrice(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
