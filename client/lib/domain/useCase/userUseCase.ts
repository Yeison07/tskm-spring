import { AuthGateway } from '../model/gateways/authGateway';
import { User } from '../model/user';

export class RegisterUseCase {
  private authGateway: AuthGateway;

  constructor(authGateway: AuthGateway) {
    this.authGateway = authGateway;
  }

  public async registerUser(user: User): Promise<boolean> {
    try {
      this.authGateway.register(user);
      return true;
    } catch (error) {
      alert(error);
      return false;
    }
  }
}

export class LoginUseCase {
  private authGateway: AuthGateway;

  constructor(authGateway: AuthGateway) {
    this.authGateway = authGateway;
  }

  public async loginUser(user: User): Promise<{ error?: any }> {
    try {
      return this.authGateway.login(user);
    } catch (errorUseCase) {
      return errorUseCase ? { ...errorUseCase } : {};
    }
  }
}

export class LogoutUseCase {
  private authGateway: AuthGateway;

  constructor(authGateway: AuthGateway) {
    this.authGateway = authGateway;
  }

  public async logOutUser(user: User): Promise<void> {
    try {
      this.authGateway.logout();
    } catch (error) {
      console.log(error);

      throw error;
    }
  }
}
