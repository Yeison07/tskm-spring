import Image from 'next/image';
import Link from 'next/link';
import * as React from 'react';
import logo from '../../public/icons/logo.svg';
import styles from './navbar.module.css';
interface INavbarProps {}

const Navbar: React.FunctionComponent<INavbarProps> = (props) => {
  return (
    <header className={styles.navbar_contaniner}>
      <div className={styles.navbar}>
        <Link className={styles.navbar_home} href={'/'}>
          <Image alt="Logo" src={logo} />
          Inicio
        </Link>
        <Link className={styles.navbar_item} href={'/'}>
          Mi cuenta
        </Link>
        <Link className={styles.navbar_item} href={'/'}>
          Cerrar sesion
        </Link>
      </div>
    </header>
  );
};

export default Navbar;
