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
export class OrderStatus {
  public id!: number;
  public rowCreatedDateTime!: Date;
  public name!: string;
  public guiColor!: string;
  public menuOrders!: Array<MenuOrder>;
  public toJson(): string {
    return JSON.stringify(this);

  }
  public static fromJson(json_obj: object): OrderStatus {
    return Object.assign(new OrderStatus(), json_obj)
  }
  public clone(): OrderStatus {
    const obj: OrderStatus = Object.assign(new OrderStatus(), JSON.parse(JSON.stringify(this)));
    return obj;

  }

}
