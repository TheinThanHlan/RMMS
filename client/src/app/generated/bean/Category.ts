import {
  MenuTemplate
}
  from "@bean/MenuTemplate";
import {
  UserGroup
}
  from "@bean/UserGroup";
import {
  Type
}
  from "@bean/Type";




export class Category {
  public id!: number;
  public name!: string;
  public type!: Type;
  public subCategories!: Array<Category>;
  public recieveUserGroups!: Array<UserGroup>;
  public toJson(): string {
    return JSON.stringify(this);

  }
  public static fromJson(json_obj: object): Category {
    return Object.assign(new Category(), json_obj)
  }
  public clone(): Category {
    const obj: Category = Object.assign(new Category(), JSON.parse(JSON.stringify(this)));
    return obj;

  }

}
