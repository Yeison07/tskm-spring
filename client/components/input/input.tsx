'use client';
import * as React from 'react';
import styles from './input.module.css';

interface IInputProps {
  type: string;
  placeholder: string;
  onChange?: any;
  id?: string;
  name?: string;
}

const Input: React.FunctionComponent<IInputProps> = ({
  type,
  placeholder,
  onChange,
  id,
  name,
}) => {
  const handleClick = () => {
    return (e: React.MouseEvent) => {
      e?.preventDefault;
    };
  };
  return (
    <input
      className={styles.input}
      onChange={onChange}
      type={type}
      placeholder={placeholder}
      onClick={handleClick()}
      id={id}
      name={name}
    ></input>
  );
};

export default Input;
