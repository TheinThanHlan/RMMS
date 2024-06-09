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
	MenuTemplate
}
 from "@bean/MenuTemplate";
import {
	MenuSize
}
 from "@bean/MenuSize";
import {
	MenuPrice
}
 from "@bean/MenuPrice";
export class Menu     {
	 public id!:number;
	 public rowCreatedDateTime!:Date;
	 public menuTemplate!:MenuTemplate;
	 public menuSize!:MenuSize;
	 public cookDuration!:Date;
	 public menuPrices!:Array<MenuPrice>;
	public toJson():string{
		return JSON.stringify(this);
		
	}
	public static fromJson(json_obj:object):Menu{
		return Object.assign(new Menu(), json_obj)
	}
	public  clone():Menu{
		const obj:Menu=Object.assign(new Menu(),JSON.parse(JSON.stringify(this)));
		return obj;
		
	}
	
}
