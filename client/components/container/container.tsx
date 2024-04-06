import * as React from 'react';
import styles from './container.module.css';
interface IFlexContainerProps {
  children: React.ReactNode;
}

export const FlexContainer: React.FunctionComponent<IFlexContainerProps> = ({
  children,
}) => {
  return <div className={styles.container_flex}>{children}</div>;
};

export const FlexColumContainer: React.FunctionComponent<
  IFlexContainerProps
> = ({ children }) => {
  return <div className={styles.container_flex_column}>{children}</div>;
};
