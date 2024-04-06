import * as React from 'react';
import styles from './form.module.css';

interface IFormProps {
  title: string;
  children: React.ReactNode;
}

const Form: React.FC<IFormProps> = ({ title, children }) => {
  return (
    <form className={styles.form_container}>
      <h1 className={styles.form_title}>{title}</h1>
      {children}
    </form>
  );
};

export default Form;
