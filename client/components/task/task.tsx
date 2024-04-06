'use client';
import * as React from 'react';
import styles from './task.module.css';
interface ITaskProps {
  description: string;
}

const Task: React.FunctionComponent<ITaskProps> = ({ description }) => {
  return (
    <div className={`${styles.card_task} drag`}>
      <div>
        <p>{description}</p>
        {}
      </div>
    </div>
  );
};

export default Task;
