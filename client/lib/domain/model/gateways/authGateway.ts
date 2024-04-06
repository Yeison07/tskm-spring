import { User } from '../user';

export interface AuthGateway {
  register(user: User): Promise<boolean>;
  login(user: User): Promise<{ error?: any }>;
  logout(): Promise<void>;
  recoverPassword(user: User): Promise<void>;
}
