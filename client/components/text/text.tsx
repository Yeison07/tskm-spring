import * as React from 'react';
import styles from './text.module.css';
interface ITitleProps {
  children: React.ReactNode;
}

export const Title: React.FunctionComponent<ITitleProps> = ({ children }) => {
  return <h1 className={styles.title}>{children}</h1>;
};

export const SubTitle: React.FunctionComponent<ITitleProps> = ({
  children,
}) => {
  return <h3 className={styles.subtitle}>{children}</h3>;
};

export const Text: React.FunctionComponent<ITitleProps> = ({ children }) => {
  return <p className={styles.text}>{children}</p>;
};
