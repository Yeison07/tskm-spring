'use client';
import * as React from 'react';
import styles from './button.module.css';
interface IButtonProps {
  children: React.ReactNode;
  handleClick: any;
}

const Button: React.FC<IButtonProps> = ({ handleClick, children }) => {
  return (
    <button onClick={handleClick} className={styles.button}>
      {children}
    </button>
  );
};

export default Button;
