'use client'; //MODIFICAR A USE SERVER CUANDO SEA ESTABLE
import { AuthGateway } from '@/lib/domain/model/gateways/authGateway';
import { User } from '@/lib/domain/model/user';
import { LoginUseCase } from '@/lib/domain/useCase/userUseCase';
import FirebaseAuthRepository from '@/lib/infrastructure/driver_adapters/repositories/firebaseAuthRepository';
import Image from 'next/image';
import Link from 'next/link';
import { useRouter } from 'next/navigation';
import * as React from 'react';
import logo from '../../public/icons/logo.svg';
import welcomeImg from '../../public/icons/welcome_login.svg';
import Button from '../button/button';
import Form from '../form/form';
import Input from '../input/input';
import styles from './login.module.css';

interface ILoginProps {}

const Login: React.FC<ILoginProps> = (props) => {
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
  const authGateway: AuthGateway = new FirebaseAuthRepository();
  const login = new LoginUseCase(authGateway);

  const loginUser = async (e: MouseEvent) => {
    e.preventDefault();
    if (user.email.trim() === '' || user.password.trim() === '') {
      console.log(user);
      return;
    }
    let loginSucces = await login.loginUser(user);
    if (loginSucces.error) {
      console.log(loginSucces);
    } else if (Object.keys(loginSucces).length === 0) {
      router.push('/home/projects');
    }
  };
  return (
    <main className={styles.login_container}>
      <div className={styles.login_logo}>
        <p className={styles.login_title}>
          Task <span>Me !</span>
        </p>
        <Image src={welcomeImg} alt="Logotipo decorativo inicio de sesion" />
      </div>
      <div className={styles.login_form}>
        <Image src={logo} alt="Logotipe" />
        <Form title="Hola, bienvenido de nuevo">
          <Input
            name="email"
            type="text"
            placeholder="Ingrese su correo"
            onChange={handleInputChange}
          />
          <Input
            name="password"
            type="password"
            placeholder="Ingrese contraseña"
            onChange={handleInputChange}
          />
          <Button handleClick={loginUser}>Iniciar sesion</Button>
        </Form>
        <p className={styles.login_registerLink}>
          ¿Aún no tienes cuenta?, <Link href={'/signup'}>registrate aqui</Link>
        </p>
      </div>
    </main>
  );
};

export default Login;
