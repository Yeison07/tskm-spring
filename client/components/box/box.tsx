'use client';
import * as React from 'react';
import styles from './box.module.css';
interface IBoxProps {
  children: React.ReactNode;
}

const Box: React.FunctionComponent<IBoxProps> = ({ children }) => {
  return (
    <div className={`${styles.box_container} drop`}>
      <p>BACKLOG</p>
      {children}
    </div>
  );
};

export default Box;
