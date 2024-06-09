import {
  User
}
  from "@bean/User";
import {
  Restaurant
}
  from "@bean/Restaurant";
import {
  Table_
}
  from "@bean/Table_";
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
import { State } from "./State";
export class Voucher {
  public id!: number;
  public rowCreatedDateTime!: Date;
  public table_!: Table_;
  public menuOrders!: Array<MenuOrder>;
  public state!: State;
  public restaurant!: Restaurant;
  public toJson(): string {
    return JSON.stringify(this);

  }
  public static fromJson(json_obj: object): Voucher {
    return Object.assign(new Voucher(), json_obj)
  }
  public clone(): Voucher {
    const obj: Voucher = Object.assign(new Voucher(), JSON.parse(JSON.stringify(this)));
    return obj;
  }

}
