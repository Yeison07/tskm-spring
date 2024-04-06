'use client';
import Button from '@/components/button/button';
import Form from '@/components/form/form';
import Input from '@/components/input/input';
import { AuthGateway } from '@/lib/domain/model/gateways/authGateway';
import { User } from '@/lib/domain/model/user';
import { RegisterUseCase } from '@/lib/domain/useCase/userUseCase';
import FirebaseAuthRepository from '@/lib/infrastructure/driver_adapters/repositories/firebaseAuthRepository';
import { useRouter } from 'next/navigation';
import * as React from 'react';
import styles from './signup.module.css';

interface IRegisterProps {}

const authGateway: AuthGateway = new FirebaseAuthRepository();
const register = new RegisterUseCase(authGateway);

const Register: React.FunctionComponent<IRegisterProps> = (props) => {
  const [user, setUser] = React.useState<User>({
    email: '',
    password: '',
  });

  const router = useRouter();

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setUser((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const registerUser = async (e: MouseEvent) => {
    e.preventDefault();
    if (user.email.trim() === '' || user.password.trim() === '') {
      console.log(user);
      return;
    }
    let registerSucces = await register.registerUser(user);
    if (registerSucces) {
      router.push('/');
    }
  };
  return (
    <main className={styles.signup_container}>
      <div className={styles.signup_form}>
        <div className={styles.signup_container}>
          <section className={styles.signup_form}>
            <Form title="Sign Up">
              <Input
                onChange={handleInputChange}
                placeholder="Ingrese su email"
                type="email"
                name="email"
              />
              <Input
                onChange={handleInputChange}
                placeholder="Ingrese su contraseña"
                type="password"
                name="password"
              />
              <Button handleClick={registerUser}>Registrarse</Button>
            </Form>
          </section>
        </div>
      </div>
    </main>
  );
};

export default Register;
