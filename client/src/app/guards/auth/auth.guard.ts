import { ActivatedRoute, CanActivateFn, Route, Router } from '@angular/router';
import { User } from '@bean/User';
import { inject } from '@angular/core';
import { Restaurant } from '@bean/Restaurant';
import { VarsService } from '../../global/vars/vars.service';





export const authGuard: CanActivateFn = (route, state) => {
  const vars: VarsService = inject(VarsService);
  const router: Router = inject(Router);
  const activatedRouter: ActivatedRoute = inject(ActivatedRoute);
  if (vars.getUser() != null && vars.getUser()!.userGroup != null) {
    vars.setCurrentRestaurant(new Restaurant());
    vars.getCurrentRestaurantTable_s()
    if (vars.getUser()?.userGroup.name == route.url.toString()) {
      return true;
    }
  }


  router.navigate(['auth/login']);
  return false;
};
