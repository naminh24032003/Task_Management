import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { AuthService } from '../service/auth.service';

@Injectable({
  providedIn: 'root',
})
export class AuthRoleGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const expectedRoles = route.data['roles'] as string[];
    const user = this.authService.getCurrentUser();

    if (!user) {
      // ❌ Chưa đăng nhập
      this.router.navigate(['/auth/login']);
      return false;
    }

    if (expectedRoles && !expectedRoles.includes(user.role)) {
      // ❌ Không có quyền
      this.router.navigate(['/unauthorized']);
      return false;
    }

    // ✅ Hợp lệ
    return true;
  }
}
