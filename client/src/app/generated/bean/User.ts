import {
  Marsta
}
  from "@bean/Marsta";
import {
  Gender
}
  from "@bean/Gender";
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
export class User {
  public id!: number;
  public rowCreatedDateTime!: Date;
  public name!: string;
  public email!: string;
  public phone!: string;
  public address!: string;
  public password!: string;
  public loginableStatus: boolean = false;
  public marsta!: Marsta;
  public gender!: Gender;
  public restaurant!: Array<Restaurant>;
  public userGroup!: UserGroup;
  public recievedAccountTransactions!: Array<AccountTransaction>;
  public paidAccountTransactions!: Array<AccountTransaction>;
  public toJson(): string {
    return JSON.stringify(this);

  }
  public static fromJson(json_obj: object): User {
    return Object.assign(new User(), json_obj)
  }
  public clone(): User {
    const obj: User = Object.assign(new User(), JSON.parse(JSON.stringify(this)));
    return obj;

  }

}
