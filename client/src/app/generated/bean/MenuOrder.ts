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
  OrderType
}
  from "@bean/OrderType";
import {
  OrderStatus
}
  from "@bean/OrderStatus";
import {
  Voucher
}
  from "@bean/Voucher";
import { State } from "./State";
export class MenuOrder {
  public id!: number;
  public rowCreatedDateTime!: Date;
  public menu!: Menu;
  public orderType!: OrderType;
  public orderState!: State;
  public cookStartTime!: Date;
  public cookEndTime!: Date;
  public dueDateTime!: Date;
  public voucher!: Voucher;
  public toJson(): string {
    return JSON.stringify(this);

  }
  public static fromJson(json_obj: object): MenuOrder {
    return Object.assign(new MenuOrder(), json_obj)
  }
  public clone(): MenuOrder {
    const obj: MenuOrder = Object.assign(new MenuOrder(), JSON.parse(JSON.stringify(this)));
    return obj;

  }

}
