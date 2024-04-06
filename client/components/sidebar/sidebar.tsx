import Image from 'next/image';
import Link from 'next/link';
import * as React from 'react';
import boardIcon from '../../public/icons/board_icon.svg';
import projectIcon from '../../public/icons/project_icon.svg';
import settingsIcon from '../../public/icons/settings_icon.svg';
import styles from './sidebar.module.css';
interface ISideBarProps {}

const SideBar: React.FunctionComponent<ISideBarProps> = (props) => {
  return (
    <div className={styles.sidebar}>
      <div className={styles.sidebar_project_info}>
        <div>
          <Image src={projectIcon} alt="" />
          <div className={styles.sidebar_project_info_text}>
            <p>Project name</p>
            <p>Project type</p>
          </div>
        </div>
      </div>
      <Link className={styles.sidebar_item} href={'/'}>
        <Image className="" src={boardIcon} alt="" />
        Tasks board
      </Link>
      <Link className={styles.sidebar_item} href={'/'}>
        <Image src={settingsIcon} alt="" />
        Configurar proyecto
      </Link>
    </div>
  );
};

export default SideBar;
