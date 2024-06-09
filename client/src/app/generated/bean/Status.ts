import { Type } from "@bean/Type";

export class Status {
  public id!: number;
  public name!: string;
  public type!: Type;
  public guiColor!: string;
  public guiClasses!: string;

  public toJson(): string {
    return JSON.stringify(this);

  }
  public static fromJson(json_obj: object): Status {
    return Object.assign(new Status(), json_obj)
  }
  public clone(): Status {
    const obj: Status = Object.assign(new Status(), JSON.parse(JSON.stringify(this)));
    return obj;

  }
}
