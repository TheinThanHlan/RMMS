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
import { Category } from "./Category";
export class MenuSize {
  public id!: number;
  public rowCreatedDateTime!: Date;
  public name!: string;
  public menus!: Array<Menu>;
  public category!: Category;
  public toJson(): string {
    return JSON.stringify(this);

  }
  public static fromJson(json_obj: object): MenuSize {
    return Object.assign(new MenuSize(), json_obj)
  }
  public clone(): MenuSize {
    const obj: MenuSize = Object.assign(new MenuSize(), JSON.parse(JSON.stringify(this)));
    return obj;

  }

}
