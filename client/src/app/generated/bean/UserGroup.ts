import { Type } from "@bean/Type";
import {
  User
}
  from "@bean/User";
export class UserGroup {
  public id!: number;
  public rowCreatedDateTime!: Date;
  public users!: Array<User>;
  public name!: string;
  public type!: Type;
  public toJson(): string {
    return JSON.stringify(this);

  }
  public static fromJson(json_obj: object): UserGroup {
    return Object.assign(new UserGroup(), json_obj)
  }
  public clone(): UserGroup {
    const obj: UserGroup = Object.assign(new UserGroup(), JSON.parse(JSON.stringify(this)));
    return obj;

  }

}
