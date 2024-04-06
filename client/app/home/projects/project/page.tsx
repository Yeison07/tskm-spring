import Board from '@/components/board/board';
import SideBar from '@/components/sidebar/sidebar';
import * as React from 'react';
import styles from './tasks.module.css';
interface IProyectosProps {}

const Proyectos: React.FunctionComponent<IProyectosProps> = (props) => {
  return (
    <div className={styles.tasks_container}>
      <SideBar></SideBar>
      <Board path="Projects / name / task board" />
    </div>
  );
};

export default Proyectos;
