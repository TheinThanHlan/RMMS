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
import {
  MenuOrder
}
  from "@bean/MenuOrder";
export class OrderType {
  public id!: number;
  public rowCreatedDateTime!: Date;
  public name!: string;
  public guiColor!: string;
  public menuOrders!: Array<MenuOrder>;
  public toJson(): string {
    return JSON.stringify(this);

  }
  public static fromJson(json_obj: object): OrderType {
    return Object.assign(new OrderType(), json_obj)
  }
  public clone(): OrderType {
    const obj: OrderType = Object.assign(new OrderType(), JSON.parse(JSON.stringify(this)));
    return obj;

  }

}
