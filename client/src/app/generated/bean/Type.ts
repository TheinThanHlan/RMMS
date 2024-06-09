import {
  Category
}
  from "@bean/Category";
export class Type {
  public id!: number;
  public name!: string;
  public toJson(): string {
    return JSON.stringify(this);

  }
  public static fromJson(json_obj: object): Type {
    return Object.assign(new Type(), json_obj)
  }
  public clone(): Type {
    const obj: Type = Object.assign(new Type(), JSON.parse(JSON.stringify(this)));
    return obj;

  }

}
