import {
  Marsta
}
  from "@bean/Marsta";
import {
  Table_
}
  from "@bean/Table_";
import {
  Restaurant
}
  from "@bean/Restaurant";
import {
  AccountTransaction
}
  from "@bean/AccountTransaction";
import {
  UserGroup
}
  from "@bean/UserGroup";

import { Type } from "@bean/Type";

export class State {
  public id!: number;
  public name!: string;
  public type!: Type;
  public guiColor!: string;
  public guiClasses!: string;
  public moreInfo!: string;
  public table_s!: Array<Table_>;
  public toJson(): string {
    return JSON.stringify(this);

  }
  public static fromJson(json_obj: object): State {
    return Object.assign(new State(), json_obj)
  }
  public clone(): State {
    const obj: State = Object.assign(new State(), JSON.parse(JSON.stringify(this)));
    return obj;

  }

}
