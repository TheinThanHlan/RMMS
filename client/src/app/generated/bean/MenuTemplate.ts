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


export class MenuTemplate {
  public id!: number;
  public rowCreatedDateTime!: Date;
  public name!: string;
  public menus!: Array<Menu>;
  public category!: Category;
  public toJson(): string {
    return JSON.stringify(this);

  }
  public static fromJson(json_obj: object): MenuTemplate {
    return Object.assign(new MenuTemplate(), json_obj)
  }
  public clone(): MenuTemplate {
    const obj: MenuTemplate = Object.assign(new MenuTemplate(), JSON.parse(JSON.stringify(this)));
    return obj;

  }

}
